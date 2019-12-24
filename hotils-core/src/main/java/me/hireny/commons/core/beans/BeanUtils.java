package me.hireny.commons.core.beans;

import me.hireny.commons.core.lang.Classes;
import me.hireny.commons.utils.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: BeanUtils
 * @Author: hireny
 * @Date: Create in 2019/12/09 01:25
 * @Description: TODO   Bean工具类
 */
public final class BeanUtils {

    private BeanUtils() {}

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz)
            throws BeansException {
//        Cached
        return null;
    }

    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName)
            throws BeansException {
        return null;
    }


    //****************Bean copyProperties********************//

    /**
     * 复制Bean对象属性
     * @param source    源Bean对象
     * @param target    目标Bean对象
     */
    public static void copyProperties(Object source, Object target) {
//        copyProperties(source, target, CopyOptions.create());
    }

    /**
     * 复制Bean对象属性
     * 限制类用于限制拷贝的属性，例如一个类我只想复制其父类的一些属性，就可以将editable设置为父类
     *
     * @param source                源Bean对象
     * @param target                目标Bean对象
     * @param ignoreProperties      不拷贝的属性列表
     */
    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
//        copyProperties(source, target, CopyOptions.create().setIgnoreProperties(ignoreProperties));
    }

    /**
     * 复制Bean对象属性
     * @param source                源Bean对象
     * @param target                目标Bean对象
     * @param ignoreCase            是否忽略大小写
     */
    public static void copyProperties(Object source, Object target, boolean ignoreCase) {
//        BeanOptions.create(source, target, CopyOptions.create().setIgnoreCase(ignoreCase)).copy();
    }

    /**
     * 复制Bean对象属性
     * 限制类用于限制拷贝的属性，例如一个类我只想复制其父类的一些属性，就可以将editable设置为父类
     *
     * @param source            源Bean对象
     * @param target            目标Bean对象
     * @param ignoreProperties       忽略的配置
     */
    public static void copyProperties(Object source, Object target, Class<?> editable, String... ignoreProperties) {
        Assert.checkNotNull(source, "Source must not be null");
        Assert.checkNotNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
                        "] not assignable to Editable class [" + editable.getName() + "]");
            }
            actualEditable = editable;
        }
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null && Classes.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new FatalBeansException(
                                    "Could not copy property '" + targetPd.getName() + "' from source to target", e);
                        }
                    }
                }
            }
        }
    }
}
