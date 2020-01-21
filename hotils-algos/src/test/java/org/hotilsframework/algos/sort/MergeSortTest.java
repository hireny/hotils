package org.hotilsframework.algos.sort;

/**
 * @ClassName: MergeSortTest
 * @Author: hireny
 * @Date: Created in 2020-01-21 14:15
 * @Version: 1.0
 */
public class MergeSortTest {
    public static void main(String[] args) {
        // 自顶向下的归并排序
// 测试冒泡排序
        Integer[] test = new Integer[]{3,8,23,93,10, 2, 99, 21};
        Sort sort = new MergeSort();
        sort.sort(test);
        System.out.println("排序后的数组：");
        for (Integer integer : test) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }
}
