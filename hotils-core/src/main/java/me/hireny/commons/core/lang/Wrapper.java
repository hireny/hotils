package me.hireny.commons.core.lang;

/**
 * @ClassName: Wrapper
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:37
 * @Description: TODO   包装器类，用于标注被该接口实现的类都是包装器类
 */
public interface Wrapper {
    /**
     * 获取目标对象
     * @param <T>
     * @return
     */
    <T> T getTarget();

    /**
     * 获取目标类
     * @param <T>
     * @return
     */
    <T> Class<T> getTargetClass();
}
