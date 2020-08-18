package org.hotilsframework.inject;

import org.hotilsframework.core.reflects.Instantiator;
import org.hotilsframework.utils.ObjectUtils;

/**
 * 对Bean实例的注册操作
 * @author hireny
 * @className Providers
 * @create 2020-05-12 22:00
 */
public class Providers {
    /**
     * 未知资源 用于父资源提供者
     */
    public static final Object UNKNOWN_SOURCE = "[unknown source]";

    private Providers() {}

    public static <T> Provider<T> of(final T instance) {
        return new ConstantProvider<> (instance);
    }

    private static final class ConstantProvider<T> implements Provider<T> {

        private final T instance;

        private ConstantProvider(T instance) {
            this.instance = instance;
        }

        @Override
        public T get() {
            return instance;
        }

        @Override
        public String toString() {
            return "of(" + instance + ")";
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof ConstantProvider)
                    && ObjectUtils.equals(instance, ((ConstantProvider<?>) o).instance);
        }

        @Override
        public int hashCode() {
            return ObjectUtils.hashCode(instance);
        }
    }
}
