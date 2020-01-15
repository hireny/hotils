package me.hireny.commons.core.lang.enums;

/**
 * @ClassName: Gender
 * @Description: TODO   性别枚举类
 * @Author: hireny
 * @Date: Created in 2020-01-09 15:30
 * @Version: 1.0
 */
public enum Gender {
    /**
     * 未知
     */
    Other("未知", 0),
    /**
     * 男
     */
    Male("男", 1),
    /**
     * 女
     */
    Female("女", 2);

    private String name;
    private Integer value;

    Gender(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
