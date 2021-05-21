package org.hotilsframework.lang;

import org.hotilsframework.collect.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Assert
 * 断言
 * @author hireny
 * @date Create in 2019/10/03 22:33
 */
public class Assert {

    /**
     * 检查是否为true，如果为 {@code false} 时抛出 {@link IllegalArgumentException} 异常 <br>
     *
     * <pre class="code">
     *      Assert.isTrue(i > 0, "The value must be greater than zero")
     * </pre>
     * @param expression            布尔值
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void checkArgument(boolean expression) throws IllegalArgumentException {
        checkArgument(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * 检查是否为true，如果为 {@code false} 时抛出 {@link IllegalArgumentException} 异常 <br>
     *
     * <pre class="code">
     *     Assert.isTrue(i > 0, "The value must be greater than zero")
     * </pre>
     * @param expression        布尔值
     * @param errorMessage      错误时抛出异常的错误信息模板，变量用 {} 代替
     * @param args              参数列表
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void checkArgument(boolean expression, String errorMessage, Object... args) throws IllegalArgumentException {
        if (!expression) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
    }

    //=======================================================
    //  check state start.
    //=======================================================

    /**
     * 检查boolean表达式，当检查结果为false时抛出 {@link IllegalStateException}
     *
     * <pre class="code">
     *     Assert.state(id == null);
     * </pre>
     * @param expression    boolean表达式
     * @throws IllegalStateException    表达式为 {@code false} 时抛出此异常
     */
    public static void checkState(boolean expression) throws IllegalStateException {
        checkState(expression, "[Assertion failed] - this state invariant must be true");
    }

    /**
     * 检查boolean表达式，当检查结果为false时抛出 {@link IllegalStateException}
     *
     * <pre class="code">
     *      Assert.state(id == null, "The id property must not already be initialized");
     * </pre>
     * @param expression        boolean表达式
     * @param errorMessage      异常时的消息模板
     * @param args              参数列表
     * @throws IllegalStateException    表达式为 {@code false} 时抛出异常
     */
    public static void checkState(boolean expression, String errorMessage, Object... args) throws IllegalStateException {
        if (!expression) {
            throw new IllegalStateException(StringUtils.format(errorMessage, args));
        }
    }

    //=======================================================
    //  check state end.
    //=======================================================

    /**
     * 断言对象是否为 {@code null}，如果不为 {@code null} 时抛出 {@link IllegalArgumentException} 异常
     *
     * <pre class="code">
     *     Assert.isNull(value);
     * </pre>
     *
     * @param object        被检查的对象
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(Object object) throws IllegalArgumentException {
        isNull(object, "[Assertion failed] - the object argument must be null.");
    }

    /**
     * 断言对象是否为 {@code null}，如果不为 {@code null} 时抛出 {@link IllegalArgumentException} 异常
     *
     * <pre class="code">
     *     Assert.isNull(value, "The value must be null.");
     * </pre>
     * @param object            被检查的对象
     * @param errorMessage      错误消息模板，变量使用 {} 表示
     * @param args              参数列表
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(Object object, String errorMessage, Object... args) throws IllegalArgumentException {
        if (object != null) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
    }

    //=======================================================
    //  check not null start.
    //=======================================================

    /**
     * 断言对象是否不为 {@code null}，如果为 {@code null} 时抛出 {@link IllegalArgumentException} 异常
     *
     * <pre class="code">
     *     Assert.notNull(clazz);
     * </pre>
     * @param reference     被检查的对象
     * @param <T>           被检查的对象类型
     * @return              非空对象
     * @throws IllegalArgumentException if the reference is {@code null}
     */
    public static <T extends Object> T notNull( T reference) throws IllegalArgumentException {
        return notNull(reference, "[Assertion failed] - this argument is required; it must not be null");
    }

