package org.hotilsframework.cache;

import org.hotilsframework.lang.Assert;

/**
 * @ClassName: CacheStatus
 * @Author: hireny
 * @Date: Create in 2019/12/03 02:03
 * @Description: TODO   缓存统计数据
 */
public class CacheStats {
    /**
     * 命中数
     */
    private final int hitCount;
    /**
     * 丢失数
     */
    private final int missCount;
    /**
     * 缓存失效时长 {@code 0} 表示没有设置，单位毫秒
     */
    private final long timeout;


    public CacheStats(int hitCount, int missCount, long timeout) {
        Assert.state(hitCount >= 0);
        Assert.state(missCount >= 0);
        Assert.state(timeout >= 0);
        this.hitCount = hitCount;
        this.missCount = missCount;
        this.timeout = timeout;
    }

    public int getHitCount() {
        return hitCount;
    }
    public int getMissCount() {
        return missCount;
    }
    public long getTimeout() {
        return timeout;
    }

    /**
     * 请求数
     * @return
     */
    public long requestCount() {
        return hitCount + missCount;
    }

    /**
     * 命中率
     * @return
     */
    public double hitRate() {
        long requestCount = requestCount();
        return (requestCount == 0) ? 1.0 : (double) hitCount / requestCount;
    }

    /**
     * 丢失率
     * @return
     */
    public double missRate() {
        long requestCount = requestCount();
        return (requestCount == 0) ? 0.0 : (double) missCount / requestCount;
    }
}
