package org.aopalliance.intercept;

import java.lang.reflect.AccessibleObject;

/**
 * @ClassName: Joinpoint
 * @Author: hireny
 * @Date: Create in 2020/01/06 01:48
 * @Description: TODO   连接点
 */
public interface Joinpoint {

    /**
     * 进入链中的下一个拦截器。
     * @return
     * @throws Throwable
     */
    Object proceed() throws Throwable;

    /**
     * 返回保存当前连接点静态部分的对象
     * @return
     */
    Object getThis();

    /**
     * 返回此连接点的静态部分
     * @return
     */
    AccessibleObject getStaticPart();
}
