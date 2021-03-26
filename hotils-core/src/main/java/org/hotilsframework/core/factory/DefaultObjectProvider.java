package org.hotilsframework.core.factory;

import java.io.IOException;

/**
 * DefaultObjectFactory
 * 类描述
 *
 * @author hireny
 * @create 2020-08-06 0:08
 */
public class DefaultObjectProvider extends LocalObjectProvider {

    private ObjectRegistry abandonePools = null;


    public DefaultObjectProvider(ObjectProvider objectProvider, int size) {
        this(objectProvider, size, new DefaultValidator());
    }

    public DefaultObjectProvider(ObjectProvider objectProvider, int size, Validator validator) {
        this(objectProvider, size, size, validator);
    }

    public DefaultObjectProvider(ObjectProvider objectProvider, int size, int abandoneSize, Validator validator) {
        super(objectProvider, size, validator);
        this.abandonePools = new WeakReferenceProvider<>(abandoneSize);
    }

    @Override
    protected void abandonObject(Object t) {
        abandonePools.release(t);
    }

    @Override
    public Object register() {
        Object object = abandonePools.register();
        return null == object ? super.register() : object;
    }

    @Override
    protected void closeResource() throws Exception {
        super.closeResource();
        abandonePools.close();
        abandonePools = null;
    }
}
