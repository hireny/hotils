package org.hotilsframework.algos.sort;

import org.hotilsframework.utils.ArrayUtils;
import org.hotilsframework.utils.ObjectUtils;

/**
 * ShellSort
 * 希尔排序
 *
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少1。
 * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于1.
 *
 * 排序思想：先将整个待排序的记录序列分隔成为若干子序列分别进行直接插入排序，
 * 待整个序列中的记录"基本有序"时，再对全体记录进行一次直接插入排序。
 *
 * @Author: hireny
 * @Date: Create in 2019/11/05 01:21
 */
public class ShellSort<T extends Comparable<? super T>> implements Sort<T> {



    @Override
    public T[] sort(T[] array) {

        if (!ArrayUtils.hasLength(array)) {
            throw new IllegalArgumentException("排序数组空指针异常");
        }

        int length = array.length;

        if (length < 2) {
            throw new IllegalArgumentException("排序数组长度不够");
        }

        int h = 1;

        while (h < length/3) {
            h = 3 * h + 1;
        }

        System.out.println("h = " + h);

        while (h >= 1) {
            // 将数组变成h有序
            for (int i = h; i < length; i++) {
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && ObjectUtils.less(array[j], array[j-h]); j -= h) {
                    ArrayUtils.exchange(array, j, j-h);
                }
            }
            h = h / 3;
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
