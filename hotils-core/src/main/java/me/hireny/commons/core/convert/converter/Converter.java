package me.hireny.commons.core.convert.converter;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/04 00:32
 */
@FunctionalInterface
public interface Converter<S,T> {
    /**
     * 将类型的源对象转换为目标类型
     * @param source    类型的源对象
     * @return          目标的类型
     */
    T convert(S source);
}
