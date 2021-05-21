package org.hotilsframework.core;

/**
 * HotilsVersion
 *
 * 项目版本
 *
 * @author hireny
 * @create 2020-07-10 14:46
 */
public final class HotilsVersion {
    private HotilsVersion() {}

    /**
     * 返回当前代码的完整版本字符串，如果不能确定，则返回 {@code null}。
     * @return
     */
    public static String getVersion() {
        Package pkg = HotilsVersion.class.getPackage();
        return (pkg != null ? pkg.getImplementationVersion() : null);
    }
}
