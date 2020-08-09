package org.hotilsframework.inject.internal;

import org.hotilsframework.beans.BeansException;
import org.hotilsframework.collect.LinkedMultiValueMap;
import org.hotilsframework.collect.MultiValueMap;
import org.hotilsframework.context.BeanContext;
import org.hotilsframework.inject.*;
import org.hotilsframework.inject.factory.InternalFactory;
import org.hotilsframework.inject.factory.Singletons;
import org.hotilsframework.utils.Assert;

import java.util.Map;

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
    /**
     * 绑定的链式元素
     */
    final MultiValueMap<Key<?>, Binding<?>> bindingMultiValueMap = LinkedMultiValueMap.create();

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
        System.out.println("绑定的关系11=" + binding);
        if (binding != null) {
            return binding;
        }
        return null;
    }

    /**
     * 根据键获取提供者
     * @param key
     * @param <T>
     * @return
     */
    public <T> Provider<T> getProvider(Key<T> key) {
        Assert.notNull(key, "key is not null.");
        System.out.println("getProvider提供的键=" + key);
        SampleBinding<? extends T> binding = getBinding(key);
        System.out.println("注入器中绑定关系=" + binding);
        System.out.println("Bean上下文=" + beanContext);
        final InternalFactory<? extends T> internalFactory = binding.getInternalFactory();
        System.out.println("内部工厂=" + internalFactory);

        return () -> {
            T t = internalFactory.get(beanContext);
            return t;
        };
    }

    public <T> T getInstance(Key<T> key) {
        return getProvider(key).get();
    }

    @Override
    public <T> T getInstance(Class<T> type) throws BeansException {
        return getInstance(Key.get(type));
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
