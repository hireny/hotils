package org.hotilsframework.context;

import org.hotilsframework.inject.BeanDefinition;
import org.hotilsframework.inject.Binding;
import org.hotilsframework.inject.Key;

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
        public Map<Key<?>, Binding<?>> getBindings() {
            return null;
        }

        @Override
        public Map<Key<?>, BeanDefinition> getBeanDefinitions() {
            return null;
        }

        @Override
        public <T> Binding<T> getBinding(Key<T> key) {
            return null;
        }

        @Override
        public BeanDefinition get(Key<?> key) {
            return null;
        }

        @Override
        public void putBinding(Key<?> key, BeanDefinition beanDefinition) {
            throw new UnsupportedOperationException("不支持存储操作");
        }

        @Override
        public void putBinding(Key<?> key, Binding<?> binding) {
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
    Map<Key<?>, Binding<?>> getBindings();

    /**
     * 获取键值对应的绑定关系
     * @return
     */
    Map<Key<?>, BeanDefinition> getBeanDefinitions();

    /**
     * 根据键获取对应的绑定元素
     * @param key
     * @param <T>
     * @return
     */
    <T> Binding<T> getBinding(Key<T> key);

    /**
     * 根据键获取BeanDefinition对象
     *
     * @param key
     * @return
     */
    BeanDefinition get(Key<?> key);

    /**
     * 存储键与对应的BeanDefinition的绑定关系
     * @param key
     * @param beanDefinition
     */
    void putBinding(Key<?> key, BeanDefinition beanDefinition);


    /**
     * 存放绑定的键值对
     * @param key
     * @param binding
     */
    void putBinding(Key<?> key,  Binding<?> binding);

    /**
     * 锁对象
     * @return
     */
    Object lock();
}
