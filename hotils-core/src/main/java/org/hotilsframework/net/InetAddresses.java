package org.hotilsframework.net;


import org.hotilsframework.lang.Splitter;

import java.net.Inet4Address;

/**
 * @Author: hireny
 * @Date: Create in 2019/09/30 01:43
 */
public final class InetAddresses {
    /**
     * IPV4长度
     */
    private static final int IPV4_PART_COUNT = 4;
    /**
     * IPV6长度
     */
    private static final int IPV6_PART_COUNT = 8;
    /**
     * Ipv4分离器
     */
    private static final Splitter IPV4_SPLITTER = Splitter.on('.').limit(IPV4_PART_COUNT);
    /**
     * IPV6分离器
     */
    private static final Splitter IPV6_SPLITTER = Splitter.on(':').limit(IPV6_PART_COUNT + 2);

    private InetAddresses() {}

    /**
     * 获取Ipv4长度
     * @param bytes
     * @return
     */
    private static Inet4Address getInetAddress(byte[] bytes) {
        return null;
    }

    /**
     * 是否是网络地址
     * @param ipString
     * @return
     */
    public static boolean isInetAddress(String ipString) {
        return false;
    }

    /**
     * 将IPV4地址转换为所对应的整数
     * @param ipv4
     * @return
     */
    public static long ipv4ToLong(String ipv4) {
        String[] s = ipv4.split("\\.");
        long ipv4Long = 0L;
        int length = s.length;
        for (int i = 0; i < length; i ++) {
            ipv4Long += Long.parseLong(s[i]) * Math.pow(255, (3 - i));
        }
        return ipv4Long;
    }
}
