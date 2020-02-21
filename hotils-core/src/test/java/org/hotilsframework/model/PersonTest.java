package org.hotilsframework.model;

import org.hotilsframework.core.lang.Gender;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 人测试类
 * @author hireny
 * @className PersonTest
 * @create 2020-02-21 19:43
 */
public class PersonTest implements Serializable {
    private String name;
    private int    age;
    private Gender sex;

    public PersonTest() {
    }

    public PersonTest(String name, int age, Gender sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonTest that = (PersonTest) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                sex == that.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonTest.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("sex=" + sex)
                .toString();
    }
}
