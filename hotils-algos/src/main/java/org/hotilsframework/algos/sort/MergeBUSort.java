package org.hotilsframework.algos.sort;

/**
 * 自顶向下的归并排序
 * @ClassName: MergeBUSort
 * @Author: hireny
 * @Date: Created in 2020-01-21 14:21
 * @Version: 1.0
 */
public class MergeBUSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public T[] sort(T[] array) {
        // 进行 lgN次两两归并
        int size = array.length;

        return super.sort(array);
    }

    @Override
    public char[] sort(char[] array) {
        return super.sort(array);
    }

    @Override
    public byte[] sort(byte[] array) {
        return super.sort(array);
    }

    @Override
    public short[] sort(short[] array) {
        return super.sort(array);
    }

    @Override
    public int[] sort(int[] array) {
        return super.sort(array);
    }

    @Override
    public long[] sort(long[] array) {
        return super.sort(array);
    }

    @Override
    public float[] sort(float[] array) {
        return super.sort(array);
    }

    @Override
    public double[] sort(double[] array) {
        return super.sort(array);
    }
}
