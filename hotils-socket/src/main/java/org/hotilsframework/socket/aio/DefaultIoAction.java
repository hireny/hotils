package org.hotilsframework.socket.aio;

import java.nio.ByteBuffer;

/**
 * @ClassName: DefaultIoAction
 * @Author: hireny
 * @Date: Create in 2019/12/07 01:22
 * @Description: TODO   简易IO信息处理类
 * 简单实现了accept和failed事件
 */
public abstract class DefaultIoAction implements IoAction<ByteBuffer> {

    @Override
    public void accept(AioSession session) {

    }

    @Override
    public void failed(Throwable t, AioSession session) {
//        log.error(t.getMessage());
    }
}
