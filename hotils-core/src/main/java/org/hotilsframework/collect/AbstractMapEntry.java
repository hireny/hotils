package org.hotilsframework.collect;

import java.util.Map;
import java.util.Objects;

/**
 * AbstractMapEntry
 * 抽象的关系映射条目
 *
 * @author hireny
 * @create 2020-07-09 12:38
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    @Override
    public abstract K getKey();

    @Override
    public abstract V getValue();

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Map.Entry) {
            Map.Entry<?, ?> that = (Map.Entry<?, ?>) o;
            return Objects.equals(that.getKey(), that.getKey())
                    && Objects.equals(that.getValue(), that.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        K k = getKey();
        V v = getValue();
        return ((k == null) ? 0 : k.hashCode());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
