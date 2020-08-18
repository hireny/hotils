package org.hotilsframework.inject;

import org.hotilsframework.inject.qualifier.Qualifier;
import org.hotilsframework.inject.qualifier.Qualifiers;

import java.lang.annotation.Annotation;
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
    /**
     * 键的类型
     */
    private final Class<T>  type;
    /**
     * 限定符，用于描述键的另外信息
     */
    private final Qualifier qualifier;
    /**
     * hash值
     */
    private final int       hashCode;

    public Key(Class<T> type) {
        this(type, Qualifiers.byAnnotation(Qualifiers.typed(type)));
    }

    public Key(Class<T> type, Annotation annotation) {
        this(type, Qualifiers.byAnnotation(annotation));
    }

    public Key(Class<T> type, Qualifier qualifier) {
        this.type = type;
        this.qualifier = qualifier;
        this.hashCode = computeHashCode();
    }

    public Class<T> getType() {
        return type;
    }

    private int computeHashCode() {
        return type.hashCode() * 31 + qualifier.hashCode();
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
        // Key 用来描述唯一性
        return String.valueOf(qualifier);
    }

    public static <T> Key<T> get(Class<T> type) {
        return new Key<>(type);
    }

    public static <T> Key<T> get(Class<T> type, Qualifier qualifier) {
        return new Key<>(type, qualifier);
    }
}
