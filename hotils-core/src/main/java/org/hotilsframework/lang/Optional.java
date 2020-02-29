package org.hotilsframework.lang;

import org.hotilsframework.utils.ObjectUtils;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @ClassName: Optional
 * @Author: hireny
 * @Date: Created in 2020-01-30 12:50
 * @Version: 1.0
 */
public final class Optional<T> implements Serializable {
    private static final long serialVersionUID = 2530734794529922233L;

    private static final Optional<?> EMPTY = new Optional<>();

    private final T value;

    public static <T> Optional<T> of(T value) {
        return new Optional<>(value);
    }

    private Optional() {
        this(null);
    }

    private Optional(T value) {
        this.value = value;
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    /**
     * 判断该值是否为空
     * @return
     */
    public boolean isPresent() {
        return value != null;
    }

    /**
     * 不为空，返回值，为空，返回参数值
     * @param other
     * @return
     */
    public T orElse(T other) {
        return value != null ? value : other;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Optional)) {
            return false;
        }

        Optional<?> other = (Optional<?>) obj;
        return ObjectUtils.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return ObjectUtils.hashCode(value);
    }
}
