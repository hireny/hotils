package org.hotilsframework.inject.factory.config;

import org.hotilsframework.inject.Injector;
import org.hotilsframework.inject.Key;
import org.hotilsframework.inject.annotation.Prototype;

import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        public <T> T get(Key<T> key) {
            return null;
        }
        @Override
        public Object remove(Key<?> key) {
            return null;
        }
        @Override
        public boolean containsKey(Key<?> key) {
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
        public <T> T get(Key<T> key) {
            return null;
        }
        @Override
        public Object remove(Key<?> key) {
            return null;
        }
        @Override
        public boolean containsKey(Key<?> key) {
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

    private static final Map<Scope, Class<?>> SCOPE_TYPES = new ConcurrentHashMap<>();

    static {
        Map<Scope, Class<?>> tempScopeTypes = new ConcurrentHashMap<>();
        tempScopeTypes.put(PROTOTYPE, Prototypes.class);
        tempScopeTypes.put(SINGLETON, Singletons.class);
        SCOPE_TYPES.putAll(tempScopeTypes);
    }

    public static Collection<Class<?>> getScopeClasses() {
        return SCOPE_TYPES.values();
    }

    public static Map<Scope, Class<?>> getScopeTypes() {
        return SCOPE_TYPES;
    }


}
