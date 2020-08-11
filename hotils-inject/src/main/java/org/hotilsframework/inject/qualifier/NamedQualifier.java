package org.hotilsframework.inject.qualifier;

import java.util.Objects;

/**
 * NamedQuailfier
 *
 * 名字限定
 *
 * @author hireny
 * @create 2020-08-07 23:12
 */
public class NamedQualifier implements Qualifier {
    /**
     * 限定名
     */
    private final String value;

    public NamedQualifier(String name) {
        this.value = Objects.requireNonNull(name, "Argument [name] can not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NamedQualifier that = (NamedQualifier) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("@Quailfier(");
        sb.append("value='").append(value).append('\'');
        sb.append(')');
        return sb.toString();
    }
}
