package org.hotilsframework.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * RegularImmutableMap
 *
 * Implementation of {@link ImmutableMap} with two or more entries.
 *
 * 带有两个或多个条目的 {@link ImmutableMap} 的实现
 *
 * @author hireny
 * @create 2020-07-09 12:31
 */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {

    static final ImmutableMap<Object, Object> EMPTY =
            new RegularImmutableMap<>((Entry<Object, Object>[]) ImmutableMap.EMPTY_ENTRY_ARRAY, null, 0);

//    private RegularImmutableMap<Entry<K, V>[] entrys, ImmutableMapEntry>

    RegularImmutableMap(Entry<K, V>[] entrys, ImmutableMapEntry tables, int size) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
