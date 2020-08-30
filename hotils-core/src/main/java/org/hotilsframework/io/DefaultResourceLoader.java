package org.hotilsframework.io;

import org.hotilsframework.core.classes.ClassLoaders;

import java.net.URL;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/24 00:06
 */
public class DefaultResourceLoader implements ResourceLoader {

    private ClassLoader classLoader;

    public DefaultResourceLoader() {
        this.classLoader = ClassLoaders.getDefaultClassLoader();
    }

    @Override
    public Resource getResource(String location) {
        URL url = this.classLoader.getResource(location);
        return (Resources.isFileURL(url) ? new FileUrlResource(url) : new UrlResource(url));
    }

    @Override
    public ClassLoader getClassLoader() {
        return this.classLoader;
    }
}
