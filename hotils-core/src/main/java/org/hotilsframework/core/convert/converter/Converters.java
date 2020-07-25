package org.hotilsframework.core.convert.converter;

/**
 * @author hireny
 * @className Converters
 * @create 2020-07-06 12:30
 */

import org.hotilsframework.core.convert.TypeDescriptor;
import org.hotilsframework.lang.KeyValue;

import java.util.*;

/**
 * 管理在服务中注册的所有的转换器
 * @author hireny
 * @className Converters
 * @create 2020-07-04 10:02
 */
public class Converters {
    /**
     * 存储所有通用的转换器
     */
    private final Set<GenericConverter>                                 globalConverters = new LinkedHashSet<>();
    /**
     * 根据键值对获取相对应的所有转换器
     */
    private final Map<KeyValue<Class<?>, Class<?>>, InternalConverters> converters       = new LinkedHashMap<>();

    public void add(GenericConverter converter) {
        Set<KeyValue<Class<?>, Class<?>>> convertibleTypes = converter.getConvertibleTypes();
        if (convertibleTypes == null) {
            this.globalConverters.add(converter);
        } else {
            for (KeyValue<Class<?>, Class<?>> keyValue : convertibleTypes) {
                InternalConverters internalConverters = getMatchableConverters(keyValue);
                internalConverters.add(converter);
            }
        }
    }

    /**
     * 是否存在
     * @param keyValue
     * @return
     */
    public boolean contains(KeyValue<Class<?>, Class<?>> keyValue) {
        return this.converters.containsKey(keyValue);
    }

    private InternalConverters getMatchableConverters(KeyValue<Class<?>, Class<?>> keyValue) {
        InternalConverters internalConverters = this.converters.get(keyValue);
        if (internalConverters == null) {
            internalConverters = new Converters.InternalConverters();
            this.converters.put(keyValue, internalConverters);
        }
        return internalConverters;
    }

    /**
     * 内部的转换器存储
     */
    private static class InternalConverters {
        private final LinkedList<GenericConverter> converters = new LinkedList<>();

        public void add(GenericConverter converter) {
            this.converters.addFirst(converter);
        }

        /**
         * 获取转换器
         * @param sourceType
         * @param targetType
         * @return
         */
        public GenericConverter getConverter(TypeDescriptor sourceType, TypeDescriptor targetType) {
            for (GenericConverter converter : this.converters) {
                return converter;
            }
            return null;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
