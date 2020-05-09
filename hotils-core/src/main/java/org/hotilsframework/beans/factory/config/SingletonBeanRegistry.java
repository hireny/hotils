package org.hotilsframework.beans.factory.config;

import org.hotilsframework.lang.Nullable;

/**
 * 单例Bean注册接口
 * @author hireny
 * @className SingletonBeanRegistry
 * @create 2020-04-09 17:45
 */
public interface SingletonBeanRegistry {
    /**
     * 在bean注册表中，在给定的bean名称下，将给定的现有对象注册为单例对象。
     * @param beanName      bean名称
     * @param singletonObj  单例对象
     */
    void registerSingleton(String beanName, Object singletonObj);

    /**
     * 根据给定的bean名称获取单例对象
     * @param beanName
     * @return
     */
    @Nullable
    Object getSingleton(String beanName);

    /**
     * 根据给定的bean名称判断是否存在该单例对象
     * @param beanName
     * @return
     */
    boolean containsSingleton(String beanName);

    /**
     * 获取所有的单例名称
     * @return
     */
    String[] getSingletonNames();

    /**
     * 获取单例对象个数
     * @return
     */
    int getSingletonCount();
}
