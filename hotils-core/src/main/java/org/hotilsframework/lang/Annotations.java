package org.hotilsframework.lang;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * Annotations
 * TODO   注解工具类
 * @author hireny
 * @ate Created in 2020-01-08 8:32
 * @since 1.0
 */
public class Annotations {
    /**
     * Constant indicating an zero annotation.
     *
     * 常量，指示零个注解
     */
    public static final Annotation[] ZERO_ANNOTATIONS = new Annotation[0];
    /**
     * Constant indicating an zero annotation.
     *
     * 常量，指示零个注解元素
     */
    public static final AnnotatedElement[] ZERO_ANNOTATION_ELEMENTS = new AnnotatedElement[0];

    private Annotations() {}

    /**
     * 根据函数的入参及参数注解，将存在注解的参数拼接成字符串作为KEY
     * @param method
     * @param args
     * @param annotationClass
     * @param <T>
     * @return
     */
    public static <T> String paramToKey(Method method, Object[] args, Class<T> annotationClass) {
        StringBuilder stringBuilder = new StringBuilder();
        Annotation[][] paramAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < paramAnnotations.length; i++) {
            Annotation[] annotations = paramAnnotations[i];
            if (annotations.length > 0) {
                for (int j = 0; j < annotations.length; j++) {
                    if (annotations[j].annotationType().equals(annotationClass)) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append(":");
                        }
                        stringBuilder.append(args[i]);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
