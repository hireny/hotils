package me.hireny.commons.cache;

import java.io.Serializable;

/**
 * 缓存对象
 * @ClassName: CacheObject
 * @Author: hireny
 * @Date: Created in 2020-01-13 10:43
 * @Version: 1.0
 */
public class CacheObject<K, V> implements Serializable {

    private static final long serialVersionUID = 5891608134274306455L;

    protected final K key;
    protected final V value;
    /**
     * 上次访问时间
     */
    private long lastAccess;
    /**
     * 访问次数
     */
    protected long accessCount;
    /**
     * 对象存活时长，0表示永久存活
     */
    protected final long ttl;

    /**
     * 构造
     *
     * @param key       键
     * @param value     值
     * @param ttl       超时时长
     */
    protected CacheObject(K key, V value, long ttl) {
        this.key = key;
        this.value = value;
        this.ttl = ttl;
    }

    /**
     * 判断是否过期
     *
     * @return  是否过期
     */
    boolean isExpired() {
        if (this.ttl > 0) {
            final long expiredTime = this.lastAccess + this.ttl;
            // expiredTime > 0 杜绝Long类型溢出变负数问题，当当前时间超过过期时间，表示过期
            return expiredTime > 0 && expiredTime < System.currentTimeMillis();
        }
        return false;
    }

    /**
     * 获取值
     *
     * @param isUpdateLastAccess    是否更新最后访问时间
     * @return  获取对象
     */
    V get(boolean isUpdateLastAccess) {
        if (isUpdateLastAccess) {
            lastAccess = System.currentTimeMillis();
        }
        accessCount++;
        return this.value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "CacheObject{" +
                "key=" + key +
                ", value=" + value +
                ", lastAccess=" + lastAccess +
                ", accessCount=" + accessCount +
                ", ttl=" + ttl +
                '}';
    }
}
