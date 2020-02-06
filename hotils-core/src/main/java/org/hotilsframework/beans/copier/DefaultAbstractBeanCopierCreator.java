package org.hotilsframework.beans.copier;

import org.hotilsframework.utils.Assert;

/**
 * @ClassName: DefaultAbstractBeanCopierCreator
 * @Author: hireny
 * @Date: Created in 2020-02-06 0:04
 * @Version: 1.0
 */
public class DefaultAbstractBeanCopierCreator<S,T> extends AbstractBeanCopierCreator<S,T> {

    public DefaultAbstractBeanCopierCreator(BeanMapper<S, T> beanMapper) {
        super(beanMapper);
    }

    @Override
    public S copy(S source) {
        return null;
    }

    @Override
    public T copy(S source, T target) {
        Assert.checkNotNull(source, "source must not be null.");
        Assert.checkNotNull(target, "target must not be null.");
        return null;
    }
}
