package org.hotilsframework.inject.factory.config;

import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.Provider;

import java.lang.annotation.Annotation;

/**
 * Prototypes
 * 类描述
 *
 * @author hireny
 * @create 2020-08-09 23:36
 */
public class Prototypes implements Scope {
    @Override
    public void register(Key<?> key, Object element) {
    }

    @Override
    public <T> Provider<T> get(Key<T> key, Provider<T> unscoped) {
        return unscoped;
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
