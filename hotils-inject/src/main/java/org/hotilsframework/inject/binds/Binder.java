package org.hotilsframework.inject.binds;

import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.Module;
import org.hotilsframework.inject.factory.config.Scope;

import java.lang.annotation.Annotation;

/**
 * 用于一个接口和实现的绑定
 * @author hireny
 * @className Binder
 * @create 2020-05-15 22:33
 */
public interface Binder {

    <T> BindingBuilder<T> bind(Key<T> key);

    <T> BindingBuilder<T> bind(Class<T> type);

    /**
     * 绑定范围
     * @param annotationType
     * @param scope
     */
    void bindScope(Class<? extends Annotation> annotationType, Scope scope);

    /**
     * 将配置信息绑定
     * @param module
     */
    void install(Module module);
}