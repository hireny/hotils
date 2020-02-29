package org.hotilsframework.core.net;

import org.hotilsframework.lang.Filter;
import org.hotilsframework.utils.CollectionUtils;
import org.hotilsframework.utils.StringUtils;

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
     * 根据long值获取ipv4地址
     *
     * @param longIp    IP的long表示形式
     * @return          IPv4 地址
     */
    public static String longToIpv4(long longIp) {
        final StringBuilder stringBuilder = new StringBuilder();
        // 直接右移24位
        stringBuilder.append((longIp >>> 24));
        stringBuilder.append(".");
        // 将高8位置0, 然后右移16位
        stringBuilder.append(((longIp & 0x00FFFFFF) >>> 16));
        stringBuilder.append(".");
        stringBuilder.append(((longIp & 0x0000FFFF) >>> 8));
        stringBuilder.append(".");
        stringBuilder.append(((longIp & 0x0000FFFF)));
        return stringBuilder.toString();
    }

    /**
     * 根据IP地址计算出long型的数据
     * @param ipv4
     * @return
     */
    public static long ipv4ToLong(String ipv4) {
        if (isValidIP(ipv4)) {
            long[] ip = new long[4];
            // 先找到IP地址字符串中.的位置
            int position1 = ipv4.indexOf(".");
            int position2 = ipv4.indexOf(".", position1 + 1);
            int position3 = ipv4.indexOf(".", position2 + 1);
            // 将每个.之间的字符串转换成整型
            ip[0] = Long.parseLong(ipv4.substring(0, position1));
            ip[1] = Long.parseLong(ipv4.substring(position1 + 1, position2));
            ip[2] = Long.parseLong(ipv4.substring(position2 + 1, position3));
            ip[3] = Long.parseLong(ipv4.substring(position3 + 1));
            return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
        }
        return 0;
    }

    /**
     * Return true for valid port numbers.
     * 验证端口是否有效
     * 此方法并不检查端口是否被占用
     *
     * @param port  端口号
     * @return      是否有效
     */
    public static boolean isValidPort(int port) {
        return port >= 0 && port <= PORT_RANGE_MAX;
    }

    /**
     * 判定是否为内网IP
     * 私有IP：A类 10.0.0.0~10.255.255.255 B类 172.16.0.0-172.31.255.255 C类 192.168.0.0-192.168.255.255 当然，还有127这个网段是环回地址
     * @param ipAddress IP地址
     * @return          是否为内网IP
     */
    public static boolean isInnerIp(String ipAddress) {
        boolean isInnerIp;
        long ipNum = ipv4ToLong(ipAddress);

        long aBegin = ipv4ToLong("10.0.0.0");
        long aEnd = ipv4ToLong("10.255.255.255");

        long bBegin = ipv4ToLong("172.16.0.0");
        long bEnd = ipv4ToLong("172.31.255.255");

        long cBegin = ipv4ToLong("192.168.0.0");
        long cEnd = ipv4ToLong("192.168.255.255");

        isInnerIp = isInner(ipNum, aBegin, aEnd) || isInner(ipNum, bBegin, bEnd) || isInner(ipNum, cBegin, cEnd) || ipAddress.equals(LOCAL_IP_ADDRESS);
        return isInnerIp;
    }

    /**
     * 指定IP的long是否在指定范围内
     *
     * @param userIp    用户IP
     * @param begin     开始IP
     * @param end       结束IP
     * @return          是否在指定范围内
     */
    private static boolean isInner(long userIp, long begin, long end) {
        return (userIp >= begin) && (userIp <= end);
    }

    /**
     * 从多级反向代理中获得第一个非unknown IP地址
     * @param ip    获得的IP地址
     * @return      第一个非unknown IP地址
     */
    public static String getMultistageReverseProxyIp(String ip) {
        // 多级反向代理检测
        if (ip != null && ip.indexOf(",") > 0) {
            final String[] ips = ip.trim().split(",");
            for (String tempIp : ips) {
                if (false == isUnknow(tempIp)) {
                    ip = tempIp;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 检测给定字符串是否为未知，多用于检测HTTP请求相关
     * @param checkString   被检测的字符串
     * @return              是否未知
     */
    public static boolean isUnknow(String checkString) {
        return StringUtils.isBlank(checkString) || "unknown".equalsIgnoreCase(checkString);
    }

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

        if (!CollectionUtils.isEmpty(localAddressList)) {
            return CollectionUtils.get(localAddressList, 0);
        }

        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            // ignore
        }

        return null;
    }
}
