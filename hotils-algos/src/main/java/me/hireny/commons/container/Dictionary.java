package me.hireny.commons.container;


import me.hireny.commons.core.beans.getter.BeanTypeGetter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: Dictionary
 * @Author: hireny
 * @Date: Create in 2019/12/04 14:45
 * @Description: TODO   字典容器的实现，扩充HashMap中的方法
 */
public class Dictionary extends LinkedHashMap<String, Object> implements BeanTypeGetter<String> {
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
    public Dictionary(Map<String, Object> map) {
        super((null == map) ? new HashMap<>() : map);
    }

    @Override
    public Object getObject(String key) {
        return null;
    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public Integer getInt(String key) {
        return null;
    }

    @Override
    public Short getShort(String key) {
        return null;
    }

    @Override
    public Boolean getBoolean(String key) {
        return null;
    }

    @Override
    public Long getLong(String key) {
        return null;
    }

    @Override
    public Character getChar(String key) {
        return null;
    }

    @Override
    public Float getFloat(String key) {
        return null;
    }

    @Override
    public Double getDouble(String key) {
        return null;
    }

    @Override
    public Byte getByte(String key) {
        return null;
    }

    @Override
    public BigDecimal getBigDecimal(String key) {
        return null;
    }

    @Override
    public BigInteger getBigInteger(String key) {
        return null;
    }

    @Override
    public <E extends Enum<E>> E getEnum(Class<E> clazz, String key) {
        return null;
    }

    @Override
    public Date getDate(String key) {
        return null;
    }

    @Override
    public LocalDate getLocalDate(String key) {
        return null;
    }

    @Override
    public LocalTime getLocalTime(String key) {
        return null;
    }

    @Override
    public LocalDateTime getLocalDateTime(String key) {
        return null;
    }
}
