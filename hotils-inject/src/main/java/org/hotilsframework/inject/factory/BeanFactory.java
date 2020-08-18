package org.hotilsframework.inject.factory;

import org.hotilsframework.inject.Key;

/**
 * BeanFactory
 *
 * 获取Bean的工厂
 *
 * @author hireny
 * @create 2020-08-09 20:49
 */
public interface BeanFactory {

    /**
     * 根据键获取值
     * @param key           键，是Bean的唯一标识
     * @param scopeType     作用域，根据作用域获取对象
     * @return
     */
    <T> T get(Key<T> key, Class<?> scopeType);
}
