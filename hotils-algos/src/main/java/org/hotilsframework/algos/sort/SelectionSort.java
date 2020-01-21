package org.hotilsframework.algos.sort;

import org.hotilsframework.utils.ArrayUtils;

/**
 * SelectionSort
 * 选择排序
 * 算法思想：选择排序，从头至尾扫描序列，找出最小的一个元素，和第一个元素交换，接着从剩下的元素中继续这种选择和交换方式，最终得到一个有序序列。
 * @Author: hireny
 * @Date: Create in 2019/11/04 00:19
 */
public class SelectionSort<T extends Comparable<? super T>> implements Sort<T> {

    @Override
    public T[] sort(T[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }

        /**
         * 排序的数组长度
         */
        int length = array.length;

        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i=0; i < length; i++) {
            int min = i;    //最小索引
            for (int j = i+1; j < length; j++) {
                // 获取最小索引
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            ArrayUtils.exchange(array, i, min);
            // 判断是否已经排序完成
            assert ArrayUtils.isSorted(array);
        }
        // 判断是否已经排序完成
        assert ArrayUtils.isSorted(array);
        return array;
    }

    @Override
    public char[] sort(char[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }

        /**
         * 排序的数组长度
         */
        int length = array.length;

        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i=0; i < length; i++) {
            int min = i;    //最小索引
            for (int j = i+1; j < length; j++) {
                // 获取最小索引
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(array, i, min);
        }
        return array;
    }

    @Override
    public byte[] sort(byte[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }

        /**
         * 排序的数组长度
         */
        int length = array.length;

        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i=0; i < length; i++) {
            int min = i;    //最小索引
            for (int j = i+1; j < length; j++) {
                // 获取最小索引
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(array, i, min);
        }
        return array;
    }

    @Override
    public short[] sort(short[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }

        /**
         * 排序的数组长度
         */
        int length = array.length;

        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i=0; i < length; i++) {
            int min = i;    //最小索引
            for (int j = i+1; j < length; j++) {
                // 获取最小索引
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(array, i, min);
        }
        return array;
    }

    @Override
    public int[] sort(int[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }

        /**
         * 排序的数组长度
         */
        int length = array.length;

        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i=0; i < length; i++) {
            int min = i;    //最小索引
            for (int j = i+1; j < length; j++) {
                // 获取最小索引
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(array, i, min);
        }
        return array;
    }

    @Override
    public long[] sort(long[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }

        /**
         * 排序的数组长度
         */
        int length = array.length;

        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i=0; i < length; i++) {
            int min = i;    //最小索引
            for (int j = i+1; j < length; j++) {
                // 获取最小索引
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(array, i, min);
        }
        return array;
    }

    @Override
    public float[] sort(float[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }

        /**
         * 排序的数组长度
         */
        int length = array.length;

        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i=0; i < length; i++) {
            int min = i;    //最小索引
            for (int j = i+1; j < length; j++) {
                // 获取最小索引
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(array, i, min);
        }
        return array;
    }

    @Override
    public double[] sort(double[] array) {
        // 判断边界条件
        if (!ArrayUtils.hasLength(array)) {
            throw new NullPointerException("排序数组空指针异常");
        }

        /**
         * 排序的数组长度
         */
        int length = array.length;

        if (length < 2) {
            throw new NullPointerException("排序数组长度不够");
        }

        for (int i=0; i < length; i++) {
            int min = i;    //最小索引
            for (int j = i+1; j < length; j++) {
                // 获取最小索引
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(array, i, min);
        }
        return array;
    }
}
