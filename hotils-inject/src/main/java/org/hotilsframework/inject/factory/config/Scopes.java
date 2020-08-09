package org.hotilsframework.inject.factory.config;

import org.hotilsframework.inject.Injector;
import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.Prototype;
import org.hotilsframework.inject.Provider;

import javax.inject.Singleton;
import java.lang.annotation.Annotation;

/**
 * provider作用域
 * @author hireny
 * @className Scopes
 * @create 2020-05-17 23:14
 */
public class Scopes {

    // 下列变量用来描述每个Bean的作用域

    /**
     * 原型作用域，代表每次请求都会获得一个新的实例。
     */
    public static final Scope PROTOTYPE = new Scope() {
        @Override
        public void register(Key<?> key, Object element) {
        }
        @Override
        public <T> Provider<T> get(Key<T> key, Provider<T> unscoped) {
            return unscoped;
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
            return Prototype.class;
        }
        @Override
        public String toString() {
            return "Scopes.PROTOTYPE";
        }
    };

    /**
     * 每个 {@link Injector} 有一个实例。请参见 {@code @}{@link Singleton}
     */
    public static final Scope SINGLETON = new Scope() {
        @Override
        public void register(Key<?> key, Object element) {
        }
        @Override
        public <T> Provider<T> get(Key<T> key, Provider<T> unscoped) {
            return unscoped;
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
            return Singleton.class;
        }
        @Override
        public String toString() {
            return "Scopes.SINGLETON";
        }
    };
}
