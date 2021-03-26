package org.hotilsframework.core.factory;


/**
 * AbstractObjectFactory
 *
 * 抽象对象工厂
 *
 * @author hireny
 * @create 2020-08-06 0:01
 */
public abstract class AbstractObjectProvider implements ObjectProvider, ObjectRegistry {

    /**
     * 验证器
     */
    protected        Validator validator = null;
    /**
     * 是否关闭
     */
    private volatile boolean      closed    = false;


    /**
     * 释放对象
     * @param o     需要释放的对象资源
     */
    @Override
    public void release(Object o) {
        if (isClosed()) {
            return;
        }
        if (validator.isValid(o)) {
            returnObject(o);
        } else {
            validator.invalidate(o);
        }
    }

    /**
     * 对象池关闭
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        this.closed = false;
        closeResource();
    }

    /**
     * 返回一个对象
     * @param o
     */
    protected abstract void returnObject(Object o);

    protected boolean isClosed() {
        return closed;
    }

    /**
     * 检查对象池是否已经被关闭
     */
    protected void checkClose() {
        if (isClosed()) {
            // 对象池已经关闭
            throw new IllegalStateException("Object Pools is already closed");
        }
    }

    /**
     * 关闭资源
     * @throws Exception
     */
    protected void closeResource() throws Exception {
        validator = null;
    }
}
