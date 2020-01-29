package org.hotilsframework.utils;

import org.hotilsframework.lang.Comparators;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ArrayUtils
 * 对数组的一些操作
 * @Author: hireny
 * @Date: Create in 2019/11/03 23:51
 */
public class ArrayUtils {

    private ArrayUtils() {}

    /**
     * 判断数组是否为空
     * @param arrays
     * @return
     */
    public static boolean isEmpty(Object[] arrays) {
        return null == arrays || arrays.length <= 0;
    }

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

    /**
     * 数组交集
     *
     * 算法思路：该算法依旧是利用了差分的性质，只不过这次比较隐蔽。
     *          它首先把两数组a和b都进行unique操作，得到两个unique数组，
     *          再将这两个数组拼接在一起，对其排序，得到数组c，如果a和b有交集2，
     *          那么数组c中一定有两个挨着的2，
     *          因此数组c中所有相邻且相等的数值(差分值等于0)都是数组a和b的交集。
     *
     * @param aArray
     * @param bArray
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] intersect(T[] aArray, T[] bArray) {
        if (aArray == null || bArray == null) {
            return null;
        }
        if (aArray.length == 0 || bArray.length == 0) {
            Object[] o = new Object[0];
            return (T[]) o;
        }
        T[] tempA = unique(aArray);
        T[] tempB = unique(bArray);
        int tempALen = tempA.length;
        int tempBLen = tempB.length;
        int tempMergeLen = tempALen + tempBLen;
        // 可能排除内存溢出错误(OutOfMemoryError)和数组大小为负(NegativeArraySizeException)的异常
        Object[] sortMergeArray = new Object[tempMergeLen];
        System.arraycopy(tempA, 0, sortMergeArray, 0, tempALen);
        System.arraycopy(tempB, 0, sortMergeArray, tempALen, tempBLen);
        Arrays.sort(sortMergeArray);
        int minLenOfTwoArrays = tempALen > tempBLen ? tempBLen : tempALen;
        Object[] minOfTwoArrays = new Object[minLenOfTwoArrays];
        int index = 0;
        for (int i = 1; i < tempMergeLen; i++) {
            if (sortMergeArray[i] == sortMergeArray[i - 1]) {
                minOfTwoArrays[index++] = sortMergeArray[i++];
                // 下一个绝对不等
            }
        }
        return (T[]) Arrays.copyOf(minOfTwoArrays, index);
    }

    /**
     * 数组并集
     *
     * 算法思路：把两个数组拼接起来，所有工作全交由unique处理。
     *
     * @param aArray
     * @param bArray
     * @param <T>
     * @return
     */
    public static <T> T[] union(T[] aArray, T[] bArray) {
        int aLen;
        if (aArray == null || (aLen = aArray.length) == 0) {
            return unique(aArray);
        }
        int bLen;
        if (bArray == null || (bLen = bArray.length) == 0) {
            return unique(bArray);
        }
        int mergeLen = aLen + bLen;
        // May throw OutOfMemoryError and NegativeArraySizeException
        Object[] mergeArray = new Object[mergeLen];
        System.arraycopy(aArray, 0, mergeArray, 0, aLen);
        System.arraycopy(bArray, 0, mergeArray, aLen, bLen);
        // Call unique to do all the work.
        // 剩下的工作交给数组去重去处理。
        return (T[]) unique(mergeArray);
    }

    /**
     * 差集
     *      假设有集合A和B，所有属于A且不属于B的元素的集合被称为A与B的差集。
     *      示例：对于集合A = {a, b, c, d} 和 集合B = {b, c, w}，则A与B的差集为 {a, b}.
     *
     * 算法思路：先将一个数组存储起来，在使用另一个数组进行判断，若有相同的，则删除。
     *
     * @param aArray
     * @param bArray
     * @param <T>
     * @return          返回aArray与bArray的差集
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] except(T[] aArray, T[] bArray) {
        if (aArray == null || bArray == null) {
            return null;
        }
        if (aArray.length == 0 || bArray.length == 0) {
            return (T[]) new Object[0];
        }
        int aLen = aArray.length;
        Object[] tempA = unique(aArray);
        Object[] tempB = unique(bArray);
        boolean[] diffs = new boolean[aLen];
        outer:
        for (Object o : tempB) {
            for (int i = 0; i < aLen; i++) {
                if (o == tempA[i]) {
                    diffs[i] = true;
                    continue outer;
                }
            }
        }
        Object[] exceptArray = new Object[aLen];
        int index = 0;
        for (int i = 0; i < aLen; i++) {
            if (!diffs[i]) {
                exceptArray[index++] = tempA[i];
            }
        }

        return (T[]) Arrays.copyOf(exceptArray, index);
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
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
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
}
