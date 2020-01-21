package org.hotilsframework.algos.sort;

/**
 * 归并排序
 * @ClassName: MergeSort
 * @Author: hireny
 * @Date: Created in 2020-01-21 13:59
 * @Version: 1.0
 */
public class MergeSort<T extends Comparable<? super T>> implements Sort<T> {

    protected T[] aux;    //归并所需的辅助数组

    public MergeSort() {

    }

    public MergeSort(int capacity) {
        init(capacity);
    }

    protected void init(int capacity) {
        aux = (T[]) new Comparable[capacity]; //一次性分配空间
    }


    protected void merge(T[] arrays, int lo, int mid, int hi) {
        // 将arrays[lo...mid] 和 arrays[mid+1...hi]归并
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // 将arrays[lo...hi]复制到aux[lo...hi]
            aux[k] = arrays[k];
        }
        for (int k = lo; k <= hi; k++) {
            // 归并回到arrays[lo...hi]
            if (i > mid) {
                arrays[k] = aux[j++];
            } else if (j > hi) {
                arrays[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                arrays[k] = aux[j++];
            } else {
                arrays[k] = aux[i++];
            }
        }
    }

    private T[] sort(T[] arrays, int lo, int hi) {
        // 将数组arrays[lo...hi]排序
        if (hi <= lo) {
            return arrays;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arrays, lo, mid);  //将左半边排序
        sort(arrays, mid + 1, hi);  //将右半边排序
        merge(arrays, lo, mid, hi);  //归并排序
        return arrays;
    }

    @Override
    public T[] sort(T[] array) {

        init(array.length);
        sort(array, 0, array.length - 1);

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
