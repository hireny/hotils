package org.hotilsframework.core.time;

import java.time.LocalDate;

/**
 * @ClassName: Zodiac
 * @Description: TODO   星座/中国生肖
 * @Author: hireny
 * @Date: Created in 2020-01-08 21:41
 * @Version: 1.0
 */
public class Zodiac {
    /** 星座分隔时间日 */
    private static final int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22 };
    /** 星座 */
    private static final String[] ZODIACS = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    private static final String[] CHINESE_ZODIACS = new String[] { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪" };

    /**
     * 通过生日计算星座
     * @param date      出生日期
     * @return          星座名
     */
    public static String getZodiac(LocalDate date) {
        return null;
    }
}
