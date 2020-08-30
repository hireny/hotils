package org.hotilsframework.core.os;

import org.hotilsframework.lang.SystemUtils;

import java.io.Serializable;

/**
 * @ClassName: JvmInfo
 * @Author: hireny
 * @Date: Create in 2019/12/07 22:32
 * @Description: TODO   代表 Java Virtual Machine Implementation的信息。
 */
public class JvmInfo implements Serializable {
    private static final long serialVersionUID = -609373140313096234L;

    private final String JVM_NAME = SystemUtils.get(SystemPropertyKey.JVM_NAME, false);
    private final String JVM_VERSION = SystemUtils.get(SystemPropertyKey.JVM_VERSION, false);
    private final String JVM_VENDOR = SystemUtils.get(SystemPropertyKey.JVM_VENDOR, false);
    private final String JVM_INFO = SystemUtils.get(SystemPropertyKey.JVM_INFO, false);

    /**
     * 获取当前JVM 的名称
     *
     * <p>
     *     例如：Sun JDK 1.4.2：<code>"Java HotSpot(TM) Client VM"</code>
     * </p>
     * @return  属性值，如果不能取得(因为Java安全限制)或值不存在，则返回 {@code null}
     */
    public final String getName() {
        return JVM_NAME;
    }

    /**
     * 取得当前JVM impl.的版本（取自系统属性：<code>java.vm.version</code>）。
     *
     * <p>
     * 例如Sun JDK 1.4.2：<code>"1.4.2-b28"</code>
     * </p>
     *
     * @return 属性值，如果不能取得（因为Java安全限制）或值不存在，则返回<code>null</code>。
     *
     */
    public final String getVersion() {
        return JVM_VERSION;
    }

    /**
     * 取得当前JVM impl.的厂商（取自系统属性：<code>java.vm.vendor</code>）。
     *
     * <p>
     * 例如Sun JDK 1.4.2：<code>"Sun Microsystems Inc."</code>
     * </p>
     *
     * @return 属性值，如果不能取得（因为Java安全限制）或值不存在，则返回<code>null</code>。
     *
     */
    public final String getVendor() {
        return JVM_VENDOR;
    }

    /**
     * 取得当前JVM impl.的信息（取自系统属性：<code>java.vm.info</code>）。
     *
     * <p>
     * 例如Sun JDK 1.4.2：<code>"mixed mode"</code>
     * </p>
     *
     * @return 属性值，如果不能取得（因为Java安全限制）或值不存在，则返回<code>null</code>。
     *
     */
    public final String getInfo() {
        return JVM_INFO;
    }

    /**
     * 将Java Virutal Machine Implementation的信息转换成字符串。
     *
     * @return JVM impl.的字符串表示
     */
    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("JVM Name:    ").append(getName())
                .append("JVM Version: ").append(getVersion())
                .append("JVM Vendor:  ").append(getVendor())
                .append("JVM Info:    ").append(getInfo());

        return builder.toString();
    }
}
