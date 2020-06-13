package org.hotilsframework.algos.sort;

import org.hotilsframework.utils.ArrayUtils;
import org.hotilsframework.utils.Comparators;

/**
 * InsertionSort
 * 插入排序
 *
 * 编程思想：每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
 *
 *
 * @Author: hireny
 * @Date: Create in 2019/11/05 01:21
 */
public class InsertionSort<T extends Comparable<? super T>> implements Sort<T> {
    @Override
    public T[] sort(T[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }
        // 排序数组的长度
        int length = array.length;
        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (Comparators.less(array[j], array[j-1])) {
                    ArrayUtils.exchange(array, j, j-1);
                }
            }
        }

        return array;
    }

    @Override
    public char[] sort(char[] array) {
        return new char[0];
    }

    @Override
    public byte[] sort(byte[] array) {
        return new byte[0];
    }

    @Override
    public short[] sort(short[] array) {
        return new short[0];
    }

    @Override
    public int[] sort(int[] array) {
        return new int[0];
    }

    @Override
    public long[] sort(long[] array) {
        return new long[0];
    }

    @Override
    public float[] sort(float[] array) {
        return new float[0];
    }

    @Override
    public double[] sort(double[] array) {
        return new double[0];
    }
}
