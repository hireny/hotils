package org.hotilsframework.inject;


/**
 * Bean的提供者
 * @author hireny
 * @className Provider
 * @create 2020-05-12 21:54
 */
public interface Provider<T> extends javax.inject.Provider<T> {
    /**
     * 提供一个Bean实例对象
     * @return
     */
    @Override
    T get();
}
