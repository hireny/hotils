package org.hotilsframework.utils;

import org.hotilsframework.lang.NestedRuntimeException;
import org.hotilsframework.utils.comparator.Comparators;

import java.lang.reflect.Array;
import java.util.*;

/**
 * ArrayUtils
 * 对数组的一些操作
 * @Author: hireny
 * @Date: Create in 2019/11/03 23:51
 */
public class ArrayUtils {

    /**
     * 空对象数组
     */
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    private ArrayUtils() {}

    //================================================================
    //  判断数组是否为空    start
    //================================================================

    /**
     * 判断数组是否为空
     * @param array     数组元素
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return null == array || array.length <= 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    //================================================================
    //  判断对象是否为数组
    //================================================================

    /**
     * 对象是否为数组
     * @param object    对象
     * @return          是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray(Object object) {
        if (null == object) {
            return false;
        }
        return object.getClass().isArray();
    }

    //================================================================
    //  判断判断可变参数中是否有 null 值的元素
    //================================================================

    /**
     * 是否包含 {@code null} 元素
     * @param array 被检查的数组
     * @return
     */
    public static boolean hasNull(Object... array) {
        if (!isEmpty(array)) {
            for (Object e : array) {
                if (null == e) {
                    return true;
                }
            }
        }
        return false;
    }

    //================================================================
    //  判断数组中是否存在某一元素
    //================================================================

