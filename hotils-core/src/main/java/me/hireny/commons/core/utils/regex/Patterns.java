package me.hireny.commons.core.utils.regex;

import java.util.regex.Pattern;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/17 00:18
 */
public abstract class Patterns {
    /**
     * 匹配
     * @param cs
     * @return
     */
    public abstract Matchers matcher(CharSequence cs);

    public abstract String pattern();

    /**
     * 判断字符串是否符合正则表达式
     * @param regex
     * @param cs
     * @return
     */
    private static boolean isMatch(String regex, CharSequence cs) {
        return cs!=null && cs.length()>0 && Pattern.matches(regex, cs);
    }
}
