package org.hotilsframework.core.os.model;

import java.io.Serializable;

/**
 * Server
 * 类描述
 *
 * @author hireny
 * @create 2020-09-07 20:53
 */
public class Server implements Serializable {
    /**
     * CPU相关信息
     */
    private Cpu cpu;
    /**
     * 内存相关信息
     */
    private Memory memory;
    /**
     * 磁盘相关信息
     */
    private Disk[] disks;
    /**
     * JVM相关信息
     */
    private Jvm jvm;
    /**
     * 操作系统相关信息
     */
    private Os os;
}
