package org.hotilsframework.beans.copier;

/**
 * @ClassName: AbstractBeanCopierCreator
 * @Author: hireny
 * @Date: Created in 2020-02-05 23:55
 * @Version: 1.0
 */
public abstract class AbstractBeanCopierCreator<S,T> implements BeanCopierCreator<S,T> {

    protected final BeanMapper<S,T> beanMapper;

    protected AbstractBeanCopierCreator(BeanMapper<S, T> beanMapper) {
        this.beanMapper = beanMapper;
    }
}
