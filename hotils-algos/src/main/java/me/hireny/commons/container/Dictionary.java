package me.hireny.commons.container;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: Dictionary
 * @Author: hireny
 * @Date: Create in 2019/12/04 14:45
 * @Description: TODO   字典容器的实现，扩充HashMap中的方法
 */
public class Dictionary extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = -7309133758732015700L;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * aka 16
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    /**
     * 是否大小写不敏感
     */
    private boolean caseInsensitive;

    // ***********************构造方法********************************** //

    public Dictionary() {
        this(false);
    }

    /**
     * 构造方法
     * @param caseInsensitive   是否大小写不敏感
     */
    public Dictionary(boolean caseInsensitive) {
        this(DEFAULT_INITIAL_CAPACITY, caseInsensitive);
    }

    /**
     * 构造方法
     * @param initialCapacity   初始容量大小
     */
    public Dictionary(int initialCapacity) {
        this(initialCapacity, false);
    }

    /**
     * 构造方法
     * @param initialCapacity   初始容量
     * @param caseInsensitive   是否大小写不敏感
     */
    public Dictionary(int initialCapacity, boolean caseInsensitive) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, caseInsensitive);
    }

    /**
     * 构造方法
     * @param initialCapacity   初始容量
     * @param loadFactor        容量增长因子，0~1，即达到容量的百分之多少时扩容
     */
    public Dictionary(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, false);
    }

    /**
     * 构造方法
     * @param initialCapacity   初始容量
     * @param loadFactor        容量增长因子，0~1，即达到容量的百分之多少时扩容
     * @param caseInsensitive   是否大小写不敏感
     */
    public Dictionary(int initialCapacity, float loadFactor, boolean caseInsensitive) {
        super(initialCapacity, loadFactor);
        this.caseInsensitive = caseInsensitive;
    }

    /**
     * 构造方法
     * @param map   map容器
     */
    public Dictionary(Map<? extends String, ?> map) {
        super((null == map) ? new HashMap<>() : map);
    }

    /**
     * 设置列
     * @param attr      属性
     * @param value     值
     * @return          本身
     */
    public Dictionary set(String attr, Object value) {
        this.put(attr, value);
        return this;
    }

    /**
     * 设置列，当键获值为null时忽略
     * @param attr      属性
     * @param value     值
     * @return          本身
     */
    public Dictionary setIgnoreNull(String attr, Object value) {
        if (null != attr && null != value) {
            set(attr, value);
        }
        return this;
    }

    /**
     * 获取特定类型值
     * @param attr              字段名
     * @param defaultValue      默认值
     * @param <T>               值类型
     * @return                  字段值
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String attr, T defaultValue) {
        final Object result = get(attr);
        return (T) (result != null ? result : defaultValue);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(customKey(key), value);
    }

    @Override
    public Dictionary clone() {
        return (Dictionary) super.clone();
    }

    /**
     * 将 Key 转为小写
     * @param key       KEY
     * @return          小写KEY
     */
    private String customKey(String key) {
        if (this.caseInsensitive && null != key) {
            key = key.toLowerCase();
        }
        return key;
    }
}
