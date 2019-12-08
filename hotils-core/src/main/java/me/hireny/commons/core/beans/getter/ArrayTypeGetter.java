package me.hireny.commons.core.beans.getter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @ClassName: ArrayTypeGetter
 * @Author: hireny
 * @Date: Create in 2019/12/09 00:39
 * @Description: TODO   数组类型的Get接口
 */
public interface ArrayTypeGetter {
    /*-------------------------- 数组类型 start -------------------------------*/

    /**
     * 获取Object型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    Object[] getObjects(String key);

    /**
     * 获取String型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    String[] getStrings(String key);

    /**
     * 获取Integer型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    Integer[] getInts(String key);

    /**
     * 获取Short型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    Short[] getShorts(String key);

    /**
     * 获取Boolean型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    Boolean[] getBooleans(String key);

    /**
     * 获取Long型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    Long[] getLongs(String key);

    /**
     * 获取Character型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    Character[] getChars(String key);

    /**
     * 获取Double型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    Double[] getDoubles(String key);

    /**
     * 获取Byte型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    Byte[] getBytes(String key);

    /**
     * 获取BigInteger型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    BigInteger[] getBigIntegers(String key);

    /**
     * 获取BigDecimal型属性值数组
     *
     * @param key 属性名
     * @return 属性值列表
     */
    BigDecimal[] getBigDecimals(String key);
    /*-------------------------- 数组类型 end -------------------------------*/
}
