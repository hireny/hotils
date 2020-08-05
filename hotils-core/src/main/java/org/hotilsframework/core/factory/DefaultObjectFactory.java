package org.hotilsframework.core.factory;

import java.io.IOException;

/**
 * DefaultObjectFactory
 * 类描述
 *
 * @author hireny
 * @create 2020-08-06 0:08
 */
public class DefaultObjectFactory extends LocalObjectFactory {

    private ObjectRegistry abandonePools = null;


    public DefaultObjectFactory(ObjectFactory objectFactory, int size) {
        this(objectFactory, size, new DefaultValidator());
    }

    public DefaultObjectFactory(ObjectFactory objectFactory, int size, Validator validator) {
        this(objectFactory, size, size, validator);
    }

    public DefaultObjectFactory(ObjectFactory objectFactory, int size, int abandoneSize, Validator validator) {
        super(objectFactory, size, validator);
        this.abandonePools = new WeakReferenceFactory<>(abandoneSize);
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
    protected void closeResource() throws IOException {
        super.closeResource();
        abandonePools.close();
        abandonePools = null;
    }
}
