package org.hotilsframework.core.primitives;

import org.hotilsframework.lang.Assert;

/**
 * 长整型
 * @className Longs
 * @author hireny
 * @date Created in 2020-01-30 13:46
 * @version 1.0
 */
public class Longs {

    private long value;

    private Longs(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    /**
     * 将长整型转换为byte数组
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
        if (isLongClass(o.getClass())) {
            int ol = (int) o;
            return value == ol;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Longs Longs = (Longs) o;

        return value == Longs.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
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
    public static final int BYTES = Long.SIZE / Byte.SIZE;

    public static Longs of(long value) {
        return new Longs(value);
    }

    public static Longs of(Long value) {
        return new Longs(value);
    }

    /**
     * 将长整型转换为byte数组类型
     * @param value
     * @return
     */
    public static byte[] toByteArray(long value) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result [i] = (byte) (value & 0xFFL);
            value >>= 8;
        }
        return result;
    }

    /**
     * 将byte数组转换为长整型
     * @param bytes
     * @return
     */
    public static long fromByteArray(byte[] bytes) {
        Assert.state(bytes.length >= BYTES, "array too small: %s < %s", bytes.length, BYTES);
        return fromBytes(bytes[0], bytes[1], bytes[2], bytes[3], bytes[4], bytes[5], bytes[6], bytes[7]);
    }

    /**
     * 将byte数组转换为长整型
     * @param b1
     * @param b2
     * @param b3
     * @param b4
     * @return
     */
    public static long fromBytes(byte b1, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return (b1 & 0xFFL) << 56
                | (b2 & 0xFFL) << 48
                | (b3 & 0xFFL) << 40
                | (b4 & 0xFFL) << 32
                | (b5 & 0xFFL) << 24
                | (b6 & 0xFFL) << 16
                | (b7 & 0xFFL) << 8
                | (b8 & 0xFFL);
    }

    /**
     * 检查给定对象对应的类是否为整型类，整型类包括：
     *
     * <pre>
     *     long.class
     *     Long.class
     * </pre>
     * @return
     */
    public static boolean isLong(Object o) {
        return o instanceof Long || o.getClass() == long.class;
    }

    /**
     * 检查给定类名是否为整型类，整型类包括：
     *
     * <pre>
     *     long.class
     *     Long.class
     * </pre>
     * @param clazz
     * @return
     */
    public static boolean isLongClass(Class<?> clazz) {
        return clazz == long.class || clazz == Long.class;
    }
}
