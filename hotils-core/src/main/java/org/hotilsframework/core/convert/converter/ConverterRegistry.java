package org.hotilsframework.core.convert.converter;

/**
 * 转换器注册
 * @author hireny
 * @className ConverterRegistry
 * @create 2020-02-22 13:20
 */
public interface ConverterRegistry {
    /**
     * 添加一个转换器
     * @param converter
     */
    void addConverter(Converter<?, ?> converter);

    /**
     * 删除从源类转换到目标类的所有转换器
     * @param sourceType
     * @param targetType
     */
    void removeConvertible(Class<?> sourceType, Class<?> targetType);
}
