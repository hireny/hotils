package org.hotilsframework.core.convert.converter.support;

import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.lang.NumberUtils;

/**
 * @author hireny
 * @className StringToNumberConverter
 * @create 2020-02-22 14:09
 */
public class StringToNumberConverter<T extends Number> implements Converter<String, T> {

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
