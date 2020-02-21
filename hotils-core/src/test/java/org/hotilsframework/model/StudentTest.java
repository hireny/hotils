package org.hotilsframework.model;

import org.hotilsframework.core.lang.Gender;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 学生测试类
 * @author hireny
 * @className StudentTest
 * @create 2020-02-21 19:43
 */
public class StudentTest extends PersonTest {
    // 学号
    private Integer studentId;
    // 年级
    private String grade;
    // 班级
    private String clazz;
    // 学校
    private String school;

    public StudentTest() {
        super();
    }

    public StudentTest(String name, int age, Gender sex, Integer studentId, String grade, String clazz, String school) {
        super(name, age, sex);
        this.studentId = studentId;
        this.grade = grade;
        this.clazz = clazz;
        this.school = school;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentTest that = (StudentTest) o;
        return studentId.equals(that.studentId) &&
                grade.equals(that.grade) &&
                clazz.equals(that.clazz) &&
                Objects.equals(school, that.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId, grade, clazz, school);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentTest.class.getSimpleName() + "[", "]")
                .add("studentId=" + studentId)
                .add("grade='" + grade + "'")
                .add("clazz='" + clazz + "'")
                .add("school='" + school + "'")
                .toString();
    }
}
