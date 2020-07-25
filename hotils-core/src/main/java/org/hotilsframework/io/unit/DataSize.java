package org.hotilsframework.io.unit;

import org.hotilsframework.utils.Assert;
import org.hotilsframework.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据大小，如：'12MB'
 * @author hireny
 * @className DataSize
 * @create 2020-02-21 20:09
 */
public final class DataSize implements Comparable<DataSize> {

    /**
     * The pattern for parsing.
     */
    private static final Pattern PATTERN = Pattern.compile("^([+\\-]?\\d+)([a-zA-Z]{0,2})$");

    /**
     * Bytes per Kilobyte.
     */
    private static final long BYTES_PER_KB = 1024;
    /**
     * Bytes per Megabyte.
     */
    private static final long BYTES_PER_MB = BYTES_PER_KB * 1024;

    /**
     * Bytes per Gigabyte.
     */
    private static final long BYTES_PER_GB = BYTES_PER_MB * 1024;

    /**
     * Bytes per Terabyte.
     */
    private static final long BYTES_PER_TB = BYTES_PER_GB * 1024;

    private final long bytes;

    private DataSize(long bytes) {
        this.bytes = bytes;
    }

    /**
     * 数据大小比较
     * @param other
     * @return
     */
    @Override
    public int compareTo(DataSize other) {
        return Long.compare(this.bytes, other.bytes);
    }

    /**
     * 检查该大小是否为负数，不包括0。
     * @return      如果小于零，则为 true
     */
    public boolean isNegative() {
        return this.bytes < 0;
    }

    /**
     * 返回字节数。
     * @return      字节数
     */
    public long toBytes() {
        return this.bytes;
    }

    /**
     * 返回千字节数。 KB
     * @return      千字节数
     */
    public long toKilobytes() {
        return this.bytes / BYTES_PER_KB;
    }

    /**
     * 返回兆字节数。
     * @return      兆字节数
     */
    public long toMegabytes() {
        return this.bytes / BYTES_PER_MB;
    }

    /**
     * 返回千兆字节数。
     * @return      千兆字节数
     */
    public long toGigabytes() {
        return this.bytes / BYTES_PER_GB;
    }

    /**
     * 返回TB字节数
     * @return      TB字节数
     */
    public long toTerabytes() {
        return this.bytes / BYTES_PER_TB;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DataSize otherSize = (DataSize) other;
        return (this.bytes == otherSize.bytes);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.bytes);
    }

    @Override
    public String toString() {
        return String.format("%dB", this.bytes);
    }

    /**
     * 静态方法获取表示字节数的 {@link DataSize} 对象
     * @param bytes
     * @return
     */
    public static DataSize ofBytes(long bytes) {
        return new DataSize(bytes);
    }

    /**
     * 静态方法获取表示千字节数的 {@link DataSize} 对象
     * @param kilobytes
     * @return
     */
    public static DataSize ofKilobytes(long kilobytes) {
        return new DataSize(Math.multiplyExact(kilobytes, BYTES_PER_KB));
    }

    /**
     * 静态方法获取表示兆字节数的 {@link DataSize} 对象
     * @param megabytes
     * @return
     */
    public static DataSize ofMegabytes(long megabytes) {
        return new DataSize(Math.multiplyExact(megabytes, BYTES_PER_MB));
    }

    /**
     * 静态方法获取表示千兆字节数的 {@link DataSize} 对象
     * @param gigabytes
     * @return
     */
    public static DataSize ofGigabytes(long gigabytes) {
        return new DataSize(Math.multiplyExact(gigabytes, BYTES_PER_GB));
    }

    /**
     * 静态方法获取表示 TB 字节数的 {@link DataSize} 对象
     * @param terabytes
     * @return
     */
    public static DataSize ofTerabytes(long terabytes) {
        return new DataSize(Math.multiplyExact(terabytes, BYTES_PER_TB));
    }

    /**
     * 获取一个 {@link DataSize} 表示指定的 {@link DataUnit} 中的一个单位。
     * @param amount
     * @param unit
     * @return
     */
    public static DataSize of(long amount, DataUnit unit) {
        Assert.notNull(unit, "Unit must not be null.");
        return new DataSize(Math.multiplyExact(amount, unit.size().toBytes()));
    }

    /**
     * 解析文本，获取数据大小
     * @param text
     * @return
     */
    public static DataSize parse(CharSequence text) {
        return parse(text, null);
    }

    /**
     * 解析文本获取数据大小
     * @param text
     * @param defaultUnit
     * @return
     */
    public static DataSize parse(CharSequence text, DataUnit defaultUnit) {
        Assert.notNull(text, "Text must not be null.");
        try {
            Matcher matcher = PATTERN.matcher(text);
            Assert.state(matcher.matches(), "Does not match data size pattern");
            DataUnit unit = determineDataUnit(matcher.group(2), defaultUnit);
            long amount = Long.parseLong(matcher.group(1));
            return DataSize.of(amount, unit);
        } catch (Exception e) {
            // 数据大小不是有效的
            throw new IllegalArgumentException("'" + text + "' is not a valid data size", e);
        }
    }

    /**
     * 确定数据单位
     * @param suffix
     * @param defaultUnit
     * @return
     */
    private static DataUnit determineDataUnit(String suffix, DataUnit defaultUnit) {
        DataUnit defaultUnitToUse = (defaultUnit != null ? defaultUnit : DataUnit.BYTES);
        return (!StringUtils.isBlank(suffix) ? DataUnit.fromSuffix(suffix) : defaultUnitToUse);
    }
}
