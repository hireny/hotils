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
        public String toString() {
            return "Scopes.SINGLETON";
        }
    };

    /**
     * 判断该注解是否是@Scope注解
     * @param annotation
     * @return
     */
    static boolean isScopeAnnotation(Annotation annotation) {
        return isScopeAnnotation(annotation.annotationType());
    }

    /**
     * 判断该类是否是@Scope注解
     * @param annotationType
     * @return
     */
    static boolean isScopeAnnotation(Class<? extends Annotation> annotationType) {
        return annotationType.isAnnotationPresent(ScopeAnnotation.class);
    }

}
