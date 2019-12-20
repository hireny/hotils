package me.hireny.commons.core.collect;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: CustomKeyMap
 * @Author: hireny
 * @Date: Create in 2019/12/20 22:08
 * @Description: TODO   自定义键的Map，默认HashMap实现
 */
public abstract class CustomKeyMap<K, V> extends RelationalMap<K, V> {
    private static final long serialVersionUID = 4291307436370698340L;

    /**
     * 构造
     *
     * 通过传入一个Map从而确定Map的类型，子类需创建一个空的Map，而非传入一个已有Map，否则值可能会被修改
     *
     * @param map
     */
    protected CustomKeyMap(Map<K, V> map) {
        super(map);
    }

    @Override
    public V get(Object key) {
        return super.get(customKey(key));
    }

    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        return super.put((K) customKey(key), value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(customKey(key));
    }

    /**
     * 自定义键
     *
     * @param key   KEY
     * @return      自定义KEY
     */
    protected abstract Object customKey(Object key);
}
