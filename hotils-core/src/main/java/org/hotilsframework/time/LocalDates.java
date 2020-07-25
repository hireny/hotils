package org.hotilsframework.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * 类功能描述
 *
 * 该类是对Java8 新的日期API的封装
 *
 * @Author: hireny
 * @Date: Create in 2019/11/05 00:51
 */
public final class LocalDates {
    /**
     * 将 Java8 新增的日期API转换为 Date
     * @param dateTime
     * @return
     */
    public static Date date(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将 Date 类转换为 Java8 新增的日期API的 LocalDate
     * @param date
     * @return
     */
    public static LocalDate date(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将 Date 类转换为 Java8 新增的日期API的 LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 将 Date 类转换为 Java8 新增的日期API的 LocalDateTime
     * @param date
     * @return
     */
    public static LocalTime time(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalTime();
    }

    /**
     * 时间戳(系统时间戳为毫秒)转Unix时间戳(Unix时间戳为秒)
     * @param timestamp
     * @return
     */
    public static long toUnixTimeStamp(long timestamp) {
        return timestamp/1000;
    }

    /**
     * Unix时间戳转时间戳
     * @param unixTimeStamp
     * @return
     */
    public static long toTimestamp(long unixTimeStamp) {
        return unixTimeStamp*1000;
    }

    /**
     * 获取指定时间的指定格式
     * @param time
     * @param pattern
     * @return
     */
    public static String format(TemporalAccessor time, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(time);
    }

    /**
     * 根据日期获取星期枚举
     * @param date
     * @return
     */
    public static Week getWeek(LocalDate date) {
        return Week.of(date.getDayOfWeek().getValue());
    }
}
