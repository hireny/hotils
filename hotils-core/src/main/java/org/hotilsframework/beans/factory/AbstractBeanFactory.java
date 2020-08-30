package org.hotilsframework.beans.factory;

import org.hotilsframework.beans.BeanDefinition;
import org.hotilsframework.beans.BeansException;
import org.hotilsframework.lang.Nullable;
import org.hotilsframework.lang.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @className AbstractBeanFactory
 * @author hireny
 * @date Created in 2020-01-21 21:03
 * @version 1.0
 */
public class AbstractBeanFactory implements BeanFactory {

    /**
     * 缓存Bean对象
     */
    protected final Map<String, BeanDefinition> beanContainers = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws BeansException {
        Assert.notNull(name);
        return doGetBean(name, null, null, false);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        Assert.notNull(name);
        Assert.notNullElements(args);
        return doGetBean(name, null, args, false);
    }

    @Override
    public Object getBean(String name, Class<?> clazz) throws BeansException {
        Assert.notNull(name);
        Assert.notNull(clazz);
        return doGetBean(name, clazz, null, false);
    }

    @Override
    public Object getBean(Class<?> clazz) throws BeansException {
        Assert.notNull(clazz);
        return doGetBean(null, clazz, null, false);
    }

    @Override
    public Object getBean(Class<?> clazz, Object... args) throws BeansException {
        Assert.notNull(clazz);
        Assert.notNullElements(args);
        return doGetBean(null, clazz, args, false);
    }

    protected Object doGetBean(String name, Class<?> requiredType, Object[] args, boolean typeCheckOnly) {
        BeanDefinition beanDefinition = beanContainers.get(name);
        if (beanDefinition == null) {
            // 如果bean为空，则抛出异常，这是因为没有定义名为name的bean
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        // 获取FactoryBean中的Bean对象
        Object bean = beanDefinition.getSource();
        if (bean == null) {
            // 刚创建对象，其它什么都没有做
//            bean = doCreateBean(beanName, factoryBean);
            // 初始化bean对象
            // 这里bean是初始化之后的bean，与刚开始创建的beean不一样
        }
        return bean;
    }

    /**
     * 根据bean的名称与bean的定义创建Bean实例
     * @param name
     * @param beanDefinition
     * @param <T>
     * @return
     */
    protected <T> T doGreateBean(String name, BeanDefinition beanDefinition) {
        return doCreateBean(name, beanDefinition, null);
    }

    /**
     *
     * @param name
     * @param beanDefinition
     * @param args
     * @param <T>
     * @return
     */
    protected <T> T doCreateBean(String name, BeanDefinition beanDefinition, @Nullable Object[] args) {

        T bean = createBeanInstance(beanDefinition);

//        beanDefinition.set
        return bean;
    }

    /**
     * 创建Bean的实例
     * @param beanDefinition
     * @param <T>
     * @return
     * @throws BeansException
     */
    protected <T> T createBeanInstance(BeanDefinition beanDefinition) throws BeansException {
        try {
            return (T) beanDefinition.getBeanClass().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new BeansException(e.getMessage());
        }
    }

    /**
     * 创建Bean实例
     * @param name
     * @param beanDefinition
     * @param args
     * @param <T>
     * @return
     */
    protected <T> T createBeanInstance(String name, BeanDefinition beanDefinition, @Nullable Object[] args) {
        // 确保编程时 bean 已经被解析
        T bean = createBeanInstance(beanDefinition);
        return bean;
    }
}
