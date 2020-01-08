package me.hireny.commons.core.lang;

import java.lang.annotation.*;

/**
 * @ClassName: NotNull
 * @Author: hireny
 * @Date: Create in 2020/01/05 23:58
 * @Description: TODO   不为空注解
 */
@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {
}
