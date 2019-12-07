package me.hireny.commons.utils;

import me.hireny.commons.core.system.SystemInfo;

import java.io.Serializable;

/**
 * @Author: hireny
 * @Date: Create in 2019/09/30 01:29
 */
public class Version implements Serializable {

    private SystemInfo systemInfo;

    private final static Version INSTANCE = new Version();

    public static Version getInstance() {
        return INSTANCE;
    }

    private Version() {
        this.systemInfo = new SystemInfo();
    }



    public SystemInfo getSystem() {
        return systemInfo;
    }

}
