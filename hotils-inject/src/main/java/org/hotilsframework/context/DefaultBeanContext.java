package org.hotilsframework.context;

import org.hotilsframework.beans.BeanDefinition;
import org.hotilsframework.collect.Lists;
import org.hotilsframework.collect.Maps;
import org.hotilsframework.inject.Binding;
import org.hotilsframework.inject.Key;
import org.hotilsframework.utils.Assert;

import java.util.*;

/**
 * DefaultBeanContext
 * 类描述
 *
 * @author hireny
 * @create 2020-07-27 23:15
 */
public class DefaultBeanContext implements BeanContext {

    /**
     * 父Bean上下文
     */
    private final BeanContext parent;
    /**
     * 明确的绑定容器
     */
    private final Map<Key<?>, Binding<?>> explicitBindings = Maps.newConcurrentHashMap();
    /**
     * 用于上锁该类元素的锁对象
     */
    private final Object lock;

    public DefaultBeanContext(BeanContext parent) {
        this.parent = Assert.notNull(parent, "parent bean context is null.");
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
    public Map<Key<?>, Binding<?>> getBindings() {
        return Collections.unmodifiableMap(explicitBindings);
    }

    /**
     * 获取键对应的绑定元素
     * @param key
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> Binding<T> getBinding(Key<T> key) {
        Binding<?> binding = getBindings().get(key);
        return binding != null ? (Binding<T>) binding : parent.getBinding(key);
    }

    @Override
    public void putBinding(Key<?> key, Binding<?> binding) {
        explicitBindings.put(key, binding);
    }

    @Override
    public Object lock() {
        return this.lock;
    }


    /**
     * 查找所有符合条件的Bean候选人
     * @param type
     * @param <T>
     * @return
     */
    protected <T> Collection<T> findBeanCandidates(Class<T> type) {
        return null;
    }
}
