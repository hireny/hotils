package org.hotilsframework.lang.primitives;

import org.hotilsframework.utils.Assert;

/**
 * 短整型
 * @author hireny
 * @className Shorts
 * @create 2020-02-19 19:06
 */
public final class Shorts {

    private short value;

    private Shorts(short value) {
        this.value = value;
    }

    public short getValue() {
        return value;
    }

    /**
     * 将短整型转换为byte数组
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
        if (isShortClass(o.getClass())) {
            short os = (short) o;
            return value == os;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Shorts Shorts = (Shorts) o;

        return value == Shorts.value;
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
     * The number of bytes required to represent a primitive {@code short} value.
     * 表示原始 {@code short} 值所需的字节数
     */
    public static final short BYTES = Short.SIZE / Byte.SIZE;

    public static Shorts of(short value) {
        return new Shorts(value);
    }

    public static Shorts of(Short value) {
        return new Shorts(value);
    }

    /**
     * 将短整型转换为byte数组
     * @param value
     * @return
     */
    public static byte[] toByteArray(short value) {
        return new byte[] {(byte) (value >> 8), (byte) value};
    }

    /**
     * 将byte数组转换为短整型
     * @param bytes
     * @return
     */
    public static short fromByteArray(byte[] bytes) {
        Assert.state(bytes.length >= BYTES, "array too small: %s < %s", bytes.length, BYTES);
        return fromBytes(bytes[0], bytes[1]);
    }

    /**
     * 将byte数组转换为短整型
     * @param b1
     * @param b2
     * @return
     */
    public static short fromBytes(byte b1, byte b2) {
        return  (short) ((b1 << 8) | (b2 & 0xFF));
    }

    /**
     * 检查给定对象对应的类是否为整型类，整型类包括：
     *
     * <pre>
     *     short.class
     *     shorteger.class
     * </pre>
     * @return
     */
    public static boolean isShort(Object o) {
        return o instanceof Short || o.getClass() == short.class;
    }

    /**
     * 检查给定类名是否为整型类，整型类包括：
     *
     * <pre>
     *     short.class
     *     shorteger.class
     * </pre>
     * @param clazz
     * @return
     */
    public static boolean isShortClass(Class<?> clazz) {
        return clazz == short.class || clazz == Short.class;
    }
}
