package org.hotilsframework.lang.function;

/**
 * 一个参数的消费者函数式接口
 * @author hireny
 * @className OneConsumer
 * @create 2020-05-24 22:21
 * @param <T> 表达式
 * @param <P> 参数
 */
@FunctionalInterface
public interface OneConsumer<T, P> {
    void accept(T t, P p);
}
