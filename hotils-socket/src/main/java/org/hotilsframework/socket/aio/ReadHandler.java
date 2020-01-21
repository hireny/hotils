package org.hotilsframework.socket.aio;

import org.hotilsframework.socket.SocketException;

import java.nio.channels.CompletionHandler;

/**
 * @ClassName: ReadHandler
 * @Author: hireny
 * @Date: Create in 2019/12/07 00:12
 * @Description: TODO   数据读取完成回调，调用Session中相应方法处理消息，单例使用
 */
public class ReadHandler implements CompletionHandler<Integer, AioSession> {
    @Override
    public void completed(Integer result, AioSession attachment) {
        attachment.callbackRead();
    }

    @Override
    public void failed(Throwable exc, AioSession attachment) {
        throw new SocketException(exc);
    }
}
