package org.hotilsframework.lang;

/**
 * ClassLoaders
 *
 * 类加载器
 *
 * @author hireny
 * @create 2020-07-26 10:13
 */
public class ClassLoaders {

    /**
     * 获取默认的类加载器
     * @return
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable t) {
            // Cannot access thread context ClassLoader - failling back...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            // 没有线程上下文类加载器 -> 使用该类的类加载器
            cl = Class.class.getClassLoader();
            if (cl == null) {
                // getClassLoader() returning null indicates the bootstrap ClassLoader
                // 该类的类加载器运行为空，表示引导类加载器
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable t) {
                    // Cannot access system ClassLoader - oh well, maybe the caller can live with null...
                    // 无法访问系统类加载器 - 哦，也许调用者可以使用null.
                }
            }
        }
        return cl;
    }
}
