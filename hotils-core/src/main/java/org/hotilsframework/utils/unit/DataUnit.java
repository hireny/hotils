package org.hotilsframework.utils.unit;

import java.util.Objects;

/**
 * 数据单位
 * @author hireny
 * @className DataUnit
 * @create 2020-02-21 20:29
 */
public enum DataUnit {
    /**
     * Bytes, represented by suffix {@code B}.
     */
    BYTES("B", DataSize.ofBytes(1)),
    /**
     * Kilobytes, represented by suffix {@code KB}.
     */
    KILOBYTES("KB", DataSize.ofKilobytes(1)),

    /**
     * Megabytes, represented by suffix {@code MB}.
     */
    MEGABYTES("MB", DataSize.ofMegabytes(1)),

    /**
     * Gigabytes, represented by suffix {@code GB}.
     */
    GIGABYTES("GB", DataSize.ofGigabytes(1)),

    /**
     * Terabytes, represented by suffix {@code TB}.
     */
    TERABYTES("TB", DataSize.ofTerabytes(1));

    private final String suffix;

    private final DataSize size;

    DataUnit(String suffix, DataSize size) {
        this.suffix = suffix;
        this.size = size;
    }

    DataSize size() {
        return this.size;
    }

    public static DataUnit fromSuffix(String suffix) {
        for (DataUnit candidate : values()) {
            if (Objects.equals(candidate.suffix, suffix)) {
                return candidate;
            }
        }
        // 数据未知的单位后缀
        throw new IllegalArgumentException("Unknown data unit suffix '" + suffix + "'");
    }
}
