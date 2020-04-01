package org.hotilsframework.utils;

import example.model.PersonModel;
import example.model.UserTestClass;
import example.reflect.ExtandsReflectExample;
import example.reflect.ReflectExample;
import org.hotilsframework.lang.enums.Sex;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName: ReflectUtilsTest
 * @Description: TODO   反射工具测试类
 * @Author: hireny
 * @Date: Created in 2020-01-08 9:11
 * @Version: 1.0
 */
public class ReflectionUtilsTest {

    // 使用反射设置字段

    /**
     * 获取属性测试
     */
    @Test
    public void getFieldWithTwoParametersTest() {
        Field field = ReflectionUtils.getField(ReflectExample.class, "doubleField");
        System.out.println(field);
    }

    /**
     * 获取字段测试
     */
    @Test
    public void getFieldWithThreeParametersTest() {
        Field field = ReflectionUtils.getField(ReflectExample.class, "intField", int.class);
        System.out.println(field);
    }

    /**
     * 获取所有字段（包括父类）
     */
    @Test
    public void getFieldsTest() {
        Field[] allFields = ReflectionUtils.getFields(ExtandsReflectExample.class);
        System.out.println(Arrays.toString(allFields));
        System.out.println("数组长度：" + allFields.length);
    }

    /**
     * 获取当前所有字段
     */
    @Test
    public void getCurrentFieldsTest() {
        Field[] currentFields = ReflectionUtils.getFields(ReflectExample.class, false);
        System.out.println(Arrays.toString(currentFields));
        System.out.println("数组长度：" + currentFields.length);
    }

    /**
     * 获取类静态属性值
     */
    @Test
    public void getStaticFieldValueTest() {
        Object fieldValue1 = ReflectionUtils.getFieldValue(ReflectExample.class, "staticIntField");
        System.out.println("字段值=" + fieldValue1 + ", 字段类型=" + fieldValue1.getClass());
        Object fieldValue2 = ReflectionUtils.getFieldValue(ReflectExample.class, ReflectionUtils.getField(ReflectExample.class, "staticDoubleField"));
        System.out.println("字段值=" + fieldValue2 + ", 字段类型=" + fieldValue2.getClass());
    }

    /**
     * 获取属性值，参数是字段名称
     */
    @Test
    public void getFieldValueWithFieldNameTest() {
        PersonModel model = new PersonModel();
        model.setName("小静");
        model.setAge(18);
        model.setSex(Sex.Female);
        Object fieldValue1 = ReflectionUtils.getFieldValue(model, "name");
        System.out.println("字段值=" + fieldValue1 + ", 字段类型=" + fieldValue1.getClass());
        Object fieldValue2 = ReflectionUtils.getFieldValue(model, "age");
        System.out.println("字段值=" + fieldValue2 + ", 字段类型=" + fieldValue2.getClass());
        Object fieldValue3 = ReflectionUtils.getFieldValue(model, "sex");
        System.out.println("字段值=" + fieldValue3 + ", 字段类型=" + fieldValue3.getClass());
    }

    /**
     * 获取属性值，参数是字段
     */
    @Test
    public void getFieldValueWithFieldTest() {
        PersonModel model = new PersonModel();
        model.setName("小黄");
        model.setAge(23);
        model.setSex(Sex.Male);
        Object fieldValue1 = ReflectionUtils.getFieldValue(model, ReflectionUtils.getField(model.getClass(), "name"));
        System.out.println("字段值=" + fieldValue1 + ", 字段类型=" + fieldValue1.getClass());
        Object fieldValue2 = ReflectionUtils.getFieldValue(model, ReflectionUtils.getField(model.getClass(), "age"));
        System.out.println("字段值=" + fieldValue2 + ", 字段类型=" + fieldValue2.getClass());
        Object fieldValue3 = ReflectionUtils.getFieldValue(model, ReflectionUtils.getField(model.getClass(), "sex"));
        System.out.println("字段值=" + fieldValue3 + ", 字段类型=" + fieldValue3.getClass());
    }

    /**
     * 设置属性值，参数为字段
     */
    @Test
    public void setFieldValueWithFieldTest() {
        PersonModel model = new PersonModel();
        model.setName("小安");
        model.setAge(30);
        model.setSex(Sex.Female);
        System.out.println("修改前的对象内容=" + model.toString());
        ReflectionUtils.setFieldValue(model, ReflectionUtils.getField(model.getClass(), "name"), "小安2号");
        System.out.println("修改后的对象内容=" + model.toString());
    }

    /**
     * 设置属性值，参数为字段名称
     */
    @Test
    public void setFieldValueWithFieldNameTest() {
        PersonModel model = new PersonModel();
        model.setName("小刘");
        model.setAge(30);
        model.setSex(Sex.Other);
        System.out.println("修改前的对象内容=" + model.toString());
        ReflectionUtils.setFieldValue(model, "name", "小刘2号");
        System.out.println("修改后的对象=" + model.toString());
    }

    /**
     * 设置静态属性值
     */
    @Test
    public void setStaticFieldValueTest() {
        System.out.println("修改前的内容=" + ReflectExample.staticDoubleField);
        ReflectionUtils.setFieldValue(ReflectExample.class, "staticDoubleField", 3.12345);
        System.out.println("修改后的内容=" + ReflectExample.staticDoubleField);


        System.out.println("修改前的内容=" + ReflectExample.getStaticIntField());
        ReflectionUtils.setFieldValue(ReflectExample.class, "staticIntField", 5);
        System.out.println("修改后的内容=" + ReflectExample.getStaticIntField());
    }

    // 使用反射设置构造方法


    // 使用反射设置方法

    @Test
    public void findMethodTest() {
        Method method = ReflectionUtils.findMethod(UserTestClass.class, "methodTest2");
        System.out.println(method);
    }

    /**
     * 获取方法测试
     */
    @Test
    public void findMethodWithParamsTest() {
        Method method = ReflectionUtils.findMethod(UserTestClass.class, "methodTest", String.class, String.class);
        System.out.println(method);
    }

    /**
     * 执行方法测试
     */
    @Test
    public void invokeMethodTest() {
        Object methodValue = ReflectionUtils.invokeMethod(new UserTestClass(), "methodTest", "小华", "小华的年龄：23");
        System.out.println(methodValue);

        methodValue = ReflectionUtils.invokeMethod(new UserTestClass(), "methodTest1", "小华", "小华的年龄：23");
        System.out.println(methodValue);
    }

    /**
     * 执行静态方法测试
     */
    @Test
    public void invokeStaticMethodTest() {
        Object staticMethodValue = ReflectionUtils.invokeMethod(UserTestClass.class, "staticMethodTest", "小静态", "小静态的年龄：22");
        System.out.println(staticMethodValue);
    }
}
