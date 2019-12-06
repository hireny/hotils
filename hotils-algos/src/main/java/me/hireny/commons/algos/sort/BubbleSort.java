package me.hireny.commons.algos.sort;

import me.hireny.commons.utils.ArrayUtils;

/**
 * BubbleSort
 * 冒泡排序
 * 简述
 * 冒泡排序正如其关键词一样，杂乱的气泡经过浮动，最后大的气泡飘到了上面而小的气泡在下面，无序的元素序列的排序规则也是如此，每次比较相邻的两个数值，如果前面的数值大于后面的数值则进行交换，最后会将本次遍历出来的最大数值排到最后位，然后按如此规则对剩余的无序序列进行类似的冒泡处理。
 *
 * 算法描述
 * 比较相邻的两个元素，如果前面的比后面的大，则交换两个元素；
 * 对每每相邻的元素都进行这样的比较操作，从开始的一对到最后一对，这样最后的元素会是本次遍历完剩下的最大的元素；
 * 针对所有的元素执行以上步骤，除了已经指派出来的最大的元素（或序列，序列排在了最末尾）
 * 重复以上步骤直至排序完成。
 *
 * 算法分析
 * 冒泡排序算法时间复杂度分析，最佳情况：T(n) = O(n)，最差情况：T(n) = O(n^2)，平均情况：T(n) = O(n^2)
 * @Author: hireny
 * @Date: Create in 2019/11/03 14:30
 */
public class BubbleSort<T extends Comparable<? super T>> implements Sort<T> {

    /**
     * 排序算法
     * @param array
     * @return
     */
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

        for (int i=0; i<length; i++) {
            for (int j=0; j< length - i - 1; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    ArrayUtils.exchange(array, j, j+1);
                }
            }
        }
        return array;
    }

    /*
     *   字符型
     */

    /**
     * char字符型(16位{0 - 2^16-1})类型排序算法
     * @param array
     * @return
     */
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

        for (int i=0; i<length; i++) {
            for (int j=0; j< length - i - 1; j++) {
                if (array[j] - array[j+1] > 0) {
                    ArrayUtils.exchange(array, j, j+1);
                }
            }
        }

        return array;
    }

    /*
     *  整型
     */

    /**
     * byte位(8位{-2^7~2^7-1})类型排序算法
     * @param array
     * @return
     */
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

        for (int i=0; i<length; i++) {
            for (int j=0; j< length - i - 1; j++) {
                if (array[j] - array[j+1] > 0) {
                    ArrayUtils.exchange(array, j, j+1);
                }
            }
        }

        return array;
    }

    /**
     * short短整型(16位{-2^15 - 2^15-1})类型排序算法
     * @param array
     * @return
     */
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

        for (int i=0; i<length; i++) {
            for (int j=0; j< length - i - 1; j++) {
                if (array[j] - array[j+1] > 0) {
                    ArrayUtils.exchange(array, j, j+1);
                }
            }
        }

        return array;
    }

    /**
     * int整型(32位{-2^31 - 2^31-1})类型排序算法
     * @param array
     * @return
     */
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

        for (int i=0; i<length; i++) {
            for (int j=0; j< length - i - 1; j++) {
                if (array[j] - array[j+1] > 0) {
                    ArrayUtils.exchange(array, j, j+1);
                }
            }
        }
        return array;
    }

    /**
     * long长整型(64位{-2^63 - 2^63-1})类型排序算法
     * @param array
     * @return
     */
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

        for (int i=0; i<length; i++) {
            for (int j=0; j< length - i - 1; j++) {
                if (array[j] - array[j+1] > 0) {
                    ArrayUtils.exchange(array, j, j+1);
                }
            }
        }
        return array;
    }

    /**
     *  浮点型
     */

    /**
     * float单精度(32位{-2^31 - 2^31-1})类型排序算法
     * @param array
     * @return
     */
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

        for (int i=0; i<length; i++) {
            for (int j=0; j< length - i - 1; j++) {
                if (array[j] - array[j+1] > 0) {
                    ArrayUtils.exchange(array, j, j+1);
                }
            }
        }
        return array;
    }

    /**
     * doule双精度(64为{-2^63 - 2^63-1})类型排序算法
     * @param array
     * @return
     */
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

        for (int i=0; i<length; i++) {
            for (int j=0; j< length - i - 1; j++) {
                if (array[j] - array[j+1] > 0) {
                    ArrayUtils.exchange(array, j, j+1);
                }
            }
        }
        return array;
    }
}
