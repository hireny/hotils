package me.hireny.commons.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName: AnnotationUtils
 * @Description: TODO   注解工具类
 * @Author: hireny
 * @Date: Created in 2020-01-08 8:32
 * @Version: 1.0
 */
public class AnnotationUtils {

    private AnnotationUtils() {}

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
