package org.hotilsframework.utils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数字工具类
 * @Author: hireny
 * @Date: Create in 2019/10/16 23:10
 */
public final class NumberUtils {

    private NumberUtils() {}

    /**
     * A map from primitive types to their corresponding wrapper types.
     * 一个从基本类型映射到包装类类型的映射容器
     */
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;

    /**
     * A map from wrapper types to their corresponding primitive types.
     * 一个从包装类型映射到基本类型的映射容器
     */
    private static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;

    static {
        Map<Class<?>, Class<?>> primToWrap = new LinkedHashMap<>(16);
        Map<Class<?>, Class<?>> wrapToPrim = new LinkedHashMap<>(16);

        add(primToWrap, wrapToPrim, boolean.class, Boolean.class);
        add(primToWrap, wrapToPrim, byte.class, Byte.class);
        add(primToWrap, wrapToPrim, char.class, Character.class);
        add(primToWrap, wrapToPrim, short.class, Short.class);
        add(primToWrap, wrapToPrim, int.class, Integer.class);
        add(primToWrap, wrapToPrim, float.class, Float.class);
        add(primToWrap, wrapToPrim, long.class, Long.class);
        add(primToWrap, wrapToPrim, double.class, Double.class);
        add(primToWrap, wrapToPrim, void.class, Void.class);


        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(primToWrap);
        WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(wrapToPrim);
    }

    /**
     * 将基本类型与包装类型对应的添加到映射容器中
     * @param forward
     * @param backward
     * @param key
     * @param value
     */
    private static void add(Map<Class<?>, Class<?>> forward,
                            Map<Class<?>, Class<?>> backward,
                            Class<?> key,
                            Class<?> value) {
        forward.put(key, value);
        backward.put(value, key);
    }

    /**
     * 获取所有基本类型
     * @return
     */
    public static Set<Class<?>> allPrimitiveTypes() {
        return PRIMITIVE_TO_WRAPPER_TYPE.keySet();
    }

    /**
     * 获取所有包装类型
     * @return
     */
    public static Set<Class<?>> allWrapperTypes() {
        return WRAPPER_TO_PRIMITIVE_TYPE.keySet();
    }

    /**
     * 是否是包装类型
     * @param type
     * @return
     */
    public static boolean isWrapperType(Class<?> type) {
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(Assert.checkNotNull(type));
    }

    /**
     * 是否是原始数据类型
     * @param type
     * @return
     */
    public static boolean isPrimitiveType(Class<?> type) {
        return type.isPrimitive() || PRIMITIVE_TO_WRAPPER_TYPE.containsKey(Assert.checkNotNull(type));
    }

    /**
     * 获取基本类型的包装类型
     * @param type
     * @param <T>
     * @return
     */
    public static <T> Class<T> wrap(Class<T> type) {
        Assert.checkNotNull(type);

        @SuppressWarnings("unchecked")
        Class<T> wrapped = (Class<T>) PRIMITIVE_TO_WRAPPER_TYPE.get(type);
        return (wrapped == null) ? type : wrapped;
    }

    /**
     * 获取基本类型
     * @param type
     * @param <T>
     * @return
     */
    public static <T> Class<T> unwrap(Class<T> type) {
        Assert.checkNotNull(type);

        @SuppressWarnings("unchecked")
        Class<T> unwrapped = (Class<T>) WRAPPER_TO_PRIMITIVE_TYPE.get(type);
        return (unwrapped == null) ? type : unwrapped;
    }

    /**
     * 给定类是否为Boolean或者boolean
     * @param type      类
     * @return          是否为Boolean或者boolean
     */
    public static boolean isBoolean(Class<?> type) {
        return (type == Boolean.class || type == boolean.class);
    }

    public static boolean isByte(Class<?> clazz) {
        return (clazz == Byte.class || clazz == byte.class);
    }

