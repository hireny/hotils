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

    private Cpu cpu;
    private Disk disk;
    private Jvm jvm;
    private Os os;
}
