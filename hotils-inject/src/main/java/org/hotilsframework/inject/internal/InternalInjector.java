package org.hotilsframework.inject.internal;

import org.hotilsframework.beans.BeansException;
import org.hotilsframework.collect.LinkedMultiValueMap;
import org.hotilsframework.collect.MultiValueMap;
import org.hotilsframework.context.BeanContext;
import org.hotilsframework.inject.*;
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
    public <T> Binding<T> getBinding(Key<T> key) {
        Binding<T> binding = beanContext.getBinding(key);
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
        Binding<T> binding = getBinding(key);
        System.out.println("注入器中绑定关系=" + binding);
        return binding.getProvider();
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
}
