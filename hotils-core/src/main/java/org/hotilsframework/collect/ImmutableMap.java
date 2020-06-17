package org.hotilsframework.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

/**
 * 一个内容永远不会改变的关系映射
 * @author hireny
 * @className ImmutableMap
 * @create 2020-06-17 19:54
 */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    private static final long serialVersionUID = 7070776278211736008L;

//    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(
//            Function<? super T, ? extends K> keyFunction,
//            Function<? super T, ? extends V> valueFunction) {
//        return CollectCollectors.toImmutableMap(keyFunction, valueFunction);
//    }
//
//
//    public static class Builder<K, V> {
//        Comparator<? super V> valueComparator;
//        /**
//         * 关系映射存储
//         */
//        Entry<K, V>[] entries;
//        /**
//         * 关系映射存储数量
//         */
//        int size;
//        /**
//         * 关系映射存储是否可以使用
//         */
//        boolean entriesUsed;
//
//        public Builder() {
//            this(4);
//        }
//
//        /**
//         * 构造方法
//         * @param initialCapacity   初始容量
//         */
//        public Builder(int initialCapacity) {
//            this.entries = new Entry[initialCapacity];
//            this.size = 0;
//            this.entriesUsed = false;
//        }
//
//        /**
//         * 扩容
//         * @param minCapacity
//         */
//        private void ensureCapacity(int minCapacity) {
//
//        }
//
//        public Builder<K, V> put(K key, V value) {
//            ensureCapacity(size + 1);
//            Entry<K, V> entry = entryOf(key, value);
//        }
//    }
}
