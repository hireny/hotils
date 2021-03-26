package org.hotilsframework.inject;


import org.hotilsframework.core.factory.ObjectProvider;

import java.util.function.Supplier;

/**
 * Bean的提供者
 * @author hireny
 * @className Provider
 * @create 2020-05-12 21:54
 */
public interface Provider<T> extends javax.inject.Provider<T>, Supplier<T>, ObjectProvider {
    /**
     * 提供一个Bean实例对象
     * @return
     */
    @Override
    T get();
}
