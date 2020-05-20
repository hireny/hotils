package org.hotilsframework.inject.binder;

import org.hotilsframework.inject.Scope;

import java.lang.annotation.Annotation;

/**
 * @author hireny
 * @className ScopedBindingBuilder
 * @create 2020-05-17 23:17
 */
public interface ScopedBindingBuilder {

    void in(Class<? extends Annotation> scopeAnnotation);

    void in(Scope scope);
}
