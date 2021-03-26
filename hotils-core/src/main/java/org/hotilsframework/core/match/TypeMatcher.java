package org.hotilsframework.core.match;

/**
 * TypeMatcher
 * 类描述
 *
 * @author hireny
 * @create 2020-12-02 11:56
 */
public class TypeMatcher<T> implements Matcher<T> {

    private final Class<T> value;

    public TypeMatcher(Class<T> value) {
        this.value = value;
    }


    @Override
    public boolean match(T t) {
        return this.value.equals(t);
    }
}
