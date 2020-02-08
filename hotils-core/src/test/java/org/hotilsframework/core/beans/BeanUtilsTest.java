package org.hotilsframework.core.beans;

import org.hotilsframework.core.beans.copier.CopyOptions;
import org.hotilsframework.core.collection.Maps;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @ClassName: BeanUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-01-31 13:43
 * @Version: 1.0
 */
public class BeanUtilsTest {

    /**
     * 测试 获取属性描述数组
     */
    @Test
    public void getPropertyDescriptorsTest() {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(JavaBean3.class);
        System.out.println(Arrays.toString(propertyDescriptors));
    }

    //============================================
    // 测试 copyProperties 的 Bean To Bean
    //============================================

    /**
     * 测试 复制属性
     * @throws IntrospectionException
     */
    @Test
    public void copyPropertiesTest1() {

        JavaBean1 javaBean1 = new JavaBean1();
        javaBean1.setId(1);
        javaBean1.setUsername("我是小沈阳");
        javaBean1.setPassword("123456");
        javaBean1.setSex(true);
        JavaBean2 javaBean2 = new JavaBean2();
        BeanUtils.copyProperties(javaBean1, javaBean2);
        System.out.println("Java Bean 1 = " + javaBean1);
        System.out.println("Java Bean 2 = " + javaBean2);
    }

    @Test
    public void copyPropertiesTest2() {
        JavaBean1 javaBean1 = new JavaBean1();
        javaBean1.setId(1);
        javaBean1.setUsername("我是小沈阳");
        javaBean1.setPassword("123456");
        javaBean1.setSex(true);
        JavaBean2 javaBean2 = new JavaBean2();
        BeanUtils.copyProperties(javaBean1, javaBean2, "password", "id");
        System.out.println("Java Bean 1 = " + javaBean1);
        System.out.println("Java Bean 2 = " + javaBean2);
    }

    @Test
    public void copyPropertiesTest3() {
        JavaBean1 javaBean1 = new JavaBean1();
        javaBean1.setId(1);
        javaBean1.setUsername("我是小沈阳");
        javaBean1.setPassword("123456");
        javaBean1.setSex(true);
        JavaBean3 javaBean2 = new JavaBean3();
        BeanUtils.copyProperties(javaBean1, javaBean2, CopyOptions.create(JavaBean3.class, "password"));
        System.out.println("Java Bean 1 = " + javaBean1);
        System.out.println("Java Bean 2 = " + javaBean2);
    }

    //============================================
    // 测试 copyProperties 的 Bean To Map
    //============================================

    @Test
    public void copyPropertiesTest4() {

        JavaBean1 javaBean1 = new JavaBean1();
        javaBean1.setId(1);
        javaBean1.setUsername("我是小沈阳");
        javaBean1.setPassword("123456");
        javaBean1.setSex(true);
        Map<String, Object> map = Maps.newHashMap();
        BeanUtils.copyProperties(javaBean1, map);
        System.out.println("Java Bean 1 = " + javaBean1);
        System.out.println("Map 2 = " + map.toString());
    }

    @Test
    public void copyPropertiesTest5() {
        JavaBean1 javaBean1 = new JavaBean1();
        javaBean1.setId(1);
        javaBean1.setUsername("我是小沈阳");
        javaBean1.setPassword("123456");
        javaBean1.setSex(true);
        Map<String, Object> map = Maps.newHashMap();
        BeanUtils.copyProperties(javaBean1, map, "password", "id");
        System.out.println("Java Bean 1 = " + javaBean1);
        System.out.println("Map 2 = " + map.toString());
    }

    @Test
    public void copyPropertiesTest6() {
        JavaBean1 javaBean1 = new JavaBean1();
        javaBean1.setId(1);
        javaBean1.setUsername("我是小沈阳");
        javaBean1.setPassword("123456");
        javaBean1.setSex(true);
        Map<String, Object> map = Maps.newHashMap();
        BeanUtils.copyProperties(javaBean1, map, CopyOptions.create(JavaBean3.class, "password"));
        System.out.println("Java Bean 1 = " + javaBean1);
        System.out.println("Map 2 = " + map.toString());
    }

    //============================================
    // 测试 copyProperties 的 Map To Bean
    //============================================

    @Test
    public void copyPropertiesTest7() {

        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1);
        map.put("username", "我是笑声杨");
        map.put("password", "123456");
        map.put("sex", true);
        map.put("age", 123);
        JavaBean1 javaBean1 = new JavaBean1();

