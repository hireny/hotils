package org.hotilsframework.inject;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Singleton
 * 但离作用于
 *
 * @author hireny
 * @create 2020-08-04 23:56
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Singleton {
}