    /**
     * 断言对象是否不为 {@code null}，如果不为 {@code null} 抛出 {@link IllegalArgumentException}  异常
     * Assert that an object is not {@code null} .
     *
     * <pre class="code">
     *     Assert.notNull(clazz, "The class must not be null.");
     * </pre>
     * @param reference     被检查的引用对象
     * @param errorMessage  错误消息模板
     * @param args          参数列表
     * @param <T>           被检查的对象泛型类型
     * @return              检查后的对象
     * @throws IllegalArgumentException if the reference is {@code null}
     */
    public static <T extends Object> T notNull(T reference, String errorMessage, Object... args) throws IllegalArgumentException {
        if (reference == null) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return reference;
    }

    //=======================================================
    //  check not null end.
    //=======================================================

    //=======================================================
    //  check empty start.
    //=======================================================

    /**
     * 检查给定字符串是否为空，为空抛出 {@link IllegalArgumentException}
     *
     * <pre class="code">
     *     Assert.notEmpty(name);
     * </pre>
     *
     * @param reference     被检查的字符串
     * @param <T>           字符串的泛型类型
     * @return              被检查的字符串
     * @throws IllegalArgumentException 被检查的字符串为空
     */
    public static <T extends CharSequence> T notEmpty(T reference) throws IllegalArgumentException {
        return notEmpty(reference, "[Assertion failed] - this String argument must have length; it must not be null or empty.");
    }

