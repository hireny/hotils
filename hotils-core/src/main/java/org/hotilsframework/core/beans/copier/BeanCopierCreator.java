package org.hotilsframework.core.beans.copier;

/**
 * @ClassName: BeanCopierCreator
 * @Author: hireny
 * @Date: Created in 2020-02-05 23:44
 * @Version: 1.0
 */
public interface BeanCopierCreator<T> {

    /**
     * 复制原对象，返回新对象
     * @param source    原对象
     * @return          新目标对象
     */
    T copy(Object source);
}
