package org.hotilsframework.socket.protocol;

import org.hotilsframework.socket.aio.AioSession;

import java.nio.ByteBuffer;

/**
 * @ClassName: MessageEncoder
 * @Author: hireny
 * @Date: Create in 2019/12/07 02:54
 * @Description: TODO   消息编码器
 *
 * @param <T> 编码前后的数据类型
 */
public interface MessageEncoder<T> {

    /**
     * 编码数据用于写出
     *
     * @param session 本次需要解码的session
     * @param writeBuffer 待处理的读buffer
     * @param data 写出的数据
     */
    void encode(AioSession session, ByteBuffer writeBuffer, T data);
}
