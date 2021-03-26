package org.hotilsframework.core.match;

/**
 * ArrayMatcher
 * 类描述
 *
 * @author hireny
 * @create 2021-01-20 23:28
 */
public class ArrayMatcher<T> extends AbstractMatcher<T> implements Matcher<T> {

    public ArrayMatcher(T value) {
        super(value);
    }
}
