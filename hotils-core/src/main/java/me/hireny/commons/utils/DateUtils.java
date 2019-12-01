package me.hireny.commons.utils;

/**
 * @ClassName: DateUtils
 * @Author: hireny
 * @Date: Create in 2019/11/14 22:51
 * @Description: TODO   日期工具类
 */
public class DateUtils {

    private DateUtils() {}

    /**
     * 时间戳(系统时间戳为毫秒)转Unix时间戳(Unix时间戳为秒)
     * @param timestamp
     * @return
     */
    public Long toUnixTimeStamp(Long timestamp) {
        return timestamp/1000;
    }

    /**
     * Unix时间戳转时间戳
     * @param unixTimeStamp
     * @return
     */
    public Long toTimestamp(Long unixTimeStamp) {
        return unixTimeStamp*1000;
    }
}
