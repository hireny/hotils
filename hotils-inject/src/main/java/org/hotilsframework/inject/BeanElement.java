package org.hotilsframework.inject;

import org.hotilsframework.lang.Element;

/**
 * BeanElement
 *
 * Bean元素
 *
 * @author hireny
 * @create 2020-08-02 20:58
 */
public interface BeanElement extends Element {

    /**
     * Writes this module element to the given binder (optional operation).
     *
     * 将此模块元素写入绑定器
     * @param binder
     */
    void applyTo(Binder binder);
}
