package org.hotilsframework.core.convert;

/**
 * 转换器没有找到异常
 * @ClassName: ConverterNotFoundException
 * @Author: hireny
 * @Date: Created in 2020-02-06 23:49
 * @Version: 1.0
 */
public class ConverterNotFoundException extends ConversionException {
    private static final long serialVersionUID = 1431604233074958795L;
    /**
     * 来源类型描述
     */
    private final TypeDescriptor sourceType;
    /**
     * 目标类型描述
     */
    private final TypeDescriptor targetType;


    public ConverterNotFoundException(TypeDescriptor sourceType,
                                      TypeDescriptor targetType) {
        super("No converter found capable of converting from type [" + sourceType + "] to type [" + targetType + "]");
        this.sourceType = sourceType;
        this.targetType = targetType;
    }

    public TypeDescriptor getSourceType() {
        return this.sourceType;
    }

    public TypeDescriptor getTargetType() {
        return this.targetType;
    }
}
