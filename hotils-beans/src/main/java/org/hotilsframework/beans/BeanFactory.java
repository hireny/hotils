package org.hotilsframework.beans;

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
     * @param beanClass bean类
     * @return          获取Bean对象
     */
    Object getBean(Class<?> beanClass);

    /**
     * 获取Bean
     * @param beanName  bean名称
     * @return          获取Bean对象
     */
    Object getBean(String beanName);
}
