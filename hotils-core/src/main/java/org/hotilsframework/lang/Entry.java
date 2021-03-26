package org.hotilsframework.lang;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName: KeyValuePair
 * @Description: TODO   键值对
 * @Author: hireny
 * @Date: Created in 2020-01-10 1:52
 * @Version: 1.0
 */
public class Entry<K, V> implements Serializable {
    private static final long serialVersionUID = -4044114608524858618L;
    
    private K key;
    private V value;

    public static <K, V> Entry<K, V> of(K k, V v) {
        return new Entry<>(k, v);
    }

    public Entry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Entry<?, ?> that = (Entry<?, ?>) o;

        if (!Objects.equals(key, that.key)) {
            return false;
        }
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
