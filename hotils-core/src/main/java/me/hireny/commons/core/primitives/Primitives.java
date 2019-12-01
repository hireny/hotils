package me.hireny.commons.core.primitives;

import me.hireny.commons.utils.Assert;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Primitives
 * 基本类型操作
 * @Author: hireny
 * @Date: Create in 2019/11/04 01:08
 */
public class Primitives {

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
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(Assert.checkNotNull(type));
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

    public static <T> Class<T> unwrap(Class<T> type) {
        Assert.checkNotNull(type);

        @SuppressWarnings("unchecked")
        Class<T> unwrapped = (Class<T>) WRAPPER_TO_PRIMITIVE_TYPE.get(type);
        return (unwrapped == null) ? type : unwrapped;
    }
}
