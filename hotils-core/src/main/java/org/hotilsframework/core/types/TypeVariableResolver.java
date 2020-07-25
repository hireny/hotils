package org.hotilsframework.core.types;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * TypeVariableResolver
 *
 * An interface for types that hold and can resolve type variables.
 * 类型变量解析器
 *
 * 用于保存和解析类型变量的接口
 *
 * @author hireny
 * @create 2020-07-07 11:01
 * @since 0.0.1
 */
public interface TypeVariableResolver {

    /**
     * 获取参数的类型参数的映射
     * @return  Obtain a map of the type parameters for the argument
     */
    default Map<String, Argument<?>> getTypeVariables() {
        return Collections.emptyMap();
    }

    /**
     * 获取参数作为数组
     * @return  The type parameters as an array
     */
    default Argument[] getTypeParameters() {
        Collection<Argument<?>> values = getTypeVariables().values();
        return values.toArray(Argument.ZERO_ARGUMENTS);
    }

    /**
     * 如果存在，获取第一个类型参数
     * @return  Return the first type parameter if it is present
     */
    default Optional<Argument<?>> getFirstTypeVariable() {
        return getTypeVariables().values().stream().findFirst();
    }

    /**
     * 如果存在，根据 {@code name} 查询类型参数
     * @param name
     * @return  Return the first type parameter if it is present
     */
    default Optional<Argument<?>> getTypeVariable(String name) {
        Argument<?> argument = getTypeVariables().get(name);
        return argument != null ? Optional.of(argument) : Optional.empty();
    }
}
