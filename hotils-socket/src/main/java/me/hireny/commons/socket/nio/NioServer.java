package me.hireny.commons.socket.nio;

import me.hireny.commons.core.io.ResourceException;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @ClassName: NioServer
 * @Author: hireny
 * @Date: Create in 2019/12/06 23:07
 * @Description: TODO   基于NIO的Socket服务端实现
 */
public abstract class NioServer implements Closeable {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    /**
     * 构造
     * @param port  端口
     */
    public NioServer(int port) throws ResourceException {
        init(new InetSocketAddress(port));
    }

    /**
     * 初始化
     * @param address
     * @return  this
     */
    public NioServer init(InetSocketAddress address) throws ResourceException {
        try {
            // 代开服务器套接字通道
            this.serverSocketChannel = ServerSocketChannel.open();
            // 设置为非阻塞状态
            serverSocketChannel.configureBlocking(false);
            // 获取通道相关联的套接字
            final ServerSocket serverSocket = serverSocketChannel.socket();
            // 绑定端口号
            serverSocket.bind(address);
            // 打开一个选择器
            selector = Selector.open();
            // 服务器套接字注册到Selector中，并指定Selector监控连接事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            throw new ResourceException(e);
        }
        return this;
    }

    /**
     * 开始监听
     * @throws ResourceException
     */
    public void listen() throws ResourceException {
        try {
            doListen();
        } catch (IOException e) {
            throw new ResourceException(e);
        }
    }

    /**
     * 开始监听
     * @throws IOException  IO异常
     */
    private void doListen() throws IOException {
        while (0 != this.selector.select()) {
            // 返回已选择键的集合
            final Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                handle(keyIterator.next());
                keyIterator.remove();
            }
        }
    }

    /**
     * 处理SelectionKey
     * @param key   SelectionKey
     */
    private void handle(SelectionKey key) throws ResourceException {
        // 有客户端接入此服务端
        if (key.isAcceptable()) {
            // 获取通道，转化为要处理的类型
            final ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel;
            try {
                // 获取连接到此服务器的客户端通道
                socketChannel = channel.accept();
            } catch (IOException e) {
                throw new ResourceException(e);
            }
            // SocketChannel通道的可读事件注册到Selector中
            registerChannel(selector, socketChannel, Operation.READ);
        }

        // 读事件就绪
        if (key.isReadable()) {
            final SocketChannel socketChannel = (SocketChannel) key.channel();
            read(socketChannel);

            // SocketChannel通道的可写事件注册到Selector中
            registerChannel(selector, socketChannel, Operation.WRITE);
        }

        // 写事件就绪
        if (key.isWritable()) {
            final SocketChannel socketChannel = (SocketChannel) key.channel();
            write(socketChannel);
            // SocketChannel通道的可读事件注册到Selector中
            registerChannel(selector, socketChannel, Operation.READ);
        }
    }

    @Override
    public void close() throws IOException {
        this.selector.close();
        this.serverSocketChannel.close();
    }

    /**
     * 处理读事件
     * 当收到读取准备就绪的信号后，回调此方法，用户可读取从客户端传过来的消息
     * @param socketChannel SocketChannel
     */
    protected abstract void read(SocketChannel socketChannel);

    /**
     * 实现写逻辑
     * 当收到写出准备就绪的信号后，回调此方法，用户可向客户端发送消息
     * @param socketChannel
     */
    protected abstract void write(SocketChannel socketChannel);

    /**
     * 注册通道到指定Selector上
     * @param selector  Selector
     * @param channel   SelectableChannel通道
     * @param operation Operation注册的通道监听类型
     */
    private void registerChannel(Selector selector, SelectableChannel channel, Operation operation) throws ResourceException {
        if (channel == null) {
            return;
        }

        try {
            channel.configureBlocking(false);
            // 注册通道
            channel.register(selector, operation.getValue());
        }  catch (ClosedChannelException e) {
            throw new ResourceException(e);
        } catch (IOException e) {
            throw new ResourceException(e);
        }
    }
}
