package org.hotilsframework.socket.aio;

import org.hotilsframework.io.ResourceException;
import org.hotilsframework.socket.SocketConfiguration;
import org.hotilsframework.utils.concurrent.ThreadFactoryBuilder;
import org.hotilsframework.utils.concurrent.ThreadPoolUtils;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * @ClassName: AioServer
 * @Author: hireny
 * @Date: Create in 2019/12/06 23:56
 * @Description: TODO   基于AIO的Socket服务端实现
 */
public class AioServer implements Closeable {

    private static final AcceptHandler ACCEPT_HANDLER = new AcceptHandler();

    private AsynchronousChannelGroup group;
    private AsynchronousServerSocketChannel channel;
    protected IoAction<ByteBuffer> ioAction;
    protected final SocketConfiguration configuration;

    /**
     * 构造
     *
     * @param port 端口
     */
    public AioServer(int port) {
        this(new InetSocketAddress(port), new SocketConfiguration());
    }

    /**
     * 构造
     *
     * @param address 地址
     * @param configuration  {@link SocketConfiguration} 配置项
     */
    public AioServer(InetSocketAddress address, SocketConfiguration configuration) {
        this.configuration = configuration;
        init(address);
    }

    /**
     * 初始化
     * @param address   地址和端口
     * @return
     */
    public AioServer init(InetSocketAddress address) {
        try {
            this.group = AsynchronousChannelGroup.withFixedThreadPool(
                    configuration.getThreadPoolSize(), // 默认线程池大小
                    ThreadFactoryBuilder.create().setNamePrefix("Hotils-socket-").build());
            this.channel = AsynchronousServerSocketChannel.open(group).bind(address);
        } catch (IOException e) {
            throw new ResourceException(e);
        }
        return this;
    }

    /**
     * 开始监听
     * @param sync  是否阻塞
     */
    public void start(boolean sync) {
        try {
            doStart(sync);
        } catch (IOException e) {
            throw new ResourceException(e);
        }
    }

    /**
     * 设置 Socket 的 Option 选项
     * 选项见： {@link java.net.StandardSocketOptions}
     *
     * @param name  {@link SocketOption} 枚举
     * @param value SocketOption参数
     * @param <T>   泛型选项
     * @return  this
     * @throws IOException  IO异常
     */
    public <T> AioServer setOption(SocketOption<T> name, T value) throws IOException {
        this.channel.setOption(name, value);
        return this;
    }

    /**
     * 获取IO处理器
     * @return
     */
    public IoAction<ByteBuffer> getIoAction() {
        return this.ioAction;
    }

    /**
     * 设置IO处理器，单例存在
     *
     * @param ioAction {@link IoAction}
     * @return this;
     */
    public AioServer setIoAction(IoAction<ByteBuffer> ioAction) {
        this.ioAction = ioAction;
        return this;
    }

    /**
     * 获取{@link AsynchronousServerSocketChannel}
     *
     * @return {@link AsynchronousServerSocketChannel}
     */
    public AsynchronousServerSocketChannel getChannel() {
        return this.channel;
    }

    /**
     * 处理接入的客户端
     *
     * @return this
     */
    public AioServer accept() {
        this.channel.accept(this, ACCEPT_HANDLER);
        return this;
    }

    /**
     * 服务是否开启状态
     *
     * @return 服务是否开启状态
     */
    public boolean isOpen() {
        return (null != this.channel) && this.channel.isOpen();
    }


    /**
     * 关闭服务
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        this.channel.close();

        if (null != this.group && false == this.group.isShutdown()) {
            this.group.shutdownNow();
        }

        // 结束阻塞
        synchronized (this) {
            this.notify();
        }
    }

    // ------------------------------------------------------------------------------------- Private method start

    /**
     * 开始监听
     *
     * @param sync 是否阻塞
     * @throws IOException IO异常
     */
    private void doStart(boolean sync) throws IOException {

        // 接收客户端连接
        accept();

        if (sync) {
            ThreadPoolUtils.sync(this);
        }
    }
    // ------------------------------------------------------------------------------------- Private method end
}
