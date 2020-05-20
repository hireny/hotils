package org.hotilsframework.inject;

import org.hotilsframework.beans.BeansException;

/**
 * 一个依赖的管理上下文
 * @author hireny
 * @className Injector
 * @create 2020-05-12 20:49
 */
public interface Injector {

    /**
     * 获取对象实例
     * @param name      bean名称
     * @return          获取Bean对象
     */
    Object getInstance(String name) throws BeansException;

    /**
     * 获取对象实例
     * @param name              Bean名称
     * @param args              参数
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getInstance(String name, Object... args) throws BeansException;

    /**
     * 获取对象实例
     * @param name              Bean名称
     * @param beanClass         Bean类
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getInstance(String name, Class<?> beanClass) throws BeansException;

    /**
     * 获取Bean
     * @param clazz     bean类
     * @return          获取Bean对象
     */
    Object getInstance(Class<?> clazz) throws BeansException;

    /**
     * 获取对象实例
     * @param clazz             Bean类
     * @param args              参数
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getInstance(Class<?> clazz, Object... args) throws BeansException;
}
