package org.hotilsframework.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ScopeAnnotation
 * 类描述
 *
 * @author hireny
 * @create 2020-07-26 23:54
 */
@Target(ANNOTATION_TYPE)
@Retention(RUNTIME)
public @interface ScopeAnnotation {
}
