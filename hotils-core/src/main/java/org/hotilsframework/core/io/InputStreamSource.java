package org.hotilsframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hireny
 * @date Create in 2019/07/23 23:56
 */
public interface InputStreamSource {

    /**
     * 返回底层的资源
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
