package org.hotilsframework.cache;

import org.hotilsframework.lang.reflects.Instantiator;
import org.hotilsframework.lang.Assert;

/**
 * 缓存构建器
 * @author hireny
 * @className CacheBuilder
 * @create 2020-07-06 8:53
 */
public final class CacheBuilder<K, V> {
    /**
     * 未设置
     */
    static final int UNSET_INT = -1;
    /**
     * 默认初始化容量
     */
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    /**
     * 默认失效时间
     */
    static final int DEFAULT_EXPIRATION_NANOS = 0;
    /**
     * 默认刷新时间
     */
    static final int DEFAULT_REFRESH_NANOS = 0;

    /**
     * 极限大小
     */
    private long maximumSize = UNSET_INT;
    /**
     * 极限权重
     */
    private long maximumWight = UNSET_INT;

    /**
     * 初始化容量
     */
    private int initialCapacity = UNSET_INT;

    long refreshNanos = UNSET_INT;
    long expireAfterWriteNanos = UNSET_INT;
    long expireAfterAccessNanos = UNSET_INT;
    /**
     * 缓存策略
     */
    private Class<?> cacheType;

    /**
     * 初始化容器容量
     *
     * @param initialCapacity  容器容量
     * @return
     */
    public CacheBuilder<K, V> initialCapacity(int initialCapacity) {
        Assert.checkArgument(initialCapacity >= 0);
        this.initialCapacity = initialCapacity;
        return this;
    }

    /**
     * 最大容量，不能为负
     * @param size      大小
     * @return
     */
    public CacheBuilder<K, V> maximumSize(long size) {
        Assert.checkArgument(size >= 0, "maximum size must not be negative.");
        this.maximumSize = size;
        return this;
    }

    /**
     * 设置缓存策略
     * @param cacheType     缓存类型
     * @return
     */
    public CacheBuilder<K, V> policy(Class<?> cacheType) {
        this.cacheType = cacheType;
        return this;
    }

    /**
     * 构建缓存对象
     * @return
     */
    public Cache<K, V> build() {
        return Instantiator.tryInstance(cacheType);
    }
}
