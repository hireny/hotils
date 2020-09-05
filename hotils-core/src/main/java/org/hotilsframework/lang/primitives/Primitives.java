package org.hotilsframework.lang.primitives;


import org.hotilsframework.lang.Assert;

import java.util.*;

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

    /**
     * Map with primitive type name as key and corresponding primitive
     * type as value, for example: "int" -> "int.class".
     * 基本类型的映射关系的缓存
     */
    private static final Map<String, Class<?>> primitiveTypeNameMap;


    static {
        Map<Class<?>, Class<?>> primToWrap = new LinkedHashMap<>(16);
        Map<Class<?>, Class<?>> wrapToPrim = new LinkedHashMap<>(16);
        Map<String, Class<?>> tempPrimitiveTypeNameMap = new LinkedHashMap<>(32);

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


        // 基本类型的集合
        Set<Class<?>> primitiveTypes = new HashSet<>(32);
        primitiveTypes.addAll(wrapToPrim.values());
        Collections.addAll(primitiveTypes, boolean[].class, byte[].class, char[].class,
                double[].class, float[].class, int[].class, long[].class, short[].class);
        primitiveTypes.add(void.class);
        for (Class<?> primitiveType : primitiveTypes) {
            tempPrimitiveTypeNameMap.put(primitiveType.getName(), primitiveType);
        }

        primitiveTypeNameMap = Collections.unmodifiableMap(tempPrimitiveTypeNameMap);

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
     * 获取从基本类型映射到包装类类型的映射容器
     * @return
     */
    public static Map<Class<?>, Class<?>> getPrimitiveToWrapperType() {
        return PRIMITIVE_TO_WRAPPER_TYPE;
    }

    /**
     * 获取从包装类型映射到基本类型的映射容器
     * @return
     */
    public static Map<Class<?>, Class<?>> getWrapperToPrimitiveType() {
        return WRAPPER_TO_PRIMITIVE_TYPE;
    }

    /**
     * 获取基本类型的映射
     * @return
     */
    public static Map<String, Class<?>> getPrimitiveTypeNameMap() {
        return primitiveTypeNameMap;
    }

    /**
     * 是否是包装类型
     * @param type
     * @return
     */
    public static boolean isWrapperType(Class<?> type) {
        if (null == type) {
            return false;
        }
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(type);
    }

    /**
     * 是否是原始数据类型
     * @param type
     * @return
     */
    public static boolean isPrimitiveType(Class<?> type) {
        if (null == type) {
            return false;
        }
        return type.isPrimitive() || PRIMITIVE_TO_WRAPPER_TYPE.containsKey(type);
    }

    //=============================================
    // wrap and unwrap
    //=============================================

    /**
     * 获取基本类型的包装类型
     * @param type
     * @return
     */
    public static <T> Class<T> wrap(Class<T> type) {
        Assert.notNull(type, "class must not be null.");
        Class<T> wrapped = (Class<T>) PRIMITIVE_TO_WRAPPER_TYPE.get(type);
        return (wrapped == null) ? type : wrapped;
    }

    /**
     * 获取包装类型的基本类型
     * @param type
     * @return
     */
    public static Class<?> unwrap(Class<?> type) {
        Assert.notNull(type, "class must not be null.");
        Class<?> unwrapped =  WRAPPER_TO_PRIMITIVE_TYPE.get(type);
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
