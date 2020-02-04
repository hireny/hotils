package org.hotilsframework.core.beans;

import org.hotilsframework.beans.BeanUtils;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName: BeanUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-01-31 13:43
 * @Version: 1.0
 */
public class BeanUtilsTest {

    @Test
    public void copyPropertiesTest1() throws InvocationTargetException, IllegalAccessException, IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(JavaBean3.class);
        System.out.println(beanInfo.getPropertyDescriptors().length);
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            System.out.println(descriptor.getPropertyType());
        }

        JavaBean1 javaBean1 = new JavaBean1();
        javaBean1.setId(1);
        javaBean1.setUsername("我是小沈阳");
        javaBean1.setPassword("123456");
        javaBean1.setSex(true);
        JavaBean2 javaBean2 = new JavaBean2();
        BeanUtils.copyProperties(javaBean1, javaBean2);
        System.out.println("Java Bean 1 = " + javaBean1);
        System.out.println("Java Bean 2 = " + javaBean2);

        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(JB.class);
        for (PropertyDescriptor pd : propertyDescriptors) {
            System.out.println(pd);
        }
        System.out.println("写完后：");
        System.out.println("Java Bean 1 = " + javaBean1);
    }

    class JB {
        private Integer id;
        private String username;
        private String password;
        private Boolean sex;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    class JavaBean1 {
        private Integer id;
        private String username;
        private String password;
        private Boolean sex;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Boolean getSex() {
            return sex;
        }

        public void setSex(Boolean sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "JavaBean1{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", sex=" + sex +
                    '}';
        }
    }

    class JavaBean2 {
        private Integer id;
        private String username;
        private Boolean sex;
        private Long age;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Boolean getSex() {
            return sex;
        }

        public void setSex(Boolean sex) {
            this.sex = sex;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "JavaBean2{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", sex=" + sex +
                    ", age=" + age +
                    '}';
        }
    }

    class JavaBean3 extends JavaBean1 {
        private Object[] objects;

        public Object[] getObjects() {
            return objects;
        }

        public void setObjects(Object[] objects) {
            this.objects = objects;
        }

        @Override
        public String toString() {
            return "JavaBean3{" +
                    "objects=" + Arrays.toString(objects) +
                    '}';
        }
    }
}
