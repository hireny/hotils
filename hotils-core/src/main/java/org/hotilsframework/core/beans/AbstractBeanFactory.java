package org.hotilsframework.core.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: AbstractBeanFactory
 * @Author: hireny
 * @Date: Created in 2020-01-21 21:03
 * @Version: 1.0
 */
public class AbstractBeanFactory implements BeanFactory {

    /**
     * 缓存Bean对象
     */
    protected final Map<String, FactoryBean> beanContainers = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(String beanName, Class<?> beanClass) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(Class<?> beanClass) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(Class<?> beanClass, Object... args) throws BeansException {
        return null;
    }

    protected Object doGetBean(String beanName, Class<?> requiredType, Object[] args, boolean typeCheckOnly) {
        FactoryBean factoryBean = beanContainers.get(beanName);
        if (factoryBean == null) {
            // 如果bean为空，则抛出异常，这是因为没有定义名为name的bean
            throw new IllegalArgumentException("No bean named " + beanName + " is defined");
        }
        // 获取FactoryBean中的Bean对象
        Object bean = factoryBean.getObject();
        if (bean == null) {
            // 刚创建对象，其它什么都没有做
//            bean = doCreateBean(beanName, factoryBean);
            // 初始化bean对象
            // 这里bean是初始化之后的bean，与刚开始创建的beean不一样
        }
        return bean;
    }
}
