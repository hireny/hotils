package org.hotilsframework.core.match;

/**
 * ObjectMatcher
 *
 * 对象匹配
 *
 * @author hireny
 * @create 2020-12-29 21:42
 */
public class ObjectMatcher extends AbstractMatcher<Object> implements Matcher<Object> {

    public ObjectMatcher(Object value) {
        super(value);
    }

    @Override
    public boolean match(Object o) {
        return super.match(o);
    }
}
