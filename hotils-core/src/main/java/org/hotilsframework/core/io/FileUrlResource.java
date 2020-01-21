package org.hotilsframework.core.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/24 00:25
 */
public class FileUrlResource extends UrlResource {

    private static final Logger logger = LoggerFactory.getLogger(FileUrlResource.class);

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
            return (ResourceConstants.URL_PROTOCOL_FILE.equals(protocol)
                    || ResourceConstants.URL_PROTOCOL_VFSFILE.equals(protocol)
                    || ResourceConstants.URL_PROTOCOL_VFS.equals(protocol));
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
            return this.file;
        }
        return null;
    }

    /**
     * 读取文件
     * @param fileName
     * @return
     */
    public static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<>();
        BufferedReader reader = null;
        FileInputStream fis = null;
        try  {
            File f = new File(fileName);
            if (f.isFile() && f.exists()) {
                fis = new FileInputStream(f);
                reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!"".equals(line)) {
                        list.add(line);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("readFile", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.error("InputStream关闭异常", e);
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                logger.error("FileInputStream关闭异常", e);
            }
        }
        return list;
    }
}
