package org.hotilsframework.inject;

import org.hotilsframework.inject.binder.AnnotatedBindingBuilder;

/**
 * 用于一个接口和实现的绑定
 * @author hireny
 * @className Binder
 * @create 2020-05-15 22:33
 */
public interface Binder {

    <T> AnnotatedBindingBuilder<T> bind(Class<T> type);
}
