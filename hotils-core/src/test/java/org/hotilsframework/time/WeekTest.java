package org.hotilsframework.time;

import org.junit.Test;

/**
 * @author hireny
 * @className WeekTest
 * @create 2020-07-07 7:06
 */
public class WeekTest {

    /**
     * 整型转换为枚举周期对应的值
     */
    @Test
    public void dayOfWeek2Week() {
        Integer[] days = {0, 1, 2, 8, 9, 10, 3, 4, -1, 5, 6, 7, -20, -30};

        for (int i = 0; i < days.length; i++) {
            try {
                Week week = Week.of(days[i]);
                System.out.println(days[i] + "=" + week);
            } catch (Exception ex) {

            }

        }

    }
}
