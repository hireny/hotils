package org.hotilsframework.core.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

/**
 * 方法参数类
 * @ClassName: MethodParameter
 * @Author: hireny
 * @Date: Created in 2020-02-06 22:45
 * @Version: 1.0
 */
public class MethodParameter {

    /**
     * 参数位置
     */
    private int parameterIndex;
    /**
     * 参数类型
     */
    private Class<?> parameterType;
    /**
     * 方法参数
     */
    private Parameter parameter;
    /**
     * 参数注解
     */
    private Annotation[] parameterAnnotations;
    /**
     * 参数名
     */
    private String parameterName;
    /**
     * 嵌套的方法参数
     */
    private MethodParameter nestedMethodParameter;
}
