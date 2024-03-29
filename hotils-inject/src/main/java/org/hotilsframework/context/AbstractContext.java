package org.hotilsframework.context;

import org.hotilsframework.collect.MapUtils;
import org.hotilsframework.inject.BeanDefinition;
import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.binding.Binding;
import org.hotilsframework.inject.binding.SampleBinding;
import org.hotilsframework.inject.factory.BeanFactory;
import org.hotilsframework.inject.factory.DefaultBeanFactory;
import org.hotilsframework.lang.Assert;

import java.util.Collections;
import java.util.Map;

/**
 * AbstractBeanContext
 * 类描述
 *
 * @author hireny
 * @create 2020-08-18 0:07
 */
public class AbstractContext implements Context {

    /**
     * 父Bean上下文
     */
    private final Context                     parent;
    /**
     * 明确的绑定容器
     */
    private final Map<Key<?>, Binding<?>>     explicitBindings       = MapUtils.newConcurrentHashMap();
    /**
     * 明确的绑定院系容器
     */
    private final Map<Key<?>, BeanDefinition> explicitBindingsMuable = MapUtils.newConcurrentHashMap();


    private final BeanFactory elements;

    /**
     * 用于上锁该类元素的锁对象
     */
    private final Object lock;

    public AbstractContext(Context parent) {
        this.parent = Assert.notNull(parent, "parent bean context is null.");
        this.elements = new DefaultBeanFactory();
        this.lock = (parent == Context.NONE) ? this : parent.lock();
    }

    public AbstractContext(Context parent, BeanFactory provider) {
        this.parent = Assert.notNull(parent, "parent bean context is null.");
        this.elements = provider;
        this.lock = (parent == Context.NONE) ? this : parent.lock();
    }

    @Override
    public Context parent() {
        return parent;
    }

    /**
     * 返回只读的绑定元素集
     * @return
     */
    @Override
    public Map<Key<?>, Binding<?>> getBindings() {
        return Collections.unmodifiableMap(explicitBindings);
    }

    @Override
    public Map<Key<?>, BeanDefinition> getBeanDefinitions() {
        return Collections.unmodifiableMap(explicitBindingsMuable);
    }

    /**
     * 获取键对应的绑定元素
     * @param key
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> SampleBinding<T> getBinding(Key<T> key) {
        Binding<?> binding = getBindings().get(key);
        return binding != null ? (SampleBinding<T>) binding : parent.getBinding(key);
    }

    @Override
    public BeanDefinition getBeanDefinition(Key<?> key) {
        BeanDefinition beanDefinition = getBeanDefinitions().get(key);
        return beanDefinition != null ? beanDefinition : parent.getBeanDefinition(key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(Key<?> key, Class<?> scopeType) {
        return (T) elements.get(key, scopeType);
    }

    @Override
    public void putBeanDefinition(Key<?> key, BeanDefinition beanDefinition) {
        explicitBindingsMuable.put(key, beanDefinition);
    }

    @Override
    public void putBinding(Key<?> key, SampleBinding<?> binding) {
        explicitBindings.put(key, binding);
    }

    @Override
    public Object lock() {
        return this.lock;
    }

}
