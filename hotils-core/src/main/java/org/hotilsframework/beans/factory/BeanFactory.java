package org.hotilsframework.beans.factory;

import org.hotilsframework.beans.BeansException;

/**
 * Java Bean的工厂类
 * @ClassName: BeanFactory
 * @Author: hireny
 * @Date: Created in 2020-01-08 22:44
 * @Version: 1.0
 */
public interface BeanFactory {

    /**
     * 获取Bean
     * @param name      bean名称
     * @return          获取Bean对象
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取Bean
     * @param name              Bean名称
     * @param args              参数
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 获取Bean
     * @param name              Bean名称
     * @param beanClass         Bean类
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getBean(String name, Class<?> beanClass) throws BeansException;

    /**
     * 获取Bean
     * @param clazz     bean类
     * @return          获取Bean对象
     */
    Object getBean(Class<?> clazz) throws BeansException;

    /**
     * 获取Bean
     * @param clazz             Bean类
     * @param args              参数
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getBean(Class<?> clazz, Object... args) throws BeansException;
}
