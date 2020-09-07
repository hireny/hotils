package org.hotilsframework.core.os.model;

import java.io.Serializable;

/**
 * Cpu
 *
 * CPU相关信息
 *
 * @author hireny
 * @create 2020-07-24 8:46
 */
public class Cpu implements Serializable {
    private static final long serialVersionUID = -7673904826530936975L;
    /**
     * 核心数
     */
    private int number;
    /**
     * CPU总的使用率
     */
    private double total;
    /**
     * CPU系统使用率
     */
    private double sys;
    /**
     * CPU用户使用率
     */
    private double used;
    /**
     * CPU当前等待率
     */
    private double wait;
    /**
     * CPU当前空闲率
     */
    private double free;
}
