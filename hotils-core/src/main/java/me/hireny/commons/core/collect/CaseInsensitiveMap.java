package me.hireny.commons.core.collect;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CaseInsensitiveMap
 * @Author: hireny
 * @Date: Create in 2019/12/20 21:59
 * @Description: TODO   忽略大小写的映射Map结构
 *
 * 对KEY忽略大小写，get("Value")和get("value")获得的值相同，put进入的值也会被覆盖
 */
public class CaseInsensitiveMap<K, V> extends CustomKeyMap<K, V> {
    private static final long serialVersionUID = -8177370574947249548L;


    public CaseInsensitiveMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public CaseInsensitiveMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 构造
     * <p>
     * 通过传入一个Map从而确定Map的类型，子类需创建一个空的Map，而非传入一个已有Map，否则值可能会被修改
     *
     * @param map
     */
    public CaseInsensitiveMap(Map<? extends K, ? extends V> map) {
        this(DEFAULT_LOAD_FACTOR, map);
    }

    /**
     * 构造
     *
     * @param loadFactor    加载因子
     * @param m             Map
     */
    public CaseInsensitiveMap(float loadFactor, Map<? extends K, ? extends V> m) {
        this(m.size(), loadFactor);
        this.putAll(m);
    }

    /**
     * 构造
     * @param initialCapacity   初始大小
     * @param loadFactor        加载因子
     */
    public CaseInsensitiveMap(int initialCapacity, float loadFactor) {
        super(new HashMap<>(initialCapacity, loadFactor));
    }

    /**
     * 将Key转为小写
     * @param key   KEY
     * @return      小写KEY
     */
    @Override
    protected Object customKey(Object key) {
        if (key instanceof CharSequence) {
            key = key.toString().toLowerCase();
        }
        return key;
    }
}
