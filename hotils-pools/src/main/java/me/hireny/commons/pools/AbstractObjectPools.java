package me.hireny.commons.pools;

import java.io.IOException;

/**
 * @ClassName: AbstractObjectPools
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:10
 * @Description: TODO   基础对象池的实现
 */
public abstract class AbstractObjectPools<T> implements ObjectPools<T> {
    /**
     * 验证器
     */
    protected Validator<T> validator = null;
    /**
     * 是否关闭
     */
    private volatile boolean closed = false;

    /**
     * 释放对象
     * @param t     需要释放的对象资源
     */
    @Override
    public void release(T t) {
        if (isClosed()) {
            return;
        }
        if (validator.isValid(t)) {
            returnPool(t);
        } else {
            validator.invalidate(t);
        }
    }

    /**
     * 对象池关闭
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        this.closed = false;
        closeResource();
    }

    /**
     * 返回一个对象
     * @param t
     */
    protected abstract void returnPool(T t);

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
     * @throws IOException
     */
    protected void closeResource() throws IOException {
        validator = null;
    }
}
