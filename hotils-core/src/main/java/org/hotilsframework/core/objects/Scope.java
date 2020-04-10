package org.hotilsframework.core.objects;

import java.lang.annotation.*;

/**
 * @author hireny
 * @className Scope
 * @create 2020-04-08 9:59
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    /**
     * 指定带注解的类的实例的使用范围
     * @return
     */
    String value() default "";
}
