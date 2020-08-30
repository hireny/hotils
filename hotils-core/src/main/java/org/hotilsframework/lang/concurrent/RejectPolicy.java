package org.hotilsframework.lang.concurrent;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: RejectPolicy
 * @Author: hireny
 * @Date: Create in 2019/12/07 02:03
 * @Description: TODO   线程拒绝策略
 * 如果设置了maxSize，当总线程数达到上限，会调用RejectedExecutionHandler进行处理，此枚举为JDK预定义的几种策略枚举表示
 */
public enum RejectPolicy {

    /** 处理程序遭到拒绝将抛出RejectedExecutionException */
    ABORT(new ThreadPoolExecutor.AbortPolicy()),
    /** 放弃当前任务 */
    DISCARD(new ThreadPoolExecutor.DiscardPolicy()),
    /** 如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程） */
    DISCARD_OLDEST(new ThreadPoolExecutor.DiscardOldestPolicy()),
    /** 由主线程来直接执行 */
    CALLER_RUNS(new ThreadPoolExecutor.CallerRunsPolicy());

    private RejectedExecutionHandler handler;

    RejectPolicy(RejectedExecutionHandler handler) {
        this.handler = handler;
    }

    /**
     * 获取RejectedExecutionHandler枚举值
     * @return
     */
    public RejectedExecutionHandler getHandler() {
        return this.handler;
    }
}
