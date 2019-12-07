package me.hireny.commons.core.system;

import me.hireny.commons.core.net.Networks;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * @ClassName: HostInfo
 * @Author: hireny
 * @Date: Create in 2019/12/07 23:54
 * @Description: TODO   主机信息，代表当前主机
 */
public class HostInfo implements Serializable {
    private static final long serialVersionUID = 98250111724703039L;

//    private final String HOST_NAME;
//    private final String HOST_ADDRESS;

    public HostInfo() {
        final InetAddress localhost = Networks.getLocalhost();
    }
}
