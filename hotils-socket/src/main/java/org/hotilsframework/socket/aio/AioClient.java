package org.hotilsframework.socket.aio;

import org.hotilsframework.io.ResourceException;
import org.hotilsframework.socket.SocketConfiguration;
import org.hotilsframework.socket.SocketException;
import org.hotilsframework.lang.concurrent.ThreadFactoryBuilder;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName: AioClient
 * @Author: hireny
 * @Date: Create in 2019/12/06 23:57
 * @Description: TODO   AIO Socket客户端
 */
public class AioClient implements Closeable {

    private final AioSession session;

    /**
     * 构造
     * @param address   地址
     * @param ioAction  IO处理类
     */
    public AioClient(InetSocketAddress address, IoAction<ByteBuffer> ioAction) {
        this(address, ioAction, new SocketConfiguration());
    }

    /**
     * 构造
     * @param address       地址
     * @param ioAction      IO处理类
     * @param configuration 配置项
     */
    public AioClient(InetSocketAddress address, IoAction<ByteBuffer> ioAction, SocketConfiguration configuration) {
        this(createChannel(address, configuration.getThreadPoolSize()), ioAction, configuration);
    }

    /**
     * 构造
     * @param channel       {@link AsynchronousSocketChannel}
     * @param ioAction      IO处理类
     * @param configuration 配置项
     */
    public AioClient(AsynchronousSocketChannel channel, IoAction<ByteBuffer> ioAction, SocketConfiguration configuration) {
        this.session = new AioSession(channel, ioAction, configuration);
        ioAction.accept(this.session);
    }

    /**
     * 设置 Socket 的 Option 选项
     * 选项见： {@link java.net.StandardSocketOptions}
     * @param name
     * @param value
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T> AioClient setOption(SocketOption<T> name, T value) throws IOException {
        this.session.getChannel().setOption(name, value);
        return this;
    }

    /**
     * 获取IO处理器
     * @return  {@link IoAction}
     */
    public IoAction<ByteBuffer> getIoAction() {
        return this.session.getIoAction();
    }

    /**
     * 从服务端读取数据
     * @return  this
     */
    public AioClient read() {
        this.session.read();
        return this;
    }

    /**
     * 写数据到服务端
     * @param data  数据
     * @return  this
     */
    public AioClient write(ByteBuffer data) {
        this.session.write(data);
        return this;
    }

    /**
     * 关闭客户端
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        this.session.close();
    }

    // ------------------------------------------------------------------------------------- Private method start

    /**
     * 初始化
     * @param address   地址和端口
     * @param poolSize  线程池大小
     * @return  this
     */
    private static AsynchronousSocketChannel createChannel(InetSocketAddress address, int poolSize) {
        AsynchronousSocketChannel channel;
        try {
            AsynchronousChannelGroup group = AsynchronousChannelGroup.withFixedThreadPool(//
                    poolSize, // 默认线程池大小
                    ThreadFactoryBuilder.create().setNamePrefix("Hotils-socket-").build()//
            );
            channel = AsynchronousSocketChannel.open(group);
        } catch (IOException e) {
            throw new ResourceException(e);
        }

        try {
            channel.connect(address).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new SocketException(e);
        }
        return channel;
    }
    // ------------------------------------------------------------------------------------- Private method end
}
