package org.hotilsframework.core.primitives.mutable;

/**
 * @author hireny
 * @className MutableByte
 * @create 2020-03-12 23:32
 */
public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    private static final long serialVersionUID = 155582862329400647L;
    /**
     * The mutable value.
     */
    private byte value;

    public MutableByte() {
        super();
    }

    public MutableByte(final byte value) {
        super();
        this.value = value;
    }

    public MutableByte(final Number value) {
        super();
        this.value = value.byteValue();
    }

    public MutableByte(final String value) {
        super();
        this.value = Byte.parseByte(value);
    }

    @Override
    public Number getValue() {
        return Byte.valueOf(this.value);
    }

    public void setValue(final byte value) {
        this.value = value;
    }

    @Override
    public void setValue(final Number value) {
        this.value = value.byteValue();
    }

    /**
     * 值增加
     */
    public void increment() {
        value++;
    }

    /**
     * 值减少
     */
    public void decrement() {
        value--;
    }

    public void add(final byte operand) {
        this.value += operand;
    }

    public void add(final Number operand) {
        this.value += operand.byteValue();
    }

    public void subtract(final byte operand) {
        this.value -= operand;
    }

    public void subtract(final Number operand) {
        this.value -= operand.byteValue();
    }

    @Override
    public int compareTo(MutableByte o) {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
