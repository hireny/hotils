package me.hireny.commons.core.time;

import java.time.*;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/11 01:33
 */
public class LocalDateTimes {

//    private final class LocalDatesHodler {
//        private final LocalDateTimes INSTANCE = new LocalDateTimes();
//    }
//
//    private LocalDateTimes INSTANCE = new LocalDatesHodler().INSTANCE;

    private LocalDateTime localDateTime;

    public LocalDateTimes() {
        // 初始化LocalDateTime对象
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTimes(LocalDateTime localDateTime) {
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


    /**
     * 获取默认时间戳
     * @return
     */
    public Long getUnixTimeStampByDefault() {
        return getUnixTimeStamp(me.hireny.commons.core.time.ZoneId.UTC);
    }
    /**
     * 获取北京时间戳
     * @return
     */
    public Long getUnixTimeStampByBeijing() {
        // 初始化时区对象，北京时间是UTC+8，所以入参为8
        return getUnixTimeStamp(me.hireny.commons.core.time.ZoneId.BJS);
    }

    /**
     * 获取Unix时间戳
     * @param zone  时区
     * @return
     */
    private Long getUnixTimeStamp(int zone) {
        // 初始化时区对象
        ZoneOffset zoneOffset = ZoneOffset.ofHours(zone);
        // 获取LocalDateTime对象对应时区的Unix时间戳
        Long now = localDateTime.toEpochSecond(zoneOffset);
        return now;
    }
}
