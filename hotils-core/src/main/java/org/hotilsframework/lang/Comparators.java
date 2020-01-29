package org.hotilsframework.lang;

import org.hotilsframework.lang.reflect.FieldInfo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    /**
     * 比较大小 v < w 返回true； v > w 返回false
     * @param v
     * @param w
     * @return
     */
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
     * 两个对象是否全相等
     * @param o1    对象一
     * @param o2    对象二
     * @return      两个对象是否全相等
     */
    public static boolean equals(Object o1, Object o2) {
        return false;
    }

    /**
     * 获取不相等的属性
     * @param o1    对象一
     * @param o2    对象二
     * @return      不相等的属性，键为属性名，值为属性类型
     */
    public static List<FieldInfo> getDiffFields(Object o1, Object o2) {
        if (o1 == o2) {
            return Collections.emptyList();
        }
        // 先尝试判断是否为简单数据类型
//        if ()
        return null;
    }
}
