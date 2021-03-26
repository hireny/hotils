package org.hotilsframework.core.convert.converter;

import org.hotilsframework.core.convert.TypeDescriptor;
import org.hotilsframework.lang.Entry;

import java.util.Set;

/**
 * 通用的转换器接口
 * @author hireny
 * @className GenericConverter
 * @create 2020-07-04 9:38
 */
public interface GenericConverter {
    /**
     * 获取所有的转换类型
     *
     * <p>该转换类型是每一个元素都是 source-target 这样的转换对</p>
     * @return
     */
    Set<Entry<Class<?>, Class<?>>> getConvertibleTypes();

    /**
     * 将 source 对象转换为 targetType 描述的类型的目标对象
     * @param source
     * @param sourceType
     * @param targetType
     * @return
     */
    Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType);
}