    public static boolean isChar(Class<?> clazz) {
        return (clazz == Character.class || clazz == char.class);
    }

    public static boolean isShort(Class<?> clazz) {
        return (clazz == Short.class || clazz == short.class);
    }

    /**
     * 给定类是否为Integer或者int
     * @param clazz
     * @return
     */
    public static boolean isInt(Class<?> clazz) {
        return (clazz == Integer.class || clazz == int.class);
    }

    public static boolean isLong(Class<?> clazz) {
        return (clazz == Long.class || clazz == long.class);
    }

    public static boolean isFloat(Class<?> clazz) {
        return (clazz == Float.class || clazz == float.class);
    }

    public static boolean isDouble(Class<?> clazz) {
        return (clazz == Double.class || clazz == double.class);
    }

//    public static int hashCode(boolean value) {
//        return value ? 1231 : 1237;
//    }
//
//    public static int hashCode(byte value) {
//        return Byte.hashCode(value);
//    }
//
//    public static int hashCode(short value) {
//        return Short.hashCode(value);
//    }
//
//    public static int hashCode(char value) {
//        return Character.hashCode(value);
//    }
//
//    public static int hashCode(int value) {
//        return Integer.hashCode(value);
//    }
//
//    public static int hashCode(long lng) {
//        return Long.hashCode(lng);
//    }
//
//    public static int hashCode(float flt) {
//        return Float.hashCode(flt);
//    }
//
//    public static int hashCode(double dbl) {
//        return Double.hashCode(dbl);
//    }


    //===========================数学运算 start=====================================//

    /** 默认运算精度 */
    private static int DEFAULT_SCALE = 10;

    /**
     * 提供数据类型转换为BigDecimal
     *
     * @param object    原始数据
     * @return  BigDecimal
     */
    public static final BigDecimal bigDecimal(Object object) {
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

    /**
     * 提供(相对)精确的加法运算。
     *
     * @param num1 被加数
     * @param num2 加数
     * @return 两个参数的和
     */
    public static final BigDecimal add(Number num1, Number num2) {
        BigDecimal result = bigDecimal(num1).add(bigDecimal(num2));
        return result.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供(相对)精确的减法运算。
     *
     * @param num1 被减数
     * @param num2 减数
     * @return 两个参数的差
     */
    public static final BigDecimal subtract(Number num1, Number num2) {
        BigDecimal result = bigDecimal(num1).subtract(bigDecimal(num2));
        return result.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供(相对)精确的乘法运算。
     *
     * @param num1 被乘数
     * @param num2 乘数
     * @return 两个参数的积
     */
    public static final BigDecimal multiply(Number num1, Number num2) {
        BigDecimal result = bigDecimal(num1).multiply(bigDecimal(num2));
        return result.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供(相对)精确的除法运算，当发生除不尽的情况时，精度为10位，以后的数字四舍五入。
     *
     * @param num1 被除数
     * @param num2 除数
     * @return 两个参数的商
     */
    public static final BigDecimal divide(Number num1, Number num2) {
        return divide(num1, num2, DEFAULT_SCALE);
    }

    /**
     * 提供(相对)精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param num1 被除数
     * @param num2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static final BigDecimal divide(Number num1, Number num2, Integer scale) {
        if (scale == null) {
            scale = DEFAULT_SCALE;
        }
        num2 = num2 == null || Math.abs(new Double(num2.toString())) == 0 ? 1 : num2;
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal result = bigDecimal(num1).divide(bigDecimal(num2), scale, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param num 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static final BigDecimal round(Number num, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal result = bigDecimal(num).divide(bigDecimal("1"), scale, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    /**
     * 获取start到end区间的随机数,不包含start+end
     *
     * @param start
     * @param end
     * @return
     */
    public static final BigDecimal getRandom(double start, double end) {
        return new BigDecimal(start + Math.random() * (end - start));
    }


    //===========================数学运算 end=====================================//
}
