package org.hotilsframework.core.factory;

/**
 * @ClassName: Validator
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:08
 * @Description: TODO   对象的验证器
 */
public interface Validator {
    /**
     * 对象是否有效
     * @param o
     * @return
     */
    boolean isValid(Object o);

    /**
     * 使对象无效
     * @param o     需要无效的对象
     */
    void invalidate(Object o);
}
