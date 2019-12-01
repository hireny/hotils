package me.hireny.commons.core.lang;

import me.hireny.commons.utils.Assert;

import java.util.*;

/**
 * @Author: hireny
 * @Date: Create in 2019/09/30 01:36
 */
public final class Objects {
    private Objects() {}

    private static final int INITIAL_HASH = 7;
    private static final int MULTIPLIER = 31;

    private static final String EMPTY_STRING = "";
    private static final String NULL_STRING = "null";
    private static final String ARRAY_START = "{";
    private static final String ARRAY_END = "}";
    private static final String EMPTY_ARRAY = ARRAY_START + ARRAY_END;
    private static final String ARRAY_ELEMENT_SEPARATOR = ", ";

    /**
     * 该方法判断一个Object对象是否是Optional类型的。
     * 如果是，打开Optional使用get()获取值，如果不是返回Object对象
     * @param obj
     * @return
     */
    public static Object unwrapOptional(Object obj) {
        if (obj instanceof Optional) {
            Optional<?> optional = (Optional<?>) obj;
            if (!optional.isPresent()) {
                // 判断该值是否存在，不存在返回null
                return null;
            }
            Object result = optional.get();
            // Multi-level Optional usage not supported
            // 不支持多级可选用法
            Assert.isTrue(!(result instanceof Optional), "Multi-level Optional usage not supported");
            return result;
        }
        return obj;
    }

