package org.hotilsframework.utils;

import org.junit.Test;

/**
 * 对象工具类测试
 * @ClassName: ObjectUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-02-08 13:11
 * @Version: 1.0
 */
public class ObjectUtilsTest {
    /**
     * 测试对象的类型
     */
    @Test
    public void getClassTest() {
        int a = 2;
        char b = 'b';
        boolean c = true;
        long d = 590892L;
        String e = "12345abc";
        Number f = 12345.5;
        float g = 23493.093f;
        double[] h = {2.1, 230.92, 23984.98};
        System.out.println(ObjectUtils.getClass(a));
        System.out.println(ObjectUtils.getClass(b));
        System.out.println(ObjectUtils.getClass(c));
        System.out.println(ObjectUtils.getClass(d));
        System.out.println(ObjectUtils.getClass(e));
        System.out.println(ObjectUtils.getClass(f));
        System.out.println(ObjectUtils.getClass(g));
        System.out.println(ObjectUtils.getClass(h));
        System.out.println(int.class);
    }

    /**
     * 相等方法测试
     */
    @Test
    public void equalsTest() {
        System.out.println("判断 null 与 null 是否相等");
        System.out.println(ObjectUtils.equals(null, null));
        System.out.println("判断 null 与 \"\" 是否相等");
        System.out.println(ObjectUtils.equals(null, ""));
        System.out.println("判断 \"\" 与 \"\" 是否相等");
        System.out.println(ObjectUtils.equals("", ""));
        System.out.println("判断 \"任何\" 与 \"任何\" 是否相等");
        System.out.println(ObjectUtils.equals("任何", "任何"));
        System.out.println("判断 new String(\"任何\") 与 new String(\"任何\") 是否相等");
        System.out.println(ObjectUtils.equals(new String("任何"), new String("任何")));
        System.out.println("判断 Boolean.TRUE 与 null 是否相等");
        System.out.println(ObjectUtils.equals(Boolean.TRUE, null));
        System.out.println("判断 Boolean.TRUE 与 \"true\" 是否相等");
        System.out.println(ObjectUtils.equals(Boolean.TRUE, "true"));
        System.out.println("判断 Boolean.TRUE 与 true 是否相等");
        System.out.println(ObjectUtils.equals(Boolean.TRUE, true));
        System.out.println("判断 new int[]{1, 2, 3, 4} 与 new int[]{1, 2, 3, 4} 是否相等");
        System.out.println(ObjectUtils.equals(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
        System.out.println("判断 new double[]{1.2, 1.324, 98.1023} 与 new double[]{1.2, 98.1023, 1.324}");
        System.out.println(ObjectUtils.equals(new double[]{1.2, 1.324, 98.1023}, new double[]{1.2, 1.324, 98.1023}));
        System.out.println("判断 new double[]{1.2, 1.324, 98.1023} 与 new float[]{1.2f, 98.1023f, 1.324f}");
        System.out.println(ObjectUtils.equals(new double[]{1.2, 1.324, 98.1023}, new float[]{1.2f, 1.324f, 98.1023f}));
    }
}
