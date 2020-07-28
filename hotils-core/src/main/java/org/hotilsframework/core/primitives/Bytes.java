package org.hotilsframework.core.primitives;


/**
 * 字节类型
 * @author hireny
 * @date Create in 2019/10/04 10:19
 */
public final class Bytes {

    private byte value;

    private Bytes(byte value) {
        this.value = value;
    }

    public byte getValue() {
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
        if (isByte(o.getClass())) {
            byte ob = (Byte) o;
            return value == ob;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Bytes bytes = (Bytes) o;

        return value == bytes.value;
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

    public static Bytes of(byte value) {
        return new Bytes(value);
    }

    public static Bytes of(Byte value) {
        return new Bytes(value);
    }


    /**
     * 检查给定对象对应的类是否为字节类型，字节类包括：
     *
     * <pre>
     *     byte.class
     *     Byte.class
     * </pre>
     * @return
     */
    public static boolean isByte(Object o) {
        return o instanceof Byte || o.getClass() == byte.class;
    }

    /**
     * 检查给定类名是否为字节类型，字节类型包括：
     *
     * <pre>
     *     byte.class
     *     Byte.class
     * </pre>
     * @param clazz
     * @return
     */
    public static boolean isByte(Class<?> clazz) {
        return clazz == byte.class || clazz == Byte.class;
    }
}
