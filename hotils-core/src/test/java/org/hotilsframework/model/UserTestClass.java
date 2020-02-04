package org.hotilsframework.model;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: UserTestClass
 * @Description: TODO   用户测试类
 * @Author: hireny
 * @Date: Created in 2020-01-08 9:12
 * @Version: 1.0
 */
public class UserTestClass {

    private static String staticUsername = "静态用户名";

    private Integer id;
    private String username;
    private String password;
    private String gender;
    private String email;
    private String telephone;
    private String introduce;
    private String activeCode;
    private int state;
    private String role;
    private Timestamp registTime;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Timestamp registTime) {
        this.registTime = registTime;
    }

    public void methodTest2() {
        System.out.println("是一个空参数的方法");
    }

    public void methodTest(String name, String value) {
        System.out.println("name=" + name + ", value=" + value);
    }

    public String methodTest1(String name, String value) {
        String merge = "字符串合并：name=" + name + ", value=" + value;
        return merge;
    }

    public static String staticMethodTest(String name, String value) {
        String merge = "静态方法-字符串合并：name=" + name + ", value=" + value;
        System.out.println(merge);
        return merge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTestClass that = (UserTestClass) o;
        return state == that.state &&
                Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(introduce, that.introduce) &&
                Objects.equals(activeCode, that.activeCode) &&
                Objects.equals(role, that.role) &&
                Objects.equals(registTime, that.registTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, gender, email, telephone, introduce, activeCode, state, role, registTime);
    }

    @Override
    public String toString() {
        return "UserTestClass{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", introduce='" + introduce + '\'' +
                ", activeCode='" + activeCode + '\'' +
                ", state=" + state +
                ", role='" + role + '\'' +
                ", registTime=" + registTime +
                '}';
    }
}
