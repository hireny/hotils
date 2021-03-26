package org.hotilsframework.core;

/**
 * AnnotatedMetaData
 *
 * 注解元数据
 *
 * @author hireny
 * @create 2020-09-14 0:05
 */
public interface AnnotatedMetaData {
    /**
     *
     * @return  获取注解元数据
     */
    AnnotatedMetaData getAnnotatedMetaData();

    /**
     * 是否为原生类型
     * @param annotation
     * @return
     */
    boolean hasDeclaredStereotype(String annotation);
}
