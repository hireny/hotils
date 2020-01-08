package me.hireny.commons.algos.sort;

import org.hayros.commons.algos.sort.BubbleSort;
import org.hayros.commons.algos.sort.Sort;

/**
 * @ClassName: BulleSortTest
 * @Author: hireny
 * @Date: Create in 2019/12/20 15:24
 * @Description: TODO   冒泡排序测试
 */
public class BulleSortTest {

    public static void main(String[] args) {
        // 测试冒泡排序
        Integer[] test = new Integer[]{3,8,23,93,10, 2, 99, 21};
        Sort sort = new BubbleSort();
        sort.sort(test);
        System.out.println("排序后的数组：");
        for (Integer integer : test) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }
}
