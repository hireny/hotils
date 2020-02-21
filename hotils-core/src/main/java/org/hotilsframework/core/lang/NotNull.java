package org.hotilsframework.core.lang;

import java.lang.annotation.*;

/**
 * @ClassName: NotNull
 * @Author: hireny
 * @Date: Create in 2020/01/05 23:58
 * @Description: TODO   不为空注解
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
}
