package org.hotilsframework.inject;

import org.hotilsframework.beans.BeansException;

import java.util.Map;

/**
 * 一个依赖的管理上下文
 * @author hireny
 * @className Injector
 * @create 2020-05-12 20:49
 */
public interface Injector {
    /**
     * 获取所有的绑定信息
     * @return
     */
    Map<Key<?>, Binding<?>> getBindings();

    /**
     * 根据键获取绑定元素
     * @param key
     * @param <T>
     * @return
     */
    <T> Binding<T> getBinding(Key<T> key);

//    /**
//     * 获取对象实例
//     * @param name      bean名称
//     * @return          获取Bean对象
//     */
//    Object getInstance(String name) throws BeansException;
//
//    /**
//     * 获取对象实例
//     * @param name              Bean名称
//     * @param args              参数
//     * @return                  获取Bean对象
//     * @throws BeansException
//     */
//    Object getInstance(String name, Object... args) throws BeansException;
//
//    /**
//     * 获取对象实例
//     * @param name              Bean名称
//     * @param beanClass         Bean类
//     * @return                  获取Bean对象
//     * @throws BeansException
//     */
//    Object getInstance(String name, Class<?> beanClass) throws BeansException;


    /**
     * 获取Bean
     * @param type      bean类
     * @param <T>
     * @return          获取Bean对象
     */
    <T> T getInstance(Class<T> type);

//    /**
//     * 获取对象实例
//     * @param clazz             Bean类
//     * @param args              参数
//     * @return                  获取Bean对象
//     * @throws BeansException
//     */
//    Object getInstance(Class<?> clazz, Object... args) throws BeansException;

    /**
     * 获取该注入器的父类
     * @return
     */
    Injector getParent();
}
