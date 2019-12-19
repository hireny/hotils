package me.hireny.commons.core.lang;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @ClassName: HotilsClassLoader
 * @Author: hireny
 * @Date: Create in 2019/12/12 21:55
 * @Description: TODO   外部Jar的类加载器
 */
public class HotilsClassLoader extends URLClassLoader {

    public HotilsClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public HotilsClassLoader(URL[] urls) {
        super(urls);
    }

    public HotilsClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }
}
