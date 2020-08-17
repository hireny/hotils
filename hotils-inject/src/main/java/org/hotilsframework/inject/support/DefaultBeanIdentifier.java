package org.hotilsframework.inject.support;

import org.hotilsframework.inject.BeanIdentifier;

import java.util.Objects;

/**
 * DefaultBeanIdentifier
 *
 * 默认实现的Bean的身份唯一性描述
 *
 * @author hireny
 * @create 2020-08-12 1:35
 */
public class DefaultBeanIdentifier implements BeanIdentifier {
    private static final long serialVersionUID = -6354519098890252951L;
    private final String id;

    public DefaultBeanIdentifier(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int length() {
        return id.length();
    }

    @Override
    public char charAt(int index) {
        return id.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return id.subSequence(start, end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultBeanIdentifier that = (DefaultBeanIdentifier) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
