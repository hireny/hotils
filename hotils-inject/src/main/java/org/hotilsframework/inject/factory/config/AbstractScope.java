package org.hotilsframework.inject.factory.config;

import org.hotilsframework.inject.Key;

import java.lang.annotation.Annotation;

/**
 * AbstractScope
 * 类描述
 *
 * @author hireny
 * @create 2020-08-10 0:17
 */
public abstract class AbstractScope implements Scope {


    @Override
    public void register(Key<?> key, Object element) {
    }

    @Override
    public <T> T get(Key<T> key) {
        return null;
    }

    @Override
    public Object remove(Key<?> key) {
        return null;
    }

    @Override
    public boolean contains(Key<?> key) {
        return false;
    }

    @Override
    public Class<? extends Annotation> getScopeAnnotation() {
        return null;
    }
}