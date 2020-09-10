package org.hotilsframework.core.os.model;

import java.io.Serializable;

/**
 * Memory
 *
 * Memory内存相关信息
 *
 * @author hireny
 * @create 2020-09-07 20:49
 */
public class Memory implements Serializable {
    private static final long serialVersionUID = -4760980095731185165L;
    /**
     * 内存总量
     */
    private double total;
    /**
     * 已用内存
     */
    private double used;
    /**
     * 剩余内存
     */
    private double free;
    private double shared;
    private double buffers;
    private double cached;
}
