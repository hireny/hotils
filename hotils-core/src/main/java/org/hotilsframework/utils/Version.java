package org.hotilsframework.utils;

import java.io.Serializable;

/**
 * @Author: hireny
 * @Date: Create in 2019/09/30 01:29
 */
public class Version implements Comparable<Version>, Serializable {

    protected String    name;
    protected String    comment;
    protected String    website;
    protected int       majorVersion = 1;
    protected int       minorVersion = 0;
    protected int       revisionVersion = 0;
    protected boolean   snapshot = false;

    public void setVersion(int major, int minor, int revision, boolean snapshot) {
        this.majorVersion = major;
        this.minorVersion = minor;
        this.revisionVersion = revision;
        this.snapshot = snapshot;
    }

    public void setVersion(String version) {
        if (null == version) {
            return;
        }
        version = version.toLowerCase();

        boolean snapshot = version.toLowerCase().contains("snapshot");

        String[] versions = version.split("[-]")[0].split("[.]");
    }

    @Override
    public int compareTo(Version o) {
        return 0;
    }
}
