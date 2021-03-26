package org.hotilsframework.inject.factory.config;

import org.hotilsframework.inject.BeanKey;
import org.hotilsframework.inject.Scope;

import java.lang.annotation.Annotation;

/**
 * AbstractScope
 * 类描述
 *
 * @author hireny
 * @create 2020-08-10 0:17
 */
public abstract class AbstractScoping implements Scoping {


    @Override
    public void register(BeanKey<?> beanKey, Object element) {
    }

    @Override
    public <T> T get(BeanKey<T> beanKey) {
        return null;
    }

    @Override
    public Object remove(BeanKey<?> beanKey) {
        return null;
    }

    @Override
    public boolean containsKey(BeanKey<?> beanKey) {
        return false;
    }

    @Override
    public Class<? extends Annotation> getScopeAnnotation() {
        return null;
    }

    @Override
    public Scope getScope() {
        return null;
    }
}
