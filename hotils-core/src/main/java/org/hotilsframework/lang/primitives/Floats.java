package org.hotilsframework.lang.primitives;

import org.hotilsframework.utils.Assert;

/**
 * 单精度浮点型
 * @className Floats
 * @author hireny
 * @date Created in 2020-01-30 13:45
 * @version 1.0
 */
public final class Floats {

    private float value;

    private Floats(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    /**
     * 将双精度浮点型转换为byte数组
     * @return
     */
    public byte[] toBytes() {
       return toByteArray(value);
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
        if (isFloatClass(o.getClass())) {
            int of = (int) o;
            return value == of;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Floats floats = (Floats) o;

        return value == floats.value;
    }

    @Override
    public int hashCode() {
        return ((Float)value).hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    //=========================================
    // 静态方法
    //=========================================

    /**
     * The number of bytes required to represent a primitive {@code int} value.
     * 表示原始 {@code int} 值所需的字节数
     */
    public static final int BYTES = Float.SIZE / Byte.SIZE;

    public static Floats of(float value) {
        return new Floats(value);
    }

    public static Floats of(Float value) {
        return new Floats(value);
    }

    /**
     * 将单精度浮点型转换为byte数组
     * @param value
     * @return
     */
    public static byte[] toByteArray(float value) {
        return Ints.toByteArray(Float.floatToRawIntBits(value));
    }

    /**
     * 将byte数组转换为单精度浮点型
     * @param bytes
     * @return
     */
    public static float fromByteArray(byte[] bytes) {
        Assert.state(bytes.length >= BYTES, "array too small: %s < %s", bytes.length, BYTES);
        return Float.floatToIntBits(Ints.fromByteArray(bytes));
    }

    /**
     * 检查给定对象对应的类是否为整型类，整型类包括：
     *
     * <pre>
     *     float.class
     *     Float.class
     * </pre>
     * @return
     */
    public static boolean isFloat(Object o) {
        return o instanceof Float || o.getClass() == float.class;
    }

    /**
     * 检查给定类名是否为整型类，整型类包括：
     *
     * <pre>
     *     float.class
     *     Float.class
     * </pre>
     * @param clazz
     * @return
     */
    public static boolean isFloatClass(Class<?> clazz) {
        return clazz == Float.class || clazz == float.class;
    }
}
