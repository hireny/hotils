package org.hotilsframework.inject;

import org.hotilsframework.inject.support.DefaultBeanIdentifier;

import java.io.Serializable;

/**
 * BeanIdentifier
 *
 * Bean的身份唯一性描述
 *
 * @author hireny
 * @create 2020-08-11 23:58
 */
public interface BeanIdentifier extends CharSequence, Serializable {
    /**
     * 身份名称
     * @return
     */
    String getName();

    static BeanIdentifier of(String identifier) {
        return new DefaultBeanIdentifier(identifier);
    }
}
