package org.aopalliance.intercept;

import java.lang.reflect.Constructor;

/**
 * @author hireny
 * @className ConstructorInvocation
 * @create 2020-04-09 20:17
 */
public interface ConstructorInvocation extends Invocation {

    /**
     * 获取被调用的构造函数
     * 该方法 与 {@link Joinpoint#getStaticPart()} 方法相同
     *
     * @return      被调用的构造函数
     */
    Constructor<?> getConstructor();
}
