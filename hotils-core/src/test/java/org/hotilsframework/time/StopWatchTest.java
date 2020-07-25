package org.hotilsframework.time;

import org.junit.Test;

/**
 * 对秒表进行测试
 * @author hireny
 * @className StopWatchTest
 * @create 2020-06-13 15:23
 */
public class StopWatchTest {

    @Test
    public void stopwatch() {
        StopWatch stopWatch = new StopWatch("first");
        stopWatch.start("first task");
        for (int i = 0; i < 1000; i++) {
            System.out.print(i);
        }
        System.out.println();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println("*********************");
        System.out.println(stopWatch.toString());
    }
}
