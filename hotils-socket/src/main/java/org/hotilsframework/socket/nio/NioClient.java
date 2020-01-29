package org.hotilsframework.socket.nio;

import org.hotilsframework.io.ResourceException;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName: NioClient
 * @Author: hireny
 * @Date: Create in 2019/12/01 14:28
 * @Description: TODO   NIO客户端
 */
public class NioClient implements Closeable {

    private SocketChannel channel;

    /**
     * 构造
     */
    public NioClient(String host, int port) throws ResourceException {
        this(new InetSocketAddress(host, port));
    }

    /**
     * 构造
     * @param address
     */
    public NioClient(InetSocketAddress address) throws ResourceException {
        init(address);
    }

    /**
     * 初始化
     * @param address   地址和端口
     * @return  this
     */
    public NioClient init(InetSocketAddress address) throws ResourceException {
        try {
            this.channel = SocketChannel.open(address);
        } catch (IOException e) {
            throw new ResourceException(e);
        }
        return this;
    }

    /**
     * 处理读事件
     * 当收到读取准备就绪的信号后，回调此方法，用户可读取从客户端传过来的消息
     *
     * @param buffer    服务端数据存储缓存
     * @return  this
     */
    public NioClient read(ByteBuffer buffer) throws ResourceException {
        try {
            this.channel.read(buffer);
        } catch (IOException e) {
            throw new ResourceException(e);
        }
        return this;
    }

    /**
     * 实现写逻辑
     * 当收到写出准备就绪的信号后，回调此方法，用户可向客户端发送消息
     *
     * @param datas 发送的数据
     * @return  this
     */
    public NioClient write(ByteBuffer... datas) throws ResourceException {
        try {
            this.channel.write(datas);
        } catch (IOException e) {
            throw new ResourceException(e);
        }
        return this;
    }


    @Override
    public void close() throws IOException {
        this.channel.close();
    }
}
