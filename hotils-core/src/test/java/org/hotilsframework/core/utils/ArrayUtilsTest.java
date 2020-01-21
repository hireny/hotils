package org.hotilsframework.core.utils;

import org.hotilsframework.utils.ArrayUtils;
import org.junit.Test;

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
}
