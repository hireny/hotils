package org.hotilsframework.inject.factory.config;

import org.hotilsframework.core.reflects.Instantiator;
import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.annotation.Prototype;

import java.lang.annotation.Annotation;

/**
 * Prototypes
 *
 * 原型作用域的对象获取类
 *
 * @author hireny
 * @create 2020-08-09 23:36
 */
public class Prototypes extends AbstractScope implements Scope {
    @Override
    public void register(Key<?> key, Object element) {
    }

    @Override
    public <T> T get(Key<T> key) {
        return Instantiator.tryInstance(key.getType());
    }
    @Override
    public Object remove(Key<?> key) {
        return null;
    }
    @Override
    public boolean containsKey(Key<?> key) {
        return false;
    }
    @Override
    public Class<? extends Annotation> getScopeAnnotation() {
        return Prototype.class;
    }
}
