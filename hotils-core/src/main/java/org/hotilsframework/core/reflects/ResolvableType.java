package org.hotilsframework.core.reflects;


import java.lang.reflect.Type;

/**
 * ResolvableType类是封装了 Type({@link Type})，提供了对Type的操作
 * @Author: hireny
 * @Date: Create in 2019/10/31 10:52
 */
public class ResolvableType {

    /**
     * 需要解析的JDK Type 类型
     */
//    private final Type type;

//    private final TypeWrapper.TypeProvider typeProvider;
//
//    /**
//     * 用于解析 {@link java.lang.reflect.TypeVariable} 的接口
//     */
//    interface VariableResolver extends Serializable {
//
//        Object getSource();
//
//        ResolvableType resolveVariable(TypeVariable<?> variable);
//    }
//
//    private static class DefaultVariableResolver implements VariableResolver {
//        private final ResolvableType source;
//
//        DefaultVariableResolver(ResolvableType resolvableType) {
//            this.source = resolvableType;
//        }
//
//        @Override
//        public ResolvableType resolveVariable(TypeVariable<?> variable) {
//            return this.source.resolveVariable(variable);
//        }
//
//        @Override
//        public Object getSource() {
//            return this.source;
//        }
//    }
}
