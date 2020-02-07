package org.hotilsframework.core.system;

import java.util.Objects;

/**
 * @ClassName: SystemInfo
 * @Author: hireny
 * @Date: Create in 2019/12/07 04:00
 * @Description: TODO   系统信息
 */
public class SystemInfo {
    /**
     * Java版本号
     */
    private String javaVersion;
    /**
     * Java提供商名称
     */
    private String javaVendor;
    /**
     * Java提供商网站
     */
    private String javaVendorUrl;
    /**
     * Java，哦，应该是jre目录
     */
    private String javaHome;
    /**
     * Java虚拟机规范版本号
     */
    private String javaVmSpecificationVersion;
    /**
     * Java虚拟机规范提供商
     */
    private String javaVmSpecificationVendor;
    /**
     * Java虚拟机规范名称
     */
    private String javaVmSpecificationName;
    /**
     * Java虚拟机版本号
     */
    private String javaVmVersion;
    /**
     * Java虚拟机提供商
     */
    private String javaVmVendor;
    /**
     * Java虚拟机名称
     */
    private String javaVmName;
    /**
     * Java规范版本号
     */
    private String javaSpecificationVersion;
    /**
     * Java推翻提供商
     */
    private String javaSpecificationVendor;
    /**
     * Java规范名称
     */
    private String javaSpecificationName;
    /**
     * Java类版本号
     */
    private String javaClassVersion;
    /**
     * Java类路径
     */
    private String javaClassPath;
    /**
     * Java lib路径
     */
    private String javaLibraryPath;
    /**
     * Java输入输出临时路径
     */
    private String javaIoTempDir;
    /**
     * Java编译器
     */
    private String javaCompiler;
    /**
     * Java执行路径
     */
    private String javaExtDirs;
    /**
     * 操作系统名称
     */
    private String osName;
    /**
     * 操作系统的架构
     */
    private String osArch;
    /**
     * 操作系统版本号
     */
    private String osVersion;
    /**
     * 文件分隔符
     */
    private String fileSeparator;
    /**
     * 路径分隔符
     */
    private String pathSeparator;
    /**
     * 直线分隔符
     */
    private String lineSeparator;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户的主目录
     */
    private String userHome;
    /**
     * 当前程序所在目录
     */
    private String userDir;

    public SystemInfo() {
        this.javaVersion = System.getProperty("java.version");
        this.javaVendor = System.getProperty("java.vendor");
        this.javaVendorUrl = System.getProperty("java.vendor.url");
        this.javaHome = System.getProperty("java.home");
        this.javaVmSpecificationVersion = System.getProperty("java.vm.specification.version");
        this.javaVmSpecificationVendor = System.getProperty("java.vm.specification.vendor");
        this.javaVmSpecificationName = System.getProperty("java.vm.specification.name");
        this.javaVmVersion = System.getProperty("java.vm.version");
        this.javaVmVendor = System.getProperty("java.vm.vendor");
        this.javaVmName = System.getProperty("java.vm.name");
        this.javaSpecificationVersion = System.getProperty("java.specification.version");
        this.javaSpecificationVendor = System.getProperty("java.specification.vendor");
        this.javaSpecificationName = System.getProperty("java.specification.name");
        this.javaClassVersion = System.getProperty("java.class.version");
        this.javaClassPath = System.getProperty("java.class.path");
        this.javaLibraryPath = System.getProperty("java.library.path");
        this.javaIoTempDir = System.getProperty("java.io.tmpdir");
        this.javaCompiler = System.getProperty("java.compiler");
        this.javaExtDirs = System.getProperty("java.ext.dirs");
        this.osName = System.getProperty("os.name");
        this.osArch = System.getProperty("os.arch");
        this.osVersion = System.getProperty("os.version");
        this.fileSeparator = System.getProperty("file.separator");
        this.pathSeparator = System.getProperty("path.separator");
        this.lineSeparator = System.getProperty("line.separator");
        this.userName = System.getProperty("user.name");
        this.userHome = System.getProperty("user.home");
        this.userDir = System.getProperty("user.dir");
    }


    public String getJavaVersion() {
        return javaVersion;
    }

    public String getJavaVendor() {
        return javaVendor;
    }

