package org.hotilsframework.cache;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * TypeCache
 *
 * 类型缓存
 *
 * @author hireny
 * @create 2020-08-09 23:43
 */
public class TypeCache<T> {

    private final Map<Class<?>, T> map;

    private TypeCache(final Map<Class<?>, T> map) {
        this.map = map;
    }

    /**
     * 返回缓存大小
     * @return
     */
    public int size() {
        return map.size();
    }

    /**
     * 该缓存是否为空
     * @return
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * 改缓存中是否存在
     * @param key
     * @return
     */
    public boolean containsKey(final Class<?> key) {
        return map.containsKey(key);
    }

    /**
     * 将键值关系添加到映射表中
     * @param key
     * @param value
     * @return
     */
    public T put(final Class<?> key, final T value) {
        return map.put(key, value);
    }

    /**
     * 通过键获取映射表中对应的值
     * @param key
     * @return
     */
    public T get(final Class<?> key) {
        return map.get(key);
    }

    /**
     * 通过键删除映射表中对应的值
     * @param key
     * @return
     */
    public T remove(final Class<?> key) {
        return map.remove(key);
    }

    /**
     * 清空缓存
     */
    public void clear() {
        map.clear();
    }

    public static class Builder<T> {

        /**
         * 构建一个类型缓存
         * @return
         */
        public TypeCache<T> get() {
            final Map<Class<?>, T> map = new IdentityHashMap<>();
            return new TypeCache<>(map);
        }
    }

    /**
     * 创建一个类型缓存的构建器
     * @param <T>
     * @return
     */
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    /**
     * 创建一个类型缓存对象
     * @param <T>
     * @return
     */
    public static <T> TypeCache<T> create() {
        return TypeCache.<T>builder().get();
    }
}
