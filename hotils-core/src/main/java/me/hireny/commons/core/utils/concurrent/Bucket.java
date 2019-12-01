package me.hireny.commons.core.utils.concurrent;

/**
 * @ClassName: Bucket
 * @Author: hireny
 * @Date: Create in 2019/11/08 22:26
 * @Description: TODO   桶
 */
public interface Bucket<V> {

    /**
     * 收到一个请求，发挥是否处理
     * @param item
     * @return      可以处理返回true；如果无法处理，返回false
     */
    boolean receive(V item);
}
