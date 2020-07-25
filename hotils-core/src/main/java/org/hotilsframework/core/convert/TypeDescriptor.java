package org.hotilsframework.core.convert;

/**
 * TypeDescriptor
 * 有关要转换的类型的上下文(就是对要进行转换类型的目标进行包装，使得获取该对象更方便)
 * @Author: hireny
 * @Date: Create in 2019/10/04 00:34
 */
public class TypeDescriptor {

    private final Object source;

    private final Class<?> sourceType;

    TypeDescriptor(Object source) {
        this(source, source.getClass());
    }

    TypeDescriptor(Class<?> sourceType) {
        this(null, sourceType);
    }

    TypeDescriptor(Object source, Class<?> sourceType) {
        this.source = source;
        this.sourceType = sourceType;
    }
}
