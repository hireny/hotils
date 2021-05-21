package org.hotilsframework.math;

import org.hotilsframework.collect.ListUtils;
import org.hotilsframework.lang.Assert;

import java.util.Stack;

/**
 * 进制转换工具
 * @author hireny
 * @className GenericBinarys
 * @create 2020-02-21 22:16
 */
public class GenericBinarys {

    /**
     * 将十进制转为任意进制
     * @param num       待转化的数字
     * @param dest      目标进制
     * @return          转化后的数字表示
     */
    public static String transfrom(int num, int dest) {
        Assert.checkState(dest <= 16, "Transform out of range, base<= 16");

        StringBuilder stringBuilder = new StringBuilder();
        String digths = "0123456789ABCDEF";
        Stack<Character> stack = ListUtils.newStack();
        while (num != 0) {
            stack.push(digths.charAt(num % dest));
            num /= dest;
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    /**
     * 十六进制内任意进制转换
     * @param num       待转换的数字
     * @param src       原进制
     * @param dest      目标进制
     * @return          转化后的数字表示
     */
    public static String transfrom(String num, int src, int dest) {
        Assert.notBlank(num, "Number must not be null");

        if (src == dest) {
            return num;
        }

        String digths = "0123456789ABCDEF";
        char[] chars = num.toCharArray();
        int len = chars.length;
        if (dest != 10) {
            // 目标进制不是十进制，先转换为十进制
            num = transfrom(num, src, 10);
        } else {
            int n = 0;
            for (int i = len - 1; i>= 0; i--) {
                n += digths.indexOf(chars[i]) * Math.pow(src, len - i - 1);
            }
            return n + "";
        }

        return transfrom(Integer.valueOf(num), dest);
    }
}
