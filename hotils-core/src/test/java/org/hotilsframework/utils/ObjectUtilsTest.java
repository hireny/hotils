package org.hotilsframework.utils;

import example.model.Gender;
import org.hotilsframework.collect.Lists;
import org.hotilsframework.collect.Maps;
import example.model.PersonModel;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * 对象工具类测试
 * @ClassName: ObjectUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-02-08 13:11
 * @Version: 1.0
 */
public class ObjectUtilsTest {

    @Test
    public void unwrapOptionalTest() {
        Optional<Object> op1 = Optional.ofNullable(2);
        System.out.println(ObjectUtils.unwrapOptional(op1));
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

    /**
     * 克隆对象测试
     */
    @Test
    public void cloneTest() throws IOException, ClassNotFoundException {
        PersonModel person1 = new PersonModel();
        person1.setName("小赵");
        person1.setAge(18);
        person1.setSex(Gender.Male);

        PersonModel person2 = ObjectUtils.clone(person1);

        System.out.println(person1 == person2);
        System.out.println(person1.equals(person2));
        System.out.println(person2);
    }
}
