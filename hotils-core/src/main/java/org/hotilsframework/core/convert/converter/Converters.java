package org.hotilsframework.core.convert.converter;

/**
 * @author hireny
 * @className Converters
 * @create 2020-07-06 12:30
 */

import org.hotilsframework.core.convert.TypeDescriptor;
import org.hotilsframework.lang.Entry;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

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
    private final Set<GenericConverter>                              globalConverters = new LinkedHashSet<>();
    /**
     * 根据键值对获取相对应的所有转换器
     */
    private final Map<Entry<Class<?>, Class<?>>, InternalConverters> converters       = new LinkedHashMap<>();

    public void add(GenericConverter converter) {
        Set<Entry<Class<?>, Class<?>>> convertibleTypes = converter.getConvertibleTypes();
        if (convertibleTypes == null) {
            this.globalConverters.add(converter);
        } else {
            for (Entry<Class<?>, Class<?>> entry : convertibleTypes) {
                InternalConverters internalConverters = getMatchableConverters(entry);
                internalConverters.add(converter);
            }
        }
    }

    /**
     * 是否存在
     * @param entry
     * @return
     */
    public boolean contains(Entry<Class<?>, Class<?>> entry) {
        return this.converters.containsKey(entry);
    }

    private InternalConverters getMatchableConverters(Entry<Class<?>, Class<?>> entry) {
        InternalConverters internalConverters = this.converters.get(entry);
        if (internalConverters == null) {
            internalConverters = new Converters.InternalConverters();
            this.converters.put(entry, internalConverters);
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
