package org.hotilsframework.utils;

import example.model.Gender;
import example.model.PersonModel;
import example.reflect.ExtandsReflectExample;
import example.reflect.ReflectExample;
import org.hotilsframework.core.reflects.Instantiator;
import org.hotilsframework.lang.ReflectionUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
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
        model.setSex(Gender.Female);
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
        model.setSex(Gender.Male);
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
        model.setSex(Gender.Female);
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
        model.setSex(Gender.Unknown);
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

    // 使用反射获取构造方法

    /**
     * 获取构造方法
     */
    @Test
    public void getConstructorTest() {
        Constructor<?> constructor1 = ReflectionUtils.getConstructor(ReflectExample.class);
        System.out.println("获取到的构造方法=" + constructor1);
        Constructor<?> constructor2 = ReflectionUtils.getConstructor(ReflectExample.class, Integer.class);
        System.out.println("获取到的构造方法="+ constructor2);
        Constructor<?> constructor3 = ReflectionUtils.getConstructor(
                ReflectExample.class, int.class, Object.class, Double.class, char.class, String.class);
        System.out.println("获取到的构造方法=" + constructor3);
    }

    /**
     * 获取所有构造方法
     */
    @Test
    public void getConstructorsTest() {
        Constructor<?>[] constructors = ReflectionUtils.getConstructors(ReflectExample.class);
        System.out.println("获取到的所有构造方法：");
        System.out.println(Arrays.toString(constructors));
        System.out.println("获取到的构造方法的数量="+constructors.length);
    }

    // 使用反射设置方法

    @Test
    public void getMethodTest() {
        Method method = ReflectionUtils.getMethod(ReflectExample.class, "methodInterface2");
        System.out.println(method);
    }

    /**
     * 获取方法测试
     */
    @Test
    public void getMethodWithParamsTest() {
        Method method = ReflectionUtils.getMethod(ReflectExample.class, "methodInterface", String.class, String.class, String[].class);
        System.out.println(method);
    }

    /**
     * 获取静态方法
     */
    @Test
    public void getStaticMethodTest() {
        Method method = ReflectionUtils.getMethod(ReflectExample.class, "getStaticIntField");
        System.out.println(method);
    }

    @Test
    public void getMethodsTest() {
        Method[] allMethods = ReflectionUtils.getMethods(ExtandsReflectExample.class);
        System.out.println("获取的当前类中的所有方法（包括父类）：");
        for (Method method : allMethods) {
            System.out.println(method);
        }
        System.out.println("方法数量：" + allMethods.length);
    }

    /**
     * 获取当前类中所有方法
     */
    @Test
    public void getCurrentMethodsTest() {
        Method[] currentMethods = ReflectionUtils.getMethods(ExtandsReflectExample.class, false);
        System.out.println("获取的当前类中的所有方法：" + Arrays.toString(currentMethods));
    }

    /**
     * 执行静态方法测试
     */
    @Test
    public void invokeStaticMethodTest() {
        Object staticMethodValue1 = ReflectionUtils.invoke(null, ReflectionUtils.getMethod(ReflectExample.class, "getStaticIntField"));
        System.out.println("执行静态方法：getStaticIntField()");
        System.out.println(staticMethodValue1);

        Object staticMethodValue2 = ReflectionUtils.invoke(null, ReflectionUtils.getMethod(ReflectExample.class, "staticReflectMethod", String.class), "小王");
        System.out.println("执行静态方法：staticReflectMethod(String name)");
        System.out.println(staticMethodValue2);
    }

    /**
     * 执行方法测试
     */
    @Test
    public void invokeMethodTest() {

        ReflectExample example = new ReflectExample(2, new Object(), 3.1415926, 'c', "reflect string");
        try {
            System.out.println("执行无参数方法：reflectMethod2");
            Object methodValue1 = ReflectionUtils.invoke(example, "reflectMethod2");
            System.out.println(methodValue1);

            System.out.println("执行方法：reflectMethod2");
            Object methodValue2 = ReflectionUtils.invoke(example, ReflectionUtils.getMethod(ReflectExample.class, "reflectMethod2", String.class), "小王");
            System.out.println(methodValue2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // 判断方法是否是 equals

    @Test
    public void isEqualsTest() {
        boolean isEquals = ReflectionUtils.isEqualsMethod(ReflectionUtils.getMethod(ReflectExample.class, "equals", Object.class));
        System.out.println(isEquals);
        boolean isEquals2 = ReflectionUtils.isEqualsMethod(ReflectionUtils.getMethod(ReflectExample.class, "getStaticIntField"));
        System.out.println(isEquals2);
    }


    // 判断方法是否是 hashCode

    @Test
    public void isHashCodeTest() {
        boolean isHashCode = ReflectionUtils.isHashCodeMethod(ReflectionUtils.getMethod(ReflectExample.class, "hashCode"));
        System.out.println(isHashCode);
        boolean isHashCode2 = ReflectionUtils.isHashCodeMethod(ReflectionUtils.getMethod(ReflectExample.class, "getStaticIntField"));
        System.out.println(isHashCode2);
    }

    // 实例化操作

    /**
     * 实例化
     */
    @Test
    public void newInstanceTest() {
        ReflectExample example1 = Instantiator.tryInstance(ReflectExample.class);
        System.out.println(example1);

        ReflectExample example2 = Instantiator.tryInstance(ReflectExample.class);
        System.out.println(example2);

        ReflectExample example3 = Instantiator.tryInstance(ReflectExample.class);
        System.out.println(example3);

        ReflectExample example4 = Instantiator.tryInstance(ReflectExample.class);
        System.out.println(example4);

        ReflectExample example5 = Instantiator.tryInstance(ReflectExample.class);
        System.out.println(example5);
    }

    /**
     * 实例化带参数的类
     */
    @Test
    public void newInstanceWithParametersTest() {
        ReflectExample example1 = Instantiator.tryInstance(ReflectExample.class, 1);
        System.out.println(example1);

        ReflectExample example2 = Instantiator.tryInstance(ReflectExample.class, 1, new Object(), 3.1314, 'c', "string");
        System.out.println(example2);

        ReflectExample example3 = Instantiator.tryInstance(ReflectExample.class, 1);
        System.out.println(example3);

        ReflectExample example4 = Instantiator.tryInstance(ReflectExample.class, 1, new Object(), 3.1314, 'c', "string");
        System.out.println(example4);

        ReflectExample example5 = Instantiator.tryInstance(ReflectExample.class, 1);
        System.out.println(example5);
    }

    /**
     * 尝试遍历并调用此类的所有构造方法测试
     */
    @Test
    public void newInstanceIfPossibleTest() {
        ReflectExample e1 = Instantiator.tryInstanceIfPossible(ReflectExample.class);

        System.out.println(e1);
    }
}
