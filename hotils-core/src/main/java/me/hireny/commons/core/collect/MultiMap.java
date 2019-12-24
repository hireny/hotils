package me.hireny.commons.core.collect;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: MultiMap
 * @Author: hireny
 * @Date: Create in 2019/12/22 00:25
 * @Description: TODO   多Map容器
 */
public interface MultiMap<K, V> extends Map<K,List<V>> {

    /**
     * 返回给定键的第一个值
     * @param key
     * @return
     */
    V getFirst(K key);

    /**
     * 将给定的单个值添加到给定的当前值列表中。
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 将给定列表的所有值添加到给定键的当前值列表的中。
     * @param key
     * @param values
     */
    void addAll(K key, List<? extends V> values);

    /**
     * 将给定的 {@code MultiMap} 映射表中的所有值添加到当前映射表容器中
     * @param values
     */
    void addAll(MultiMap<K, V> values);

    /**
     * 将值添加到给定的键中，只有当前键中没有该值才执行。
     * @param key
     * @param value
     */
    default void addIfAbsend(K key, V value) {
        if (!containsKey(key)) {
            add(key, value);
        }
    }

    /**
     * 在给定键下设置给定的单个值
     * @param key
     * @param value
     */
    void set(K key, V value);

    /**
     * 设置给定的值
     * @param values
     */
    void setAll(Map<K, V> values);

    /**
     * 返回一个 {@code Map}，其中包含 {@code MultiMap} 中的第一个值。
     * @return
     */
    Map<K, V> toSingleValueMap();
}
