package org.hotilsframework.inject.internal;

import org.hotilsframework.beans.BeansException;
import org.hotilsframework.context.BeanContext;
import org.hotilsframework.inject.*;
import org.hotilsframework.inject.binds.Binding;
import org.hotilsframework.inject.binds.SampleBinding;
import org.hotilsframework.inject.factory.config.Scope;
import org.hotilsframework.inject.factory.InternalFactory;
import org.hotilsframework.utils.Assert;

import java.util.*;

/**
 * InjectorBuilder
 *
 * 构建器注入
 *
 * @author hireny
 * @create 2020-07-31 8:12
 */
public class InternalInjector implements Injector {

    final BeanContext beanContext;
    /**
     * 指向父类
     */
    final Injector                          parent;

    InternalInjector(Injector parent, BeanContext beanContext) {
        this.parent = parent;
        this.beanContext = beanContext;
    }


    /**
     * 获取所有的绑定键值对
     * @return
     */
    @Override
    public Map<Key<?>, Binding<?>> getBindings() {
        return beanContext.getBindings();
    }

    @Override
    public <T> SampleBinding<T> getBinding(Key<T> key) {
        SampleBinding<T> binding = beanContext.getBinding(key);
        return binding;
    }

    /**
     * 根据键获取提供者
     * @param key
     * @param <T>
     * @return
     */
    @Override
    public <T> Provider<T> getProvider(Key<T> key) {
        System.out.println("提供的键=" + key);
        Assert.notNull(key, "key is not null.");
        SampleBinding<? extends T> binding = getBinding(key);

        System.out.println("获取的绑定信息=" + binding);
        final InternalFactory<? extends T> internalFactory = binding.getInternalFactory();

        return () -> internalFactory.get(beanContext);
    }

    @Override
    public  <T> Provider<T> getProvider(Class<T> type) {
        return getProvider(Key.get(type));
    }

    @Override
    public <T> T getInstance(Key<T> key) {
        return getProvider(key).get();
    }

    @Override
    public <T> T getInstance(Class<T> type) throws BeansException {
        return getProvider(type).get();
    }

    @Override
    public Injector getParent() {
        return parent;
    }


    // 以后可以实现，必要时使用上下文时，查找本地上下文，或创建一个新线程。


    // 创建一个绑定关系

    /**
     * 根据键创建绑定关系
     * @param key
     * @param <T>
     * @return
     */
    private <T> SampleBinding<T> createSampleBinding(Key<T> key) {
        return null;
    }

    /**
     * 创建绑定关系
     * @param injector
     * @param key
     * @param scope
     * @param <T>
     * @return
     */
    static <T> SampleBinding<T> create(
            InternalInjector injector,
            Key<T> key,
            Scope scope) {
        return null;
    }
}
