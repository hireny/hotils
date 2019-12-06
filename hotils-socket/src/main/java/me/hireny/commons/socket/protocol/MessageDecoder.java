package me.hireny.commons.socket.protocol;

import me.hireny.commons.socket.aio.AioSession;

import java.nio.ByteBuffer;

/**
 * @ClassName: MessageDecoder
 * @Author: hireny
 * @Date: Create in 2019/12/07 02:52
 * @Description: TODO   消息解码器
 *
 * @param <T>   解码后的目标类型
 */
public interface MessageDecoder<T> {

    /**
     * 对于从Socket流中获取到的数据采用当前MessageDecoder的实现类协议进行解码。
     * @param session       本次需要解码的session
     * @param readBuffer    待处理的读buffer
     * @return              本次解码成功后封装的业务消息对象，返回null则表示解码未完成
     */
    T decode(AioSession session, ByteBuffer readBuffer);
}
