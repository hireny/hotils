package me.hireny.commons.core.beans.getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @ClassName: OptNullBeanTypeFromStringGetter
 * @Author: hireny
 * @Date: Create in 2019/12/09 00:53
 * @Description: TODO   基本类型的getter接口抽象实现，所有类型的值获取都是通过将String转换而来<br>
 *  * 用户只需实现getStr方法即可，其他类型将会从String结果中转换 在不提供默认值的情况下， 如果值不存在或获取错误，返回null<br>
 */
public interface OptNullBeanTypeFromStringGetter<K> extends OptNullBeanTypeGetter<K> {

    @Override
    default Object getObject(K key, Object defaultValue) {
        return getString(key, null == defaultValue ? null : defaultValue.toString());
    }

    @Override
    default Integer getInt(K key, Integer defaultValue) {
//        return Convert.toInt(getStr(key), defaultValue);
        return null;
    }

    @Override
    default Short getShort(K key, Short defaultValue) {
        return null;
    }

    @Override
    default Boolean getBoolean(K key, Boolean defaultValue) {
        return null;
    }

    @Override
    default Long getLong(K key, Long defaultValue) {
        return null;
    }

    @Override
    default Character getChar(K key, Character defaultValue) {
        return null;
    }

    @Override
    default Float getFloat(K key, Float defaultValue) {
        return null;
    }

    @Override
    default Double getDouble(K key, Double defaultValue) {
        return null;
    }

    @Override
    default Byte getByte(K key, Byte defaultValue) {
        return null;
    }

    @Override
    default BigDecimal getBigDecimal(K key, BigDecimal defaultValue) {
        return null;
    }

    @Override
    default BigInteger getBigInteger(K key, BigInteger defaultValue) {
        return null;
    }

    @Override
    default  <E extends Enum<E>> E getEnum(Class<E> clazz, K key, E defaultValue) {
        return null;
    }

    @Override
    default Date getDate(K key, Date defaultValue) {
        return null;
    }

    @Override
    default LocalDate getLocalDate(K key, LocalDate defaultValue) {
        return null;
    }

    @Override
    default LocalTime getLocalTime(K key, LocalTime defaultValue) {
        return null;
    }

    @Override
    default LocalDateTime getLocalDateTime(K key, LocalDateTime defaultValue) {
        return null;
    }

}
