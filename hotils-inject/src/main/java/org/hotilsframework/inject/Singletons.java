package org.hotilsframework.inject;

import org.hotilsframework.beans.BeansException;
import org.hotilsframework.collect.Maps;
import org.hotilsframework.core.reflects.Instancer;
import org.hotilsframework.utils.Assert;

import java.util.Map;
import java.util.Objects;

/**
 * Singletons
 *
 * 用于存放单例作用域的元素
 *
 * @author hireny
 * @create 2020-08-05 0:48
 */
public class Singletons implements BeanElements {
    /**
     * 单例元素的关系映射存储
     */
    private final Map<Key<?>, Object> singletons = Maps.newConcurrentHashMap();

    @Override
    public Object getElement(Key<?> key) throws BeansException {
        Assert.notNull(key, "key is not null.");
        return doGetElement(key);
    }

    private <T> T doGetElement(Key<?> key) {
        Object element = singletons.get(key);
        if (element == null) {
            element = doCreateElement(key);
            // 创建后，存储起来
            singletons.put(key, element);
        }
        return (T) element;
    }

    /**
     * 创建元素
     * @param key
     * @param <T>
     * @return
     */
    private <T> T doCreateElement(Key<?> key) {
        // 创建对象
        return Instancer.tryInstance(key.getType());
    }

    @Override
    @SuppressWarnings("unchecked")
    public  <T> Provider<T> getProvider(Key<T> key) {
        Assert.notNull(key, "key is not null.");
        Object element = getElement(key);
        return (Provider<T>) Providers.of(element);
    }
}
