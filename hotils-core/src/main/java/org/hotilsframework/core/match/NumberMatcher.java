package org.hotilsframework.core.match;

/**
 * NumberMatcher
 *
 * 数值匹配
 *
 * @author hireny
 * @create 2020-12-29 21:44
 */
public class NumberMatcher<T extends Number> extends AbstractMatcher<T> implements Matcher<T> {

    public NumberMatcher(T value) {
        super(value);
    }

    @Override
    public boolean match(T t) {
        return super.match(t);
    }

    public static void main(String[] args) {
        Integer a = 123;
        Matcher<Integer> iMatcher = new NumberMatcher<>(a);
        boolean isMa = iMatcher.match(124);
        System.out.println(isMa);
    }
}
