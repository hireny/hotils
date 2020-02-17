package org.hotilsframework.core.lang.primitives;

import org.hotilsframework.utils.Assert;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 基本/包装类型工具类
 * @ClassName: Primitives
 * @Author: hireny
 * @Date: Created in 2020-02-09 0:44
 * @Version: 1.0
 */
public final class Primitives {
    private Primitives() {}

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
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(Assert.notNull(type));
    }

    /**
     * 是否是原始数据类型
     * @param type
     * @return
     */
    public static boolean isPrimitiveType(Class<?> type) {
        return type.isPrimitive() || PRIMITIVE_TO_WRAPPER_TYPE.containsKey(Assert.notNull(type));
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

    //=============================================
    // wrap and unwrap
    //=============================================

    /**
     * 获取基本类型的包装类型
     * @param type
     * @param <T>
     * @return
     */
    public static <T> Class<T> wrap(Class<T> type) {
        Assert.notNull(type);

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
        Assert.notNull(type);

        @SuppressWarnings("unchecked")
        Class<T> unwrapped = (Class<T>) WRAPPER_TO_PRIMITIVE_TYPE.get(type);
        return (unwrapped == null) ? type : unwrapped;
    }

    /**
     * 将基本类型数组包装成包装类型
     * @param values    基本类型数组
     * @return          包装类型数组
     */
    public static Byte[] wrap(byte... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Byte[0];
        }
        final Byte[] array = new Byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型数组转为基本类型数组
     * @param values    包装类型数组
     * @return          基本类型数组
     */
    public static byte[] unwrap(Byte... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new byte[0];
        }
        final byte[] array = new byte[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装成包装类型
     * @param values    基本类型数组
     * @return          包装类型数组
     */
    public static Short[] wrap(short... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Short[0];
        }
        final Short[] array = new Short[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型数组转为基本类型数组
     * @param values    包装类型数组
     * @return          基本类型数组
     */
    public static short[] unwrap(Short... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new short[0];
        }
        final short[] array = new short[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装成包装类型
     * @param values    基本类型数组
     * @return          包装类型数组
     */
    public static Integer[] wrap(int... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Integer[0];
        }
        final Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型数组转为基本类型数组
     * @param values    包装类型数组
     * @return          基本类型数组
     */
    public static int[] unwrap(Integer... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new int[0];
        }
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装成包装类型
     * @param values    基本类型数组
     * @return          包装类型数组
     */
    public static Long[] wrap(long... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Long[0];
        }
        final Long[] array = new Long[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型数组转为基本类型数组
     * @param values    包装类型数组
     * @return          基本类型数组
     */
    public static long[] unwrap(Long... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new long[0];
        }
        final long[] array = new long[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装成包装类型
     * @param values    基本类型数组
     * @return          包装类型数组
     */
    public static Float[] wrap(float... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Float[0];
        }
        final Float[] array = new Float[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型数组转为基本类型数组
     * @param values    包装类型数组
     * @return          基本类型数组
     */
    public static float[] unwrap(Float... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new float[0];
        }
        final float[] array = new float[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装成包装类型
     * @param values    基本类型数组
     * @return          包装类型数组
     */
    public static Double[] wrap(double... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Double[0];
        }
        final Double[] array = new Double[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型数组转为基本类型数组
     * @param values    包装类型数组
     * @return          基本类型数组
     */
    public static double[] unwrap(Double... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new double[0];
        }
        final double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装成包装类型
     * @param values    基本类型数组
     * @return          包装类型数组
     */
    public static Character[] wrap(char... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Character[0];
        }
        final Character[] array = new Character[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型数组转为基本类型数组
     * @param values    包装类型数组
     * @return          基本类型数组
     */
    public static char[] unwrap(Character... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new char[0];
        }
        final char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 将基本类型数组包装成包装类型
     * @param values    基本类型数组
     * @return          包装类型数组
     */
    public static Boolean[] wrap(boolean... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new Boolean[0];
        }
        final Boolean[] array = new Boolean[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    /**
     * 包装类型数组转为基本类型数组
     * @param values    包装类型数组
     * @return          基本类型数组
     */
    public static boolean[] unwrap(Boolean... values) {
        if (null == values) {
            return null;
        }
        final int length = values.length;
        if (0 == length) {
            return new boolean[0];
        }
        final boolean[] array = new boolean[length];
        for (int i = 0; i < length; i++) {
            array[i] = values[i];
        }
        return array;
    }
}
