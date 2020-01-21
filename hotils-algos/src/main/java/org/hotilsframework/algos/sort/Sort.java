package org.hotilsframework.algos.sort;

/**
 * Sort
 * 排序策略的公共接口
 * 排序算法是使用策略模式来实现的
 * @Author: hireny
 * @Date: Create in 2019/11/03 14:19
 */
public interface Sort<T extends Comparable<? super T>> {

    /**
     * 排序算法
     * @param array
     * @return
     */
    T[] sort(T[] array);


    /*
     *   字符型
     */

    /**
     * char字符型(16位{0 - 2^16-1})类型排序算法
     * @param array
     * @return
     */
    char[] sort(char[] array);

    /*
     *  整型
     */

    /**
     * byte位(8位{-2^7~2^7-1})类型排序算法
     * @param array
     * @return
     */
    byte[] sort(byte[] array);

    /**
     * short短整型(16位{-2^15 - 2^15-1})类型排序算法
     * @param array
     * @return
     */
    short[] sort(short[] array);

    /**
     * int整型(32位{-2^31 - 2^31-1})类型排序算法
     * @param array
     * @return
     */
    int[] sort(int[] array);

    /**
     * long长整型(64位{-2^63 - 2^63-1})类型排序算法
     * @param array
     * @return
     */
    long[] sort(long[] array);

    /**
     *  浮点型
     */

    /**
     * float单精度(32位{-2^31 - 2^31-1})类型排序算法
     * @param array
     * @return
     */
    float[] sort(float[] array);

    /**
     * doule双精度(64为{-2^63 - 2^63-1})类型排序算法
     * @param array
     * @return
     */
    double[] sort(double[] array);
}
