package org.hotilsframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;

/**
 * 资源的工具类
 * @Author: hireny
 * @Date: Create in 2019/07/24 00:17
 */
public class Resources {

    /** Pseudo URL prefix for loading from the class path: "classpath:". */
    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    /** URL prefix for loading from the file system: "file:". */
    public static final String FILE_URL_PREFIX = "file:";

    /** URL prefix for loading from a jar file: "jar:". */
    public static final String JAR_URL_PREFIX = "jar:";

    /** URL prefix for loading from a war file on Tomcat: "war:". */
    public static final String WAR_URL_PREFIX = "war:";

    /** URL protocol for a file in the file system: "file". */
    public static final String URL_PROTOCOL_FILE = "file";

    /** URL protocol for an entry from a jar file: "jar". */
    public static final String URL_PROTOCOL_JAR = "jar";

    /** URL protocol for an entry from a war file: "war". */
    public static final String URL_PROTOCOL_WAR = "war";

    /** URL protocol for an entry from a zip file: "zip". */
    public static final String URL_PROTOCOL_ZIP = "zip";

    /** URL protocol for an entry from a WebSphere jar file: "wsjar". */
    public static final String URL_PROTOCOL_WSJAR = "wsjar";

    /** URL protocol for an entry from a JBoss jar file: "vfszip". */
    public static final String URL_PROTOCOL_VFSZIP = "vfszip";

    /** URL protocol for a JBoss file system resource: "vfsfile". */
    public static final String URL_PROTOCOL_VFSFILE = "vfsfile";

    /** URL protocol for a general JBoss VFS resource: "vfs". */
    public static final String URL_PROTOCOL_VFS = "vfs";

    /** File extension for a regular jar file: ".jar". */
    public static final String JAR_FILE_EXTENSION = ".jar";

    /** Separator between JAR URL and file path within the JAR: "!/". */
    public static final String JAR_URL_SEPARATOR = "!/";

    /** Special separator between WAR URL and jar part on Tomcat. */
    public static final String WAR_URL_SEPARATOR = "*/";

    /**
     * 判断该url是否是文件的url
     * @param url
     * @return
     */
    public static boolean isFileURL(URL url) {
        String protocol = url.getProtocol();
        return (URL_PROTOCOL_FILE.equals(protocol)
                || URL_PROTOCOL_VFSFILE.equals(protocol)
                || URL_PROTOCOL_VFS.equals(protocol));
    }

    /**
     * 判断文件是图片格式
     * @param is
     * @return
     * @throws IOException
     */
    public static FileType getFileType(InputStream is) throws IOException {
        byte[] src = new byte[28];
        is.read(src, 0, 28);
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v).toUpperCase();
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        FileType[] fileTypes = FileType.values();
        for (FileType fileType : fileTypes) {
            if (stringBuilder.toString().startsWith(fileType.getValue())) {
                return fileType;
            }
        }
        return null;
    }

    public static void copyBytes(InputStream in, OutputStream out, int bufferSize, boolean close) throws IOException {
        if (close) {
            try (InputStream input = in; OutputStream output = out) {
                copyBytes(in, out, bufferSize);
            }
        } else {
            copyBytes(in, out, bufferSize);
        }
    }

    public static void copyBytes(InputStream in, OutputStream out, int bufferSize) throws IOException {
        PrintStream ps = out instanceof PrintStream ? (PrintStream) out : null;
        byte[] buffer = new byte[bufferSize];
        int bytesRead = -1;
        while ((bytesRead = in.read(buffer)) >= 0) {
            out.write(buffer, 0, bytesRead);
            if ((ps != null) && ps.checkError()) {
                throw new IOException("Unable to write to output stream.");
            }
        }
    }
}
