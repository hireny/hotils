package org.hotilsframework.core.objects;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: WeakReferencePools
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:30
 * @Description: TODO   这个弱引用的对象池实现,目的是用来存储被线程私有对象池丢弃的对象
 *
 * 在线程私有对象池没有对象可取时,可以从这个弱引用对象池里拿
 * 这个是线程共享的.
 * 不保证可以返回对象
 *  *
 * 我觉得可以试一下用反射,不要每次都要new WeakReference,代价太大
 * 经过试验,WeakReference只能被回收一次,但是如果null == referent,就不会被回收
 * 搞得太复杂,算了
 */
public class WeakReferencePools<T> extends AbstractObjectPools<T> implements ObjectPools<T> {

    private int size;

    private Entry<T>[] objects = null;

    //cpu核数,用于自旋
    static final int MAX_SCAN_RETRIES =
            Runtime.getRuntime().availableProcessors();

    public WeakReferencePools(int size) {
        this(size, new DefaultValidator<>());
    }

    public WeakReferencePools(int size, Validator<T> validator) {
        super();
        this.size = size;
        this.validator = validator;
        initObjects();
    }

    private void initObjects() {
        objects = (Entry<T>[]) new Entry[size];
        for (int i = 0, len = objects.length; i < len; i++) {
            objects[i] = new Entry<>();
        }
    }

    /**
     * 获取对象
     * @return
     */
    @Override
    public T get() {
        checkClose();
        return objects[getIndex()].get();
    }

    @Override
    protected void returnPool(T t) {
        objects[getIndex()].set(t);
    }

    @Override
    protected void closeResource() throws IOException {
        super.closeResource();
        objects = null;
    }

    private int getIndex() {
        return ThreadLocalRandom.current().nextInt(size);
    }

    @SuppressWarnings({"serial"})
    static class Entry<T> extends ReentrantLock {
        WeakReference<T> reference = new WeakReference<>(null);

        void set(T t) {
            int count = MAX_SCAN_RETRIES;
            while (--count >= 0) {
                if (tryLock()) {
                    try {
                        setReference(t);
                        return;
                    } finally {
                        unlock();
                    }
                }
            }
        }

        T get() {
            int count = MAX_SCAN_RETRIES;
            while (--count >= 0) {
                if (tryLock()) {
                    try {
                        T t = getReference();
                        return t;
                    } finally {
                        unlock();
                    }
                }
            }
            return null;
        }

        private T getReference() {
            T t = reference.get();
            reference.clear();
            return t;
        }

        private void setReference(T t) {
            reference = null == reference.get() ?
                    new WeakReference<>(t) : reference;
        }
    }
}
