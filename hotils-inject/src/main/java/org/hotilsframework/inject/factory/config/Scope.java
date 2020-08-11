package org.hotilsframework.inject.factory.config;

import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.annotation.Prototype;
import org.hotilsframework.inject.Provider;
import org.hotilsframework.inject.annotation.Singleton;

import java.lang.annotation.Annotation;

/**
 * 范围
 * @author hireny
 * @className Scope
 * @create 2020-04-01 20:18
 */
public interface Scope {

    /**
     * 注册Bean元素
     * @param key
     * @param element
     */
    void register(Key<?> key, Object element);

    /**
     * 根据指定的键来获取该作用域的对象
     * @param key       键，用来获取该作用域下的提供者
     * @param <T>       泛型
     * @return
     */
    <T> T get(Key<T> key);

    /**
     * 移除作用域中关于键的元素
     * @param key
     * @return
     */
    Object remove(Key<?> key);

    /**
     * 判断该key是否存在
     * @param key
     * @return
     */
    boolean contains(Key<?> key);

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
            public void register(Key<?> key, Object element) {
            }

            @Override
            public <T> T get(Key<T> key) {
                return null;
            }

            @Override
            public Object remove(Key<?> key) {
                return null;
            }

            @Override
            public boolean contains(Key<?> key) {
                return false;
            }

            @Override
            public Class<? extends Annotation> getScopeAnnotation() {
                return scopeType;
            }
        };
    }
}
