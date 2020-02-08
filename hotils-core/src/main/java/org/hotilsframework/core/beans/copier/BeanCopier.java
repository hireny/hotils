package org.hotilsframework.core.beans.copier;

import org.hotilsframework.core.beans.BeanMap;
import org.hotilsframework.core.beans.BeanUtils;
import org.hotilsframework.core.beans.FatalBeansException;
import org.hotilsframework.core.lang.Copy;
import org.hotilsframework.utils.Assert;
import org.hotilsframework.utils.ClassUtils;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Bean对象复制
 * @ClassName: BeanCopier
 * @Author: hireny
 * @Date: Created in 2020-02-05 22:16
 * @Version: 1.0
 */
public class BeanCopier<T> implements Copy<T>, Serializable {
    private static final long serialVersionUID = -5885126118175946991L;
    /**
     * 源对象
     */
    private final Object source;
    /**
     * 目标对象
     */
    private final T target;
    /**
     * 目标的类型（用于泛型类注入）
     */
    private final Class<?> targetType;
    /**
     * 拷贝选项
     */
    private final CopyOptions options;

    /**
     * 构造
     * @param source        来源对象，可以是Bean或者Map
     * @param target        目标Bean对象
     * @param targetType    目标的泛型类型，用于标注有泛型参数的Bean对象
     * @param options       拷贝属性选项
     */
    private BeanCopier(Object source, T target, Class<?> targetType, CopyOptions options) {
        Assert.checkNotNull(source, "Source must not be null");
        Assert.checkNotNull(target, "Target must not be null");
        this.source = source;
        this.target = target;
        this.targetType = targetType == null ? target.getClass() : targetType;
        this.options = options;
    }

    @Override
    public T copy() {

        if (this.source instanceof Map) {
            if (this.target instanceof Map) {
                mapToMap( (Map<?, ?>) this.source, (Map<?, ?>) this.target);
            } else {
                mapToBean( (Map<?, ?>)this.source, this.target);
            }
        } else {
            if (this.target instanceof Map) {
                beanToMap(this.source, (Map<?, ?>) this.target);
            } else {
                beanToBean(this.source, this.target);
            }
        }
        return null;
    }


    /**
     * 对象转对象
     * @param source
     * @param target
     */
    private void beanToBean(Object source, Object target) {
        Class<?> actualEditable = target.getClass();
        if (null != options.editable) {
            // 检查限制类是否为target的父类或接口
            if (!options.editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
                        "] not assignable to Editable class [" + options.editable.getName() + "]");
            }
            actualEditable = options.editable;
        }

        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (options.ignoreProperties != null ? Arrays.asList(options.ignoreProperties) : null);

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new FatalBeansException(
                                    "Could not copy property '" + targetPd.getName() + "' from source to target", e);
                        }
                    }
                }
            }
        }
    }

    /**
     * 对象转Map
     * @param source
     * @param target
     */
    private void beanToMap(Object source, Map target) {
        BeanMap beanMap = BeanMap.create(source);
        target.putAll(beanMap.toMap());
        List<String> ignoreList = (options.ignoreProperties != null ? Arrays.asList(options.ignoreProperties) : null);
        if (ignoreList != null) {
            for (String ignoreProperties : ignoreList) {
                if (target.containsKey(ignoreProperties)) {
                    target.remove(ignoreProperties);
                }
            }
        }
    }

    /**
     * Map转对象
     * @param source
     * @param target
     */
    private void mapToBean(Map<?, ?> source, T target) {
        List<String> ignoreList = (options.ignoreProperties != null ? Arrays.asList(options.ignoreProperties) : null);
        if (ignoreList != null) {
            for (String ignoreProperties : ignoreList) {
                if (source.containsKey(ignoreProperties)) {
                    source.remove(ignoreProperties);
                }
            }
        }
        System.out.println(source.toString());
        BeanUtils.mapToBean(source, target);
    }

    /**
     * Map转Map
     * @param source
     * @param target
     */
    private void mapToMap(Map source, Map target) {
        target.putAll(source);
        List<String> ignoreList = (options.ignoreProperties != null ? Arrays.asList(options.ignoreProperties) : null);
        if (ignoreList != null) {
            for (String ignoreProperties : ignoreList) {
                if (target.containsKey(ignoreProperties)) {
                    target.remove(ignoreProperties);
                }
            }
        }
    }


    //=============================================
    // 静态方法创建
    //=============================================

    /**
     * 静态方法创建BeanCopier
     * @param source        来源对象，可以是Bean或者Map
     * @param target        目标Bean对象
     * @param options       拷贝属性选项
     * @param <T>           目标Bean类型
     * @return              BeanCopier
     */
    public static <T> BeanCopier<T> create(Object source, T target, CopyOptions options) {
        return create(source, target, target.getClass(), options);
    }

    /**
     * 静态方法创建BeanCopier
     * @param source        来源对象，可以是Bean或者Map
     * @param target        目标Bean对象
     * @param targetType    目标的泛型类型，用于标注有泛型参数的Bean对象
     * @param options       拷贝属性选项
     * @param <T>           目标Bean类型
     * @return              BeanCopier
     */
    public static <T> BeanCopier<T> create(Object source, T target, Class<?> targetType, CopyOptions options) {
        return new BeanCopier<>(source, target, targetType, options);
    }
}
