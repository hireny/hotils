package org.hotilsframework.collect;

import org.hotilsframework.lang.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * 一个内容永远不会改变的关系映射
 * @author hireny
 * @className ImmutableMap
 * @create 2020-06-17 19:54
 */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    private static final long serialVersionUID = 7070776278211736008L;
    /**
     * 空条目的数组
     */
    static final Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Entry<?, ?>[0];

//    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(
//            Function<? super T, ? extends K> keyFunction,
//            Function<? super T, ? extends V> valueFunction) {
//        return CollectCollectors.toImmutableMap(keyFunction, valueFunction);
//    }

    public static <K, V> ImmutableMap<K, V> of() {
//        return new RegularImmutableMap();
        return null;
    }

    /**
     * 验证 {@code key} 和 {@code value} 是非空的，并返回一个不可变的 {@link java.util.Map.Entry}
     *
     * @param key       键
     * @param value     值
     * @param <K>       键的类型
     * @param <V>       值的类型
     * @return          返回一个不可变的 {@link java.util.Map.Entry}
     */
    static <K, V> Entry<K, V> entryOf(K key, V value) {
        Assert.notNullEntry(key, value);
        return new AbstractMap.SimpleImmutableEntry<>(key, value);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    /**
     * 不可变关系映射的构建器
     * @param <K>
     * @param <V>
     */
    public static class Builder<K, V> {
        Comparator<? super V> valueComparator;
        /**
         * 关系映射存储
         */
        Entry<K, V>[] entries;
        /**
         * 关系映射存储数量
         */
        int size;
        /**
         * 关系映射存储是否可以使用
         */
        boolean entriesUsed;

        /**
         * Constructor no parameter
         */
        public Builder() {
            this(ImmutableCollection.Builder.DEFAULT_INITIAL_CAPACITY);
        }

        /**
         * 构造方法
         * @param initialCapacity   初始容量
         */
        public Builder(int initialCapacity) {
            this.entries = new Entry[initialCapacity];
            this.size = 0;
            this.entriesUsed = false;
        }

        /**
         * 扩容
         * @param minCapacity
         */
        private void ensureCapacity(int minCapacity) {

        }

        /**
         * 存放键值对
         * @param key       键
         * @param value     值
         * @return
         */
        public Builder<K, V> put(K key, V value) {
            ensureCapacity(size + 1);
            Entry<K, V> entry = entryOf(key, value);
            entries[size++] = entry;
            return this;
        }

        public Builder<K, V> put(Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            return putAll(map.entrySet());
        }

        public Builder<K, V> putAll(Iterable<? extends Entry<? extends K, ? extends V>> entries) {
            if (entries instanceof Collection) {
                ensureCapacity(size + ((Collection<?>) entries).size());
            }
            for (Entry<? extends K, ? extends V> entry : entries) {
                put(entry);
            }
            return this;
        }

        public ImmutableMap<K, V> build() {

            switch (size) {
                case 0:
                    return of();
            }
            return null;
        }
    }
}
