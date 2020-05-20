package org.hotilsframework.inject.binder;

import java.lang.annotation.Annotation;

/**
 * @author hireny
 * @className AnnotatedBindingBuilder
 * @create 2020-05-17 23:21
 */
public interface AnnotatedBindingBuilder<T> extends LinkedBindingBuilder<T> {

    LinkedBindingBuilder<T> annotatedWith(Class<? extends Annotation> annotationType);
}
