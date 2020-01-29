package org.hotilsframework.time;

import org.hotilsframework.utils.Assert;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @ClassName: DateBetween
 * @Description: TODO   日期间隔
 * @Author: hireny
 * @Date: Created in 2020-01-08 21:43
 * @Version: 1.0
 */
public class DateBetween implements Serializable {
    private static final long serialVersionUID = -2523085299070149194L;

    /** 开始日期 */
    private LocalDateTime begin;
    /** 结束日期 */
    private LocalDateTime end;

    /**
     * 构造
     * 在前的日期作为起始时间，在后的做为结束时间，间隔只保留绝对值正数
     *
     * @param begin 起始时间
     * @param end   结束时间
     */
    public DateBetween(LocalDateTime begin, LocalDateTime end) {
        this(begin, end, true);
    }

    /**
     * 构造
     * 在前的日期做为起始时间，在后的做为结束时间
     *
     * @param begin     起始时间
     * @param end       结束时间
     * @param isAbs     日期间隔是否只保留绝对值正数
     */
    public DateBetween(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
        Assert.checkNotNull(begin, "Begin date is null !");
        Assert.checkNotNull(end, "End date is null !");

        if (isAbs && begin.isAfter(end)) {
            // 间隔只为正数的情况下，如果开始日期晚于结束日期，置换之
            this.begin = end;
            this.end = begin;
        } else {
            this.begin = begin;
            this.end = end;
        }
    }

    /**
     * 判断两个日期相差的时长
     * @param unit      相差的单位：相差 天{@link DateUnit#DAY}、小时{@link DateUnit#HOUR} 等
     * @return          时长差
     */
    public long between(DateUnit unit) {
        long diff = end.toEpochSecond(ZoneOffset.UTC) - begin.toEpochSecond(ZoneOffset.UTC);
        return diff / unit.getMillis();
    }
}
