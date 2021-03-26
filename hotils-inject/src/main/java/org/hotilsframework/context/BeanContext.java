package org.hotilsframework.context;

import org.hotilsframework.inject.BeanDefinition;
import org.hotilsframework.inject.binding.Binding;
import org.hotilsframework.inject.BeanKey;
import org.hotilsframework.inject.binding.SampleBinding;

import java.util.Map;

/**
 * ApplicationContext
 *
 * 应用上下文
 *
 * @author hireny
 * @create 2020-07-27 23:04
 */
public interface BeanContext {

    BeanContext NONE = new BeanContext() {
        @Override
        public BeanContext parent() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Map<BeanKey<?>, Binding<?>> getBindings() {
            return null;
        }

        @Override
        public Map<BeanKey<?>, BeanDefinition> getBeanDefinitions() {
            return null;
        }

        @Override
        public <T> SampleBinding<T> getBinding(BeanKey<T> beanKey) {
            return null;
        }

        @Override
        public BeanDefinition getBeanDefinition(BeanKey<?> beanKey) {
            throw new UnsupportedOperationException("不支持该操作");
        }

        @Override
        public <T> T get(BeanKey<?> beanKey, Class<?> scopeType) {
            throw new UnsupportedOperationException("不支持该操作");
        }

        @Override
        public void putBeanDefinition(BeanKey<?> beanKey, BeanDefinition beanDefinition) {
            throw new UnsupportedOperationException("不支持存储操作");
        }

        @Override
        public void putBinding(BeanKey<?> beanKey, SampleBinding<?> binding) {
            throw new UnsupportedOperationException("不支持存储操作");
        }

        @Override
        public Object lock() {
            return null;
        }
    };

    /**
     * 父Bean上下文
     * @return
     */
    BeanContext parent();

    /**
     * 获取与键有关的所有绑定元素
     * @return
     */
    Map<BeanKey<?>, Binding<?>> getBindings();

    /**
     * 获取键值对应的绑定关系
     * @return
     */
    Map<BeanKey<?>, BeanDefinition> getBeanDefinitions();

    /**
     * 根据键获取对应的绑定元素
     * @param beanKey
     * @param <T>
     * @return
     */
    <T> SampleBinding<T> getBinding(BeanKey<T> beanKey);

    BeanDefinition getBeanDefinition(BeanKey<?> beanKey);

    /**
     * 根据键获取BeanDefinition对象
     *
     * @param beanKey       键
     * @param scopeType 该键属于作用域
     * @return
     */
    <T> T get(BeanKey<?> beanKey, Class<?> scopeType);

    /**
     * 存储键与对应的BeanDefinition的绑定关系
     * @param beanKey
     * @param beanDefinition
     */
    void putBeanDefinition(BeanKey<?> beanKey, BeanDefinition beanDefinition);


    /**
     * 存放绑定的键值对
     * @param beanKey
     * @param binding
     */
    void putBinding(BeanKey<?> beanKey, SampleBinding<?> binding);

    /**
     * 锁对象
     * @return
     */
    Object lock();
}
