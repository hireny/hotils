package example.model;

import org.hotilsframework.lang.enums.Sex;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author hireny
 * @className ArrayModelTest
 * @create 2020-03-17 10:01
 */
public class ArrayModelTest {
    private String name;
    private int age;
    private Sex sex;

    public ArrayModelTest() {
    }

    public ArrayModelTest(String name, int age, Sex sex) {
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayModelTest that = (ArrayModelTest) o;
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
        return new StringJoiner(", ", ArrayModelTest.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("sex=" + sex)
                .toString();
    }
}
