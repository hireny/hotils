package org.hotilsframework.time;

import java.time.DayOfWeek;

/**
 * @ClassName: Week
 * @Description: TODO   星期枚举
 * @Author: hireny
 * @Date: Created in 2020-01-08 21:08
 * @Version: 1.0
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

    /**星期日*/
    SUNDAY(DayOfWeek.SUNDAY.getValue()),
    /**星期一*/
    MONDAY(DayOfWeek.MONDAY.getValue()),
    /**星期二*/
    TUESDAY(DayOfWeek.TUESDAY.getValue()),
    /**星期三*/
    WEDNESDAY(DayOfWeek.WEDNESDAY.getValue()),
    /**星期四*/
    THURSDAY(DayOfWeek.THURSDAY.getValue()),
    /**星期五*/
    FRIDAY(DayOfWeek.FRIDAY.getValue()),
    /**星期六*/
    SATURDAY(DayOfWeek.SATURDAY.getValue());

    /**
     * 星期对应 {@link DayOfWeek} 中的Week值
     */
    private int value;

    /**
     * 构造
     * @param value 星期对应{@link DayOfWeek} 中的Week值
     */
    Week(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
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
        switch (this) {
            case SUNDAY:
                return weekNamePrefix + "日";
            case MONDAY:
                return weekNamePrefix + "一";
            case TUESDAY:
                return weekNamePrefix + "二";
            case WEDNESDAY:
                return weekNamePrefix + "三";
            case THURSDAY:
                return weekNamePrefix + "四";
            case FRIDAY:
                return weekNamePrefix + "五";
            case SATURDAY:
                return weekNamePrefix + "六";
            default:
                return null;
        }
    }

//    /**
//     * 将 {@link DayOfWeek} 星期相关值转换为Week枚举对象
//     * @param dayOfWeekIntValue
//     * @return
//     */
//    public static Week of(int dayOfWeekIntValue) {
//        switch (dayOfWeekIntValue) {
//            case DayOfWeek.SUNDAY.getValue():
//                return SUNDAY;
//            case DayOfWeek.MONDAY.getValue():
//                return MONDAY;
//            case DayOfWeek.TUESDAY.getValue():
//                return TUESDAY;
//            case DayOfWeek.WEDNESDAY.getValue():
//                return WEDNESDAY;
//            case DayOfWeek.THURSDAY.getValue():
//                return THURSDAY;
//            case DayOfWeek.FRIDAY.getValue():
//                return FRIDAY;
//            case DayOfWeek.SATURDAY.getValue():
//                return SATURDAY;
//            default:
//                return null;
//        }
//    }
}
