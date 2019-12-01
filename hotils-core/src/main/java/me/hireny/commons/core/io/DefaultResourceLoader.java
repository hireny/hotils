package me.hireny.commons.core.io;


import me.hireny.commons.core.lang.Classes;

import javax.annotation.Nullable;
import java.net.URL;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/24 00:06
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Nullable
    private ClassLoader classLoader;

    public DefaultResourceLoader() {
        this.classLoader = Classes.getDefaultClassLoader();
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
