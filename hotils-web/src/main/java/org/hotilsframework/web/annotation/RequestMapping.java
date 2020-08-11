package org.hotilsframework.web.annotation;

import org.hotilsframework.http.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * HTTP请求路径
 * @author hireny
 * @className RequestMapping
 * @create 2020-05-15 22:24
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    /**
     * 请求路径
     * @return
     */
    String value() default "";

    /**
     * 请求方法
     * @return
     */
    RequestMethod method() default RequestMethod.GET;
}
