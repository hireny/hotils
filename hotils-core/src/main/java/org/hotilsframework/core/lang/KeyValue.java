package org.hotilsframework.core.lang;

/**
 * @ClassName: KeyValuePair
 * @Description: TODO   键值对
 * @Author: hireny
 * @Date: Created in 2020-01-10 1:52
 * @Version: 1.0
 */
public class KeyValue<K, V> {

    private K key;
    private V value;

    public static <K, V> KeyValue<K, V> of(K k, V v) {
        return new KeyValue<>(k, v);
    }

    public KeyValue(K k, V v) {
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

        KeyValue<?, ?> that = (KeyValue<?, ?>) o;

        if (key != null ? !key.equals(that.key) : that.key != null) {
            return false;
        }
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
