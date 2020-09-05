package org.hotilsframework.utils;

import org.hotilsframework.lang.reflects.ModifierUtils;
import org.hotilsframework.lang.reflects.ReflectionUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 修饰符工具测试类
 * @ClassName: ModifierUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-02-03 22:51
 * @Version: 1.0
 */
public class ModifierUtilsTest {

    @Test
    public void isPublicTest() {
        System.out.println("测试字段 Field：");
        Field field = ReflectionUtils.getField(ModifierTestClass.class, "isSex");
        System.out.println(ModifierUtils.isPublic(field));
        System.out.println(ModifierUtils.isPrivate(field));
        System.out.println(ModifierUtils.isProtected(field));

        System.out.println("测试方法 Method：");
        Method method = ReflectionUtils.getMethod(ModifierTestClass.class, "test3");
        System.out.println(ModifierUtils.isPublic(method));
        System.out.println(ModifierUtils.isProtected(method));
        System.out.println(ModifierUtils.isPrivate(method));

        System.out.println("测试构造器 Constructor：");
        Constructor constructor = ReflectionUtils.getConstructor(ModifierTestClass.class, int.class);
        System.out.println(ModifierUtils.isPublic(constructor));
        System.out.println(ModifierUtils.isProtected(constructor));
        System.out.println(ModifierUtils.isPrivate(constructor));

        System.out.println("测试类 Class：");
        System.out.println(ModifierUtils.isPublic(ModifierTestClass.class));
        System.out.println(ModifierUtils.isProtected(ModifierTestClass.class));
        System.out.println(ModifierUtils.isPrivate(ModifierTestClass.class));

        System.out.println("测试是否是 Static");
        System.out.println(ModifierUtils.isStatic(ModifierTestClass.class));
    }

    @Test
    public void isFinalTest() {
        Field field = ReflectionUtils.getField(ModifierTestClass.class, "username");
        System.out.println(ModifierUtils.isFinal(field));
    }

    public static class ModifierTestClass {
        private int id;
        private String username;
        public String password;
        protected Boolean isSex;

        public ModifierTestClass() {}

        protected ModifierTestClass(String username) {}

        private ModifierTestClass(int id) {}

        public ModifierTestClass(String password, Boolean isSex) {}

        public void test1() {
            System.out.println("test1");
        }

        protected void test2() {
            System.out.println("test2");
        }

        private void test3() {
            System.out.println("test3");
        }
    }
}
