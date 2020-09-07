package org.hotilsframework.core.os.model;

import java.io.Serializable;

/**
 * Os
 *
 * Os操作系统相关信息
 * @author hireny
 * @date Create in 2019/12/08 15:32
 */
public class Os implements Serializable {
    private static final long serialVersionUID = -3327968003619526055L;
    /**
     * 操作系统名称
     */
    private String name;
    /**
     * 操作系统架构
     */
    private String arch;
    /**
     * 操作系统版本
     */
    private String version;
}
