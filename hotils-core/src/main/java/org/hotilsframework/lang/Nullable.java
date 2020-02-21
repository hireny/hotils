package org.hotilsframework.lang;

import java.lang.annotation.*;

/**
 * @ClassName: Nullable
 * @Author: hireny
 * @Date: Create in 2020/01/05 23:58
 * @Description: TODO   为空注解
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Nullable {
}
