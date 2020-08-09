package org.hotilsframework.inject.factory;

import org.hotilsframework.inject.Key;

/**
 * SingletonRegistry
 *
 * 单例注册
 *
 * @author hireny
 * @create 2020-08-09 0:17
 */
public interface SingletonRegistry {

    /**
     * 注册单例
     * @param key
     * @param element
     */
    void registerSingleton(Key<?> key, Object element);

    /**
     * 根据键获取单例
     * @param key
     * @return
     */
    Object getSingleton(Key<?> key);

    /**
     *
     * @param key
     * @return
     */
    boolean containsSingleton(Key<?> key);
}
