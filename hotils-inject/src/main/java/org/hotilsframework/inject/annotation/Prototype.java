package org.hotilsframework.inject.annotation;

import javax.inject.Scope;
import java.lang.annotation.*;

/**
 * Prototype
 * 原型作用域
 *
 * @author hireny
 * @create 2020-08-04 23:51
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Prototype {
}
