package org.hotilsframework.core.convert;

import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.core.convert.converter.Converters;
import org.hotilsframework.core.convert.converter.GenericConverter;
import org.hotilsframework.lang.Entry;

import java.util.*;

/**
 * 通用的转换服务
 * @author hireny
 * @className GenericConversionService
 * @create 2020-07-04 9:34
 */
public class GenericConversionService implements ConfigurableConversionService {
    /**
     * 一般是在无操作转换时使用，因为转换是不需要的。
     */
    private static final GenericConverter NO_OP_CONVERTER = new NoOpConverter("NO_OP");
    /**
     * 当没有转换器可用时作为缓存项
     * 这个转换器永远不会返回
     */
    private static final GenericConverter NO_MATCH_CONVERTER = new NoOpConverter("NO_MATCH");

    private Converters converters = new Converters();

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return converters.contains(new Entry<>(sourceType, targetType));
    }

    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        return (T) convert(source, new TypeDescriptor(source), new TypeDescriptor(targetType));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

        return null;
    }

    @Override
    public void addConverter(Converter<?, ?> converter) {

    }

    @Override
    public void removeConvertible(Class<?> sourceType, Class<?> targetType) {

    }




    /**
     * Internal converter that performs no operation.
     * 内部转换器，不执行任何操作
     */
    private static class NoOpConverter implements GenericConverter {
        /**
         * 转换器名称
         */
        private final String name;

        private NoOpConverter(String name) {
            this.name = name;
        }

        @Override
        public Set<Entry<Class<?>, Class<?>>> getConvertibleTypes() {
            return null;
        }

        @Override
        public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
            return source;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
