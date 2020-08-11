package org.hotilsframework.inject.binds.binder;

import org.hotilsframework.inject.qualifier.Qualifier;

import java.lang.annotation.Annotation;

/**
 * InterfaceBindingBuilder
 * 类描述
 *
 * @author hireny
 * @create 2020-08-02 19:42
 */
public interface BindingBuilderInterface<T> {

    BindingBuilder<T> annotatedWith(Qualifier qualifier);

    BindingBuilder<T> annotatedWith(Class<? extends Annotation> annotationType);

    BindingBuilder<T> to(Class<? extends T> implementation);

    /**
     * 绑定的实例
     * @param instance
     */
    void toInstance(T instance);

    /**
     * 绑定Scope作用域
     * @param scopeType
     */
    void in(Class<? extends Annotation> scopeType);
}
