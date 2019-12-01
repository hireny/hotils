package me.hireny.commons.socket;

import me.hireny.commons.core.io.ResourceException;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ClosedChannelException;
import java.util.Optional;

/**
 * @ClassName: SocketUtils
 * @Author: hireny
 * @Date: Create in 2019/12/01 14:19
 * @Description: TODO   Socket先关工具
 */
public class SocketUtils {

    private SocketUtils() {}

    /**
     * 获取远程端的地址信息，包括host和port
     * null表示channel为null或者远程主机未连接
     * @param channel   {@link AsynchronousSocketChannel}
     * @return  远程端的地址信息，包括host和端口，null表示channel为null或者远程主机未连接
     */
    public static SocketAddress getRemoteAddress(AsynchronousSocketChannel channel) throws ResourceException {
        try {
            return Optional.ofNullable(channel).isPresent() ? null : channel.getRemoteAddress();
        } catch (ClosedChannelException e) {
            // Channel未打开或已关闭，返回null表示未连接
            return null;
        } catch (IOException e) {
            throw new ResourceException(e.getMessage());
        }
    }

    /**
     * 远程主机是否处于连接状态
     * 通过判断远程地址获取成功与否判断
     * @param channel   {@link AsynchronousSocketChannel}
     * @return  远程主机是否处于连接状态
     */
    public static boolean isConnected(AsynchronousSocketChannel channel) throws ResourceException {
        return null != getRemoteAddress(channel);
    }
}
