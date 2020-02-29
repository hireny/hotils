package org.hotilsframework.lang.primitives;

import org.hotilsframework.utils.Assert;

/**
 * 整型
 * @author hireny
 * @date Create in 2019/09/30 01:44
 */
public final class Ints {

    private int value;

    private Ints(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * 将整型转换为byte数组
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
        if (isIntClass(o.getClass())) {
            int oi = (int) o;
            return value == oi;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Ints ints = (Ints) o;

        return value == ints.value;
    }

    @Override
    public int hashCode() {
        return value;
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
    public static final int BYTES = Integer.SIZE / Byte.SIZE;

    public static Ints of(int value) {
        return new Ints(value);
    }

    public static Ints of(Integer value) {
        return new Ints(value);
    }

    /**
     * 将整型转换为byte数组
     * @param value
     * @return
     */
    public static byte[] toByteArray(int value) {
        return new byte[] {
                (byte) (value >> 24), (byte) (value >> 16),
                (byte) (value >> 8), (byte) value
        };
    }

    /**
     * 将byte数组转换为整型
     * @param bytes
     * @return
     */
    public static int fromByteArray(byte[] bytes) {
        Assert.state(bytes.length >= BYTES, "array too small: %s < %s", bytes.length, BYTES);
        return fromBytes(bytes[0], bytes[1], bytes[2], bytes[3]);
    }

    /**
     * 将byte数组转换为整型
     * @param b1
     * @param b2
     * @param b3
     * @param b4
     * @return
     */
    public static int fromBytes(byte b1, byte b2, byte b3, byte b4) {
        return b1 << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8 | (b4 & 0xFF);
    }

    /**
     * 检查给定对象对应的类是否为整型类，整型类包括：
     *
     * <pre>
     *     int.class
     *     Integer.class
     * </pre>
     * @return
     */
    public static boolean isInt(Object o) {
        return o instanceof Integer || o.getClass() == int.class;
    }

    /**
     * 检查给定类名是否为整型类，整型类包括：
     *
     * <pre>
     *     int.class
     *     Integer.class
     * </pre>
     * @param clazz
     * @return
     */
    public static boolean isIntClass(Class<?> clazz) {
        return clazz == int.class || clazz == Integer.class;
    }
}
