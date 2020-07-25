package org.hotilsframework.socket.aio;

import org.hotilsframework.io.ResourceException;
import org.hotilsframework.socket.SocketConfiguration;
import org.hotilsframework.socket.SocketUtils;

import java.io.Closeable;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: AioSession
 * @Author: hireny
 * @Date: Create in 2019/12/06 23:58
 * @Description: TODO   AIO会话，每个客户端对应一个会话对象
 */
public class AioSession implements Closeable {

    private static final ReadHandler READ_HANDLER;

    static {
        READ_HANDLER = new ReadHandler();
    }

    private final AsynchronousSocketChannel channel;
    private final IoAction<ByteBuffer> ioAction;
    private ByteBuffer readBuffer;
    private ByteBuffer writeBuffer;
    /** 读取超时时长，小于等于0表示默认 */
    private long readTimeout;
    /** 写出超时时长，小于等于0表示默认 */
    private long writeTimeout;

    /**
     * 构造
     * @param channel   {@link AsynchronousSocketChannel}
     * @param ioAction  IO消息处理类
     * @param configuration 配置项
     */
    public AioSession(AsynchronousSocketChannel channel, IoAction<ByteBuffer> ioAction, SocketConfiguration configuration) {
        this.channel = channel;
        this.readBuffer = ByteBuffer.allocate(configuration.getReadBufferSize());
        this.writeBuffer = ByteBuffer.allocate(configuration.getWriteBufferSize());
        this.ioAction = ioAction;
    }

    /**
     * 获取 {@link AsynchronousSocketChannel}
     * @return  {@link AsynchronousSocketChannel}
     */
    public AsynchronousSocketChannel getChannel() {
        return this.channel;
    }

    /**
     * 获取读取Buffer
     *
     * @return 读取Buffer
     */
    public ByteBuffer getReadBuffer() {
        return this.readBuffer;
    }

    /**
     * 获取写Buffer
     *
     * @return 写Buffer
     */
    public ByteBuffer getWriteBuffer() {
        return this.writeBuffer;
    }

    /**
     * 获取消息处理器
     *
     * @return {@link IoAction}
     */
    public IoAction<ByteBuffer> getIoAction() {
        return this.ioAction;
    }

    /**
     * 获取远程主机（客户端）地址和端口
     *
     * @return 远程主机（客户端）地址和端口
     */
    public SocketAddress getRemoteAddress() throws ResourceException {
        return SocketUtils.getRemoteAddress(this.channel);
    }

    /**
     * 读取数据到Buffer
     *
     * @return this
     */
    public AioSession read() {
        return read(READ_HANDLER);
    }

    /**
     * 读取数据到Buffer
     *
     * @param handler {@link CompletionHandler}
     * @return this
     */
    public AioSession read(CompletionHandler<Integer, AioSession> handler) {
        if (isOpen()) {
            this.readBuffer.clear();
            this.channel.read(this.readBuffer, Math.max(this.readTimeout, 0L), TimeUnit.MILLISECONDS, this, handler);
        }
        return this;
    }

    /**
     * 写数据到目标端，并关闭输出
     *
     * @param data 数据
     * @return this
     */
    public AioSession writeAndClose(ByteBuffer data) throws ResourceException {
        write(data);
        return closeOut();
    }

    /**
     * 写数据到目标端
     *
     * @param data 数据
     * @return {@link Future}
     */
    public Future<Integer> write(ByteBuffer data) {
        return this.channel.write(data);
    }

    /**
     * 写数据到目标端
     *
     * @param data 数据
     * @param handler {@link CompletionHandler}
     * @return this
     */
    public AioSession write(ByteBuffer data, CompletionHandler<Integer, AioSession> handler) {
        this.channel.write(data, Math.max(this.writeTimeout, 0L), TimeUnit.MILLISECONDS, this, handler);
        return this;
    }

    /**
     * 会话是否打开状态<br>
     * 当Socket保持连接时会话始终打开
     *
     * @return 会话是否打开状态
     */
    public boolean isOpen() {
        return (null != this.channel) && this.channel.isOpen();
    }

    /**
     * 关闭输出
     *
     * @return this
     */
    public AioSession closeIn() throws ResourceException {
        if (null != this.channel) {
            try {
                this.channel.shutdownInput();
            } catch (IOException e) {
                throw new ResourceException(e);
            }
        }
        return this;
    }

    /**
     * 关闭输出
     *
     * @return this
     */
    public AioSession closeOut() throws ResourceException {
        if (null != this.channel) {
            try {
                this.channel.shutdownOutput();
            } catch (IOException e) {
                throw new ResourceException(e);
            }
        }
        return this;
    }

    /**
     * 关闭会话
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        this.channel.close();
        this.readBuffer = null;
        this.writeBuffer = null;
    }

    /**
     * 执行读，用于读取事件结束的回调
     */
    protected void callbackRead() {
        readBuffer.flip();// 读模式
        ioAction.doAction(this, readBuffer);
    }
}
