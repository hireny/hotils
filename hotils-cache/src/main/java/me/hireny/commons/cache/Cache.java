package me.hireny.commons.cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName: Cache
 * @Author: hireny
 * @Date: Create in 2019/12/03 01:59
 * @Description: TODO   缓存接口
 */
public interface Cache<K,V> {

    V getIfPresent(Object var1);

    /**
     * 获取
     * @param var1
     * @param var2
     * @return
     * @throws ExecutionException
     */
    V get(K var1, Callable<? extends V> var2) throws ExecutionException;

//    ImmutableMap<K, V> getAllPresent(Iterable<?> var1);

    /**
     * 存入
     * @param var1
     * @param var2
     */
    void put(K var1, V var2);

    /**
     * 存入
     * @param var1
     */
    void putAll(Map<? extends K, ? extends V> var1);

    void invalidate(Object var1);

    void invalidateAll();

    /**
     * 缓存大小
     * @return
     */
    long size();

    /**
     * 缓存状态
     * @return
     */
    CacheStatus status();

    ConcurrentMap<K, V> asMap();

    /**
     * 缓存清除
     */
    void cleanUp();
}
