package me.hireny.commons.pools;

import java.io.IOException;

/**
 * @ClassName: DefaultObjectPools
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:29
 * @Description: TODO   这个是默认的对象池实现
 * 空闲池是LocalObjectPools
 * 废弃池是WeakReferencePools
 */
public class DefaultObjectPools<T> extends LocalObjectPools<T> implements ObjectPools<T> {

    private ObjectPools<T> abandonePools = null;


    public DefaultObjectPools(ObjectFactory<T> objectFactory, int size) {
        this(objectFactory, size, new DefaultValidator<>());
    }

    public DefaultObjectPools(ObjectFactory<T> objectFactory, int size, Validator<T> validator) {
        this(objectFactory, size, size, validator);
    }

    public DefaultObjectPools(ObjectFactory<T> objectFactory, int size, int abandoneSize, Validator<T> validator) {
        super(objectFactory, size, validator);
        this.abandonePools = new WeakReferencePools<>(abandoneSize);
    }

    @Override
    protected void abandonObject(T t) {
        abandonePools.release(t);
    }

    @Override
    protected T create() {
        T object = abandonePools.get();
        return null == object ? super.create() : object;
    }

    @Override
    protected void closeResource() throws IOException {
        super.closeResource();
        abandonePools.close();
        abandonePools = null;
    }
}
