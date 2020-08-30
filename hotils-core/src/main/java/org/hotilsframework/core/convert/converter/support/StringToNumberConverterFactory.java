package org.hotilsframework.core.convert.converter.support;

import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.core.convert.converter.ConverterFactory;
import org.hotilsframework.lang.NumberUtils;

/**
 * @author hireny
 * @className StringToNumberConverter
 * @create 2020-02-22 14:09
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

    /**
     * 获取一个转换目标为 {@code targetType} 类型的转换器
     * @param targetType
     * @param <T>
     * @return
     */
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumberConverter<>(targetType);
    }

    private static final class StringToNumberConverter<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        public StringToNumberConverter(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }
}
