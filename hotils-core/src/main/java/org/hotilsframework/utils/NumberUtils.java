package org.hotilsframework.utils;

import org.hotilsframework.core.lang.Nullable;

/**
 * 数字工具类
 *
 * 1.原始类型数字与byte[]的双向转换
 * 2.判断字符串是否是数字，是否16进制字符串
 * 3.10进制/16进制字符串与原始类型数字/数字对象的双向转换
 * @Author: hireny
 * @Date: Create in 2019/10/16 23:10
 */
public final class NumberUtils {

    private NumberUtils() {}

    private static final double DEFAULT_DOUBLE_EPSILON = 0.00001D;

    /**
     * 因为double的精度问题，允许两个double在0.00001内的误差为相等。
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equalsWithin(double d1, double d2) {
        return Math.abs(d1 -d2) < DEFAULT_DOUBLE_EPSILON;
    }

    /**
     * 因为double的精度问题，允许两个double在epsilon内的误差为相等。
     * @param d1
     * @param d2
     * @param epsilon
     * @return
     */
    public static boolean equalsWithin(double d1, double d2, double epsilon) {
        return Math.abs(d1 - d2) < epsilon;
    }


    //========================================
    // 判断字符串类型
    //========================================

    /**
     * 判断字符串是否合法数字
     * @param value
     * @return
     */
    public static boolean isNumber(@Nullable String value) {
        return false;
    }

    /**
     * 判断字符串是否16进制
     * @param value
     * @return
     */
    public static boolean isHex(@Nullable String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        int index = value.startsWith("-") ? 1 : 0;
        return value.startsWith("0x", index)
                || value.startsWith("0X", index)
                || value.startsWith("#", index);
    }
}
