package me.hireny.commons.core.lang;

/**
 * @ClassName: CharMatcher
 * @Author: hireny
 * @Date: Create in 2019/11/07 21:49
 * @Description: TODO   字符匹配类
 */
public abstract class CharMatcher implements Predicate<Character> {

    public static CharMatcher is(final char match) {
//        return new Is(match);
        return null;
    }

    @Override
    public boolean apply(Character input) {
        return false;
    }
}
