package me.hireny.commons.core.net;

import me.hireny.commons.core.collect.Collections;
import me.hireny.commons.core.lang.Filter;

import java.net.*;
import java.util.Enumeration;
import java.util.LinkedHashSet;

/**
 * @ClassName: Networks
 * @Author: hireny
 * @Date: Create in 2019/12/01 22:18
 * @Description: TODO   网络工具类
 */
public class Networks {

    public final static String LOCAL_IP_ADDRESS = "127.0.0.1";
    /**
     * 默认最小端口,1024
     */
    public static final int PORT_RANGE_MIN = 1024;
    /**
     * 默认最大端口，65535
     */
    public static final int PORT_RANGE_MAX = 0xFFFF;

    public Networks() {}

    /**
     * 获取MAC地址
     * @param ip
     * @return
     */
    public static String getMacAddress(String ip) {
        return null;
    }

    /**
     * 判断IP是否是一个符合规则的IP
     * @param ip
     * @return
     */
    public static boolean isValidIP(String ip) {
        return false;
    }

    /**
     * 获取所有满足过滤添加的本地IP地址对象
     * @param addressFilter
     * @return
     */
    public static LinkedHashSet<InetAddress> localAddressList(Filter<InetAddress> addressFilter) {
        Enumeration<NetworkInterface> networkInterfaces;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new NetworkException(e);
        }
        if (null == networkInterfaces) {
            throw new NetworkException("Get network interface error!");
        }
        final LinkedHashSet<InetAddress> inetAddresses = new LinkedHashSet<>();
        while (networkInterfaces.hasMoreElements()) {
            final NetworkInterface networkInterface = networkInterfaces.nextElement();
            final Enumeration<InetAddress> inetAddress = networkInterface.getInetAddresses();
            while (inetAddress.hasMoreElements()) {
                final InetAddress address = inetAddress.nextElement();
                if (address != null && (null == addressFilter || addressFilter.accept(address))) {
                    inetAddresses.add(address);
                }
            }
        }
        return inetAddresses;
    }

    /**
     * 获取本机网卡IP地址，这个地址为所有网卡中非回路地址的第一个
     * 如果获取失败调用  {@link InetAddress#getLocalHost()}方法获取
     * 此方法不会抛出异常，获取失败将返回<code>null</code>
     * @return
     */
    public static String getLocalhostString() {
        InetAddress localhost =getLocalhost();
        if (null != localhost) {
            return localhost.getHostAddress();
        }
        return null;
    }

    /**
     * 获取本机网卡IP地址，规则如下：
     * <pre>
     *     1. 查找所有网卡地址，必须非回路(loopback)地址、非局域网地址(siteLocal)、IPv4地址
     *     2. 如果无满足要求的地址，调用 {@link InetAddress#getLocalHost()} 获取地址
     * </pre>
     *
     * 此方法不会抛出异常，获取失败将返回 {@code null}
     * @return  本机网卡IP地址，获取失败返回 {@code null}
     */
    public static InetAddress getLocalhost() {
        final LinkedHashSet<InetAddress> localAddressList = localAddressList(address -> {
            // 非loopback地址，指127.*.*.*的地址
            return false == address.isLoopbackAddress()
                    // 非地区本地地址，指10.0.0.0 ~ 10.255.255.255、172.16.0.0 ~ 172.31.255.255、192.168.0.0 ~ 192.168.255.255
                    && false == address.isSiteLocalAddress()
                    // 需为IPV4地址
                    && address instanceof Inet4Address;
        });

        if (!Collections.isEmpty(localAddressList)) {
            return Collections.get(localAddressList, 0);
        }

        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            // ignore
        }

        return null;
    }
}
