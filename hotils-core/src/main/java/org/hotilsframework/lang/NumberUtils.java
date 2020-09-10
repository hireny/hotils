package org.hotilsframework.lang;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

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

    private NumberUtils() {
        throw new AssertionError();
    }


    //========================================
    // 字符串转换为原始类型数字
    //========================================

    /**
     * 将10进制的String转换为int
     *
     * 当str为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.parseInt(null) = 0
     *     NumberUtils.parseInt("")   = 0
     *     NumberUtils.parseInt("1")  = 1
     * </pre>
     * @param value
     * @return
     */
    public static int parseInt(final String value) {
        return parseInt(value, 0);
    }

    /**
     * 将10进制的String安全的转换为int。
     *
     * 当value为空或非数字字符串时，返回default值。
     *
     * <pre>
     *     NumberUtils.parseInt(null, 1) = 1
     *     NumberUtils.parseInt("", 1)   = 1
     *     NumberUtils.parseInt("1", 0)  = 1
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static int parseInt(final String value, int defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 将10进制的String转换为long
     *
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.parseLong(null) = 0L
     *     NumberUtils.parseLong("")   = 0L
     *     NumberUtils.parseLong("1")  = 1L
     * </pre>
     * @param value
     * @return
     */
    public static long parseLong(final String value) {
        return parseLong(value, 0L);
    }

    /**
     * 将10进制的String转换为long
     *
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.parseLong(null, 1L) = 1L
     *     NumberUtils.parseLong("", 1L)   = 1L
     *     NumberUtils.parseLong("1", 0L)  = 1L
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static long parseLong(final String value, long defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 将10进制的String转换为float
     *
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.parseFloat(null) = 0.0f
     *     NumberUtils.parseFloat("")   = 0.0f
     *     NumberUtils.parseFloat("1.5")  = 1.5f
     * </pre>
     * @param value
     * @return
     */
    public static float parseFloat(final String value) {
        return parseFloat(value, 0.0f);
    }

    /**
     * 将10进制的String转换为float
     *
     * 当value为空或非数字字符串时，返回0.0f
     *
     * <pre>
     *     NumberUtils.parseFloat(null, 1.1f) = 1.1f
     *     NumberUtils.parseFloat("", 1.1f)   = 1.1f
     *     NumberUtils.parseFloat("1.5", 0.0f)  = 1.5f
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static float parseFloat(final String value, float defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 将10进制的String转换为double
     *
     * 当value为空或非数字字符串时，返回0.0
     *
     * <pre>
     *     NumberUtils.parseDouble(null) = 0.0d
     *     NumberUtils.parseDouble("")   = 0.0d
     *     NumberUtils.parseDouble("1.5")  = 1.5d
     * </pre>
     * @param value
     * @return
     */
    public static double parseDouble(final String value) {
        return parseDouble(value, 0.0d);
    }

    /**
     * 将10进制的String转换为double
     *
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.parseDouble(null, 1.1d) = 1.1d
     *     NumberUtils.parseDouble("", 1.1d)   = 1.1d
     *     NumberUtils.parseDouble("1.5", 0.0d)  = 1.5d
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static double parseDouble(final String value, double defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 将10进制的String转换为double
     *
     * 当value为空或非数字字符串时，返回0.0
     *
     * <pre>
     *     NumberUtils.parseDouble(null) = 0.0d
     *     NumberUtils.parseDouble("")   = 0.0d
     *     NumberUtils.parseDouble("1.5")  = 1.5d
     *     NumberUtils.parseDouble(BigDecimal.valueOf(8.5d)) = 8.5d
     * </pre>
     * @param value
     * @return
     */
    public static double parseDouble(final BigDecimal value) {
        return parseDouble(value, 0.0d);
    }

    /**
     * 将10进制的String转换为double
     *
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.parseDouble(null, 1.1d) = 1.1d
     *     NumberUtils.parseDouble(BigDecimal.valueOf(8.5d), 1.1d)  = 8.5d
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static double parseDouble(final BigDecimal value, double defaultValue) {
        return value == null ? defaultValue : value.doubleValue();
    }

    /**
     * 将10进制的String转换为byte
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.parseByte(null) = 0
     *     NumberUtils.parseByte("")   = 0
     *     NumberUtils.parseByte("1")  = 1
     * </pre>
     * @param value
     * @return
     */
    public static byte parseByte(final String value) {
        return parseByte(value, (byte) 0);
    }

    /**
     * 将10进制的String转换为byte
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.parseByte(null, 1) = 1
     *     NumberUtils.parseByte("", 1)   = 1
     *     NumberUtils.parseByte("1", 0)  = 1
     * </pre>
     * @param value
     * @return
     */
    public static byte parseByte(final String value, byte defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        try {
            return Byte.parseByte(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 将10进制的String转换为short
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *   NumberUtils.parseShort(null) = 0
     *   NumberUtils.parseShort("")   = 0
     *   NumberUtils.parseShort("1")  = 1
     * </pre>
     *
     * @param value
     * @return
     */
    public static short parseShort(final String value) {
        return parseShort(value, (short) 0);
    }

    /**
     * 将10进制的String转换为short
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *   NumberUtils.parseShort(null, 1) = 1
     *   NumberUtils.parseShort("", 1)   = 1
     *   NumberUtils.parseShort("1", 0)  = 1
     * </pre>
     *
     * @param value
     * @param defaultValue
     * @return
     */
    public static short parseShort(final String value, final short defaultValue) {
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        try {
            return Short.parseShort(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static boolean parseBoolean(final String value) {
        return parseBoolean(value, false);
    }

    /**
     * 将boolean类型的字符串转换为boolean类型
     * @param value
     * @param defaultValue
     * @return
     */
    public static boolean parseBoolean(final String value, final boolean defaultValue) {
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    //========================================
    // 字符串转换为对象类型的数字
    //========================================

    /**
     * 将响应的  {@code value} 解析为给定目标类的 {@link Number} 的实例。
     * @param value
     * @param targetClass
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T parseNumber(String value, Class<T> targetClass) {
        Assert.notNull(value, "Value must not be null");
        Assert.notNull(targetClass, "Target class must not be null");

        // 剔除所有的空格
        String trimmed = StringUtils.trimAllWhitespace(value);

        if (Byte.class == targetClass) {
            return (T) (isHexNumber(trimmed) ? Byte.decode(trimmed) : Byte.valueOf(trimmed));
        } else if (Short.class == targetClass) {
            return (T) (isHexNumber(trimmed) ? Short.decode(trimmed) : Short.valueOf(trimmed));
        } else if (Integer.class == targetClass) {
            return (T) (isHexNumber(trimmed) ? Integer.decode(trimmed) : Integer.valueOf(trimmed));
        } else if (Long.class == targetClass) {
            return (T) (isHexNumber(trimmed) ? Long.decode(trimmed) : Long.valueOf(trimmed));
        } else if (BigInteger.class == targetClass) {
            return (T) (isHexNumber(trimmed) ? decodeBigInteger(trimmed) : new BigInteger(trimmed));
        } else if (Float.class == targetClass) {
            return (T) Float.valueOf(trimmed);
        } else if (Double.class == targetClass) {
            return (T) Double.valueOf(trimmed);
        } else if (BigDecimal.class == targetClass || Number.class == targetClass) {
            return (T) new BigDecimal(trimmed);
        }
        throw new IllegalArgumentException(
                "Cannot convert String [" + value +"] to target class [" + targetClass.getName() + "]");
    }

    /**
     * 提供数据类型转换为BigDecimal
     *
     * @param object    原始数据
     * @return  BigDecimal
     */
    public static BigDecimal parseBigDecimal(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (object instanceof BigDecimal) {
            return (BigDecimal)object;
        }
        BigDecimal result;
        try {
            result = new BigDecimal(object.toString().replaceAll(",", ""));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Please give me a numeral.Not " + object);
        }
        return result;
    }

    //========================================
    // 判断字符串类型
    //========================================

    /**
     * 判断类型是否是数字类型
     * @param type
     * @return
     */
    public static boolean isNumber(Class<?> type) {
        if (Objects.isNull(type)) {
            return false;
        }
        return JavaTypes.allStandardNumberTypes().contains(type);
    }

    /**
     * 判断字符串是否合法数字
     * @param value
     * @return
     */
    public static boolean isNumeric(String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        String regex = "-?[0-9]+.?[0-9]*";
        return value.matches(regex);
    }

    /**
     * 判断字符串是否16进制
     * @param value
     * @return
     */
    public static boolean isHexNumber(final String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        int index = value.startsWith("-") ? 1 : 0;
        return value.startsWith("0x", index)
                || value.startsWith("0X", index)
                || value.startsWith("#", index);
    }

    /**
     * 检查字符串是否是有效的数字
     *
     * <pre>
     *     1、10进制
     *     2、16进制数字（0x开头）
     *     3、科学记数发形式（1234E3）
     *     4、类型标识形式（123D）
     *     5、正负数标识形式（+123、-234）
     * </pre>
     * @param value 要检查的 {@code String}
     * @return  如果字符串是正确格式的数字，则为{@code true}
     */
    public static boolean isCreatable(final String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        final char[] chars = value.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        // deal with any possible sign up front
        final int start = chars[0] == '-' || chars[0] == '+' ? 1 : 0;
        if (sz > start + 1 && chars[start] == '0' && !StringUtils.contains(value, '.')) {
            // leading 0, skip if is a decimal number
            if (chars[start + 1] == 'x' || chars[start + 1] == 'X') {
                // leading 0x/0X
                int i = start + 2;
                if (i == sz) {
                    // str == "0x"
                    return false;
                }
                // checking hex (it can't be anything else)
                for (; i < chars.length; i++) {
                    if ((chars[i] < '0' || chars[i] > '9')
                            && (chars[i] < 'a' || chars[i] > 'f')
                            && (chars[i] < 'A' || chars[i] > 'F')) {
                        System.out.println(value);
                        return false;
                    }
                }
                return true;
            } else if (Character.isDigit(chars[start + 1])) {
                // leading 0, but not hex, must be octal
                int i = start + 1;
                for (; i < chars.length; i++) {
                    if (chars[i] < '0' || chars[i] > '7') {
                        return false;
                    }
                }
                return true;
            }
        }
        sz--;   // don't want to loop to the last char, check it afterwords
                // for type qualifiers
        int i = start;
        // loop to the next to last char or to the last char if we need another digit to
        // make a valid number (e.g. chars[0..5] = "1234E")
        while (i < sz || i < sz + 1 && allowSigns && !foundDigit) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                foundDigit = true;
                allowSigns = false;

            } else if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                hasDecPoint = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // we've already taken care of hex.
                if (hasExp) {
                    // two E's
                    return false;
                }
                if (!foundDigit) {
                    return false;
                }
                hasExp = true;
                allowSigns = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (!allowSigns) {
                    return false;
                }
                allowSigns = false;
                foundDigit = false; // we need a digit after the E
            } else {
                return false;
            }
            i++;
        }
        if (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // no type qualifier, OK
                return true;
            }
            if (chars[i] == 'e' || chars[i] == 'E') {
                // can't have an E at the last byte
                return false;
            }
            if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                // single trailing decimal point after non-exponent is ok
                return foundDigit;
            }
            if (!allowSigns
                    && (chars[i] == 'd'
                    || chars[i] == 'D'
                    || chars[i] == 'f'
                    || chars[i] == 'F')) {
                return foundDigit;
            }
            if (chars[i] == 'l'
                    || chars[i] == 'L') {
                // not allowing L with an exponent or decimal point
                return foundDigit && !hasExp && !hasDecPoint;
            }
            // last character is illegal
            return false;
        }
        // allowSigns is true iff the val ends in 'E'
        // found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
        return !allowSigns && foundDigit;
    }

    /**
     * 从 {@link String} 中解码出一个 {@link BigInteger}
     * <p> 支持 十进制、十六进制和八进制计数法
     * @param value
     * @return
     */
    private static BigInteger decodeBigInteger(final String value) {
        int radix = 10;
        int index = 0;
        boolean negative =false;

        // Handle minus sign, if present.
        if (value.startsWith("-")) {
            negative = true;
            index++;
        }

        // Handle radix specifier, if present.
        if (value.startsWith("0x", index) || value.startsWith("0X", index)) {
            index += 2;
            radix = 16;
        } else if (value.startsWith("#", index)) {
            index++;
            radix = 16;
        } else if (value.startsWith("0", index) && value.length() > 1 + index) {
            index++;
            radix = 8;
        }

        BigInteger result = new BigInteger(value.substring(index), radix);
        return (negative ? result.negate() : result);
    }

}
