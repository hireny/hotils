package org.hotilsframework.inject;

import java.lang.annotation.Annotation;

/**
 * 范围
 * @author hireny
 * @className Scope
 * @create 2020-04-01 20:18
 */
public interface Scope {
    /**
     * 范围提供者，根据Key与Provider返回该Key的范围的对象
     * @param key
     * @param unscoped
     * @param <T>
     * @return
     */
    <T> Provider<T> scope(Key<T> key, Provider<T> unscoped);

    <T> Provider<T> get(Key<T> key, Provider<T> unscoped);

    /**
     * 获取作用域注解
     * @return
     */
    Class<? extends Annotation> getScopeAnnotation();

    /**
     * 返回字符串
     * @return
     */
    @Override
    String toString();

    /**
     * 传入作用域注解，返回作用域
     * @param scopeType
     * @return
     */
    static Scope forAnnotation(final Class<? extends Annotation> scopeType) {
        if (scopeType == Singleton.class || scopeType == javax.inject.Singleton.class) {
            // 单例作用域
            return Scopes.SINGLETON;
        }
        if (scopeType == Prototype.class) {
            // 原型作用域
            return Scopes.PROTOTYPE;
        }
        return new Scope() {
            @Override
            public <T> Provider<T> scope(Key<T> key, Provider<T> unscoped) {
                return unscoped;
            }

            @Override
            public <T> Provider<T> get(Key<T> key, Provider<T> unscoped) {
                return null;
            }

            @Override
            public Class<? extends Annotation> getScopeAnnotation() {
                return scopeType;
            }
        };
    }
}
