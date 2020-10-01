package org.hotilsframework.lang;

import org.hotilsframework.collect.Sets;

import java.io.Closeable;
import java.io.Externalizable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.Optional;

/**
 * JavaType
 *
 * 用来描述Java类型
 *
 * @author hireny
 * @create 2020-09-07 20:57
 */
public final class JavaTypes {

    private JavaTypes() {
        throw new AssertionError();
    }


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

    private static final Set<Class<?>> STANDARD_NUMBER_TYPES;

    /**
     * 常用的类型缓存，都是Java中的类型，不包括基本类型，
     * 例如：boolean、char、byte、short、int、long、float、double等
     */
    private static final Map<String, Class<?>> commonClassCache;

    /**
     * Common Java language interfaces which are supposed to be ignored
     * when searching for 'primary' user-level interfaces.
     * Java语言的公共接口的类型缓存
     */
    private static final Set<Class<?>> javaLanguageInterfaces;


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

        // 标准数字类型
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



        // 常用基本类型
        Map<String, Class<?>> tempCommonClassCache = new LinkedHashMap<>(16);

        for (Class<?> wrapperType : JavaTypes.allWrapperTypes()) {
            // 注册常用类型
            registerCommonClasses(tempCommonClassCache, wrapperType);
        }

        // 注册常用类型
        registerCommonClasses(tempCommonClassCache, Boolean[].class, Byte[].class, Character[].class, Double[].class,
                Float[].class, Integer[].class, Long[].class, Short[].class);
        registerCommonClasses(tempCommonClassCache, Number.class, Number[].class, String.class, String[].class,
                Class.class, Class[].class, Object.class, Object[].class);
        registerCommonClasses(tempCommonClassCache, Throwable.class, Exception.class, RuntimeException.class,
                Error.class, StackTraceElement.class, StackTraceElement[].class);
        registerCommonClasses(tempCommonClassCache, Enum.class, Iterable.class, Iterator.class, Enumeration.class,
                Collection.class, List.class, Set.class, Map.class, Map.Entry.class, Optional.class);

        // Java语言公共接口的数组
        Class<?>[] javaLanguageInterfaceArray = {Serializable.class, Externalizable.class,
                Closeable.class, AutoCloseable.class, Cloneable.class, Comparable.class};
        registerCommonClasses(tempCommonClassCache, javaLanguageInterfaceArray);
        javaLanguageInterfaces = new HashSet<>(Arrays.asList(javaLanguageInterfaceArray));

        commonClassCache = Collections.unmodifiableMap(tempCommonClassCache);
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
     * 注册常用的类型
     * @param commonClassCache
     * @param commonClasses
     */
    private static void registerCommonClasses(Map<String, Class<?>> commonClassCache, Class<?>... commonClasses) {
        for (Class<?> commonClass : commonClasses) {
            commonClassCache.put(commonClass.getName(), commonClass);
        }
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
     * 获取所有标准数字类型
     * @return
     */
    public static Set<Class<?>> allStandardNumberTypes() {
        return STANDARD_NUMBER_TYPES;
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
}
