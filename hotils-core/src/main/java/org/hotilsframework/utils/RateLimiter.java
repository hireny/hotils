package org.hotilsframework.utils;

import org.hotilsframework.concurrent.RejectException;
import org.hotilsframework.time.SleepingStopWatch;

/**
 * @ClassName: RateLimiter
 * @Author: hireny
 * @Date: Create in 2019/11/08 22:29
 * @Description: TODO   速度限制器
 */
public interface RateLimiter {
    /**
     * 获取限流操作
     *
     * @throws RejectException
     */
    void acquire() throws RejectException;

    /**
     * 创建限流器
     * @param permitsPerSecond 每秒许可
     * @return
     */
    static RateLimiter create(double permitsPerSecond) {
        return create(permitsPerSecond, new SleepingStopWatch());
    }

    /**
     * 创建限流器
     * @param permitsPerSecond  每秒许可
     * @param stopWatch         睡眠秒表
     * @return
     */
    static RateLimiter create(double permitsPerSecond, SleepingStopWatch stopWatch) {
        RateLimiter rateLimiter = new RateCounter();
        return rateLimiter;
    }
}
