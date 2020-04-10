package org.hotilsframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author hireny
 * @className DynamicIntroductionAdvice
 * @create 2020-04-09 20:58
 */
public interface DynamicIntroductionAdvice extends Advice {
    /**
     * 判断是否实现了该接口
     * @param intf
     * @return
     */
    boolean implementsInterface(Class<?> intf);
}
