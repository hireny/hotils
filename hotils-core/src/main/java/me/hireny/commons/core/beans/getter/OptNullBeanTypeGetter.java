package me.hireny.commons.core.beans.getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @ClassName: OptNullBeanTypeGetter
 * @Author: hireny
 * @Date: Create in 2019/12/09 00:31
 * @Description: TODO   基本类型的getter接口抽象实现
 * 提供一个统一的接口定义返回不同类型的值（基本类型）<br>
 * 在不提供默认值的情况下， 如果值不存在或获取错误，返回null<br>
 * 用户只需实现{@link OptBeanTypeGetter}接口即可
 */
public interface OptNullBeanTypeGetter<K> extends BeanTypeGetter<K>, OptBeanTypeGetter<K> {

    @Override
    default Object getObject(K key) {
        return getObject(key, null);
    }

    /**
     * 获取字符串型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default String getString(K key){
        return this.getString(key, null);
    }

    /**
     * 获取int型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Integer getInt(K key) {
        return this.getInt(key, null);
    }

    /**
     * 获取short型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Short getShort(K key){
        return this.getShort(key, null);
    }

    /**
     * 获取boolean型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Boolean getBoolean(K key){
        return this.getBoolean(key, null);
    }

    /**
     * 获取long型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Long getLong(K key){
        return this.getLong(key, null);
    }

    /**
     * 获取char型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Character getChar(K key){
        return this.getChar(key, null);
    }

    /**
     * 获取float型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Float getFloat(K key){
        return this.getFloat(key, null);
    }

    /**
     * 获取double型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Double getDouble(K key){
        return this.getDouble(key, null);
    }

    /**
     * 获取byte型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Byte getByte(K key){
        return this.getByte(key, null);
    }

    /**
     * 获取BigDecimal型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default BigDecimal getBigDecimal(K key){
        return this.getBigDecimal(key, null);
    }

    /**
     * 获取BigInteger型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default BigInteger getBigInteger(K key){
        return this.getBigInteger(key, null);
    }

    /**
     * 获取Enum型属性值<br>
     * 无值或获取错误返回null
     *
     * @param clazz Enum 的 Class
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default <E extends Enum<E>> E getEnum(Class<E> clazz, K key) {
        return this.getEnum(clazz, key, null);
    }

    /**
     * 获取Date型属性值<br>
     * 无值或获取错误返回null
     *
     * @param key 属性名
     * @return 属性值
     */
    @Override
    default Date getDate(K key) {
        return this.getDate(key, null);
    }

    /**
     * 获取LocalDate类型值
     * @param key   属性名
     * @return      LocalDate类型属性值
     */
    @Override
    default LocalDate getLocalDate(K key) {
        return this.getLocalDate(key, null);
    }

    /**
     * 获取LocalTime类型值
     * @param key   属性名
     * @return      LocalTime类型属性值
     */
    @Override
    default LocalTime getLocalTime(K key) {
        return this.getLocalTime(key, null);
    }

    /**
     * 获取LocalDateTime类型值
     * @param key   属性名
     * @return      LocalDateTime类型属性值
     */
    @Override
    default LocalDateTime getLocalDateTime(K key) {
        return this.getLocalDateTime(key, null);
    }
}
