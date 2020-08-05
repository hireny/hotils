package org.hotilsframework.core.factory;


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
public class WeakReferenceFactory<T> extends AbstractObjectFactory implements ObjectRegistry {

    private int size;

    private Entry[] objects = null;

    //cpu核数,用于自旋
    static final int MAX_SCAN_RETRIES =
            Runtime.getRuntime().availableProcessors();

    public WeakReferenceFactory(int size) {
        this(size, new DefaultValidator());
    }

    public WeakReferenceFactory(int size, Validator validator) {
        super();
        this.size = size;
        this.validator = validator;
        initObjects();
    }

    private void initObjects() {
        objects = (Entry[]) new Entry[size];
        for (int i = 0, len = objects.length; i < len; i++) {
            objects[i] = new Entry();
        }
    }

    /**
     * 获取对象
     * @return
     */
    @Override
    public Object get() {
        checkClose();
        return objects[getIndex()].get();
    }

    @Override
    protected void returnObject(Object o) {
        objects[getIndex()].set(o);
    }

    @Override
    protected void closeResource() throws IOException {
        super.closeResource();
        objects = null;
    }

    private int getIndex() {
        return ThreadLocalRandom.current().nextInt(size);
    }

    @Override
    public Object register() {
        return null;
    }

    @SuppressWarnings({"serial"})
    static class Entry extends ReentrantLock {
        WeakReference<Object> reference = new WeakReference<>(null);

        void set(Object o) {
            int count = MAX_SCAN_RETRIES;
            while (--count >= 0) {
                if (tryLock()) {
                    try {
                        setReference(o);
                        return;
                    } finally {
                        unlock();
                    }
                }
            }
        }

        Object get() {
            int count = MAX_SCAN_RETRIES;
            while (--count >= 0) {
                if (tryLock()) {
                    try {
                        Object o = getReference();
                        return o;
                    } finally {
                        unlock();
                    }
                }
            }
            return null;
        }

        private Object getReference() {
            Object o = reference.get();
            reference.clear();
            return o;
        }

        private void setReference(Object o) {
            reference = null == reference.get() ?
                    new WeakReference<>(o) : reference;
        }
    }
}
