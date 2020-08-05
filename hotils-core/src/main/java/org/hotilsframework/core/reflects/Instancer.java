package org.hotilsframework.core.reflects;

import org.hotilsframework.beans.BeanInstantiationException;
import org.hotilsframework.core.Classes;
import org.hotilsframework.utils.ArrayUtils;
import org.hotilsframework.utils.Assert;
import org.hotilsframework.utils.ReflectionUtils;
import org.hotilsframework.utils.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.hotilsframework.utils.ReflectionUtils.getConstructor;
import static org.hotilsframework.utils.ReflectionUtils.handleReflectionException;

/**
 * Instanter
 *
 * 实例化操作
 *
 * @author hireny
 * @create 2020-08-03 19:58
 */
public final class Instancer {
    private Instancer() {
        throw new AssertionError("不允许创建");
    }

    /**
     * 实例化对象
     * @param clazz 类名
     * @param <T>   对象类型
     * @return      对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T tryInstance(Class<?> clazz) {
        Assert.notNull(clazz, "Class must not be null.");
        if (clazz.isInterface()) {
            throw new BeanInstantiationException(clazz, "Specified class is an interface");
        }
        if (Modifier.isAbstract(clazz.getModifiers())) {
            throw new BeanInstantiationException(clazz, "Specified class is an abstract class");
        }
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // 异常处理
            handleReflectionException(e);
        }
        return null;
    }

    /**
     * 实例化对象
     * @param clazz     类
     * @param args      构造函数参数
     * @param <T>       对象类型
     * @return          对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T tryInstance(Class<T> clazz, Object... args) {
        if (ArrayUtils.isEmpty(args)) {
            final Constructor<T> constructor = getConstructor(clazz);
            try {
                return constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                handleReflectionException(e);
            }

        }
        final Class<?>[] parameterTypes = Classes.getClasses(args);
        final Constructor<T> constructor = getConstructor(clazz, parameterTypes);

        if (null == constructor) {

            throw new IllegalArgumentException(
                    StringUtils.format("No Constructor matched for parameter types: [{}]", parameterTypes));
        }

        try {
            return constructor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            handleReflectionException(e);
        }
        return null;
    }

    /**
     * 尝试遍历并调用此类的所有构造方法，直到构造成功并返回
     *
     * @param clazz     被构造的类
     * @param <T>       对象类型
     * @return          构造后的对象
     */
    public static <T> T tryInstanceIfPossible(Class<T> clazz) {
        Assert.notNull(clazz);
        try {
            return tryInstance(clazz);
        } catch (Exception e) {
            // ignore
            // 默认构造不存在的情况下查找其它构造
        }

        final Constructor<T>[] constructors = ReflectionUtils.getConstructors(clazz);
        Class<?>[] parameterTypes;
        for (Constructor<T> constructor : constructors) {
            parameterTypes = constructor.getParameterTypes();
            if (0 == parameterTypes.length) {
                continue;
            }
            ReflectionUtils.makeAccessible(constructor);
            try {
                return constructor.newInstance(Classes.defaultValues(parameterTypes));
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                // 构造出错时继续尝试下一种构造方法
            }
        }
        return null;
    }
}
