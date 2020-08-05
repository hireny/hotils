package org.hotilsframework.core.factory;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LocalObjects
 * 本地对象工厂
 *
 * @author hireny
 * @create 2020-08-06 0:01
 */
public class LocalObjectFactory extends AbstractObjectFactory {
    private ThreadLocal<Deque<Object>> objects       = null;
    private ObjectFactory              objectFactory = null;
    /**
     * 这个是每个线程私有对象池的大小，而不是整个对象池的大小
     */
    private int                   localSize;

    /**
     * 构造私有对象池
     * @param objectFactory
     * @param size
     */
    public LocalObjectFactory(ObjectFactory objectFactory, int size) {
        this(objectFactory, size, new DefaultValidator());
    }

    public LocalObjectFactory(ObjectFactory objectFactory, int size, Validator validator) {
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
    public Object get() {
        // 检查对象池是否已经被关闭
        checkClose();
        Deque<Object> localObjects = objects.get();
        if (null == localObjects) {
            localObjects = new ArrayDeque<>(localSize);
            objects.set(localObjects);
            return register();
        }
        Object object = localObjects.pollFirst();
        return null == object ? register() : object;
    }

    @Override
    protected void returnObject(Object t) {
        Deque<Object> localObjects = objects.get();
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

    protected void abandonObject(Object o) {

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

    /**
     * 创建对象资源
     * @return
     */
    @Override
    public Object register() {
        return objectFactory.get();
    }
}
