package org.hotilsframework.core.lang.primitives;


/**
 * 布尔类型
 * @author hireny
 * @date Create in 2019/10/13 20:17
 */
public final class Booleans {

    private boolean value;

    private Booleans(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    /**
     * 比较是否相等
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (isBooleanClass(o.getClass())) {
            boolean ob = (boolean) o;
            return value == ob;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Booleans booleans = (Booleans) o;

        return value == booleans.value;
    }

    @Override
    public int hashCode() {
        return value ? 1231 : 1237;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    //=========================================
    // 静态方法
    //=========================================

    public static Booleans of(boolean value) {
        return new Booleans(value);
    }

    public static Booleans of(Boolean value) {
        return new Booleans(value);
    }


    /**
     * 检查给定对象对应的类是否为布尔类型，布尔类包括：
     *
     * <pre>
     *     boolean.class
     *     Boolean.class
     * </pre>
     * @return
     */
    public static boolean isBoolean(Object o) {
        return o instanceof Boolean || o.getClass() == boolean.class;
    }

    /**
     * 检查给定类名是否为布尔类型，布尔类包括：
     *
     * <pre>
     *     boolean.class
     *     Boolean.class
     * </pre>
     * @param clazz
     * @return
     */
    public static boolean isBooleanClass(Class<?> clazz) {
        return clazz == boolean.class || clazz == Boolean.class;
    }
}
