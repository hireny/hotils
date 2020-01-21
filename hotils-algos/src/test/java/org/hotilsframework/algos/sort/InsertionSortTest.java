package org.hotilsframework.algos.sort;

/**
 * 插入排序测试
 * @ClassName: InsertionSortTest
 * @Author: hireny
 * @Date: Created in 2020-01-19 19:42
 * @Version: 1.0
 */
public class InsertionSortTest {
    public static void main(String[] args) {
        // 测试冒泡排序
        Integer[] test = new Integer[]{3,8,23,93,10, 2, 99, 21};
        Sort sort = new InsertionSort();
        sort.sort(test);
        System.out.println("排序后的数组：");
        for (Integer integer : test) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }
}
