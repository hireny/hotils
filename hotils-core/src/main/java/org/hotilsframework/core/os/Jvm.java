package org.hotilsframework.core.os;

import org.hotilsframework.math.Arithmetic;

import java.io.Serializable;
import java.math.RoundingMode;

/**
 * Jvm
 *
 * Jvm相关信息
 *
 * @author hireny
 * @create 2020-08-31 22:17
 */
public class Jvm implements Serializable {

    private static final long serialVersionUID = 7720887108178026638L;
    /**
     * 当前JVM占用的内存总数(M)
     */
    private double total;

    /**
     * JVM最大可用内存总数(M)
     */
    private double max;

    /**
     * JVM空闲内存(M)
     */
    private double free;

    /**
     * JDK版本
     */
    private String version;

    /**
     * JDK路径
     */
    private String home;

    public double getTotal() {
        return Arithmetic.divide(total, (1024 * 1024), 2, RoundingMode.HALF_UP);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMax() {
        return Arithmetic.divide(max, (1024 * 1024), 2, RoundingMode.HALF_UP);
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getFree() {
        return Arithmetic.divide(free, (1024 * 1024), 2, RoundingMode.HALF_UP);
    }

    public void setFree(double free) {
        this.free = free;
    }

    public double getUsed() {
        return Arithmetic.divide(total - free, (1024 * 1024), 2, RoundingMode.HALF_UP);
    }

    public double getUsage() {
        return Arithmetic.multiply(Arithmetic.divide(total - free, total, 4, RoundingMode.HALF_UP), 4);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    /**
     * JDK启动时间
     * @return
     */
    public String getStartTime() {
        return null;
    }

    /**
     * JDK运行时间
     * @return
     */
    public String getRunTime() {
        return null;
    }
}
