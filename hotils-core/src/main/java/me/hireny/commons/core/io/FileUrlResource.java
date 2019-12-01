package me.hireny.commons.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static me.hireny.commons.core.io.ResourceConstants.*;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/24 00:25
 */
public class FileUrlResource extends UrlResource {

    private volatile File file;

    public FileUrlResource(URL url) {
        super(url);
    }

    /**
     * 判断该资源是否是文件
     * @return
     */
    @Override
    public boolean isFile() throws ResourceException {
        try {
            String protocol = this.getURL().getProtocol();
            return (URL_PROTOCOL_FILE.equals(protocol)
                    || URL_PROTOCOL_VFSFILE.equals(protocol)
                    || URL_PROTOCOL_VFS.equals(protocol));
        } catch (IOException e) {
            throw new ResourceException("URL获取失败");
        }
    }

    /**
     * 获取文件
     * @return
     * @throws IOException
     */
    public File getFile() throws IOException, ResourceException {
        if (this.isFile()) {
            this.file = new File(String.valueOf(this.getURL().getFile()));
        }
        return null;
    }
}
