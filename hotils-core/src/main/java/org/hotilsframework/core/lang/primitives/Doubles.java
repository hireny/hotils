package org.hotilsframework.core.lang.primitives;

import org.hotilsframework.utils.Assert;

/**
 * 双精度浮点型
 * @className Doubles
 * @author hireny
 * @date Created in 2020-01-30 13:44
 * @version 1.0
 */
public final class Doubles {

    private double value;

    private Doubles(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    /**
     * 将双精度浮点型转换为byte数组
     * @return
     */
    public byte[] toBytes() {
        long result = Double.doubleToRawLongBits(value);
        return Longs.of(result).toBytes();
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
        if (isDoubleClass(o.getClass())) {
            double od = (double) o;
            return ((Double)value).equals(od);
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Doubles doubles = (Doubles) o;

        return ((Double) value).equals(doubles.value);
    }

    @Override
    public int hashCode() {
        return ((Double)value).hashCode();
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
    public static final int BYTES = Double.SIZE / Byte.SIZE;

    public static Doubles of(double value) {
        return new Doubles(value);
    }

    public static Doubles of(Double value) {
        return new Doubles(value);
    }

    /**
     * 将byte数组转换为双精度浮点型
     * @param bytes
     * @return
     */
    public static double fromByteArray(byte[] bytes) {
        Assert.state(bytes.length >= BYTES, "array too small: %s < %s", bytes.length, BYTES);
        return Double.longBitsToDouble(Longs.fromByteArray(bytes));
    }

    /**
     * 检查给定对象对应的类是否为双精度浮点型，双精度浮点型类包括：
     *
     * <pre>
     *     double.class
     *     Double.class
     * </pre>
     * @return
     */
    public static boolean isDouble(Object o) {
        return o instanceof Float || o.getClass() == double.class;
    }

    /**
     * 检查给定类名是否为整型类，整型类包括：
     *
     * <pre>
     *     double.class
     *     Double.class
     * </pre>
     * @param clazz
     * @return
     */
    public static boolean isDoubleClass(Class<?> clazz) {
        return clazz == Double.class || clazz == double.class;
    }
}
