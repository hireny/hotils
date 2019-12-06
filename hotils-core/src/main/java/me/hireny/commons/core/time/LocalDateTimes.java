package me.hireny.commons.core.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/11 01:33
 */
public final class LocalDateTimes {

    private LocalDateTime localDateTime;

    private LocalDateTimes() {
        // 初始化LocalDateTime对象
        this.localDateTime = LocalDateTime.now();
    }

    private LocalDateTimes(LocalDateTime localDateTime) {
        this.localDateTime = LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime());
    }

    public LocalDateTimes(int year, int month, int dayOfMonth) {
        this(LocalDateTime.of(LocalDate.of(year, month, dayOfMonth), LocalTime.MIN));
    }

    public LocalDateTimes(int hour, int minutes) {
        this(LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minutes)));
    }

    public LocalDateTimes(int year, int month, int dayOfMonth, int hour, int minutes) {

    }

    public LocalDateTimes(int year, int month, int dayOfMonth, int hour, int minutes, int seconds) {
        this.localDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minutes, seconds);
    }

    public LocalDateTimes(int year, int month, int dayOfMonth, int hour, int minutes, int seconds, int nanoOfSecond) {
        this.localDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minutes, seconds, nanoOfSecond);
    }


    // region 获取属性值
    public int getYear() {
        return this.localDateTime.getYear();
    }

    /**
     * 获取月份
     *
     * @return 月
     */
    public int getMonth() {
        return this.localDateTime.getMonthValue();
    }

    /**
     * 获取月份对象
     *
     * @return 对象
     */
    public Month getMonthObj() {
        return this.localDateTime.getMonth();
    }

    /**
     * 获取天在这周的次序
     *
     * @return 天
     */
    public int getDayOfWeek() {
        return this.localDateTime.getDayOfWeek().getValue();
    }

    /**
     * 获取天在这周的对象
     *
     * @return 对象
     */
    public DayOfWeek getDayOfWeekObj() {
        return this.localDateTime.getDayOfWeek();
    }

    /**
     * 获取天在这月的次序
     *
     * @return 天
     */
    public int getDayOfMonth() {
        return this.localDateTime.getDayOfMonth();
    }

    /**
     * 获取天在这年的次序
     *
     * @return 天
     */
    public int getDayOfYear() {
        return this.localDateTime.getDayOfYear();
    }

    /**
     * 获取小时数
     *
     * @return
     */
    public int getHour() {
        return this.localDateTime.getHour();
    }

    /**
     * 获取分钟数
     *
     * @return
     */
    public int getMinute() {
        return this.localDateTime.getMinute();
    }

    /**
     * 获取秒数
     *
     * @return
     */
    public int getSecond() {
        return this.localDateTime.getSecond();
    }

    /**
     * 获取纳秒数
     *
     * @return
     */
    public int getNanoSecond() {
        return this.localDateTime.getNano();
    }

    /**
     * 获取这个月的最后一天
     *
     * @return 天
     */
    public LocalDateTimes getLastDayOfMonth() {
        return new LocalDateTimes(this.localDateTime.with(TemporalAdjusters.lastDayOfMonth()));
    }

    /**
     * 获取这一年的最后一天
     *
     * @return 天
     */
    public LocalDateTimes getLastDayOfYear() {
        return new LocalDateTimes(this.localDateTime.with(TemporalAdjusters.lastDayOfYear()));
    }

    /**
     * 获取这个月的第一天
     *
     * @return 天
     */
    public LocalDateTimes getFirstDayOfMonth() {
        return new LocalDateTimes(this.localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
    }

    /**
     * 获取这一年的第一天
     *
     * @return 天
     */
    public LocalDateTimes getFirstDayOfYear() {
        return new LocalDateTimes(this.localDateTime.with(TemporalAdjusters.firstDayOfYear()));
    }

    /**
     * 获取下个月的第一天
     *
     * @return 天
     */
    public LocalDateTimes getFirstDayOfNextMonth() {
        return new LocalDateTimes(this.localDateTime.with(TemporalAdjusters.firstDayOfNextMonth()));
    }

    /**
     * 获取这一年的第一天
     *
     * @return 天
     */
    public LocalDateTimes getFirstDayOfNextYear() {
        return new LocalDateTimes(this.localDateTime.with(TemporalAdjusters.firstDayOfNextYear()));
    }
    
    // end region

    //*****************************静态方法************************************************

    public static LocalDateTime getUTCLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime;
    }

    /**
     * Date转换为LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     * @return
     */
    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定日期的毫秒
     * @param localDateTime
     * @return
     */
    public static Long getMillisecondByTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒
     * @param localDateTime
     * @return
     */
    public static Long getSecondsByTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取当前时间的指定格式
     * @param pattern
     * @return
     */
    public static String formatTime(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 获取指定时间的指定格式
     * @param localDateTime
     * @param pattern
     * @return
     */
    public static String formatTime(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 日期加上一个数，根据field不同加不同值，field为ChronoUnit.*
     * @param localDateTime
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime plus(LocalDateTime localDateTime, long number, TemporalUnit field) {
        return localDateTime.plus(number, field);
    }

    /**
     * 日期减去一个数，根据field不同减不同值，field为ChronoUnit.*
     * @param localDateTime
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime minus(LocalDateTime localDateTime, long number, TemporalUnit field) {
        return localDateTime.minus(number, field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*.
     * @param startDateTime
     * @param endDateTime
     * @param field
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startDateTime, LocalDateTime endDateTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startDateTime), LocalDate.from(endDateTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        } else if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12L + period.getMonths();
        }
        return field.between(startDateTime, endDateTime);
    }

    /**
     * 获取一天的开始时间，例如：2019,1,1 00:00
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getDayStart(LocalDateTime localDateTime) {
        return localDateTime.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取一天的结束时间，例如：2019,1,1 23:59:59.999999999.
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getDayEnd(LocalDateTime localDateTime) {
        return localDateTime.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }
}
