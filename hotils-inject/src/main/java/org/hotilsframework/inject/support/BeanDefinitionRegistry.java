package org.hotilsframework.inject.support;

import org.hotilsframework.inject.BeanDefinition;
import org.hotilsframework.inject.Key;

/**
 * BeanDefinitionRegistry
 *
 * BeanDefinition注册
 *
 * @author hireny
 * @create 2020-08-06 21:17
 */
public interface BeanDefinitionRegistry {
    /**
     * 根据键与Bean定义的信息来注册Bean
     * @param key
     * @param beanDefinition
     */
    void registerBeanDefinition(Key<?> key, BeanDefinition beanDefinition);

    /**
     * 根据键来删除指定的Bean定义信息
     * @param key
     */
    void removeBeanDefinition(Key<?> key);
}
