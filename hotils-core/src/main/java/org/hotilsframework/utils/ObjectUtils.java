package org.hotilsframework.utils;

import com.sun.deploy.util.ArrayUtil;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 对象工具类
 * @ClassName: ObjectUtils
 * @Author: hireny
 * @Date: Created in 2020-01-15 14:04
 * @Version: 1.0
 */
public class ObjectUtils {

    private ObjectUtils() {}

    private static final int INITIAL_HASH = 7;
    private static final int MULTIPLIER = 31;

    private static final String EMPTY_STRING = "";
    private static final String NULL_STRING = "null";
    private static final String ARRAY_START = "{";
    private static final String ARRAY_END = "}";
    private static final String EMPTY_ARRAY = ARRAY_START + ARRAY_END;
    private static final String ARRAY_ELEMENT_SEPARATOR = ", ";

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
        } else if (o instanceof Optional) {
            return !((Optional) o).isPresent();
        } else if (o instanceof CharSequence) {
            return ((CharSequence) o).length() == 0;
        } else if (o.getClass().isArray()) {
            return Array.getLength(o) == 0;
        } else if (o instanceof Collection) {
            return ((Collection) o).isEmpty();
        } else if (o instanceof Map) {
            return ((Map) o).isEmpty();
        }
        return false;
    }

    /**
     * 获取对象的类型
     * @param o
     * @return
     */
    public static Class<?> getClass(Object o) {
        if (o.getClass() == boolean.class) {
            return boolean.class;
        } else if (o.getClass() == char.class) {
            return char.class;
        } else if (o.getClass() == byte.class) {
            return byte.class;
        } else if (o.getClass() == short.class) {
            return short.class;
        } else if (o.getClass() == int.class) {
            return int.class;
        } else if (o.getClass() == long.class) {
            return long.class;
        } else if (o.getClass() == float.class) {
            return float.class;
        } else if (o.getClass() == double.class) {
            return double.class;
        }
        return o.getClass();
    }

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
        if (obj instanceof org.hotilsframework.core.lang.Optional) {
            org.hotilsframework.core.lang.Optional<?> optional = (org.hotilsframework.core.lang.Optional<?>) obj;
            if (!optional.isPresent()) {
                return null;
            }
            Object result = optional.get();
            Assert.isTrue(!(result instanceof org.hotilsframework.core.lang.Optional), "Multi-level Optional usage not supported");
            return result;
        }
        return obj;
    }


    /**
     * 获取不相等的属性
     * @param o1    对象一
     * @param o2    对象二
     * @return      不相等的属性，键为属性名，值为属性类型
     */
    public static List<Object> getDiffFields(Object o1, Object o2) {
        if (o1 == o2) {
            return Collections.emptyList();
        }
        // 先尝试判断是否为简单数据类型
//        if ()
        return null;
    }

    /**
     * 判断是否是JDK内部对象
     * @param o     对象
     * @return
     */
    public static boolean isJdkInnerObject(Object o) {
        if (isEmpty(o)) {
            return false;
        }
        if (o.getClass().isPrimitive()) {
            return true;
        }
        String packageName = o.getClass().getName();
        if (packageName.contains("java.")) {
            return true;
        }
        return false;
    }

    /**
     * 比较两个对象是否完全相同
     *
     * <p>
     *     此方法可以正确地比较多维数组
     * </p>
     *
     * <pre>
     *     ObjectUtils.equals(null, null)                   = true
     *     ObjectUtils.equals(null, "")                     = false
     *     ObjectUtils.equals("", null)                     = false
     *     ObjectUtils.equals("", "")                       = true
     *     ObjectUtils.equals(Boolean.TRUE, null)           = false
     *     ObjectUtils.equals(Boolean.TRUE, "true")         = false
     *     ObjectUtils.equals(Boolean.TRUE, Boolean.TRUE)   = true
     *     ObjectUtils.equals(Boolean.TRUE, Boolean.FALSE)  = false
     * </pre>
     * @param o1    对象1
     * @param o2    对象2
     * @return      如果相等，则返回 {@code true}
     */
    public static boolean equals(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        if (!o1.getClass().equals(o2.getClass())) {
            return false;
        }
        if (o1.getClass().isArray() && o2.getClass().isArray()) {
            // 同为数组的话，判断数组是否相同
            return arrayEquals(o1, o2);
        }
        return o1.equals(o2);
    }

    /**
     * 根据数组元素而不是数组引用来比较给定的数组是否相等
     * @param o1
     * @param o2
     * @return
     */
    private static boolean arrayEquals(Object o1, Object o2) {
        if (o1 instanceof Object[] && o2 instanceof Object[]) {
            return Arrays.deepEquals((Object[]) o1, (Object[]) o2);
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
     * 比较两个对象是否类型相同 {@code null} 被看做任意类型
     * @param o1    对象1
     * @param o2    对象2
     * @return      如果两个对象有相同的类型，则返回 {@code true}
     */
    public static boolean isSameType(Object o1, Object o2) {
        if (o1 == null || o2 == null) {
            return true;
        }
        return o1.getClass().equals(o2.getClass());
    }

    /**
     * 取得对象的hash值，如果对象为 {@code null}, 则返回 {@code 0}
     * 
     * <p>
     *     此方法可以正确地处理多维数组
     * </p>
     * @param o     对象
     * @return      hash值
     */
    public static int hashCode(Object o) {
        if (o == null) {
            return 0;
        }
        if (o.getClass().isArray()) {
            return arrayHashCode(o);
        }
        return o.hashCode();
    }

    /**
     * 取得对象的hash值，如果对象为 {@code null}, 则返回 {@code 0}
     *
     * <p>
     *     此方法可以正确地处理多维数组
     * </p>
     * @param objects   对象
     * @return          hash值
     */
    public static int hashCode(Object... objects) {
        return arrayHashCode(objects);
    }

    /**
     * 取得对象的hash值，如果对象为 {@code null}, 则返回 {@code 0}
     * @param o     对象
     * @return      hash值
     */
    private static int arrayHashCode(Object o) {
        if (o instanceof Object[]) {
            return arrayHashCode((Object[]) o);
        }
        if (o instanceof boolean[]) {
            return arrayHashCode((boolean[]) o);
        }
        if (o instanceof byte[]) {
            return arrayHashCode((byte[]) o);
        }
        if (o instanceof char[]) {
            return arrayHashCode((char[]) o);
        }
        if (o instanceof double[]) {
            return arrayHashCode((double[]) o);
        }
        if (o instanceof float[]) {
            return arrayHashCode((float[]) o);
        }
        if (o instanceof int[]) {
            return arrayHashCode((int[]) o);
        }
        if (o instanceof long[]) {
            return arrayHashCode((long[]) o);
        }
        if (o instanceof short[]) {
            return arrayHashCode((short[]) o);
        }
        return o.hashCode();
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int arrayHashCode(Object[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (Object element : array) {
            hash = MULTIPLIER * hash + arrayHashCode(element);
        }
        return hash;
    }

    /**
     * Return a hash code based on the contents of the specified array.
     * If {@code array} is {@code null}, this method returns 0.
     */
    private static int arrayHashCode(boolean[] array) {
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
    private static int arrayHashCode( byte[] array) {
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
    private static int arrayHashCode(char[] array) {
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
    private static int arrayHashCode(double[] array) {
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
    private static int arrayHashCode(float[] array) {
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
    private static int arrayHashCode(int[] array) {
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
    private static int arrayHashCode(long[] array) {
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
    private static int arrayHashCode(short[] array) {
        if (array == null) {
            return 0;
        }
        int hash = INITIAL_HASH;
        for (short element : array) {
            hash = MULTIPLIER * hash + element;
        }
        return hash;
    }

    //---------------------------------------------------------------------
    // Convenience methods for toString output
    //---------------------------------------------------------------------

    /**
     * 取得对象自身的 identity，如果对象没有覆盖 {@code toString()} 方法时，
     * {@code Object.toString()} 的原始输出。
     * @param obj
     * @return
     */
    public static String identityToString(Object obj) {
        if (obj == null) {
            return EMPTY_STRING;
        }
        return obj.getClass().getName() + "@" + getIdentityHexString(obj);
    }

    /**
     * 返回对象标识哈希码的十六进制字符串形式。
     * @param o     对象
     * @return      对象的16进制标识符
     */
    public static String getIdentityHexString(Object o) {
        return Integer.toHexString(System.identityHashCode(o));
    }

    /**
     * 将对象以字符串的形式返回的容忍处理
     * @param o
     * @return
     */
    public static String lenientToString(Object o) {
        try {
            return String.valueOf(o);
        } catch (Exception e) {
            // Default toString(0 behavior - see Object.toString()
            String objectToString = identityToString(o);
            // Logger is created inline with fixed name to avoid forcing Proguard to create another class.
            Logger.getLogger("org.hotilsframework.utils.StringUtils")
                    .log(Level.WARNING, "Exception during lenientFormat for " + objectToString, e);
            return "<" + objectToString + " throw " + e.getClass().getName() + ">";
        }
    }

    /**
     * 获取对象的 {@code toString()} 的值，如果对象为 {@code null}，则返回空字符串 {@code ""}
     *
     * <pre>
     *     ObjectUtils.toString(null)         = ""
     *     ObjectUtils.toString("")           = ""
     *     ObjectUtils.toString("bat")        = "bat"
     *     ObjectUtils.toString(Boolean.TRUE) = "true"
     *     ObjectUtils.toString([1, 2, 3])    = "[1, 2, 3]"
     * </pre>
     * @param o     对象
     * @return      对象的 {@code toString()} 的返回值，或空字符串 {@code ""}
     */
    public static String toString(Object o) {
        if (o == null) {
            return NULL_STRING;
        }
        if (o instanceof String) {
            return (String) o;
        }
        if (o instanceof Object[]) {
            return arrayToString((Object[]) o);
        }
        if (o instanceof boolean[]) {
            return arrayToString((boolean[]) o);
        }
        if (o instanceof byte[]) {
            return arrayToString((byte[]) o);
        }
        if (o instanceof char[]) {
            return arrayToString((char[]) o);
        }
        if (o instanceof double[]) {
            return arrayToString((double[]) o);
        }
        if (o instanceof float[]) {
            return arrayToString((float[]) o);
        }
        if (o instanceof int[]) {
            return arrayToString((int[]) o);
        }
        if (o instanceof long[]) {
            return arrayToString((long[]) o);
        }
        if (o instanceof short[]) {
            return arrayToString((short[]) o);
        }
        String str = o.toString();
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
    public static String arrayToString(Object[] array) {
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
    public static String arrayToString(boolean[] array) {
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
    public static String arrayToString(byte[] array) {
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
    public static String arrayToString(char[] array) {
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
    public static String arrayToString(double[] array) {
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
    public static String arrayToString(float[] array) {
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
    public static String arrayToString(int[] array) {
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
    public static String arrayToString(long[] array) {
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
    public static String arrayToString(short[] array) {
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
     * 如果给定对象为{@code null} 返回默认值
     *
     * ObjectUtil.defaultIfNull(null, null)      = null
     * ObjectUtil.defaultIfNull(null, "")        = ""
     * ObjectUtil.defaultIfNull(null, "zz")      = "zz"
     * ObjectUtil.defaultIfNull("abc", *)        = "abc"
     * ObjectUtil.defaultIfNull(Boolean.TRUE, *) = Boolean.TRUE
     *
     * @param obj               被检查对象，可能为{@code null}
     * @param defaultValue      被检查对象为{@code null}返回的默认值，可以为{@code null}
     * @param <T>               对象类型
     * @return                  被检查对象为{@code null}返回默认值，否则返回原值
     */
    public static <T> T defaultIfNull(final T obj, final T defaultValue) {
        return (null != obj) ? obj : defaultValue;
    }

    /**
     * 克隆对象
     * 如果对象实现Cloneable接口，调用其clone方法
     * 如果实现Serializable接口，执行深度克隆
     * 否则返回 {@code null}
     * @param object    被克隆的对象
     * @param <T>       对象类型
     * @return          克隆后的对象
     */
    public static <T> T clone(T object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos));
        oos.writeObject(object);
        oos.flush();

        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        @SuppressWarnings("unchecked")
        T result=(T) ois.readObject();

        ois.close();
        oos.close();
        bos.close();
        return result;
    }

    /**
     * 返回克隆后的对象，如果克隆失败，返回原对象
     *
     * @param <T> 对象类型
     * @param obj 对象
     * @return 克隆后或原对象
     */
//    public static <T> T cloneIfPossible(final T obj) {
//        T clone = null;
//        try {
//            clone = clone(obj);
//        } catch (Exception e) {
//            // pass
//        }
//        return clone == null ? obj : clone;
//    }
}
