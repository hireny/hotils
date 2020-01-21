package org.hotilsframework.core.beans;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @ClassName: BeanOptions
 * @Author: hireny
 * @Date: Create in 2019/12/09 01:30
 * @Description: TODO   Bean对象操作
 */
public final class BeanOptions<T> implements Serializable {
    private static final long serialVersionUID = -2558120262295127413L;

    /** 源对象 */
    private final Object source;
    /** 目标对象 */
    private final T target;
    /** 目标的类型（用于泛型类注入） */
    private final Type targetType;
    /** 拷贝选项 */
    private final CopyOptions copyOptions;

    /**
     * 创建BeanOptions
     *
     * @param source            来源对象，可以是Bean或者Map
     * @param target            目标对象，可以是Bean或者Map
     * @param copyOptions       拷贝属性选项
     * @param <T>               目标类型
     * @return                  BeanOptions
     */
    public static <T> BeanOptions<T> create(Object source, T target, CopyOptions copyOptions) {
        return create(source, target, target.getClass(), copyOptions);
    }

    /**
     * 创建BeanCopier
     *
     * @param <T> 目标Bean类型
     * @param source 来源对象，可以是Bean或者Map
     * @param target 目标Bean对象
     * @param targetType 目标的泛型类型，用于标注有泛型参数的Bean对象
     * @param copyOptions 拷贝属性选项
     * @return BeanCopier
     */
    public static <T> BeanOptions<T> create(Object source, T target, Type targetType, CopyOptions copyOptions) {
        return new BeanOptions(source, target, targetType, copyOptions);
    }

    /**
     * 构造
     *
     * @param source        来源对象，可以是Bean或者Map
     * @param target        目标对象，可以是Bean或者Map
     * @param targetType    目标的泛型类型，用于标注有泛型参数的Bean对象
     * @param copyOptions   拷贝属性选项
     */
    public BeanOptions(Object source, T target, Type targetType, CopyOptions copyOptions) {
        this.source = source;
        this.target = target;
        this.targetType = targetType;
        this.copyOptions = copyOptions;
    }

    /**
     * Bean对象复制操作
     * @param source        源Bean对象
     * @param target        目标Bean对象
     */
    public void copy(Object source, Object target) {

    }

    /**
     * 对象转Map
     * @param bean      Bean对象
     * @param target    目标的Map
     */
    public void beanToMap(Object bean, Map target) {

    }

    /**
     * Map转Bean属性拷贝
     * @param source        Map对象
     * @param target        目标Bean对象
     */
    public void mapToBean(Map source, Object target) {

    }
}