    public String getJavaVendorUrl() {
        return javaVendorUrl;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public String getJavaVmSpecificationVersion() {
        return javaVmSpecificationVersion;
    }

    public String getJavaVmSpecificationVendor() {
        return javaVmSpecificationVendor;
    }

    public String getJavaVmSpecificationName() {
        return javaVmSpecificationName;
    }

    public String getJavaVmVersion() {
        return javaVmVersion;
    }

    public String getJavaVmVendor() {
        return javaVmVendor;
    }

    public String getJavaVmName() {
        return javaVmName;
    }

    public String getJavaSpecificationVersion() {
        return javaSpecificationVersion;
    }

    public String getJavaSpecificationVendor() {
        return javaSpecificationVendor;
    }

    public String getJavaSpecificationName() {
        return javaSpecificationName;
    }

    public String getJavaClassVersion() {
        return javaClassVersion;
    }

    public String getJavaClassPath() {
        return javaClassPath;
    }

    public String getJavaLibraryPath() {
        return javaLibraryPath;
    }

    public String getJavaIoTempDir() {
        return javaIoTempDir;
    }

    public String getJavaCompiler() {
        return javaCompiler;
    }

    public String getJavaExtDirs() {
        return javaExtDirs;
    }

    public String getOsName() {
        return osName;
    }

    public String getOsArch() {
        return osArch;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getFileSeparator() {
        return fileSeparator;
    }

    public String getPathSeparator() {
        return pathSeparator;
    }

    public String getLineSeparator() {
        return lineSeparator;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserHome() {
        return userHome;
    }

    public String getUserDir() {
        return userDir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemInfo that = (SystemInfo) o;
        return Objects.equals(javaVersion, that.javaVersion) &&
                Objects.equals(javaVendor, that.javaVendor) &&
                Objects.equals(javaVendorUrl, that.javaVendorUrl) &&
                Objects.equals(javaHome, that.javaHome) &&
                Objects.equals(javaVmSpecificationVersion, that.javaVmSpecificationVersion) &&
                Objects.equals(javaVmSpecificationVendor, that.javaVmSpecificationVendor) &&
                Objects.equals(javaVmSpecificationName, that.javaVmSpecificationName) &&
                Objects.equals(javaVmVersion, that.javaVmVersion) &&
                Objects.equals(javaVmVendor, that.javaVmVendor) &&
                Objects.equals(javaVmName, that.javaVmName) &&
                Objects.equals(javaSpecificationVersion, that.javaSpecificationVersion) &&
                Objects.equals(javaSpecificationVendor, that.javaSpecificationVendor) &&
                Objects.equals(javaSpecificationName, that.javaSpecificationName) &&
                Objects.equals(javaClassVersion, that.javaClassVersion) &&
                Objects.equals(javaClassPath, that.javaClassPath) &&
                Objects.equals(javaLibraryPath, that.javaLibraryPath) &&
                Objects.equals(javaIoTempDir, that.javaIoTempDir) &&
                Objects.equals(javaCompiler, that.javaCompiler) &&
                Objects.equals(javaExtDirs, that.javaExtDirs) &&
                Objects.equals(osName, that.osName) &&
                Objects.equals(osArch, that.osArch) &&
                Objects.equals(osVersion, that.osVersion) &&
                Objects.equals(fileSeparator, that.fileSeparator) &&
                Objects.equals(pathSeparator, that.pathSeparator) &&
                Objects.equals(lineSeparator, that.lineSeparator) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userHome, that.userHome) &&
                Objects.equals(userDir, that.userDir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(javaVersion, javaVendor, javaVendorUrl, javaHome, javaVmSpecificationVersion, javaVmSpecificationVendor, javaVmSpecificationName, javaVmVersion, javaVmVendor, javaVmName, javaSpecificationVersion, javaSpecificationVendor, javaSpecificationName, javaClassVersion, javaClassPath, javaLibraryPath, javaIoTempDir, javaCompiler, javaExtDirs, osName, osArch, osVersion, fileSeparator, pathSeparator, lineSeparator, userName, userHome, userDir);
    }

    @Override
    public String toString() {
        return "SystemBean{" +
                "javaVersion='" + javaVersion + '\'' +
                ", javaVendor='" + javaVendor + '\'' +
                ", javaVendorUrl='" + javaVendorUrl + '\'' +
                ", javaHome='" + javaHome + '\'' +
                ", javaVmSpecificationVersion='" + javaVmSpecificationVersion + '\'' +
                ", javaVmSpecificationVendor='" + javaVmSpecificationVendor + '\'' +
                ", javaVmSpecificationName='" + javaVmSpecificationName + '\'' +
                ", javaVmVersion='" + javaVmVersion + '\'' +
                ", javaVmVendor='" + javaVmVendor + '\'' +
                ", javaVmName='" + javaVmName + '\'' +
                ", javaSpecificationVersion='" + javaSpecificationVersion + '\'' +
                ", javaSpecificationVendor='" + javaSpecificationVendor + '\'' +
                ", javaSpecificationName='" + javaSpecificationName + '\'' +
                ", javaClassVersion='" + javaClassVersion + '\'' +
                ", javaClassPath='" + javaClassPath + '\'' +
                ", javaLibraryPath='" + javaLibraryPath + '\'' +
                ", javaIoTempDir='" + javaIoTempDir + '\'' +
                ", javaCompiler='" + javaCompiler + '\'' +
                ", javaExtDirs='" + javaExtDirs + '\'' +
                ", osName='" + osName + '\'' +
                ", osArch='" + osArch + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", fileSeparator='" + fileSeparator + '\'' +
                ", pathSeparator='" + pathSeparator + '\'' +
                ", lineSeparator='" + lineSeparator + '\'' +
                ", userName='" + userName + '\'' +
                ", userHome='" + userHome + '\'' +
                ", userDir='" + userDir + '\'' +
                '}';
    }
}
