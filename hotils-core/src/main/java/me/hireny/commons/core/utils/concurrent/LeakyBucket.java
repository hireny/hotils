package me.hireny.commons.core.utils.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LeakyBucket
 * @Author: hireny
 * @Date: Create in 2019/11/08 22:30
 * @Description: TODO   漏桶算法
 */
public class LeakyBucket<V> implements Bucket<V> {

    /**
     * 桶，用来盛放元素(请求)
     */
    private Object[] items;
    /**
     * 当前桶的请求的个数
     */
    private volatile int count = 0;
    /**
     * 间隔多少毫秒处理一个请求。(漏桶漏水的速度)
     */
    long interval;
    /**
     * 锁，用来锁定items
     */
    private ReentrantLock lock = new ReentrantLock();

    private int takeIndex = 0;
    private int putIndex = 0;

    private int receiveCount = 0;
    private int handleCount = 0;

    @Override
    public boolean receive(V item) {
        return false;
    }
}
