package me.hireny.commons.socket.aio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @ClassName: AcceptHandler
 * @Author: hireny
 * @Date: Create in 2019/12/06 23:55
 * @Description: TODO   接入完成回调，单例使用
 */
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

    private static final Logger log = LoggerFactory.getLogger(AcceptHandler.class);

    @Override
    public void completed(AsynchronousSocketChannel result, AioServer attachment) {
        // 继续等待接入(异步)
        attachment.accept();

        final IoAction<ByteBuffer> ioAction = attachment.ioAction;
        // 创建Session会话
        final AioSession session = new AioSession(result, ioAction, attachment.configuration);
        // 处理请求接入(同步)
        ioAction.accept(session);
        // 处理读(异步)
        session.read();
    }

    @Override
    public void failed(Throwable exc, AioServer attachment) {
        log.error(exc.getMessage());
    }
}
