package org.hotilsframework.utils;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @ClassName: DateTimeUtils
 * @Author: hireny
 * @Date: Create in 2019/11/14 22:51
 * @Description: TODO   日期工具类
 */
public class DateTimeUtils {

    private DateTimeUtils() {}

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
}
