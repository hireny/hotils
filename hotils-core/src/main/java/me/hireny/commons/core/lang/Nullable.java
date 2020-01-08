package me.hireny.commons.core.lang;

import java.lang.annotation.*;

/**
 * @ClassName: Nullable
 * @Author: hireny
 * @Date: Create in 2020/01/05 23:58
 * @Description: TODO   为空注解
 */
@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Nullable {
}
