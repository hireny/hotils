package me.hireny.commons.core.beans.getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @ClassName: OptNullBeanTypeFromObjectGetter
 * @Author: hireny
 * @Date: Create in 2019/12/09 00:46
 * @Description: TODO   基本类型的getter接口抽象实现，所有类型的值获取都是通过将getObj获得的值转换而来<br>
 *  * 用户只需实现getObj方法即可，其他类型将会从Object结果中转换
 *  * 在不提供默认值的情况下， 如果值不存在或获取错误，返回null<br>
 */
public interface OptNullBeanTypeFromObjectGetter<K> extends OptNullBeanTypeGetter<K> {

    @Override
    default String getString(K key, String defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toStr(obj, defaultValue);
        return null;
    }

    @Override
    default Integer getInt(K key, Integer defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toInt(obj, defaultValue);
        return null;
    }

    @Override
    default Short getShort(K key, Short defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toShort(obj, defaultValue);
        return null;
    }

    @Override
    default Boolean getBoolean(K key, Boolean defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toBool(obj, defaultValue);
        return null;
    }

    @Override
    default Long getLong(K key, Long defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toLong(obj, defaultValue);
        return null;
    }

    @Override
    default Character getChar(K key, Character defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toChar(obj, defaultValue);
        return null;
    }

    @Override
    default Float getFloat(K key, Float defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toFloat(obj, defaultValue);
        return null;
    }

    @Override
    default Double getDouble(K key, Double defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toDouble(obj, defaultValue);
        return null;
    }

    @Override
    default Byte getByte(K key, Byte defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toByte(obj, defaultValue);
        return null;
    }

    @Override
    default BigDecimal getBigDecimal(K key, BigDecimal defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toBigDecimal(obj, defaultValue);
        return null;
    }

    @Override
    default BigInteger getBigInteger(K key, BigInteger defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toBigInteger(obj, defaultValue);
        return null;
    }

    @Override
    default <E extends Enum<E>> E getEnum(Class<E> clazz, K key, E defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toEnum(clazz, obj, defaultValue);
        return null;
    }

    @Override
    default Date getDate(K key, Date defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
//        return Convert.toDate(obj, defaultValue);
        return null;
    }

    /**
     * 获取LocalDate类型值
     * @param key   属性名
     * @param defaultValue 默认值
     * @return      LocalDate类型属性值
     */
    @Override
    default LocalDate getLocalDate(K key, LocalDate defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
        return null;
    }

    /**
     * 获取LocalTime类型值
     * @param key   属性名
     * @param defaultValue 默认值
     * @return      LocalTime类型属性值
     */
    @Override
    default LocalTime getLocalTime(K key, LocalTime defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
        return null;
    }

    /**
     * 获取LocalDateTime类型值
     * @param key   属性名
     * @param defaultValue 默认值
     * @return      LocalDateTime类型属性值
     */
    @Override
    default LocalDateTime getLocalDateTime(K key, LocalDateTime defaultValue) {
        final Object obj = getObject(key);
        if(null == obj) {
            return defaultValue;
        }
        return null;
    }
}
