package org.hotilsframework.lang.reflect;

/**
 * 复合型类型
 *
 * 由其它类型（如数组、参数化类型或通配符类型）组成的类型
 * @author hireny
 * @className CompositeType
 * @create 2020-06-08 11:07
 */
public interface CompositeType {

    boolean isFullySpecified();
}
