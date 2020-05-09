package org.hotilsframework.beans.factory;

import org.hotilsframework.beans.BeansException;

/**
 * 工厂的Java Bean类
 * 用于直接将Bean注入到容器中
 * @className FactoryBean
 * @author hireny
 * @date Created in 2020-01-21 21:03
 * @version 1.0
 */
public interface FactoryBean<T> {

    /**
     * 返回对象实例
     * @return
     * @throws BeansException
     */
    T getObject() throws BeansException;

    /**
     * 返回Bean的类型
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否单例
     * @return
     */
    default boolean isSingleton() {
        return true;
    }
}
