package org.hotilsframework.core.beans;

import org.hotilsframework.core.collection.Lists;
import org.hotilsframework.core.collection.Maps;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Bean与Map互转测试
 * @ClassName: BeanMapTest
 * @Author: hireny
 * @Date: Created in 2020-02-06 21:55
 * @Version: 1.0
 */
public class BeanMapTest {

    @Test
    public void beanToMapTest() {
        BeanMapTestClass beanTest = new BeanMapTestClass();
        beanTest.setId(1);
        beanTest.setUsername("小明");
        beanTest.setPassword("123456".getBytes());
        beanTest.setSex(false);
        beanTest.setAge(24);
        beanTest.setAddress(new String[]{"新源县", "新乡县", "新安县"});
        beanTest.setCreateTime(new Date());
        beanTest.setModifiedTime(LocalDateTime.now());
        beanTest.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        beanTest.setFriends(Lists.newArrayList("小张", "小赵", "小钱", "小孙", "小李"));
        BeanMap beanMap = BeanMap.create(beanTest);
        System.out.println("获取封装的bean：");
        System.out.println(beanMap.toBean());
        System.out.println("获取键值对：");
        System.out.println(beanMap.entrySets().toString());
        System.out.println("获取Map：");
        System.out.println(beanMap.toMap().toString());
        System.out.println("获取键：");
        System.out.println(beanMap.keySets().toString());
        System.out.println("获取值：");
        System.out.println(beanMap.values().toString());

        Map<String, Object> mapTest = Maps.newHashMap();
        mapTest.put("id", 2);
        mapTest.put("username", "肖玲玲");
        mapTest.put("password", "123456".getBytes());
        mapTest.put("sex", true);
        mapTest.put("age", 12);
        mapTest.put("createTime", new Date());
        mapTest.put("modifiedTime", LocalDateTime.now());
        mapTest.put("updateTime", new Timestamp(System.currentTimeMillis()));
        mapTest.put("address", new String[]{"小街道", "大街道", "中街道"});
        mapTest.put("friends", Lists.newArrayList("小龙", "小凤", "小虎", "小玄武", "小麒麟"));


        BeanMap beanMap1 = BeanMap.create(mapTest, BeanMapTestClass.class);
        System.out.println("获取另一个Map：");
        System.out.println(beanMap1.toBean().toString());

        Map<String, Object> mapTest2 = Maps.newHashMap();
        mapTest2.put("id", 2);
        mapTest2.put("username", "肖玲玲");
        mapTest2.put("password", "123456".getBytes());
        mapTest2.put("sex", true);
        mapTest2.put("age", 12);
        mapTest2.put("createTime", new Date());
        mapTest2.put("modifiedTime", LocalDateTime.now());
        mapTest2.put("updateTime", new Timestamp(System.currentTimeMillis()));
        mapTest2.put("address", new String[]{"小街道", "大街道", "中街道"});
        mapTest2.put("friends", Lists.newArrayList("小龙", "小凤", "小虎", "小玄武", "小麒麟"));

        BeanMapTestClass beanMapTestClass2 = new BeanMapTestClass();
        System.out.println("赋值之前=");
        System.out.println(beanMapTestClass2.toString());
        BeanMap beanMap2 = BeanMap.create(mapTest, beanMapTestClass2);
        System.out.println("获取第二个Map：");
        System.out.println(beanMap2.toBean().toString());
        System.out.println("获取BeanMapTestClass的对象：");
        System.out.println("赋值之后=");
        System.out.println(beanMapTestClass2.toString());
    }

    public static class BeanMapTestClass {

        private int id;
        private String username;
        private byte[] password;
        private Boolean sex;
        private Integer age;
        private Date createTime;
        private LocalDateTime modifiedTime;
        private Timestamp updateTime;
        private String[] address;
        private List<Object> friends;

        public BeanMapTestClass() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public byte[] getPassword() {
            return password;
        }

        public void setPassword(byte[] password) {
            this.password = password;
        }

        public Boolean getSex() {
            return sex;
        }

        public void setSex(Boolean sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public LocalDateTime getModifiedTime() {
            return modifiedTime;
        }

        public void setModifiedTime(LocalDateTime modifiedTime) {
            this.modifiedTime = modifiedTime;
        }

        public Timestamp getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Timestamp updateTime) {
            this.updateTime = updateTime;
        }

        public String[] getAddress() {
            return address;
        }

        public void setAddress(String[] address) {
            this.address = address;
        }

        public List<Object> getFriends() {
            return friends;
        }

        public void setFriends(List<Object> friends) {
            this.friends = friends;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BeanMapTestClass that = (BeanMapTestClass) o;

            if (id != that.id) return false;
            if (username != null ? !username.equals(that.username) : that.username != null) return false;
            if (!Arrays.equals(password, that.password)) return false;
            if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
            if (age != null ? !age.equals(that.age) : that.age != null) return false;
            if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
            if (modifiedTime != null ? !modifiedTime.equals(that.modifiedTime) : that.modifiedTime != null)
                return false;
            if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            if (!Arrays.equals(address, that.address)) return false;
            return friends != null ? friends.equals(that.friends) : that.friends == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (username != null ? username.hashCode() : 0);
            result = 31 * result + Arrays.hashCode(password);
            result = 31 * result + (sex != null ? sex.hashCode() : 0);
            result = 31 * result + (age != null ? age.hashCode() : 0);
            result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
            result = 31 * result + (modifiedTime != null ? modifiedTime.hashCode() : 0);
            result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
            result = 31 * result + Arrays.hashCode(address);
            result = 31 * result + (friends != null ? friends.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", BeanMapTestClass.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("username='" + username + "'")
                    .add("password=" + Arrays.toString(password))
                    .add("sex=" + sex)
                    .add("age=" + age)
                    .add("createTime=" + createTime)
                    .add("modifiedTime=" + modifiedTime)
                    .add("updateTime=" + updateTime)
                    .add("address=" + Arrays.toString(address))
                    .add("friends=" + friends)
                    .toString();
        }
    }
}
