package org.hotilsframework.codec.hash;

/**
 * Primitives
 * 类描述
 * An object which can receive a stream of primitive values.
 *
 * 可以接收原始值流的对象
 *
 * @author hireny
 * @create 2020-07-13 20:58
 */
public interface PrimitiveSink {
    /**
     * Puts a byte into this sink.
     *
     * 将一个字节放入这个接收器
     * @param b
     * @return
     */
    PrimitiveSink putByte(byte b);
}
