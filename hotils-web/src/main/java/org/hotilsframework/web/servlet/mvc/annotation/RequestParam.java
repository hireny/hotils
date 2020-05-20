package org.hotilsframework.web.servlet.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求的方法参数名
 * @author hireny
 * @className RequestParam
 * @create 2020-05-15 22:25
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {
    /**
     * 方法参数别名
     * @return
     */
    String value() default "";

    /**
     * 是否必传
     * @return
     */
    boolean required() default true;
}
