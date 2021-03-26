package org.hotilsframework.context;

import org.hotilsframework.collect.Maps;
import org.hotilsframework.inject.BeanDefinition;
import org.hotilsframework.inject.BeanKey;
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
public class AbstractBeanContext implements BeanContext {

    /**
     * 父Bean上下文
     */
    private final BeanContext                     parent;
    /**
     * 明确的绑定容器
     */
    private final Map<BeanKey<?>, Binding<?>>     explicitBindings       = Maps.newConcurrentHashMap();
    /**
     * 明确的绑定院系容器
     */
    private final Map<BeanKey<?>, BeanDefinition> explicitBindingsMuable = Maps.newConcurrentHashMap();


    private final BeanFactory elements;

    /**
     * 用于上锁该类元素的锁对象
     */
    private final Object lock;

    public AbstractBeanContext(BeanContext parent) {
        this.parent = Assert.notNull(parent, "parent bean context is null.");
        this.elements = new DefaultBeanFactory();
        this.lock = (parent == BeanContext.NONE) ? this : parent.lock();
    }

    public AbstractBeanContext(BeanContext parent, BeanFactory provider) {
        this.parent = Assert.notNull(parent, "parent bean context is null.");
        this.elements = provider;
        this.lock = (parent == BeanContext.NONE) ? this : parent.lock();
    }

    @Override
    public BeanContext parent() {
        return parent;
    }

    /**
     * 返回只读的绑定元素集
     * @return
     */
    @Override
    public Map<BeanKey<?>, Binding<?>> getBindings() {
        return Collections.unmodifiableMap(explicitBindings);
    }

    @Override
    public Map<BeanKey<?>, BeanDefinition> getBeanDefinitions() {
        return Collections.unmodifiableMap(explicitBindingsMuable);
    }

    /**
     * 获取键对应的绑定元素
     * @param beanKey
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> SampleBinding<T> getBinding(BeanKey<T> beanKey) {
        Binding<?> binding = getBindings().get(beanKey);
        return binding != null ? (SampleBinding<T>) binding : parent.getBinding(beanKey);
    }

    @Override
    public BeanDefinition getBeanDefinition(BeanKey<?> beanKey) {
        BeanDefinition beanDefinition = getBeanDefinitions().get(beanKey);
        return beanDefinition != null ? beanDefinition : parent.getBeanDefinition(beanKey);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(BeanKey<?> beanKey, Class<?> scopeType) {
        return (T) elements.get(beanKey, scopeType);
    }

    @Override
    public void putBeanDefinition(BeanKey<?> beanKey, BeanDefinition beanDefinition) {
        explicitBindingsMuable.put(beanKey, beanDefinition);
    }

    @Override
    public void putBinding(BeanKey<?> beanKey, SampleBinding<?> binding) {
        explicitBindings.put(beanKey, binding);
    }

    @Override
    public Object lock() {
        return this.lock;
    }

}
