package me.hireny.commons.core.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: RelationalMap
 * @Author: hireny
 * @Date: Create in 2019/12/20 22:17
 * @Description: TODO   关系映射表,通过实现一个已有Map实现特定功能。例如自定义Key的规则或Value规则
 *
 * @param <K> 键类型
 * @param <V> 值类型
 */
public class RelationalMap<K, V> implements Map<K, V>, Iterable<Map.Entry<K, V>>, Cloneable, Serializable {
    private static final long serialVersionUID = 200427986630758584L;

    /**
     * 默认增长因子
     */
    protected static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 默认初始大小
     */
    protected static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;   // aka 16

    private Map<K, V> raw;

    /**
     * 构造
     *
     * @param raw   被包装的Map
     */
    public RelationalMap(Map<K, V> raw) {
        this.raw = raw;
    }

    /**
     * 获取原始的Map
     * @return
     */
    public Map<K, V> getRaw() {
        return this.raw;
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
    public boolean containsKey(Object key) {
        return raw.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return raw.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return raw.get(key);
    }

    @Override
    public V put(K key, V value) {
        return raw.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return raw.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        raw.putAll(m);
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
}
