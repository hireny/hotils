package org.hotilsframework.core.pools;

/**
 * @ClassName: Validator
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:08
 * @Description: TODO   对象的验证器
 */
public interface Validator<T> {
    /**
     * 对象是否有效
     * @param t
     * @return
     */
    boolean isValid(T t);

    /**
     * 使对象无效
     * @param t     需要无效的对象
     */
    void invalidate(T t);
}
