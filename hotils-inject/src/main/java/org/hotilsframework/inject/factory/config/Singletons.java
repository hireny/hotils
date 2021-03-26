package org.hotilsframework.inject.factory.config;

import org.hotilsframework.collect.Maps;
import org.hotilsframework.lang.reflects.TypeInstance;
import org.hotilsframework.inject.*;
import org.hotilsframework.inject.annotation.Singleton;
import org.hotilsframework.lang.Assert;

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
public class Singletons extends AbstractScoping implements Scoping {
    /**
     * 单例元素的关系映射存储
     */
    private final Map<BeanKey<?>, Object> singletons = Maps.newConcurrentHashMap();

    /**
     * 单例Bean注册
     * @param beanKey
     * @param element
     */
    @Override
    public void register(BeanKey<?> beanKey, Object element) {
        Assert.notNull(beanKey, "key must not be null.");
        Assert.notNull(element, "Singleton object must be null.");
        synchronized (this.singletons) {
            Object old = this.singletons.get(beanKey);
            if (old != null) {
                throw new IllegalStateException("Could not register object [" + element + "] under key '" + beanKey + "': there is already object [" + old + "] bound");
            }
            addSingleton(beanKey, element);
        }
    }

    protected void addSingleton(BeanKey<?> beanKey, Object element) {
        synchronized (this.singletons) {
            this.singletons.put(beanKey, element);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(BeanKey<T> beanKey) {
        Assert.notNull(beanKey, "key is not null.");
        Object element = doGetSingleton(beanKey);
        return (T) element;
    }

    private Object doGetSingleton(BeanKey<?> beanKey) {
        Object element = singletons.get(beanKey);
        if (element == null) {
            // 单例对象不存在，则创建
            element = doCreateElement(beanKey);
            // 创建后，存储起来
            singletons.put(beanKey, element);
        }
        return element;
    }

    /**
     * 创建元素
     * @param beanKey
     * @param <T>
     * @return
     */
    private <T> T doCreateElement(BeanKey<?> beanKey) {
        // 创建对象
        return TypeInstance.tryInstance(beanKey.getType());
    }

    @Override
    public boolean containsKey(BeanKey<?> beanKey) {
        return this.singletons.containsKey(beanKey);
    }

    @Override
    public Object remove(BeanKey<?> beanKey) {
        Assert.notNull(beanKey, "key is not null.");
        return this.singletons.remove(beanKey);
    }

    @Override
    public Class<? extends Annotation> getScopeAnnotation() {
        return Singleton.class;
    }

    @Override
    public String toString() {
        return "Scopes.SINGLETON";
    }
}
