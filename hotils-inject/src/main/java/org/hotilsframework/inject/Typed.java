package org.hotilsframework.inject;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Typed
 *
 * 按类型装配
 *
 * @author hireny
 * @create 2020-08-08 0:00
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Typed {
    /**
     * 类型数组
     * @return
     */
    Class<?>[] value();
}
