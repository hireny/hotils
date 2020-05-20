package org.hotilsframework.inject.binder;

/**
 * @author hireny
 * @className LinkedBindingBuilder
 * @create 2020-05-17 23:19
 */
public interface LinkedBindingBuilder<T> extends ScopedBindingBuilder {

    ScopedBindingBuilder to(Class<? extends T> implementation);
}
