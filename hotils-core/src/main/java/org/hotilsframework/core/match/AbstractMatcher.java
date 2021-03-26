package org.hotilsframework.core.match;

/**
 * AbstractMatcher
 * 类描述
 *
 * @author hireny
 * @create 2020-12-29 21:40
 */
public abstract class AbstractMatcher<T> implements Matcher<T> {

    private final T value;

    public AbstractMatcher(final T value) {
        this.value = value;
    }

    @Override
    public boolean match(T t) {
        return this.value.equals(t);
    }
}
