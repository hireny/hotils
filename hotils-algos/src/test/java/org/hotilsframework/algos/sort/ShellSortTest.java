package org.hotilsframework.algos.sort;

/**
 * @ClassName: ShellSortTest
 * @Author: hireny
 * @Date: Created in 2020-01-21 8:57
 * @Version: 1.0
 */
public class ShellSortTest {

    public static void main(String[] args) {
        // 测试冒泡排序
        Integer[] test = new Integer[]{3,8,23,93,10, 2, 99, 21};
        Sort sort = new ShellSort();
        sort.sort(test);
        System.out.println("排序后的数组：");
        for (Integer integer : test) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }
}
