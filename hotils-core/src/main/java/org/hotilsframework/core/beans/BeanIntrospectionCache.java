package org.hotilsframework.core.beans;

/**
 * Bean内省的缓存类
 * @ClassName: BeanIntrospectionCache
 * @Author: hireny
 * @Date: Created in 2020-02-01 21:47
 * @Version: 1.0
 */
public final class BeanIntrospectionCache {

    public static BeanIntrospectionCache forClass(Class<?> beanClass) throws BeansException {
        BeanIntrospectionCache result = new BeanIntrospectionCache(beanClass);
        return result;
    }

    public BeanIntrospectionCache(Class<?> beanClass) {

    }
}
