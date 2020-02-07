package org.hotilsframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;

/**
 * 文件资源
 * @ClassName: FileResource
 * @Author: hireny
 * @Date: Created in 2020-02-06 13:25
 * @Version: 1.0
 */
public class FileResource implements Resource {

    private File resource;

    private FileResource(File resource) {
        this.resource = resource;
    }

    public long size() {
        return size(resource);
    }

    private long size(File resource) {
        if (resource.isDirectory()) {
            return sizeOfDirectory(resource);
        }
        return sizeOfFile(resource);
    }

    private long sizeOfFile(final File file) {
        return file.length();
    }

    private long sizeOfDirectory(final File directory) {
        final File[] files = directory.listFiles();
        if (files == null) {
            // null if security restricted
            return 0L;
        }

        long size = 0;

        for (final File file : files) {
            FileResource fr = FileResource.of(file);
            if (!fr.isSymlink()) {
                size += fr.size();
                if (size < 0) {
                    break;
                }
            }

        }
        return size;
    }

    @Override
    public boolean exists() throws ResourceException {
        return resource.exists();
    }

    @Override
    public boolean isFile() throws ResourceException {
        return resource.isFile();
    }

    @Override
    public boolean isDirectory() throws ResourceException {
        return resource.isDirectory();
    }

    /**
     * 是否是链接
     * @return
     * @throws ResourceException
     */
    @Override
    public boolean isSymlink() throws ResourceException {
        return Files.isSymbolicLink(resource.toPath());
    }

    @Override
    public URL getURL() throws IOException {
        return null;
    }

    @Override
    public URI getURI() throws IOException {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    //=====================================================
    // 静态方法
    //=====================================================

    public static FileResource of(File file) throws ResourceException {
        return new FileResource(file);
    }
}