    /**
     * 检查给定字符串是否为空，为空抛出 {@link IllegalArgumentException}
     *
     * <pre class="code">
     *     Assert.notEmpty(name, "Name must not be empty.");
     * </pre>
     * @param reference     被检查的字符串
     * @param errorMessage  错误消息模板，变量使用{}表示
     * @param args          参数列表
     * @param <T>           字符串类型
     * @return              非空字符串
     * @throws IllegalArgumentException 被检查字符串为空
     */
    public static <T extends CharSequence> T notEmpty(T reference, String errorMessage, Object... args) throws IllegalArgumentException {
        if (StringUtils.isEmpty(reference)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return reference;
    }

    /**
     * 断言给定数组是否包含元素，数组必须不为 {@code null} 且至少包含一个元素
     *
     * <pre class="code">
     *     Assert.notEmpty(array);
     * </pre>
     *
     * @param array     被检查的数组
     * @return          被检查的数组
     * @throws IllegalArgumentException if the object array is {@code null} or has no elements
     */
    public static Object[] notEmpty(Object[] array) throws IllegalArgumentException {
        return notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element.");
    }

    /**
     * 断言给定数组是否包含元素，数组必须不为 {@code null} 且至少包含一个元素
     *
     * <pre class="code">
     *     Assert.notEmpty(array, "The array must have elements.");
     * </pre>
     *
     * @param array             被检查的数组
     * @param errorMessage      异常时的错误消息模板
     * @param args              参数列表
     * @return                  被检查的数组
     * @throws IllegalArgumentException if the object array is {@code null} or has no elements.
     */
    public static Object[] notEmpty(Object[] array, String errorMessage, Object... args) throws IllegalArgumentException {
        if (ArrayUtils.isEmpty(array)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return array;
    }

    /**
     * 断言给定集合非空
     *
     * <pre class="code">
     *     Assert.notEmpty(collection);
     * </pre>
     *
     * @param collection        被检查的集合
     * @param <T>               集合元素类型
     * @return                  非空集合
     * @throws IllegalArgumentException if the collection is {@code null} or has no elements.
     */
    public static <T> Collection<T> notEmpty(Collection<T> collection) throws IllegalArgumentException {
        return notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must cotain at least 1 element.");
    }

    /**
     * 断言给定集合非空
     *
     * <pre class="code">
     *     Assert.notEmpty(collection, "Collection must have elements.");
     * </pre>
     *
     * @param collection        被检查的集合
     * @param errorMessage      异常时的消息模板
     * @param args              参数列表
     * @param <T>               集合元素类型
     * @return                  非空集合
     * @throws IllegalArgumentException if the collection is {@code null} or has no elements.
     */
    public static <T> Collection<T> notEmpty(Collection<T> collection, String errorMessage, Object... args) throws IllegalArgumentException {
        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return collection;
    }

    /**
     * 断言给定Map非空
     *
     * <pre class="code">
     *     Assert.notEmpty(map, "The must have entries.");
     * </pre>
     *
     * @param map               被检查的Map
     * @param <K>               Key类型
     * @param <V>               Value类型
     * @return                  被检查的Map
     * @throws IllegalArgumentException if the map is {@code null} or has no entries.
     */
    public static <K, V> Map<K, V> notEmpty(Map<K, V> map) throws IllegalArgumentException {
        return notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry.");
    }

    /**
     * 断言给定Map非空
     *
     * <pre class="code">
     *     Assert.notEmpty(map, "The must have entries.");
     * </pre>
     *
     * @param map               被检查的Map
     * @param errorMessage      异常时的错误消息模板
     * @param args              参数列表
     * @param <K>               Key类型
     * @param <V>               Value类型
     * @return                  被检查的Map
     * @throws IllegalArgumentException if the map is {@code null} or has no entries.
     */
    public static <K, V> Map<K, V> notEmpty(Map<K, V> map, String errorMessage, Object... args) throws IllegalArgumentException {
        if (CollectionUtils.isEmpty(map)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return map;
    }

    //=======================================================
    //  check empty end.
    //=======================================================

    //=======================================================
    //  check blank start.
    //=======================================================

    /**
     * 检查给定字符串是否为空白（null、空串或只包含空白符），为空抛出 {@link IllegalArgumentException}
     * @param reference     被检查的字符串
     * @param <T>           字符串的泛型类型
     * @return              非空字符串
     * @throws IllegalArgumentException 被检查的字符串为空白
     */
    public static <T extends CharSequence> T notBlank(T reference) throws IllegalArgumentException {
        return notBlank(reference, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank.");
    }

    /**
     * 检查给定字符串是否为空白（null、空串或只包含空白符），为空抛出 {@link IllegalArgumentException}
     *
     * <pre class="code">
     *     Assert.notBlank(name, "Name must not be blank");
     * </pre>
     *
     * @param reference         被检查的字符串
     * @param errorMessage      错误消息模板，变量使用{}表示
     * @param args              参数列表
     * @param <T>               被检查的字符串泛型类型
     * @return                  非空字符串
     * @throws IllegalArgumentException 被检查的字符串为空白
     */
    public static <T extends CharSequence> T notBlank(T reference, String errorMessage, Object... args) throws IllegalArgumentException {
        if (StringUtils.isBlank(reference)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return reference;
    }

    //=======================================================
    //  check blank end.
    //=======================================================


    //=======================================================
    //  check not contain start.
    //=======================================================

    /**
     * 断言给定字符串是否不被另一个字符串包含（即是否为子串）
     *
     * <pre class="node">
     *     Assert.doesNotContain(name, "rod", "Name must not contain 'rod'.");
     * </pre>
     *
     * @param textToSearch      被搜索的字符串
     * @param substring         被检查的子串
     * @return                  被检查的子串
     * @throws IllegalArgumentException 是子串抛出异常
     */
    public static String doesNotContain(String textToSearch, String substring) throws IllegalArgumentException {
        return doesNotContain(textToSearch, substring, "[Assertion failed] - this String argument must not contain the substring [{}]", substring);
    }

    /**
     * 断言给定字符串是否不被另一个字符串包含（即是否为子串）
     *
     * <pre class="node">
     *     Assert.doesNotContain(name, "rod", "Name must not contain 'rod'.");
     * </pre>
     *
     * @param textToSearch      被搜索的字符串
     * @param substring         被检查的子串
     * @param errorMessage      异常时的错误消息模板
     * @param args              参数列表
     * @return                  被检查的子串
     * @throws IllegalArgumentException 是子串抛出异常
     */
    public static String doesNotContain(String textToSearch, String substring, String errorMessage, Object... args) throws IllegalArgumentException {
        if (!StringUtils.isEmpty(textToSearch) && !StringUtils.isEmpty(substring) && textToSearch.contains(substring)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return substring;
    }

    //=======================================================
    //  check not contain end.
    //=======================================================

    //=======================================================
    //  check entry start.
    //=======================================================

    public static void notNullEntry(Object key, Object value) {
        if (key == null) {
            throw new NullPointerException("null key in entry: null=" + value);
        } else if (value == null) {
            throw new NullPointerException("null value in entry: " + key + "=null");
        }
    }

    //=======================================================
    //  check entry start.
    //=======================================================


    //=======================================================
    //  check elements start.
    //=======================================================

    /**
     * 断言给定数组是否不包含 {@code null} 元素，如果数组为空或 {@code null} 将被认为不包含
     *
     * <pre class="code">
     *     Assert.noNullElements(array);
     * </pre>
     *
     * @param array     被检查的数组
     * @param <T>       数组元素类型
     * @return          被检查的数组
     * @throws IllegalArgumentException if the object array contains a {@code null} element.
     */
    public static <T> T[] notNullElements(T[] array) throws IllegalArgumentException {
        return notNullElements(array, "[Assertion failed] - this array must not contain any null elements.");
    }

    /**
     * 断言给定数组是否不包含 {@code null} 元素，如果数组为空或 {@code null} 将被认为不包含
     *
     * <pre class="code">
     *     Assert.noNullElements(array, "The array must have non-null elements");
     * </pre>
     *
     * @param array             被检查的数组
     * @param errorMessage      异常时的错误消息模板
     * @param args              参数列表
     * @param <T>               被检查的数组元素类型
     * @return                  被检查的数组
     * @throws IllegalArgumentException if the object array contains a {@code null} element
     */
    public static <T> T[] notNullElements(T[] array, String errorMessage, Object... args) throws IllegalArgumentException {
        if (ArrayUtils.hasNull(array)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return array;
    }

    //=======================================================
    //  check elements end.
    //=======================================================


    //=======================================================
    //  check instance start.
    //=======================================================

    /**
     * 断言给定对象是否是给定类的实例
     *
     * <pre class="code">
     *     Assert.isInstanceOf(Foo.class, foo, "Type to check against must not be null.");
     * </pre>
     *
     * @param type              被检查对象匹配的类型
     * @param obj               被检查的对象
     * @param <T>               被检查对象的泛型类型
     * @throws IllegalArgumentException if the object is not an instance of clazz
     */
    public static <T> T isInstanceOf(Class<?> type, T obj) throws IllegalArgumentException {
        return isInstanceOf(type, obj, "Object [{}] is not instanceof [{}]", obj, type);
    }

    /**
     * 断言给定对象是否是给定类的实例
     *
     * <pre class="code">
     *     Assert.isInstanceOf(Foo.class, foo, "Object [{}] is not instanceof [{}]", foo, Foo.class);
     * </pre>
     *
     * @param type              被检查对象匹配的类型
     * @param obj               被检查的对象
     * @param errorMessage      异常时的错误消息模板
     * @param args              参数列表
     * @param <T>               被检查对象的泛型类型
     * @throws IllegalArgumentException if the object is not an instance of clazz
     */
    public static <T> T isInstanceOf(Class<?> type, T obj, String errorMessage, Object... args) throws IllegalArgumentException {
        notNull(type, "Type to check against must not be null.");
        if (false == type.isInstance(obj)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
        return obj;
    }

    //=======================================================
    //  check instance end.
    //=======================================================

    //=======================================================
    //  check assignable start.
    //=======================================================

    /**
     * 断言 {@code superType.isAssignableFrom(subType)} 是否为 {@code true}
     *
     * <pre class="code">
     *     Assert.isAssignable(Number.class, myClass);
     * </pre>
     *
     * @param superType     需要检查的父类或接口
     * @param subType       需要检查的子类
     * @throws IllegalArgumentException 如果子类非继承父类，抛出此异常
     */
    public static void isAssignable(Class<?> superType, Class<?> subType) throws IllegalArgumentException {
        isAssignable(superType, subType, "{} is not assignable to {}", subType, superType);
    }

    /**
     * 断言 {@code superType.isAssignableFrom(subType)} 是否为 {@code true}
     *
     * <pre class="code">
     *     Assert.isAssignable(Number.class, myClass);
     * </pre>
     *
     * @param superType     需要检查的父类或接口
     * @param subType       需要检查的子类
     * @param errorMessage  异常时的错误消息模板
     * @param args          参数列表
     * @throws IllegalArgumentException 如果子类非继承父类，抛出此异常
     */
    public static void isAssignable(Class<?> superType, Class<?> subType, String errorMessage, Object... args) throws IllegalArgumentException {
        notNull(superType, "Type to check against must not be null.");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            throw new IllegalArgumentException(StringUtils.format(errorMessage, args));
        }
    }

    //=======================================================
    //  check assignable end.
    //=======================================================


    //=======================================================
    //  check the range of values start.
    //=======================================================

    /**
     * 检查下标（数组、集合、字符串）是否符合要求，下标必须满足：
     *
     * <pre class="code">
     *      0 <= index <= size
     * </pre>
     *
     * @param index     下标
     * @param size      长度
     * @return          检查后的下标
     * @throws IllegalArgumentException 如果 size<=0 抛出此异常
     * @throws IndexOutOfBoundsException    如果 index <= 0 或者 index >= size 抛出此异常
     */
    public static int checkElementIndex(int index, int size) throws IllegalArgumentException, IndexOutOfBoundsException {
        return checkElementIndex(index, size, "[Assertion failed]");
    }

    /**
     * 检查下标（数组、集合、字符串）是否符合要求，下标必须满足：
     *
     * <pre class="code">
     *      0 <= index <= size
     * </pre>
     *
     * @param index             下标
     * @param size              长度
     * @param errorMessage      异常时的错误消息模板
     * @return                  检查后的下标
     * @throws IllegalArgumentException 如果 size<=0 抛出此异常
     * @throws IndexOutOfBoundsException    如果 index <= 0 或者 index >= size 抛出此异常
     */
    public static int checkElementIndex(int index, int size, String errorMessage, Object... args) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(badIndexMessage(index, size, errorMessage, args));
        }
        return index;
    }

    /**
     * 检查值是否在指定范围内
     *
     * @param value     值
     * @param min       最小值（包含）
     * @param max       最大值（包含）
     * @return          检查后的长度值
     */
    public static long checkBetween(long value, long min, long max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(StringUtils.format("Length must be between {} and {}.", min, max));
        }
        return value;
    }

    /**
     * 检查值是否在指定范围内
     *
     * @param value     值
     * @param min       最小值（包含）
     * @param max       最大值（包含）
     * @return          检查后的长度值
     */
    public static double checkBetween(double value, double min, double max) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(StringUtils.format("Length must be between {} and {}.", min, max));
        }
        return value;
    }

    /**
     * 检查值是否在指定范围内
     *
     * @param value     值
     * @param min       最小值（包含）
     * @param max       最大值（包含）
     * @return          检查后的长度值
     */
    public static Number checkBetween(Number value, Number min, Number max) {
        notNull(value);
        notNull(min);
        notNull(max);
        double valueDouble = value.doubleValue();
        double minDouble = min.doubleValue();
        double maxDouble = max.doubleValue();
        if (valueDouble < minDouble || valueDouble > maxDouble) {
            throw new IllegalArgumentException(StringUtils.format("Length must be between {} and {}.", min, max));
        }
        return value;
    }

    //=======================================================
    //  check the range of values end.
    //=======================================================

    /**
     * 错误的下标时显示的消息
     * @param index     下标
     * @param size      长度
     * @param desc      异常时的消息模板
     * @param args      参数列表
     * @return          消息
     */
    private static String badIndexMessage(int index, int size, String desc, Object... args) {
        if (index < 0) {
            return StringUtils.format("{} ({}) must not be negative", StringUtils.format(desc, args), index);
        } else if (size < 0) {
            throw new IllegalArgumentException("negative size: " + size);
        } else {
            // index >= size
            return StringUtils.format("{} ({}) must be less than size ({})", StringUtils.format(desc, args), index, size);
        }
    }
}
