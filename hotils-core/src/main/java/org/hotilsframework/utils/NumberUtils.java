package org.hotilsframework.utils;

import org.hotilsframework.core.collection.Sets;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Set;

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

    public static final Set<Class<?>> STANDARD_NUMBER_TYPES;

    static {
        Set<Class<?>> numberTypes = Sets.newHashSet();
        numberTypes.add(Byte.class);
        numberTypes.add(Short.class);
        numberTypes.add(Integer.class);
        numberTypes.add(Long.class);
        numberTypes.add(BigInteger.class);
        numberTypes.add(Float.class);
        numberTypes.add(Double.class);
        numberTypes.add(BigDecimal.class);
        STANDARD_NUMBER_TYPES = Collections.unmodifiableSet(numberTypes);
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
     *     NumberUtils.toInt(null) = 0
     *     NumberUtils.toInt("")   = 0
     *     NumberUtils.toInt("1")  = 1
     * </pre>
     * @param value
     * @return
     */
    public static int toInt(final String value) {
        return toInt(value, 0);
    }

    /**
     * 将10进制的String安全的转换为int。
     *
     * 当value为空或非数字字符串时，返回default值。
     *
     * <pre>
     *     NumberUtils.toInt(null, 1) = 1
     *     NumberUtils.toInt("", 1)   = 1
     *     NumberUtils.toInt("1", 0)  = 1
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static int toInt(final String value, int defaultValue) {
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
     *     NumberUtils.toLong(null) = 0L
     *     NumberUtils.toLong("")   = 0L
     *     NumberUtils.toLong("1")  = 1L
     * </pre>
     * @param value
     * @return
     */
    public static long toLong(final String value) {
        return toLong(value, 0L);
    }

    /**
     * 将10进制的String转换为long
     *
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.toLong(null, 1L) = 1L
     *     NumberUtils.toLong("", 1L)   = 1L
     *     NumberUtils.toLong("1", 0L)  = 1L
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static long toLong(final String value, long defaultValue) {
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
     *     NumberUtils.toFloat(null) = 0.0f
     *     NumberUtils.toFloat("")   = 0.0f
     *     NumberUtils.toFloat("1.5")  = 1.5f
     * </pre>
     * @param value
     * @return
     */
    public static float toFloat(final String value) {
        return toFloat(value, 0.0f);
    }

    /**
     * 将10进制的String转换为float
     *
     * 当value为空或非数字字符串时，返回0.0f
     *
     * <pre>
     *     NumberUtils.toFloat(null, 1.1f) = 1.1f
     *     NumberUtils.toFloat("", 1.1f)   = 1.1f
     *     NumberUtils.toFloat("1.5", 0.0f)  = 1.5f
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static float toFloat(final String value, float defaultValue) {
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
     *     NumberUtils.toDouble(null) = 0.0d
     *     NumberUtils.toDouble("")   = 0.0d
     *     NumberUtils.toDouble("1.5")  = 1.5d
     * </pre>
     * @param value
     * @return
     */
    public static double toDouble(final String value) {
        return toDouble(value, 0.0d);
    }

    /**
     * 将10进制的String转换为float
     *
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.toDouble(null, 1.1d) = 1.1d
     *     NumberUtils.toDouble("", 1.1d)   = 1.1d
     *     NumberUtils.toDouble("1.5", 0.0d)  = 1.5d
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static double toDouble(final String value, double defaultValue) {
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
     *     NumberUtils.toDouble(null) = 0.0d
     *     NumberUtils.toDouble("")   = 0.0d
     *     NumberUtils.toDouble("1.5")  = 1.5d
     *     NumberUtils.toDouble(BigDecimal.valueOf(8.5d)) = 8.5d
     * </pre>
     * @param value
     * @return
     */
    public static double toDouble(final BigDecimal value) {
        return toDouble(value, 0.0d);
    }

    /**
     * 将10进制的String转换为float
     *
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.toDouble(null, 1.1d) = 1.1d
     *     NumberUtils.toDouble(BigDecimal.valueOf(8.5d), 1.1d)  = 8.5d
     * </pre>
     * @param value
     * @param defaultValue
     * @return
     */
    public static double toDouble(final BigDecimal value, double defaultValue) {
        return value == null ? defaultValue : value.doubleValue();
    }

    /**
     * 将10进制的String转换为byte
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.toByte(null) = 0
     *     NumberUtils.toByte("")   = 0
     *     NumberUtils.toByte("1")  = 1
     * </pre>
     * @param value
     * @return
     */
    public static byte toByte(final String value) {
        return toByte(value, (byte) 0);
    }

    /**
     * 将10进制的String转换为byte
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *     NumberUtils.toByte(null, 1) = 1
     *     NumberUtils.toByte("", 1)   = 1
     *     NumberUtils.toByte("1", 0)  = 1
     * </pre>
     * @param value
     * @return
     */
    public static byte toByte(final String value, byte defaultValue) {
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
     *   NumberUtils.toShort(null) = 0
     *   NumberUtils.toShort("")   = 0
     *   NumberUtils.toShort("1")  = 1
     * </pre>
     *
     * @param value
     * @return
     */
    public static short toShort(final String value) {
        return toShort(value, (short) 0);
    }

    /**
     * 将10进制的String转换为short
     * 当value为空或非数字字符串时，返回0
     *
     * <pre>
     *   NumberUtils.toShort(null, 1) = 1
     *   NumberUtils.toShort("", 1)   = 1
     *   NumberUtils.toShort("1", 0)  = 1
     * </pre>
     *
     * @param value
     * @param defaultValue
     * @return
     */
    public static short toShort(final String value, final short defaultValue) {
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        try {
            return Short.parseShort(value);
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
    public static <T extends Number> T toNumber(String value, Class<T> targetClass) {
        Assert.notNull(value, "Value must not be null");
        Assert.notNull(targetClass, "Target class must not be null");

        // 剔除所有的空格
        String trimmed = StringUtils.trimAllWhiteSpace(value);

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

    //========================================
    // 判断字符串类型
    //========================================

    /**
     * 判断字符串是否合法数字
     * @param value
     * @return
     */
//    public static boolean isNumber(final String value) {
//        if (StringUtils.isEmpty(value)) {
//            return false;
//        }
//        final char[] chars = value.toCharArray();
//        int length = chars.length;
//        boolean hasExp = false;
//        boolean hasDecPoint = false;
//        boolean allowSigns = false;
//        boolean foundDigit = false;
//        // deal with any possible sign up front
//        final int start = chars[0] == '-' || chars[0] == '+' ? 1 : 0;
//    }

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
     * 从 {@link String} 中解码出一个 {@link BigInteger}
     * <p> 支持 十进制、十六进制和八进制计数法
     * @param value
     * @return
     */
    private static BigInteger decodeBigInteger(String value) {
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
