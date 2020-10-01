package org.hotilsframework.core.match;

/**
 * 字符匹配
 * @ClassName: CharMatcher
 * @Author: hireny
 * @Date: Created in 2020-02-14 23:10
 * @Version: 1.0
 */
public class CharMatcher implements Matcher<Character> {

    private Character c;

    public CharMatcher(Character c) {
        this.c = c;
    }

    @Override
    public boolean match(Character c) {
        return false;
    }

    public static CharMatcher is(Character c) {
        return new CharMatcher(c);
    }

    public static CharMatcher range(Character c1, Character c2) {
        return null;
    }
}
