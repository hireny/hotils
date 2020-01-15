package me.hireny.commons.utils;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @ClassName: Suppliers
 * @Author: hireny
 * @Date: Created in 2020-01-13 19:40
 * @Version: 1.0
 */
public final class Suppliers {
    private Suppliers() {}

    /**
     * 创建单例
     * @param instance
     * @param <T>
     * @return
     */
    public static <T> Supplier<T> ofInstance(T instance) {
        return new SupplierOfInstance<T>(instance);
    }

    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {

        private static final long serialVersionUID = -3004960051309014768L;

        final T instance;

        SupplierOfInstance(T instance) {
            this.instance = instance;
        }

        @Override
        public T get() {
            return instance;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof SupplierOfInstance) {
                SupplierOfInstance<?> that = (SupplierOfInstance<?>) o;
                return Objects.equals(instance, that.instance);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(instance);
        }

        @Override
        public String toString() {
            return "SupplierOfInstance{" +
                    "instance=" + instance +
                    '}';
        }
    }
}
