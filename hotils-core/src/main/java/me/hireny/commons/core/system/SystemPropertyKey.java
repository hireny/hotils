package me.hireny.commons.core.system;

/**
 * @ClassName: SystemPropertyKey
 * @Author: hireny
 * @Date: Create in 2019/12/07 22:38
 * @Description: TODO   系统属性名称常量池
 * 封装了包括Java运行时信息、Java虚拟机信息、Java类信息、OS信息、用户信息等
 */
public interface SystemPropertyKey {

    //******************Java运行时环境信息**********************//
    /**
     * Java版本号，Java运行时环境版本
     */
    String VERSION = "java.version";
    /**
     * Java提供商名称,Java运行时环境供应商
     */
    String VENDOR = "java.vendor";
    /**
     * Java提供商网站,Java供应商的URL
     */
    String VENDOR_URL = "java.vendor.url";
    /**
     * Java，哦，应该是jre目录,Java安装目录
     */
    String HOME = "java.home";

    /**
     * Java规范版本号，Java运行时环境规范版本
     */
    String SPECIFICATION_VERSION = "java.specification.version";
    /**
     * Java规范提供商，Java运行时环境规范供应商
     */
    String SPECIFICATION_VENDOR = "java.specification.vendor";
    /**
     * Java规范名称,Java运行时环境规范名称
     */
    String SPECIFICATION_NAME = "java.specification.name";
    /**
     * Java lib路径，加载库时搜索的路径列表
     */
    String LIBRARY_PATH = "java.library.path";
    /**
     * Java输入输出临时路径，默认的临时文件路径
     */
    String TMPDIR = "java.io.tmpdir";
    /**
     * Java编译器，要使用 JIT编译器的名称
     */
    String COMPILER = "java.compiler";
    /**
     * Java执行路径,一个或多个扩展目录的路径
     */
    String EXT_DIRS = "java.ext.dirs";

    //******************Java运行时环境信息**********************//


    //******************Java虚拟机信息**********************//
    /**
     * Java虚拟机版本号
     */
    String JVM_VERSION = "java.vm.version";
    /**
     * Java虚拟机提供商
     */
    String JVM_VENDOR = "java.vm.vendor";
    /**
     * Java虚拟机名称
     */
    String JVM_NAME = "java.vm.name";
    /**
     * Java虚拟机信息
     */
    String JVM_INFO = "java.vm.info";
    /**
     * Java虚拟机规范版本号
     */
    String JVM_SPECIFICATION_VERSION = "java.vm.specification.version";
    /**
     * Java虚拟机规范提供商
     */
    String JVM_SPECIFICATION_VENDOR= "java.vm.specification.vendor";
    /**
     * Java虚拟机规范名称
     */
    String JVM_SPECIFICATION_NAME = "java.vm.specification.name";


    //******************Java虚拟机信息**********************//


    //******************Java类信息**********************//
    /**
     * Java类版本号
     */
    String JAVA_CLASS_VERSION = "java.class.version";
    /**
     * Java类路径
     */
    String JAVA_CLASS_PATH = "java.class.path";
    //******************Java类信息**********************//


    //******************OS信息**********************//
    /**
     * 操作系统名称
     */
    String OS_NAME = "os.name";
    /**
     * 操作系统的架构
     */
    String OS_ARCH = "os.arch";
    /**
     * 操作系统版本号
     */
    String OS_VERSION = "os.version";
    /**
     * 文件分隔符
     */
    String FILE_SPEARATOR = "file.separator";
    /**
     * 路径分隔符
     */
    String PATH_SEPARATOR = "path.separator";
    /**
     * 直线分隔符
     */
    String LINE_SEPARATOR = "line.separator";
    //******************OS信息**********************//







    //******************用户信息**********************//
    /**
     * 用户名
     */
    String USER_NAME = "user.name";
    /**
     * 用户的主目录
     */
    String USER_HOME = "user.home";
    /**
     * 当前程序所在目录
     */
    String USER_DIR = "user.dir";
    //******************用户信息**********************//
}
