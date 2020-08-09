package org.hotilsframework.inject.factory;

import org.hotilsframework.beans.BeansException;
import org.hotilsframework.collect.Maps;
import org.hotilsframework.core.reflects.Instantiator;
import org.hotilsframework.inject.*;
import org.hotilsframework.utils.Assert;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Singletons
 *
 * 用于存放单例作用域的元素
 *
 * @author hireny
 * @create 2020-08-05 0:48
 */
public class Singletons extends AliasFactory implements SingletonRegistry {
    /**
     * 单例元素的关系映射存储
     */
    private final Map<Key<?>, Object> singletons = Maps.newConcurrentHashMap();

    /**
     * 单例Bean注册
     * @param key
     * @param element
     */
    @Override
    public void registerSingleton(Key<?> key, Object element) {
        Assert.notNull(key, "key must not be null.");
        Assert.notNull(element, "Singleton object must be null.");
        synchronized (this.singletons) {
            Object old = this.singletons.get(key);
            if (old != null) {
                throw new IllegalStateException("Could not register object [" + element + "] under key '" + key + "': there is already object [" + old + "] bound");
            }
            addSingleton(key, element);
        }
    }

    protected void addSingleton(Key<?> key, Object element) {
        synchronized (this.singletons) {
            this.singletons.put(key, element);
        }
    }

    @Override
    public Object getSingleton(Key<?> key) {
        Assert.notNull(key, "key is not null.");
        return doGetElement(key);
    }

    private Object doGetElement(Key<?> key) {
        Object element = singletons.get(key);
        if (element == null) {
            // 单例对象不存在，则创建
            element = doCreateElement(key);
            // 创建后，存储起来
            singletons.put(key, element);
        }
        return element;
    }

    @Override
    public boolean containsSingleton(Key<?> key) {
        return this.singletons.containsKey(key);
    }

    /**
     * 创建元素
     * @param key
     * @param <T>
     * @return
     */
    private <T> T doCreateElement(Key<?> key) {
        // 创建对象
        return Instantiator.tryInstance(key.getType());
    }

    @SuppressWarnings("unchecked")
    public  <T> Provider<T> getProvider(Key<T> key) {
        Assert.notNull(key, "key is not null.");
        Object element = getSingleton(key);
        return (Provider<T>) Providers.of(element);
    }
}
