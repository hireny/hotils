package org.hotilsframework.inject;

import java.util.Objects;

/**
 * Key
 *
 * 用以描述Bean键的类
 *
 * @author hireny
 * @create 2020-07-28 22:32
 */
public class Key<T> {
    private final Class<T> type;
//    private final Qualifier<? extends Annotation> qualifier;
    private final int hashCode;

    public Key(Class<T> type) {
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
        Key<?> key = (Key<?>) o;
        return hashCode == key.hashCode &&
                Objects.equals(type, key.type);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Key{");
        sb.append("type=").append(type);
        sb.append(", hashCode=").append(hashCode);
        sb.append('}');
        return sb.toString();
    }

    public static <T> Key<T> get(Class<T> type) {
        return new Key<>(type);
    }
}
