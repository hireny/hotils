package org.hotilsframework.time;

import org.hotilsframework.collect.MapUtils;
import org.hotilsframework.lang.Assert;

import java.time.DayOfWeek;
import java.util.Map;

/**
 * @className Week
 *
 * 星期枚举
 *
 * @author hireny
 * @date Created in 2020-01-08 21:08
 * @version 1.0
 *
 * @see #SUNDAY
 * @see #MONDAY
 * @see #TUESDAY
 * @see #WEDNESDAY
 * @see #THURSDAY
 * @see #FRIDAY
 * @see #SATURDAY
 */
public enum Week {

    /**
     * 星期一
     * 它的数值为 {@code 1}
     */
    MONDAY,
    /**
     * 星期二
     * 它的数值为 {@code 2}
     */
    TUESDAY,
    /**
     * 星期三
     * 它的数值为 {@code 3}
     */
    WEDNESDAY,
    /**
     * 星期四
     * 它的数值为 {@code 4}
     */
    THURSDAY,
    /**
     * 星期五
     * 它的数值为 {@code 5}
     */
    FRIDAY,
    /**
     * 星期六
     * 它的数值为 {@code 6}
     */
    SATURDAY,
    /**
     * 星期日
     * 它的数值为 {@code 7}
     */
    SUNDAY;
    /**
     * 该枚举类中所有枚举值
     */
    private static final Week[] WEEKS = Week.values();

    /**
     * 构造
     */
    Week() {}

    public int getValue() {
        return ordinal() + 1;
    }

    /**
     * 转换为中文名
     * @return      星期的中文名
     */
    public String toChinese() {
        return toChinese("星期");
    }

    /**
     * 转换为中文名
     * @param weekNamePrefix    表示星期的前缀，例如前缀为“星期”，则返回结果为“星期一”；前缀为”周“，结果为“周一”
     * @return      星期的中文名
     */
    public String toChinese(String weekNamePrefix) {
        return weekNamePrefix + weeksOfChinese().get(this);
    }

    /**
     * 将 {@link DayOfWeek} 星期相关值转换为Week枚举对象
     * @param dayOfWeek
     * @return
     */
    public static Week of(int dayOfWeek) {

        Assert.checkArgument(dayOfWeek >= DayOfWeek.MONDAY.getValue() && dayOfWeek <= DayOfWeek.SUNDAY.getValue(), "not find day of week");
        return WEEKS[dayOfWeek];
    }

    /**
     * 将JAVA的DayOfWeek转换为Week
     * @param dayOfWeek
     * @return
     */
    public static Week of(DayOfWeek dayOfWeek) {
        return WEEKS[dayOfWeek.getValue() - 1];
    }

    /**
     * 每周的数字对应中国名称
     * @return
     */
    private static Map<Week, String> weeksOfChinese() {
        Map<Week, String> weekOfChinese = MapUtils.newHashMap();
        weekOfChinese.put(Week.MONDAY, "一");
        weekOfChinese.put(Week.TUESDAY, "二");
        weekOfChinese.put(Week.WEDNESDAY, "三");
        weekOfChinese.put(Week.THURSDAY, "四");
        weekOfChinese.put(Week.FRIDAY, "五");
        weekOfChinese.put(Week.SATURDAY, "六");
        weekOfChinese.put(Week.SUNDAY, "日");
        return weekOfChinese;
    }
}
