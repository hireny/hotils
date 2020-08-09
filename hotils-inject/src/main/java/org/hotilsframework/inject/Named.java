package org.hotilsframework.inject;

import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Named注解相当于Spring中的@Component注解
 * @author hireny
 * @className Named
 * @create 2020-04-01 20:14
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Named {
    String value() default "";
}
