package org.hotilsframework.io;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/23 13:57
 */
public interface Resource extends InputStreamSource {
    /**
     * 判断该资源是否存在
     * @return
     */
    boolean exists() throws ResourceException;

    /**
     * 判断该资源是否是文件
     * @return
     */
    default boolean isFile() throws ResourceException {
        return false;
    }

    /**
     * 判断该资源是否是目录
     * @return
     * @throws ResourceException
     */
    default boolean isDirectory() throws ResourceException {
        return false;
    }

    /**
     * 判断该资源是否是链接
     * @return
     * @throws ResourceException
     */
    default boolean isSymlink() throws ResourceException {
        return false;
    }

    /**
     * 获取统一资源定位符
     * @return
     * @throws IOException
     */
    URL getURL() throws IOException;

    /**
     * 获取统一资源标识符
     * @return
     * @throws IOException
     */
    URI getURI() throws IOException;
}