        BeanUtils.copyProperties(map, javaBean1);
        System.out.println("Map  = " + map.toString());
        System.out.println("Java Bean 1 = " + javaBean1);

    }

    @Test
    public void copyPropertiesTest8() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1);
        map.put("username", "我是笑声杨");
        map.put("password", "123456");
        map.put("sex", true);
        map.put("age", 123);
        JavaBean1 javaBean1 = new JavaBean1();

        BeanUtils.copyProperties(map, javaBean1, "password", "id");
        System.out.println("Map  = " + map.toString());
        System.out.println("Java Bean 1 = " + javaBean1);

    }

    @Test
    public void copyPropertiesTest9() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1);
        map.put("username", "我是笑声杨");
        map.put("password", "123456");
        map.put("sex", true);
        map.put("age", 123);
        JavaBean1 javaBean1 = new JavaBean1();

        BeanUtils.copyProperties(map, javaBean1, CopyOptions.create(JavaBean1.class, "id", "sex"));
        System.out.println("Map  = " + map.toString());
        System.out.println("Java Bean 1 = " + javaBean1);
    }

    //============================================
    // 测试 copyProperties 的 Map To Map
    //============================================

    @Test
    public void copyPropertiesTest10() {

        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1);
        map.put("username", "我是笑声杨");
        map.put("password", "123456");
        map.put("sex", true);
        map.put("age", 123);
        Map<String, Object> copyMap = Maps.newHashMap();

        BeanUtils.copyProperties(map, copyMap);
        System.out.println("Map  = " + map.toString());
        System.out.println("Copy Map = " + copyMap.toString());
        System.out.println(map.hashCode() == copyMap.hashCode());

    }

    @Test
    public void copyPropertiesTest11() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1);
        map.put("username", "我是笑声杨");
        map.put("password", "123456");
        map.put("sex", true);
        map.put("age", 123);
        Map<String, Object> copyMap = Maps.newHashMap();

        BeanUtils.copyProperties(map, copyMap, "id", "sex");
        System.out.println("Map  = " + map.toString());
        System.out.println("Copy Map = " + copyMap.toString());
        System.out.println(map.hashCode() == copyMap.hashCode());

    }

    @Test
    public void copyPropertiesTest12() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1);
        map.put("username", "我是笑声杨");
        map.put("password", "123456");
        map.put("sex", true);
        map.put("age", 123);
        Map<String, Object> copyMap = Maps.newHashMap();

        BeanUtils.copyProperties(map, copyMap, CopyOptions.create(Map.class, "username", "age"));
        System.out.println("Map  = " + map.toString());
        System.out.println("Copy Map = " + copyMap.toString());
        System.out.println(map.hashCode() == copyMap.hashCode());
    }


    //============================================
    // 测试 beanToMap 方法
    //============================================

    @Test
    public void beanToMapTest() {
        JavaBean1 javaBean1 = new JavaBean1();
        javaBean1.setId(1);
        javaBean1.setUsername("我是小沈阳");
        javaBean1.setPassword("123456");
        javaBean1.setSex(true);
        Map<String, Object> map = Maps.newHashMap();
        BeanUtils.beanToMap(javaBean1, map);
        System.out.println("Java Bean 1 = " + javaBean1);
        System.out.println("Map = " + map.toString());
    }

    //============================================
    // 测试 mapToBean 方法
    //============================================

    @Test
    public void mapToBeanTest() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1);
        map.put("username", "我是笑声杨");
        map.put("password", "123456");
        map.put("sex", true);
        map.put("age", 23L);
        JavaBean2 javaBean1 = new JavaBean2();
        BeanUtils.mapToBean(map, javaBean1);
        System.out.println("Map = " + map.toString());
        System.out.println("Java Bean 1 = " + javaBean1.toString());
    }

    public static class JB {
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

    public static class JavaBean1 {
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
            return new StringJoiner(", ", JavaBean1.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("username='" + username + "'")
                    .add("password='" + password + "'")
                    .add("sex=" + sex)
                    .toString();
        }
    }

    public static class JavaBean2 {
        private Integer id;
        private String username;
        private String password;
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

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", JavaBean2.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("username='" + username + "'")
                    .add("password='" + password + "'")
                    .add("sex=" + sex)
                    .add("age=" + age)
                    .toString();
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
            return new StringJoiner(", ", JavaBean3.class.getSimpleName() + "[", "]")
                    .add("id=" + super.id)
                    .add("username='" + super.username + "'")
                    .add("password='" + super.password + "'")
                    .add("sex=" + super.sex)
                    .add("objects=" + Arrays.toString(objects))
                    .toString();
        }
    }
}
