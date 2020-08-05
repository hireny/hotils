package org.hotilsframework.inject;

import javax.inject.Singleton;
import java.lang.annotation.Annotation;

/**
 * provider作用域
 * @author hireny
 * @className Scopes
 * @create 2020-05-17 23:14
 */
public class Scopes {
    /**
     * 原型作用域，代表每次请求都会获得一个新的实例。
     */
    public static final Scope PROTOTYPE = new Scope() {
        @Override
        public <T> Provider<T> scope(Class<?> key, Provider<T> unscoped) {
            return unscoped;
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
        public <T> Provider<T> scope(Class<?> key, Provider<T> creator) {
            return new Provider<T>() {
                /**
                 * 实例
                 */
                private T instance;

                @Override
                public T get() {

                    if (instance == null) {
                        // 加锁
                        synchronized (Injector.class) {
                            if (instance == null) {
                                instance = creator.get();
                            }
                        }
                    }
                    return instance;
                }

                @Override
                public String toString() {
                    return creator.toString();
                }
            };
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

    /**
     * 查询绑定类型是否是单例模式
     * @param binding
     * @return
     */
    public static boolean isSingleton(Binding<?> binding) {
        return false;
    }

}
