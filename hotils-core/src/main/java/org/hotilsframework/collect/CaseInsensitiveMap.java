package org.hotilsframework.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * 忽略大小写的映射Map结构
 * @className CaseInsensitiveMap
 * @author hireny
 * @date Create in 2019/12/20 21:59
 *
 * 对KEY忽略大小写，get("Value")和get("value")获得的值相同，put进入的值也会被覆盖
 */
public class CaseInsensitiveMap<K, V> implements Map<K, V>, Iterable<Map.Entry<K, V>>, Cloneable, Serializable {
    private static final long serialVersionUID = -8177370574947249548L;

    /**
     * 默认增长因子
     */
    protected static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 默认初始大小，初始化大小为16
     */
    protected static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    private Map<K, V> raw;


    public CaseInsensitiveMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public CaseInsensitiveMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 构造
     * <p>
     * 通过传入一个Map从而确定Map的类型，子类需创建一个空的Map，而非传入一个已有Map，否则值可能会被修改
     *
     * @param map
     */
    public CaseInsensitiveMap(Map<? extends K, ? extends V> map) {
        this(DEFAULT_LOAD_FACTOR, map);
    }

    /**
     * 构造
     *
     * @param loadFactor    加载因子
     * @param m             Map
     */
    public CaseInsensitiveMap(float loadFactor, Map<? extends K, ? extends V> m) {
        this(m.size(), loadFactor);
        this.putAll(m);
    }

    /**
     * 构造
     * @param initialCapacity   初始大小
     * @param loadFactor        加载因子
     */
    public CaseInsensitiveMap(int initialCapacity, float loadFactor) {
        this.raw = new HashMap<>(initialCapacity, loadFactor);
    }

    /**
     * 获取原始的Map
     * @return
     */
    public Map<K, V> getRaw() {
        return this.raw;
    }

    @Override
    public V get(Object key) {
        return raw.get(customKey(key));
    }

    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        return raw.put((K) customKey(key), value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        return raw.remove(key);
    }


    @Override
    public boolean containsKey(Object key) {
        return raw.containsKey(customKey(key));
    }


    @Override
    public int size() {
        return raw.size();
    }

    @Override
    public boolean isEmpty() {
        return raw.isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        return raw.containsValue(value);
    }

    @Override
    public void clear() {
        raw.clear();
    }

    @Override
    public Set<K> keySet() {
        return raw.keySet();
    }

    @Override
    public Collection<V> values() {
        return raw.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return raw.entrySet();
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return this.entrySet().iterator();
    }

    @Override
    public String toString() {
        return raw.toString();
    }

    /**
     * 将Key转为小写
     * @param key   KEY
     * @return      小写KEY
     */
    protected Object customKey(Object key) {
        if (key instanceof CharSequence) {
            key = key.toString().toLowerCase();
        }
        return key;
    }
}
