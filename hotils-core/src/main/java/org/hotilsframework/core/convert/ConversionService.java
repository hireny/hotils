package org.hotilsframework.core.convert;

/**
 * ConversionService
 * 转换器服务
 * @Author: hireny
 * @Date: Create in 2019/10/04 00:29
 */
public interface ConversionService {

    /**
     * 是否能转换
     * @param sourceType
     * @param targetType
     * @return
     */
    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    /**
     * 转换
     * @param source        源对象
     * @param targetType    目标类型
     * @param <T>           目标泛型
     * @return              目标对象
     */
    <T> T convert(Object source, Class<T> targetType);

    /**
     * 转换
     * @param source        源对象
     * @param sourceType    源对象的类型描述
     * @param targetType    目标对象的类型描述
     * @return              目标对象
     */
    Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType);
}
