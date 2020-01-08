package me.hireny.commons.core.time;

/**
 * 农历日历。<br>
 * 将农历从1901年到2100年之间各年、月的大小以及历年节气保存，然后基于这些数据进行计算。<br>
 * <br>
 * 新增了几个用于农历的常量属性字段，可以使用get()方法获取日历对应的值；<br>
 * 农历年、月、日还可以使用set()/add()/roll()方法设置，其他农历属性自动计算；<br>
 * 另外，还提供了getChinese(int field)方法用于获得农历的中文文字（仅适用于农历属性和星期）。<br>
 * <ul>
 * <li>CHINESE_YEAR - 农历年</li>
 * <li>CHINESE_MONTH - 农历月</li>
 * <li>CHINESE_DATE - 农历日</li>
 * <li>CHINESE_SECTIONAL_TERM - 当月的节气</li>
 * <li>CHINESE_PRINCIPLE_TERM - 当月的中气</li>
 * <li>CHINESE_HEAVENLY_STEM - 农历年的天干</li>
 * <li>CHINESE_EARTHLY_BRANCH - 农历年的地支</li>
 * <li>CHINESE_ZODIAC - 农历年的属相</li>
 * <li>CHINESE_TERM_OR_DATE - 如果当天存在一个节气则指示节气，否则如果当天是初一则指示农历月，否则指示农历日</li>
 * </ul>
 * 注意：<br>
 * 由于Calendar类的设定，公历月份从0起始。所有方法都遵循了这一约定。<br>
 * 但所有的农历属性从1起始。即使是在Calendar提供的方法中，农历月也是从1起始的，并以负数表示闰月。<br>
 * clear()方法在某些情况下会导致农历和公历日期不对应或是不能达到预期的重置效果，应尽量避免使用。<br>
 * 使用getSimpleDateString()获得公历日期字符串时，公历月已经修正；<br>
 * 使用getSimpleChineseDateString()获得农历日期字符串时，农历闰月以*表示。<br>
 * <br>
 * <i>农历算法来源于<a href="http://www.herongyang.com/year_gb/program.html">和荣笔记</a>。</i>
 */

/**
 * @ClassName: LunarCalendar
 * @Author: hireny
 * @Date: Create in 2019/12/12 21:52
 * @Description: TODO   农历/阴历
 */
public class LunarCalendar {
}
