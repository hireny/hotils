package org.hotilsframework.utils;

import org.hotilsframework.utils.patterns.RegexConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式验证器
 * @author hireny
 * @className Validator
 * @create 2020-02-20 22:42
 */
public final class RegexValidator {
    private RegexValidator() {}

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
     * 效验邮编
     * @param s
     * @return
     */
    public static boolean isPostalCode(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        Matcher matcher = RegexConstants.POSTALCODE.matcher(s);
        return matcher.matches();
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

    /**
     * 校验是否是整数.
     *
     * @param value
     * @return isInteger
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断是否含有特殊字符.
     *
     * @param text
     * @return boolean true,通过，false，没通过
     */
    public static boolean hasSpecialChar(String text) {
        if (null == text || "".equals(text)) {
            return true;
        }
        String reg = "[a-z]*[A-Z]*\\d*-*_*\\s*";
        if (text.replaceAll(reg, "").length() == 0) {
            // 如果不包含特殊字符
            return false;
        }
        return true;
    }

    /**
     * 判断是否正整数.
     *
     * @param number 数字
     * @return boolean true,通过，false，没通过
     */
    public static boolean isNumber(String number) {
        if (null == number || "".equals(number)) {
            return false;
        }
        String regex = "[0-9]*";
        return number.matches(regex);
    }

    /**
     * 判断是否是正确的IP地址.
     *
     * @param ip
     * @return boolean true,通过，false，没通过
     */
    public static boolean isIp(String ip) {
        if (null == ip || "".equals(ip)) {
            return false;
        }
        Matcher m = RegexConstants.IP.matcher(ip);
        return m.matches();
    }

    /**
     * 判断是否含有中文，仅适合中国汉字，不包括标点.
     *
     * @param text
     * @return boolean true,通过，false，没通过
     */
    public static boolean isChinese(String text) {
        if (null == text || "".equals(text)) {
            return false;
        }
        Matcher m = RegexConstants.CHINESE.matcher(text);
        return m.find();
    }

    /**
     * 判断字符串str是否符合正则表达式reg.
     *
     * @param str 需要处理的字符串
     * @param reg 正则
     * @return 是否匹配
     */
    public static boolean isMatche(String str, String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
}
