package org.hotilsframework.core.match;

/**
 * CharMatcher
 *
 * 字符匹配
 *
 * @author hireny
 * @create 2020-12-29 21:39
 */
public class CharMatcher extends AbstractMatcher<Character> implements Matcher<Character> {


    public CharMatcher(Character value) {
        super(value);
    }

    @Override
    public boolean match(Character value) {
        return super.match(value);
    }

    public static CharMatcher of(Character value) {
        return new CharMatcher(value);
    }

    public static CharMatcher is(Character value) {
        return null;
    }

    public static CharMatcher range(Character c1, Character c2) {
        return null;
    }
}
