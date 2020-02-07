package org.hotilsframework.core.time;


/**
 * @ClassName: DateUnit
 * @Description: TODO   日期时间单位，每个单位都是以毫秒为基数
 * @Author: hireny
 * @Date: Created in 2020-01-08 21:35
 * @Version: 1.0
 */
public enum DateUnit {
    /**一毫秒*/
    MS(1),
    /**一秒的毫秒*/
    SECOND(1000),
    /**一分钟的毫秒数*/
    MINUTE(SECOND.getMillis() * 60),
    /**一小时的毫秒数*/
    HOUR(MINUTE.getMillis() * 60),
    /**一天的毫秒数*/
    DAY(HOUR.getMillis() * 24),
    /**一周的毫秒数*/
    WEEK(DAY.getMillis() * 7),
    /** 一年的毫秒数 */
    YEAR(DAY.getMillis() * 365),
    YEAR2(DAY.getMillis() * 366);


    private long millis;

    DateUnit(long millis) {
        this.millis = millis;
    }

    public long getMillis() {
        return this.millis;
    }
}
