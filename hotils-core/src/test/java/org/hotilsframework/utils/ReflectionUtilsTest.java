package org.hotilsframework.utils;

import example.model.UserTestClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName: ReflectUtilsTest
 * @Description: TODO   反射工具测试类
 * @Author: hireny
 * @Date: Created in 2020-01-08 9:11
 * @Version: 1.0
 */
public class ReflectionUtilsTest {

    /**
     * 获取属性测试
     */
    @Test
    public void findFieldTest() {
        Field usernameField = ReflectionUtils.findField(UserTestClass.class, "username");
        System.out.println(usernameField);
    }

    /**
     * 获取成员属性值
     */
    @Test
    public void findFieldValueTest() {
        UserTestClass user = new UserTestClass();
        user.setUsername("小年");
        Object fieldValue = ReflectionUtils.findFieldValue(user, "username");
        System.out.println(fieldValue);
    }

    /**
     * 获取类静态属性值
     */
    @Test
    public void findStaticFieldValueTest() {
        Object fieldValue = ReflectionUtils.findFieldValue(UserTestClass.class, "staticUsername");
        System.out.println(fieldValue);
    }

    /**
     * 设置属性值
     */
    @Test
    public void setFieldValueTest() {
        UserTestClass user = new UserTestClass();
        System.out.println(user);
        ReflectionUtils.setFieldValue(user, "username", "小柜子");
        System.out.println(user);
    }

    /**
     * 设置静态属性值
     */
    @Test
    public void setStaticFieldValueTest() {
        Object fieldValue = ReflectionUtils.findFieldValue(UserTestClass.class, "staticUsername");
        System.out.println(fieldValue);
        ReflectionUtils.setFieldValue(UserTestClass.class, "staticUsername", "小林子");
        fieldValue = ReflectionUtils.findFieldValue(UserTestClass.class, "staticUsername");
        System.out.println(fieldValue);
    }

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
