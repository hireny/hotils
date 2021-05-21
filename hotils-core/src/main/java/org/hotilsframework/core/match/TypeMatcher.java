package org.hotilsframework.core.match;

/**
 * TypeMatcher
 *
 * 类型匹配
 *
 * @author hireny
 * @create 2020-12-02 11:56
 */
public class TypeMatcher extends AbstractMatcher<Class<?>> implements Matcher<Class<?>> {


    public TypeMatcher(Class<?> value) {
        super(value);
    }


    @Override
    public boolean match(Class<?> type) {
        return super.match(type);
    }
}
