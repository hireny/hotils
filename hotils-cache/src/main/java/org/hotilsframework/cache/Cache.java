package org.hotilsframework.cache;

import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName: Cache
 * @Author: hireny
 * @Date: Create in 2019/12/03 01:59
 * @Description: TODO   缓存接口
 */
public interface Cache<K,V> extends Iterable<V>, Serializable {

    /**
     * 返回缓存容量， <code>0</code>表示无大小限制
     * @return  返回缓存容量，<code>0</code>表示无大小限制
     */
    int capacity();

    /**
     * 缓存失效时长， <code>0</code> 表示没有设置，单位毫秒
     *
     * @return 缓存失效时长， <code>0</code> 表示没有设置，单位毫秒
     */
    long timeout();

    /**
     * 存入
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * 将对象加入到缓存，使用指定失效时长
     * 如果缓存满了， {@link #prune()} 将被调用以获得空间来存放新对象
     *
     * @param key       键
     * @param value     缓存的对象
     * @param timeout   失效时长，单位毫秒
     */
    void put(K key, V value, long timeout);


    /**
     * 每次调用此方法会刷新最后访问时间，也就是说会重新计算超时时间.
     * @param key   键
     * @return      键对应的对象
     */
    V get(K key);

    /**
     * 从缓存中获得对象，当对象不在缓存中或已经过期返回Func0回调产生的对象
     *
     * @param key  键
     * @param callable  如果不存在回调方法，用于生产值对象
     * @return      值对象
     * @throws ExecutionException
     */
    V get(K key, Callable<? extends V> callable) throws ExecutionException;

    /**
     * 从缓存中获得对象，当对象不在缓存中或已经过期返回<code>null</code>
     *
     * <p>
     * 调用此方法时，会检查上次调用时间，如果与当前时间差值大于超时时间返回<code>null</code>，否则返回值。
     * @param key                   键
     * @param isUpdateLastAccess    是否更新最后访问时间，即重新计算超时时间。
     * @return  键对应的对象
     */
    V get(K key, boolean isUpdateLastAccess);

    /**
     * 返回包含键和值的迭代器
     * @return  缓存对象迭代器
     */
    Iterator<CacheObject<K, V>> cacheObjectIterator();

    /**
     * 从缓存中清理过期对象，清理策略取决于具体实现
     *
     * @return 清理的缓存对象个数
     */
    int prune();

    /**
     * 缓存是否已满，仅用于有空间限制的缓存对象
     *
     * @return  缓存是否已满，仅用于有空间限制的缓存对象
     */
    boolean isFull();

    /**
     * 从缓存中移除对象
     * @param key
     */
    void remove(K key);

    /**
     * 清空缓存
     */
    void clear();

    /**
     * 缓存的对象数量
     * @return
     */
    int size();

    /**
     * 缓存是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含key
     * @param key   key
     * @return      是否包含key
     */
    boolean containsKey(K key);
}
