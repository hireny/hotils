package org.hotilsframework.lang;

import org.hotilsframework.core.collection.ImmutableList;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MethodDefinition
 * @Description: TODO   方法定义
 * @Author: hireny
 * @Date: Created in 2020-01-10 1:33
 * @Version: 1.0
 */
public interface MethodDefinition {

    String getName();

    Class<?> getReturnType();

    int getModifiers();

    <T extends Annotation> T getAnnotation(Class<T> annotationClass);

    /**
     * 获取参数类型
     * @return
     */
    Class<?>[] getParameterTypes();

    int getParameterCount();

    /**
     * 获取异常类型
     * @return
     */
    Class<?>[] getExceptionTypes();

    Annotation[][] getParameterAnnotations();

    boolean isDefault();

    boolean isVarArgs();

    static MethodDefinition of(Method method) {
        return new MethodDefinition() {
            @Override
            public String getName() {
                return method.getName();
            }

            @Override
            public Class<?> getReturnType() {
                return method.getReturnType();
            }

            @Override
            public int getModifiers() {
                return method.getModifiers();
            }

            @Override
            public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
                return method.getAnnotation(annotationClass);
            }

            @Override
            public Class<?>[] getParameterTypes() {
                return method.getParameterTypes();
            }

            @Override
            public int getParameterCount() {
                return method.getParameterCount();
            }

            @Override
            public Class<?>[] getExceptionTypes() {
                return method.getExceptionTypes();
            }

            @Override
            public Annotation[][] getParameterAnnotations() {
                return method.getParameterAnnotations();
            }

            @Override
            public boolean isDefault() {
                return method.isDefault();
            }

            @Override
            public boolean isVarArgs() {
                return method.isVarArgs();
            }

            @Override
            public String toString() {
                Map<String, Object> helper = new HashMap<>();
                helper.put("name", getName());
                helper.put("returnType", getReturnType());
                helper.put("modifiers", getModifiers());
                helper.put("Annotations", ImmutableList.of(method.getAnnotations()));
                helper.put("method", method);
                return super.toString() + helper.toString();
            }
        };
    }
}
