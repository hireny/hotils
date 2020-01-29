package org.hotilsframework.io;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/23 13:57
 */
public interface ResourceLoader {
    /**
     * 根据路径获取资源
     * @param location
     * @return
     */
    Resource getResource(String location);

    /**
     * 获取类加载器
     * 允许为空
     * @return
     */
    ClassLoader getClassLoader();
}
