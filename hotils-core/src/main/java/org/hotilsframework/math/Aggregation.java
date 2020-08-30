package org.hotilsframework.math;

import org.hotilsframework.lang.ArrayUtils;

import java.util.Arrays;

/**
 * @className Aggregate
 * @description TODO   数学集合
 * @author hireny
 * @date Created in 2020-01-08 23:07
 * @version 1.0
 */
public class Aggregation {

    /**
     * 数组交集
     *
     * 算法思路：该算法依旧是利用了差分的性质，只不过这次比较隐蔽。
     *          它首先把两数组a和b都进行unique操作，得到两个unique数组，
     *          再将这两个数组拼接在一起，对其排序，得到数组c，如果a和b有交集2，
     *          那么数组c中一定有两个挨着的2，
     *          因此数组c中所有相邻且相等的数值(差分值等于0)都是数组a和b的交集。
     *
     * @param aArray
     * @param bArray
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] intersect(T[] aArray, T[] bArray) {
        if (aArray == null || bArray == null) {
            return null;
        }
        if (aArray.length == 0 || bArray.length == 0) {
            Object[] o = new Object[0];
            return (T[]) o;
        }
        T[] tempA = ArrayUtils.unique(aArray);
        T[] tempB = ArrayUtils.unique(bArray);
        int tempALen = tempA.length;
        int tempBLen = tempB.length;
        int tempMergeLen = tempALen + tempBLen;
        // 可能排除内存溢出错误(OutOfMemoryError)和数组大小为负(NegativeArraySizeException)的异常
        Object[] sortMergeArray = new Object[tempMergeLen];
        System.arraycopy(tempA, 0, sortMergeArray, 0, tempALen);
        System.arraycopy(tempB, 0, sortMergeArray, tempALen, tempBLen);
        Arrays.sort(sortMergeArray);
        int minLenOfTwoArrays = tempALen > tempBLen ? tempBLen : tempALen;
        Object[] minOfTwoArrays = new Object[minLenOfTwoArrays];
        int index = 0;
        for (int i = 1; i < tempMergeLen; i++) {
            if (sortMergeArray[i] == sortMergeArray[i - 1]) {
                minOfTwoArrays[index++] = sortMergeArray[i++];
                // 下一个绝对不等
            }
        }
        return (T[]) Arrays.copyOf(minOfTwoArrays, index);
    }

    /**
     * 数组并集
     *
     * 算法思路：把两个数组拼接起来，所有工作全交由unique处理。
     *
     * @param aArray
     * @param bArray
     * @param <T>
     * @return
     */
    public static <T> T[] union(T[] aArray, T[] bArray) {
        int aLen;
        if (aArray == null || (aLen = aArray.length) == 0) {
            return ArrayUtils.unique(aArray);
        }
        int bLen;
        if (bArray == null || (bLen = bArray.length) == 0) {
            return ArrayUtils.unique(bArray);
        }
        int mergeLen = aLen + bLen;
        // May throw OutOfMemoryError and NegativeArraySizeException
        Object[] mergeArray = new Object[mergeLen];
        System.arraycopy(aArray, 0, mergeArray, 0, aLen);
        System.arraycopy(bArray, 0, mergeArray, aLen, bLen);
        // Call unique to do all the work.
        // 剩下的工作交给数组去重去处理。
        return (T[]) ArrayUtils.unique(mergeArray);
    }

    /**
     * 差集
     *      假设有集合A和B，所有属于A且不属于B的元素的集合被称为A与B的差集。
     *      示例：对于集合A = {a, b, c, d} 和 集合B = {b, c, w}，则A与B的差集为 {a, b}.
     *
     * 算法思路：先将一个数组存储起来，在使用另一个数组进行判断，若有相同的，则删除。
     *
     * @param aArray
     * @param bArray
     * @param <T>
     * @return          返回aArray与bArray的差集
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] except(T[] aArray, T[] bArray) {
        if (aArray == null || bArray == null) {
            return null;
        }
        if (aArray.length == 0 || bArray.length == 0) {
            return (T[]) new Object[0];
        }
        int aLen = aArray.length;
        Object[] tempA = ArrayUtils.unique(aArray);
        Object[] tempB = ArrayUtils.unique(bArray);
        boolean[] diffs = new boolean[aLen];
        outer:
        for (Object o : tempB) {
            for (int i = 0; i < aLen; i++) {
                if (o == tempA[i]) {
                    diffs[i] = true;
                    continue outer;
                }
            }
        }
        Object[] exceptArray = new Object[aLen];
        int index = 0;
        for (int i = 0; i < aLen; i++) {
            if (!diffs[i]) {
                exceptArray[index++] = tempA[i];
            }
        }

        return (T[]) Arrays.copyOf(exceptArray, index);
    }
}
