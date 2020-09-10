package org.hotilsframework.collect;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/**
 * TypeCache
 *
 * 类型缓存
 *
 * @author hireny
 * @create 2020-08-09 23:43
 */
public class TypeMap<T> implements Map<Class<?>, T> {

    private final Map<Class<?>, T> map;

    private TypeMap(final Map<Class<?>, T> map) {
        this.map = map;
    }

    /**
     * 返回缓存大小
     * @return
     */
    @Override
    public int size() {
        return map.size();
    }

    /**
     * 该缓存是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * 该缓存中是否存在键
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(Object key) {
        if (key instanceof Class<?>) {
            return false;
        }
        return map.containsKey(key);
    }

    /**
     * 该缓存中是否存在值
     * @param value
     * @return
     */
    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public T get(Object key) {
        return null;
    }

//    /**
//     * 该缓存中是否存在
//     * @param key
//     * @return
//     */
//    public boolean containsKey(final Class<?> key) {
//        return map.containsKey(key);
//    }

    /**
     * 将键值关系添加到映射表中
     * @param key
     * @param value
     * @return
     */
    @Override
    public T put(final Class<?> key, final T value) {
        return map.put(key, value);
    }

    @Override
    public T remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends Class<?>, ? extends T> m) {

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
    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<Class<?>> keySet() {
        return null;
    }

    @Override
    public Collection<T> values() {
        return null;
    }

    @Override
    public Set<Entry<Class<?>, T>> entrySet() {
        return null;
    }

    public static class Builder<T> {

        /**
         * 构建一个类型缓存
         * @return
         */
        public TypeMap<T> get() {
            final Map<Class<?>, T> map = new IdentityHashMap<>();
            return new TypeMap<>(map);
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
    public static <T> TypeMap<T> create() {
        return TypeMap.<T>builder().get();
    }
}
