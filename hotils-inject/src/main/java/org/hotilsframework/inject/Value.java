package org.hotilsframework.inject;

import java.util.Objects;

/**
 * Value
 *
 * 用以描述Bean值的类
 *
 * @author hireny
 * @create 2020-08-03 0:51
 */
public class Value<T> {

    private final Class<T> type;
    private final int hashCode;

    public Value(Class<T> type) {
        this.type = type;
        this.hashCode = computeHashCode();
    }

    public Class<T> getType() {
        return type;
    }

    private int computeHashCode() {
        return type.hashCode() * 31;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Value<?> value = (Value<?>) o;
        return hashCode == value.hashCode &&
                Objects.equals(type, value.type);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Value{");
        sb.append("type=").append(type);
        sb.append(", hashCode=").append(hashCode);
        sb.append('}');
        return sb.toString();
    }

    public static <T> Value<T> get(Class<T> type) {
        return new Value<>(type);
    }
}
