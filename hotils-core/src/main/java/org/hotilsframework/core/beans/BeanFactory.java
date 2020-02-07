package org.hotilsframework.core.beans;

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
     * @param beanName  bean名称
     * @return          获取Bean对象
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 获取Bean
     * @param beanName          Bean名称
     * @param args              参数
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getBean(String beanName, Object... args) throws BeansException;

    /**
     * 获取Bean
     * @param beanName          Bean名称
     * @param beanClass         Bean类
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getBean(String beanName, Class<?> beanClass) throws BeansException;

    /**
     * 获取Bean
     * @param beanClass bean类
     * @return          获取Bean对象
     */
    Object getBean(Class<?> beanClass) throws BeansException;

    /**
     * 获取Bean
     * @param beanClass         Bean类
     * @param args              参数
     * @return                  获取Bean对象
     * @throws BeansException
     */
    Object getBean(Class<?> beanClass, Object... args) throws BeansException;
}
