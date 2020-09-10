package org.hotilsframework.core.os.model;

import java.io.Serializable;

/**
 * Disk
 *
 * Disk磁盘相关信息
 *
 * @author hireny
 * @create 2020-09-07 20:44
 */
public class Disk implements Serializable {
    private static final long serialVersionUID = -5276853275660876163L;
    /**
     * 磁盘名称
     */
    private String name;
    /**
     * 磁盘大小
     */
    private String size;
    /**
     * 磁盘已用大小
     */
    private String used;
    /**
     * 磁盘剩余大小
     */
    private String free;
    /**
     * 资源的使用率
     */
    private double usage;
    /**
     * 磁盘类型
     */
    private String type;
    /**
     * 安装点(盘符路径)
     */
    private String mountpoint;
}
