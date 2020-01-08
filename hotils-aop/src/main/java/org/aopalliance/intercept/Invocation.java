package org.aopalliance.intercept;

/**
 * @ClassName: Invocation
 * @Author: hireny
 * @Date: Create in 2020/01/06 01:50
 * @Description: TODO
 */
public interface Invocation extends Joinpoint {

    /**
     * 将参数作为数组对象获取。
     *
     * 可以通过改变数组中的元素值来改变参数
     *
     * @return
     */
    Object[] getArguments();
}
