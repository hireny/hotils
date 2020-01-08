package me.hireny.commons.core.io;


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
