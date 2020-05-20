package org.hotilsframework.inject;

import org.hotilsframework.utils.ObjectUtils;

import java.util.Objects;

/**
 * 对Bean实例的注册操作
 * @author hireny
 * @className Providers
 * @create 2020-05-12 22:00
 */
public class Providers {

    private Providers() {}

    public static <T> Provider<T> of(final T instance) {
        return new ConstantProvider<T> (instance);
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
