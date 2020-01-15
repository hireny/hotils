package me.hireny.commons.cache;

import me.hireny.commons.core.collect.CopiedIterator;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 超时和限制大小的缓存的默认实现
 * @ClassName: AbstractCache
 * @Author: hireny
 * @Date: Created in 2020-01-13 10:14
 * @Version: 1.0
 */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    private static final long serialVersionUID = 2327950817706048562L;

    protected Map<K, CacheObject<K,V>> cacheMap;

    private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private final ReadLock readLock = cacheLock.readLock();
    private final WriteLock writeLock = cacheLock.writeLock();

    /** 返回缓存容量，<code>0</code>表示无大小限制 */
    protected int capacity;
    /** 缓存失效时长， <code>0</code> 表示无限制，单位毫秒 */
    protected long timeout;

    /** 每个对象是否有单独的失效时长，用于决定清理过期对象是否有必要。 */
    protected boolean existCustomTimeout;

    /** 命中数 */
    protected int hitCount;
    /** 丢失数 */
    protected int missCount;


    protected AbstractCache() {}

    @Override
    public void put(K key, V value) {
        put(key, value, timeout);
    }

    @Override
    public void put(K key, V value, long timeout) {
        writeLock.lock();
        try {
            putWithoutLock(key, value, timeout);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 加入元素，无锁
     * @param key       键
     * @param value     值
     * @param timeout   超时时间
     */
    private void putWithoutLock(K key, V value, long timeout) {
        CacheObject<K, V> cacheObject = new CacheObject<>(key, value, timeout);
        if (timeout != 0) {
            existCustomTimeout = true;
        }
        if (isFull()) {
            pruneCache();
        }
        cacheMap.put(key, cacheObject);
    }

    @Override
    public boolean containsKey(K key) {
        readLock.lock();
        try {
            // 不存在或已移除
            final CacheObject<K, V> cacheObject = cacheMap.get(key);
            if (cacheObject == null) {
                return false;
            }
            if (false == cacheObject.isExpired()) {
                // 命中
                return true;
            }
        } finally {
            readLock.unlock();
        }
        // 过期
        remove(key, true);
        return false;
    }

    @Override
    public V get(K key) {
        return get(key, true);
    }

    @Override
    public V get(K key, Callable<? extends V> callable) throws ExecutionException {
        V value = get(key);
        if (null == value && null != callable) {
            writeLock.lock();
            try {
                // 双重检查类
                final CacheObject<K, V> cacheObject = cacheMap.get(key);
                if (null == cacheObject || cacheObject.isExpired() || null == cacheObject.getValue()) {
                    try {
                        value = callable.call();
                    } catch (Exception e) {
                        throw new ExecutionException(e);
                    }
                    putWithoutLock(key, value, this.timeout);
                } else {
                    value = cacheObject.get(true);
                }
            } finally {
                writeLock.unlock();
            }
        }
        return value;
    }

    @Override
    public V get(K key, boolean isUpdateLastAccess) {
        readLock.lock();
        try {
            // 不存在或已移除
            final CacheObject<K, V> cacheObject = cacheMap.get(key);
            if (cacheObject == null) {
                missCount++;
                return null;
            }

            if (false == cacheObject.isExpired()) {
                // 命中
                hitCount++;
                return cacheObject.get(isUpdateLastAccess);
            }
        } finally {
            readLock.unlock();
        }

        // 过期
        remove(key, true);
        return null;
    }

    /**
     * 获取缓存对象中值的迭代器
     * @return
     */
    @Override
    public Iterator<V> iterator() {
        Iterator<CacheObject<K, V>> iterator = cacheObjectIterator();
        return new Iterator<V>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public V next() {
                return iterator.next().getValue();
            }

            @Override
            public void remove() {
                iterator.remove();
            }
        };
    }

    /**
     * 获取缓存对象的迭代器
     * @return
     */
    @Override
    public Iterator<CacheObject<K, V>> cacheObjectIterator() {
        CopiedIterator<CacheObject<K, V>> copiedIterator;
        readLock.lock();
        try {
            copiedIterator = CopiedIterator.copyOf(this.cacheMap.values().iterator());
        } finally {
            readLock.unlock();
        }
        return new Iterator<CacheObject<K, V>>() {
            @Override
            public boolean hasNext() {
                return copiedIterator.hasNext();
            }
            @Override
            public CacheObject<K, V> next() {
                return copiedIterator.next();
            }

            @Override
            public void remove() {
                // 不支持修改缓存值迭代器
                throw new UnsupportedOperationException("Cache Value Iterator is not support to modify.");
            }
        };
    }

    /**
     * 清理实现
     * @return  清理数量
     */
    protected abstract int pruneCache();

    @Override
    public int prune() {
        writeLock.lock();
        try {
            return pruneCache();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public int capacity() {
        return capacity;
    }

    /**
     *
     * @return  默认缓存失效时长 <br>
     *          每个对象可以单独设置失效时长
     */
    @Override
    public long timeout() {
        return timeout;
    }

    @Override
    public boolean isFull() {
        this.readLock.lock();
        try {
            return (capacity > 0) && (cacheMap.size() >= capacity);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override
    public void remove(K key) {
        remove(key, false);
    }

    @Override
    public void clear() {
        writeLock.lock();
        try {
            cacheMap.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public int size() {
        this.readLock.lock();
        try {
            return cacheMap.size();
        } finally {
            this.readLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        this.readLock.lock();
        try {
            return cacheMap.isEmpty();
        } finally {
            this.readLock.unlock();
        }
    }

    @Override
    public String toString() {
        this.readLock.lock();
        try {
            return this.cacheMap.toString();
        } finally {
            this.readLock.unlock();
        }
    }

    /**
     * 对象移除回调，默认无动作
     *
     * @param key           键
     * @param cachedObject  被缓存的对象
     */
    protected void onRemove(K key, V cachedObject) {
        // ignore
    }

    /**
     * 移除key对应的对象
     *
     * @param key               键
     * @param withMissCount     是否计数丢失数
     */
    private void remove(K key, boolean withMissCount) {
        writeLock.lock();
        CacheObject<K, V> cacheObject;
        try {
            cacheObject = removeWithoutLock(key, withMissCount);
        } finally {
            writeLock.unlock();
        }
        if (null != cacheObject) {
            onRemove(cacheObject.key, cacheObject.value);
        }
    }

    private CacheObject<K, V> removeWithoutLock(K key, boolean withMissCount) {
        final CacheObject<K, V> cacheObject = cacheMap.remove(key);
        if (withMissCount) {
            // 在丢失计数有效的情况下，移除一般为get时的超时操作，此处应该丢失数+1
            this.missCount++;
        }
        return cacheObject;
    }

    /**
     * 统计计数器
     */
    public interface StatsCounter {
        /**
         * 记录命中数
         * @param count
         */
        void recordHits(int count);

        /**
         * 记录丢失数
         * @param count
         */
        void recordMisses(int count);

        /**
         * 记录加载成功时间
         * @param loadTime
         */
        void recordLoadSuccess(long loadTime);

        /**
         * 记录加载异常时间
         * @param loadTime
         */
        void recordLoadException(long loadTime);
    }

    public static final class SimpleStatsCounter implements StatsCounter {

        @Override
        public void recordHits(int count) {

        }

        @Override
        public void recordMisses(int count) {

        }

        @Override
        public void recordLoadSuccess(long loadTime) {

        }

        @Override
        public void recordLoadException(long loadTime) {

        }
    }
}
