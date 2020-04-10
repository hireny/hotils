package org.hotilsframework.core.objects;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: LocalObjectPools
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:18
 * @Description: TODO   这个是线程私有对象池实现
 */
public class LocalObjectPools<T> extends AbstractObjectPools<T> {

    private ThreadLocal<Deque<T>> objects = null;
    private ObjectFactory<T> objectFactory = null;
    /**
     * 这个是每个线程私有对象池的大小，而不是整个对象池的大小
     */
    private int localSize;

    /**
     * 构造私有对象池
     * @param objectFactory
     * @param size
     */
    public LocalObjectPools(ObjectFactory<T> objectFactory, int size) {
        this(objectFactory, size, new DefaultValidator<T>());
    }

    public LocalObjectPools(ObjectFactory<T> objectFactory, int size, Validator<T> validator) {
        super();
        this.objectFactory = objectFactory;
        this.validator = validator;
        this.localSize = size;
        objects = new ThreadLocal<>();
    }

    /**
     * 获取对象
     * @return
     */
    @Override
    public T get() {
        // 检查对象池是否已经被关闭
        checkClose();
        Deque<T> localObjects = objects.get();
        if (null == localObjects) {
            localObjects = new ArrayDeque<>(localSize);
            objects.set(localObjects);
            return create();
        }
        T object = localObjects.pollFirst();
        return null == object ? create() : object;
    }

    @Override
    protected void returnPool(T t) {
        Deque<T> localObjects = objects.get();
        if (null == localObjects) {
            localObjects = new ArrayDeque<>(localSize);
            objects.set(localObjects);
        }
        if (localSize == localObjects.size()) {
            abandonObject(t);
            return;
        }
        localObjects.offerLast(t);
    }

    public int getLocalSize() {
        return localSize;
    }

    protected void abandonObject(T t) {

    }

    /**
     * 创建对象资源
     * @return
     */
    protected T create() {
        return objectFactory.create();
    }

    /**
     * 关闭资源
     * @throws IOException
     */
    @Override
    protected void closeResource() throws IOException {
        super.closeResource();
        objects = null;
        objectFactory = null;
    }
}