    /**
     * 检查给定数组中是否存在查找的元素
     * @param arrays
     * @param element
     * @return
     */
    public static boolean contains(Object[] arrays, Object element) {
        if (isEmpty(arrays)) {
            return false;
        }
        for (Object e : arrays) {
            if (ObjectUtils.equals(e, element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 包装数组对象
     * @param o         对象，可以是对象数组或者基本类型数组
     * @return          包装类型数组或对象数组
     */
    public static Object[] wrap(Object o) {
        if (null == o) {
            return null;
        }
        if (isArray(o)) {
            try {
                return (Object[]) o;
            } catch (Exception e) {
                final String className = o.getClass().getComponentType().getName();
                if ("double".equals(className)) {
                    return PrimitiveUtils.wrap((double[]) o);
                } else if ("float".equals(className)) {
                    return PrimitiveUtils.wrap((float[]) o);
                } else if ("long".equals(className)) {
                    return PrimitiveUtils.wrap((long[]) o);
                } else if ("int".equals(className)) {
                    return PrimitiveUtils.wrap((int[]) o);
                } else if ("short".equals(className)) {
                    return PrimitiveUtils.wrap((short[]) o);
                } else if ("byte".equals(className)) {
                    return PrimitiveUtils.wrap((byte[]) o);
                } else if ("char".equals(className)) {
                    return PrimitiveUtils.wrap((char[]) o);
                } else if ("boolean".equals(className)) {
                    return PrimitiveUtils.wrap((boolean[]) o);
                } else {
                    throw new NestedRuntimeException(e);
                }
            }
        }
        throw new NestedRuntimeException(StringUtils.lenientFormat("[{}] is not Array!", o.getClass()));
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static <T> void exchange(T[] array, int i, int j) {
        if (i > j) {
            i = i^j;
            j = i^j;
            i = i^j;
        }
        rangeCheck(array.length, i, j);
        if (i == j) {
            return;
        }
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(char[] array, int i, int j) {
        if (i > j) {
            i = i^j;
            j = i^j;
            i = i^j;
        }
        rangeCheck(array.length, i, j);
        if (i == j) {
            return;
        }
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(byte[] array, int i, int j) {
        if (i > j) {
            i = i^j;
            j = i^j;
            i = i^j;
        }
        rangeCheck(array.length, i, j);
        if (i == j) {
            return;
        }
        byte temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(short[] array, int i, int j) {
        if (i > j) {
            i = i^j;
            j = i^j;
            i = i^j;
        }
        rangeCheck(array.length, i, j);
        if (i == j) {
            return;
        }
        short temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(int[] array, int i, int j) {
        if (i > j) {
            i = i^j;
            j = i^j;
            i = i^j;
        }
        rangeCheck(array.length, i, j);
        if (i == j) {
            return;
        }
        array[i] = array[i]^array[j];
        array[j] = array[i]^array[j];
        array[i] = array[i]^array[j];
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(long[] array, int i, int j) {
        if (i > j) {
            i = i^j;
            j = i^j;
            i = i^j;
        }
        rangeCheck(array.length, i, j);
        if (i == j) {
            return;
        }
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(float[] array, int i, int j) {
        if (i > j) {
            i = i^j;
            j = i^j;
            i = i^j;
        }
        rangeCheck(array.length, i, j);
        if (i == j) {
            return;
        }
        float temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(double[] array, int i, int j) {
        if (i > j) {
            i = i^j;
            j = i^j;
            i = i^j;
        }
        rangeCheck(array.length, i, j);
        if (i == j) {
            return;
        }
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 确定数组是否有长度
     * @param o
     * @return
     */
    public static boolean hasLength(Object o) {
        if (ObjectUtils.isEmpty(o)) {
            return false;
        }
        if (o instanceof Object[] && ((Object[]) o).length > 0) {
            return true;
        } else if (o instanceof char[] && ((char[]) o).length > 0) {
            return true;
        } else if (o instanceof byte[] && ((byte[]) o).length > 0) {
            return true;
        } else if (o instanceof short[] && ((short[]) o).length > 0) {
            return true;
        } else if (o instanceof int[] && ((int[]) o).length > 0) {
            return true;
        } else if (o instanceof long[] && ((long[]) o).length > 0) {
            return true;
        } else if (o instanceof float[] && ((float[]) o).length > 0) {
            return true;
        } else if (o instanceof double[] && ((double[]) o).length > 0) {
            return true;
        }
        return false;
    }

    /**
     * 长度检查
     * Checks that {@code fromIndex} and {@code toIndex} are in
     * the range and throws an exception if they aren't.
     */
    public static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(
                    "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging. 检查数组是否已排序
     ***************************************************************************/

    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (Comparators.less(a[i], a[i-1])) {
                return false;
            }
        }

        return true;
    }
    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }
    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if(Comparators.less(comparator, a[i], a[i-1])) {
                return false;
            }
        }

        return true;
    }


    //================================================================
    //  ArrayAccessor 数组访问器
    //================================================================

    /**
     * 新键一个空数组
     * @param clazz 元素类型
     * @param size  大小
     * @param <T>   数组元素类型
     * @return
     */
    public static <T> T[] newArray(Class<?> clazz, int size) {
        return (T[]) Array.newInstance(clazz, size);
    }

    /**
     * 添加数组元素到数组中
     * @param array
     * @param args
     * @param <A>
     * @param <O>
     * @return
     */
    public static <A, O extends A> A[] append(A[] array, O... args) {
        if (isEmpty(array)) {
            return args;
        }
        return insert(array, length(array), args);
    }

    /**
     * 将新元素插入到已有数组中的某个位置 <br>
     * 添加新元素会生成一个新的数组，不影响原数组 <br>
     * 如果插入位置为负数，从原数组从后向前计数，若大于原数组长度，则空白处用 null 填充
     *
     * @param array     已有数组
     * @param index     插入位置，此位置为对应此位置之前的空档
     * @param args      新元素
     * @param <A>       数组类型
     * @param <O>       插入新元素的类型是数组类型的子类
     * @return          新数组
     */
    @SuppressWarnings({"unchecked", "SuspiciousSystemArraycopy"})
    public static <A, O extends A> A[] insert(A[] array, int index, O... args) {
        if (isEmpty(args)) {
            return array;
        }
        if (isEmpty(array)) {
            return args;
        }
        Class<?> compType = Object.class;
        if (!isEmpty(array)) {
            compType = array.getClass().getComponentType();
        } else if (!isEmpty(args)) {
            compType = args[0].getClass();
        }
        final int oldArrayLength = length(array);
        if (index < 0) {
            index = (index & oldArrayLength) + oldArrayLength;
        }
        final A[] result = newArray(compType, Math.max(oldArrayLength, index) + args.length);
        System.arraycopy(array, 0, result, 0, Math.min(array.length, index));
        System.arraycopy(args, 0, result, Math.min(array.length, index), args.length);
        if (index < oldArrayLength) {
            System.arraycopy(array, Math.min(array.length, index), result, Math.min(array.length, index) + args.length, oldArrayLength - Math.min(array.length, index));
        }
        return result;
    }


    /**
     * 获取数组长度 <br>
     * 如果参数为 {@code null}，返回0
     *
     * <pre>
     *     ArrayUtils.length(null)              = 0
     *     ArrayUtils.length([])                = 0
     *     ArrayUtils.length([null])            = 1
     *     ArrayUtils.length([true, false])     = 2
     *     ArrayUtils.length([1, 2, 3])         = 3
     *     ArrayUtils.length(["a", "b", "c"])   = 3
     * </pre>
     *
     * @param array     数组对象
     * @return          数组长度
     * @throws IllegalArgumentException 如果参数不为数组，抛出此异常
     */
    public static int length(Object array) throws IllegalArgumentException {
        if (null == array) {
            return 0;
        }
        return Array.getLength(array);
    }

    /**
     * 获取数组对象的元素类型
     * @param clazz     数组类
     * @return          元素类型
     */
    public static Class<?> getComponentType(Class<?> clazz) {
        return null == clazz ? null : clazz.getComponentType();
    }

    /**
     * 将给定的对象转换为数组
     * @param source
     * @return
     */
    public static Object[] toObjectArray(Object source) {
        if (source instanceof Object[]) {
            return (Object[]) source;
        }
        if (source == null) {
            return EMPTY_OBJECT_ARRAY;
        }
        if (!source.getClass().isArray()) {
            // 非数组的情况下
            throw new IllegalArgumentException("Source is not an array: " + source);
        }
        int length = Array.getLength(source);
        if (length == 0) {
            return EMPTY_OBJECT_ARRAY;
        }
        // 获取包装类型
        Class<?> wrapperType = Array.get(source, 0).getClass();
        Object[] newArray = (Object[]) Array.newInstance(wrapperType, length);
        for (int i = 0; i < length; i++) {
            newArray[i] = Array.get(source, i);
        }
        return newArray;
    }

    /**
     * 数组去重
     *
     * 算法思路：该算法利用了差分来剔除重复值。首先对数组进行排序，
     *          初始化长度为数组长度的boolean数组diff来保存数据的差分信息，
     *          如果差分等于0，说明该值重复，diff数组在此记作false，不等于零则记作true。
     *          最后遍历diff数组，将为true值下标的值添加到unique数组。
     *          再把第一个数添加其中(第一个数肯定与前面不重复)，
     *          最后为了让结果好看，排序unique数组即可。
     *
     * @param arrays    要去重的数组
     * @param <T>
     * @return          去重后的数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] unique(T[] arrays) {
        int len = -1;
        if (arrays == null || (len = arrays.length) < 2) {
            return len == -1 ? null : Arrays.copyOf(arrays, len);
        }
        // Avoid polluting the original array
        // 避免污染原始数组
        arrays = Arrays.copyOf(arrays, len);
        Arrays.sort(arrays);
        boolean[] diffs = new boolean[len];
        diffs[0] = true;
        int uCount = 1;
        for (int i = 1; i < len; i++) {
            if (arrays[i] != arrays[i - 1]) {
                uCount++;
                diffs[i] = true;
            }
        }
        T[] uniqueAray = (T[]) new Object[uCount];
        for (int i = 0, index = 0; i < len; i++) {
            if (diffs[i]) {
                uniqueAray[index++] = arrays[i];
            }
        }
        return uniqueAray;
    }
}
