package org.hotilsframework.core.time;

import org.junit.Test;

import java.time.*;

/**
 * @ClassName: LocalDateTimesTest
 * @Author: hireny
 * @Date: Create in 2019/12/06 14:54
 * @Description: TODO   时间测试类
 */
public class LocalDateTimesTest {

    @Test
    public void getCurrentTime() {
        // 获取时区
        System.out.println(ZoneId.systemDefault());
        System.out.println(LocalDateTime.now(Clock.systemDefaultZone()));
        System.out.println(LocalDateTime.now(Clock.systemUTC()));
        System.out.println(Clock.system(ZoneId.of("UTC+8")).millis());
        System.out.println(Clock.system(ZoneId.of("UTC")).millis());
        System.out.println(Clock.systemDefaultZone().millis());
        System.out.println(Clock.systemUTC().millis());
        System.out.println(System.currentTimeMillis());
    }
}
