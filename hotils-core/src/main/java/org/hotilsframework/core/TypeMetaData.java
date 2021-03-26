package org.hotilsframework.core;

/**
 * TypeMetaData
 *
 * 类型元数据
 *
 * @author hireny
 * @create 2020-12-30 13:27
 */
public interface TypeMetaData {
    /**
     *
     * @return  获取类型元数据
     */
    TypeMetaData getTypeMetaData();

    /**
     * 是否为原生类型
     * @param type
     * @return
     */
    boolean hasDeclaredStereotype(String type);
}
