package org.hotilsframework.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Named注解相当于Spring中的@Component注解
 * @author hireny
 * @className Named
 * @create 2020-04-01 20:14
 */
@javax.inject.Named
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface Named {
    String value();
}
