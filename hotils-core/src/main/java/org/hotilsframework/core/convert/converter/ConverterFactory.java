package org.hotilsframework.core.convert.converter;

/**
 * @ClassName: ConverterFactory
 * @Author: hireny
 * @Date: Create in 2019/12/25 16:02
 * @Description: TODO   转换器工厂
 */
public interface ConverterFactory<S, R> {

    /**
     * 获取从S转换为T的转换器，T是R的一个实例
     * @param targetType
     * @param <T>
     * @return
     */
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
