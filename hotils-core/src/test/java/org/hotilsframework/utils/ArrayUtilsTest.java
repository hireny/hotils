package org.hotilsframework.utils;

import example.model.ArrayModelTest;
import org.hotilsframework.lang.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: ArrayUtilsTest
 * @Author: hireny
 * @Date: Create in 2019/12/19 15:27
 * @Description: TODO   数组工具测试类
 */
public class ArrayUtilsTest {

    @Test
    public void uniqueTest() {
        System.out.println("数组去重方法：");

        String[] arr = {"jslkdfj", "sds", "abc", "dd", "nn", "mm", "abc", "nn", "mm"};
        System.out.println("未去重后的数组:");
        for (String s : arr) {
            System.out.print(s + ", ");
        }
        System.out.println();
        System.out.println("方案一：基本的数组去重法");
        String[] uniqueArr = ArrayUtils.unique(arr);
        System.out.println("去重后的数组:");
        for (String s : uniqueArr) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }

    /**
     * 新键数组
     */
    @Test
    public void newArrayTest() {
        ArrayModelTest[] models = ArrayUtils.newArray(ArrayModelTest.class, 12);
        System.out.println(models);
        System.out.println("数组个数="+models.length);
    }

    @Test
    public void appendTest() {
        Integer[] a = {1,8,3,54,61,901, 235, 85};
        Integer[] b = {2, 6, 989, 32124, 542};
        Integer[] c = ArrayUtils.append(a, 2);
        System.out.println(Arrays.toString(a));
        System.out.println("新数组="+ Arrays.toString(c));
    }

    /**
     * 数组中插入元素
     */
    @Test
    public void insertTest() {
        System.out.println(-9%5 + 5);
        Integer[] a = {1,8,3,54,61,901, 235, 85};
        Integer[] b = {2, 6, 989, 32124, 542};
        Integer[] c = ArrayUtils.insert(a, -9, b);
        System.out.println(Arrays.toString(a));
        System.out.println("新数组="+ Arrays.toString(c));
    }

    @Test
    public void getComponentTypeTest() {
        Integer[] a = {1,8,3,54,61,901, 235, 85};
        System.out.println(ArrayUtils.getComponentType(a.getClass()));
    }
}
