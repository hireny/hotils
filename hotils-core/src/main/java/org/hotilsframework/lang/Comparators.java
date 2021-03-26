package org.hotilsframework.lang;

import java.util.Comparator;

/**
 * 比较器的封装
 * @className Comparators
 * @author hireny
 * @date Created in 2020-02-06 23:01
 * @version 1.0
 */
public class Comparators {

    /********************************************************************************************
     *   Helper.sorting.functions   排序的辅助方法
     ********************************************************************************************/

    /**
     * 比较大小 v < w 返回true； v > w 返回false
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    public static boolean less(char v, char w) {
        return v - w < 0;
    }

    public static boolean less(byte v, byte w) {
        return v - w < 0;
    }

    public static boolean less(short v, short w) {
        return v - w < 0;
    }

    public static boolean less(int v, int w) {
        return v - w < 0;
    }

    public static boolean less(long v, long w) {
        return v - w < 0;
    }

    public static boolean less(float v, float w) {
        return v - w < 0;
    }

    public static boolean less(double v, double w) {
        return v - w < 0;
    }
}
