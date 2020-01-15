package me.hireny.commons.utils.concurrent;

/**
 * @ClassName: RateLimiter
 * @Author: hireny
 * @Date: Create in 2019/11/08 22:29
 * @Description: TODO   速度限制器
 */
public interface RateLimiter {
    /**
     * 获取
     */
    void acquire() throws RejectException;
}
