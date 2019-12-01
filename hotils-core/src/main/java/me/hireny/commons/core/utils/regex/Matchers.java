package me.hireny.commons.core.utils.regex;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/06 00:16
 */
public abstract class Matchers {

    private Matchers() {}


    /**
     * 验证字符串是否为整数
     * @param s
     * @return
     */
    public static boolean isInt(String s) {
        String regex = "^[-\\+]?[\\d]+$";
        return s.matches(regex);
    }
    /**
     * 验证用户名
     * @param s
     * @return
     */
    public static boolean isUsernameExact(String s) {
        return s.matches(RegexConstants.USERNAME_REGEX);
    }

    /**
     * 验证手机号
     * @param s     待验证文本
     * @return
     */
    public static boolean isMobileExact(String s) {
        return s.matches(RegexConstants.PHONE_NUMBER_REGEX);
    }

    /**
     * 验证邮箱
     * @param s     待验证文本
     * @return
     */
    public static boolean isEmailExact(String s) {
        return s.matches(RegexConstants.EMAIL_REGEX);
    }

}
