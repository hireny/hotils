package org.hotilsframework.lang;

import java.io.Serializable;

/**
 * @ClassName: Wrapper
 * @Author: hireny
 * @Date: Create in 2019/12/25 15:37
 * @Description: TODO   包装器类，用于标注被该接口实现的类都是包装器类
 */
public interface Wrapper extends Serializable {
    /**
     * 获取目标对象
     *
     * @return
     */
    Object getTarget();

    /**
     * 获取目标类
     * @return
     */
    Class<?> getTargetClass();
}
