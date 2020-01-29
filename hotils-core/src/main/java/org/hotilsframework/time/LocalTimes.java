package org.hotilsframework.time;

import java.time.LocalTime;

/**
 * @Author: hireny
 * @Date: Create in 2019/11/05 00:51
 */
public class LocalTimes {

    private LocalTime localTime;

    public static LocalTimes of(LocalTime localTime) {
        return new LocalTimes(localTime);
    }


    private LocalTimes(LocalTime localTime) {
        this.localTime = localTime;
    }
}
