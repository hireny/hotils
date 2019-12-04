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

    V get(K var1, Callable<? extends V> var2) throws ExecutionException;

//    ImmutableMap<K, V> getAllPresent(Iterable<?> var1);

    void put(K var1, V var2);

    void putAll(Map<? extends K, ? extends V> var1);

    void invalidate(Object var1);

    void invalidateAll();

    long size();

    CacheStatus status();

    ConcurrentMap<K, V> asMap();

    void cleanUp();
}