    /**
     * 判断对象是否为Empty(null 或元素为 0)
     * 适用于对如下对象做判断：String Collection及其子类 Map及其子类
     * @param o     待检查的对象
     * @return
     */
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o == "") {
            return true;
        }
        if (o instanceof String) {
            return ((String) o).length() == 0;
        } else if (o instanceof Collection) {
            return ((Collection) o).isEmpty();
        } else if (o instanceof Map) {
            return ((Map) o).size() == 0;
        }
        return false;
    }

    /**
     * 确定两个对象是否相等
     * @param o1
     * @param o2
     * @return
     */
    public static boolean equals(Object o1, Object o2) {
        return nullSafeEquals(o1, o2);
    }

    /**
     * 确定两个对象是否相等
     * @param o1
     * @param o2
     * @return
     */
    private static boolean nullSafeEquals(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        if (o1.equals(o2)) {
            return true;
        }
        if (o1.getClass().isArray() && o2.getClass().isArray()) {
            // 同为数组的话，判断数组是否相同
            return arrayEquals(o1, o2);
        }
        return false;
    }

    /**
     * 根据数组元素而不是数组引用来比较给定的数组是否相等
     * @param o1
     * @param o2
     * @return
     */
    private static boolean arrayEquals(Object o1, Object o2) {
        if (o1 instanceof Object[] && o2 instanceof Object[]) {
            return Arrays.equals((Object[]) o1, (Object[]) o2);
        }
        if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
            return Arrays.equals((boolean[]) o1, (boolean[]) o2);
        }
        if (o1 instanceof byte[] && o2 instanceof byte[]) {
            return Arrays.equals((byte[]) o1, (byte[]) o2);
        }
        if (o1 instanceof char[] && o2 instanceof char[]) {
            return Arrays.equals((char[]) o1, (char[]) o2);
        }
        if (o1 instanceof double[] && o2 instanceof double[]) {
            return Arrays.equals((double[]) o1, (double[]) o2);
        }
        if (o1 instanceof float[] && o2 instanceof float[]) {
            return Arrays.equals((float[]) o1, (float[]) o2);
        }
        if (o1 instanceof int[] && o2 instanceof int[]) {
            return Arrays.equals((int[]) o1, (int[]) o2);
        }
        if (o1 instanceof long[] && o2 instanceof long[]) {
            return Arrays.equals((long[]) o1, (long[]) o2);
        }
        if (o1 instanceof short[] && o2 instanceof short[]) {
            return Arrays.equals((short[]) o1, (short[]) o2);
        }
        return false;
    }

    /**
     * 返回hashCode
     * @param object
     * @return
     */
    public static int hashCode(Object object) {
        return nullSafeHashCode(object);
    }
    /**
     * 返回hashCode
     * @param objects
     * @return
     */
    public static int hashCode(Object... objects) {
        return nullSafeHashCode(objects);
    }

    /**
     * 返回Object对象的HashCode
     *
     * Return as hash code for the given object; typically the value of
     * {@code Object#hashCode()}}. If the object is an array,
     * this method will delegate to any of the {@code nullSafeHashCode}
     * methods for arrays in this class. If the object is {@code null},
     * this method returns 0.
     * @see Object#hashCode()
     * @see #nullSafeHashCode(Object[])
     * @see #nullSafeHashCode(boolean[])
     * @see #nullSafeHashCode(byte[])
     * @see #nullSafeHashCode(char[])
     * @see #nullSafeHashCode(double[])
     * @see #nullSafeHashCode(float[])
     * @see #nullSafeHashCode(int[])
     * @see #nullSafeHashCode(long[])
     * @see #nullSafeHashCode(short[])
     */
    private static int nullSafeHashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof Object[]) {
                return nullSafeHashCode((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return nullSafeHashCode((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return nullSafeHashCode((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return nullSafeHashCode((char[]) obj);
            }
            if (obj instanceof double[]) {
                return nullSafeHashCode((double[]) obj);
            }
            if (obj instanceof float[]) {
                return nullSafeHashCode((float[]) obj);
            }
            if (obj instanceof int[]) {
                return nullSafeHashCode((int[]) obj);
            }
            if (obj instanceof long[]) {
                return nullSafeHashCode((long[]) obj);
            }
            if (obj instanceof short[]) {
                return nullSafeHashCode((short[]) obj);
            }
        }
        return obj.hashCode();
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode(Object[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (Object element : array) {
            hash = MULTIPLIER * hash + nullSafeHashCode(element);
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode(boolean[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (boolean element : array) {
            hash = MULTIPLIER * hash + Boolean.hashCode(element);
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode( byte[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (byte element : array) {
            hash = MULTIPLIER * hash + element;
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode(char[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (char element : array) {
            hash = MULTIPLIER * hash + element;
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode(double[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (double element : array) {
            hash = MULTIPLIER * hash + Double.hashCode(element);
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode(float[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (float element : array) {
            hash = MULTIPLIER * hash + Float.hashCode(element);
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode(int[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (int element : array) {
            hash = MULTIPLIER * hash + element;
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode(long[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (long element : array) {
            hash = MULTIPLIER * hash + Long.hashCode(element);
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int nullSafeHashCode(short[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (short element : array) {
            hash = MULTIPLIER * hash + element;
        }
        return hash;
    }

    // 对各对象的hashCode进行多态封装

    /**
     * Return the same value as {@link Boolean#hashCode(boolean)}}.
     * @deprecated as of Spring Framework 5.0, in favor of the native JDK 8 variant
     */
    @Deprecated
    public static int hashCode(boolean bool) {
        return Boolean.hashCode(bool);
    }

    /**
     * Return the same value as {@link Double#hashCode(double)}}.
     * @deprecated as of Spring Framework 5.0, in favor of the native JDK 8 variant
     */
    @Deprecated
    public static int hashCode(double dbl) {
        return Double.hashCode(dbl);
    }

    /**
     * Return the same value as {@link Float#hashCode(float)}}.
     * @deprecated as of Spring Framework 5.0, in favor of the native JDK 8 variant
     */
    @Deprecated
    public static int hashCode(float flt) {
        return Float.hashCode(flt);
    }

    /**
     * Return the same value as {@link Long#hashCode(long)}}.
     * @deprecated as of Spring Framework 5.0, in favor of the native JDK 8 variant
     */
    @Deprecated
    public static int hashCode(long lng) {
        return Long.hashCode(lng);
    }


    //---------------------------------------------------------------------
    // Convenience methods for toString output
    //---------------------------------------------------------------------

    /**
     * Return a String representation of an object's overall identity.
     * @param obj the object (may be {@code null})
     * @return the object's identity as String representation,
     * or an empty String if the object was {@code null}
     */
    public static String identityToString( Object obj) {
        if (obj == null) {
            return EMPTY_STRING;
        }
        return obj.getClass().getName() + "@" + getIdentityHexString(obj);
    }

    /**
     * Return a hex String form of an object's identity hash code.
     * @param obj the object
     * @return the object's identity code in hex notation
     */
    public static String getIdentityHexString(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /**
     * Return a String representation of the specified Object.
     * <p>Builds a String representation of the contents in case of an array.
     * Returns a {@code "null"} String if {@code obj} is {@code null}.
     * @param obj the object to build a String representation for
     * @return a String representation of {@code obj}
     */
    public static String nullSafeToString( Object obj) {
        if (obj == null) {
            return NULL_STRING;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Object[]) {
            return nullSafeToString((Object[]) obj);
        }
        if (obj instanceof boolean[]) {
            return nullSafeToString((boolean[]) obj);
        }
        if (obj instanceof byte[]) {
            return nullSafeToString((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return nullSafeToString((char[]) obj);
        }
        if (obj instanceof double[]) {
            return nullSafeToString((double[]) obj);
        }
        if (obj instanceof float[]) {
            return nullSafeToString((float[]) obj);
        }
        if (obj instanceof int[]) {
            return nullSafeToString((int[]) obj);
        }
        if (obj instanceof long[]) {
            return nullSafeToString((long[]) obj);
        }
        if (obj instanceof short[]) {
            return nullSafeToString((short[]) obj);
        }
        String str = obj.toString();
        return (str != null ? str : EMPTY_STRING);
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(Object[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringJoiner sj = new StringJoiner(ARRAY_ELEMENT_SEPARATOR, ARRAY_START, ARRAY_END);
        for (Object o : array) {
            sj.add(String.valueOf(o));
        }
        return sj.toString();
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(boolean[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            }
            else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }

            sb.append(array[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(byte[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            }
            else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(array[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(char[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            }
            else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("'").append(array[i]).append("'");
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(double[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            }
            else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }

            sb.append(array[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(float[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            }
            else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }

            sb.append(array[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(int[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            }
            else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(array[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(long[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            }
            else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(array[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }

    /**
     * Return a String representation of the contents of the specified array.
     * <p>The String representation consists of a list of the array's elements,
     * enclosed in curly braces ({@code "{}"}). Adjacent elements are separated
     * by the characters {@code ", "} (a comma followed by a space).
     * Returns a {@code "null"} String if {@code array} is {@code null}.
     * @param array the array to build a String representation for
     * @return a String representation of {@code array}
     */
    public static String nullSafeToString(short[] array) {
        if (array == null) {
            return NULL_STRING;
        }
        int length = array.length;
        if (length == 0) {
            return EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(ARRAY_START);
            }
            else {
                sb.append(ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(array[i]);
        }
        sb.append(ARRAY_END);
        return sb.toString();
    }
}
