package org.hotilsframework.core.io;

/**
 * ResourceConstants
 *
 * 资源常量
 * @Author: hireny
 * @Date: Create in 2019/10/05 22:50
 */
public interface ResourceConstants {

    /** Pseudo URL prefix for loading from the class path: "classpath:". */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /** URL prefix for loading from the file system: "file:". */
    String FILE_URL_PREFIX = "file:";

    /** URL prefix for loading from a jar file: "jar:". */
    String JAR_URL_PREFIX = "jar:";

    /** URL prefix for loading from a war file on Tomcat: "war:". */
    String WAR_URL_PREFIX = "war:";

    /** URL protocol for a file in the file system: "file". */
    String URL_PROTOCOL_FILE = "file";

    /** URL protocol for an entry from a jar file: "jar". */
    String URL_PROTOCOL_JAR = "jar";

    /** URL protocol for an entry from a war file: "war". */
    String URL_PROTOCOL_WAR = "war";

    /** URL protocol for an entry from a zip file: "zip". */
    String URL_PROTOCOL_ZIP = "zip";

    /** URL protocol for an entry from a WebSphere jar file: "wsjar". */
    String URL_PROTOCOL_WSJAR = "wsjar";

    /** URL protocol for an entry from a JBoss jar file: "vfszip". */
    String URL_PROTOCOL_VFSZIP = "vfszip";

    /** URL protocol for a JBoss file system resource: "vfsfile". */
    String URL_PROTOCOL_VFSFILE = "vfsfile";

    /** URL protocol for a general JBoss VFS resource: "vfs". */
    String URL_PROTOCOL_VFS = "vfs";

    /** File extension for a regular jar file: ".jar". */
    String JAR_FILE_EXTENSION = ".jar";

    /** Separator between JAR URL and file path within the JAR: "!/". */
    String JAR_URL_SEPARATOR = "!/";

    /** Special separator between WAR URL and jar part on Tomcat. */
    String WAR_URL_SEPARATOR = "*/";



    /** 默认缓存大小 8192*/
    int DEFAULT_BUFFER_SIZE = 2 << 12;
    /** 默认中等缓存大小 16384*/
    int DEFAULT_MIDDLE_BUFFER_SIZE = 2 << 13;
    /** 默认大缓存大小 32768*/
    int DEFAULT_LARGE_BUFFER_SIZE = 2 << 14;

    /** 数据流末尾 */
    int EOF = -1;

}
