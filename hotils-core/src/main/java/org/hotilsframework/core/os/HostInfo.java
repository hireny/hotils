package org.hotilsframework.core.os;

import org.hotilsframework.core.net.Networks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName: HostInfo
 * @Author: hireny
 * @Date: Create in 2019/12/07 23:54
 * @Description: TODO   主机信息，代表当前主机
 */
public class HostInfo implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(HostInfo.class);

    private static final long serialVersionUID = 98250111724703039L;

//    private final String HOST_NAME;
//    private final String HOST_ADDRESS;

    public HostInfo() {
        final InetAddress localhost = Networks.getLocalhost();
    }

    /** 获取机器名 */
    public static final String getHostName() {
        String hostName = "";
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.error(e.getMessage(), e);
        }
        return hostName;
    }

    /**
     * 获取网卡序列号
     * @return
     */
    public static final String getDUID() {
        String address = "";
        String command = "cmd.exe /c ipconfig /all";
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.indexOf("DUID") > 0) {
                    int index = line.indexOf(":");
                    index += 2;
                    address = line.substring(index);
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
        }
        return address;
    }

    public static void main(String[] args) {
        System.out.println("获取机器名：" + getHostName());
        System.out.println("获取网卡序列号：" + getDUID());
    }
}
