package me.hireny.commons.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: hireny
 * @Date: Create in 2019/11/03 14:12
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = -3644310128315227043L;
    private final int cacheSize;

    /**
     * 传递进来最多能缓存多少数据
     * @param cacheSize
     */
    public LRUCache(int cacheSize) {
        // true表示让LinkedHashMap按照访问顺序来进行排序，
        // 最近访问的放在头部，最老访问的放在尾部。
        super((int) (Math.ceil(cacheSize / 0.75) + 1), 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当 map 中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return super.removeEldestEntry(eldest);
    }
}
