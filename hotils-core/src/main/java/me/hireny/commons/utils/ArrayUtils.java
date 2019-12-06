package me.hireny.commons.utils;

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
        return null == arrays;
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


    /********************************************************************************************
     *   Helper.sorting.functions   排序的辅助方法
     ********************************************************************************************/

    // is v < w ?
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    public static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    // is v < w ?
    public static boolean less(char v, char w) {
        return v - w < 0;
    }

    // is v < w ?
    public static boolean less(byte v, byte w) {
        return v - w < 0;
    }

    // is v < w ?
    public static boolean less(short v, short w) {
        return v - w < 0;
    }

    // is v < w ?
    public static boolean less(int v, int w) {
        return v - w < 0;
    }

    // is v < w ?
    public static boolean less(long v, long w) {
        return v - w < 0;
    }

    // is v < w ?
    public static boolean less(float v, float w) {
        return v - w < 0;
    }

    // is v < w ?
    public static boolean less(double v, double w) {
        return v - w < 0;
    }

    /**
     * 将两个下标的值进行交换
     * @param array
     * @param i
     * @param j
     */
    public static <T> void exchange(T[] array, int i, int j) {
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
        if (o == null) {
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
            if (less(a[i], a[i-1])) {
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
            if(less(comparator, a[i], a[i-1])) {
                return false;
            }
        }

        return true;
    }
}
