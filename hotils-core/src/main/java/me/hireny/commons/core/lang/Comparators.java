package me.hireny.commons.core.lang;

import java.util.Comparator;

/**
 * @ClassName: Comparators
 * @Author: hireny
 * @Date: Create in 2019/12/20 02:57
 * @Description: TODO   比较器工具类
 */
public final class Comparators {

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
}
