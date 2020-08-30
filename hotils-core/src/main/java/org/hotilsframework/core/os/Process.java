package org.hotilsframework.core.os;

/**
 * Process
 *
 * 进程元素
 *
 * @author hireny
 * @create 2020-07-07 11:42
 */
public class Process {
    /**
     * 进程ID
     */
    private int pid;
    /**
     * 进程名
     */
    private String command;
    /**
     * 运行状态
     */
    private String status;
    /**
     * 进程仍然在使用的，没被交换出物理内存部分的大小
     */
    private String res;
    /**
     * 所有者
     */
    private String user;
    /**
     * 时间总计
     */
    private String time;
    /**
     * 优先级
     */
    private String pr;
    /**
     * nice值
     */
    private String ni;
    /**
     * 虚拟内存
     */
    private String virt;
    /**
     * 共享内存大小
     */
    private String shr;
    /**
     * 内存比重
     */
    private String mem;
    /**
     * cpu比重
     */
    private String cpu;
    /**
     * 端口
     */
    private String port;
}
