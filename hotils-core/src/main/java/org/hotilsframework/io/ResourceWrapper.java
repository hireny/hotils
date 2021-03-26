package org.hotilsframework.io;

/**
 * ResourceWrapper
 *
 * 资源包装器
 *
 * @author hireny
 * @create 2020-12-31 14:14
 */
public interface ResourceWrapper {
    /**
     * 获取资源名称
     * @return
     */
    String getName();

    /**
     * 获取资源类型
     * @return
     */
    String getType();

    /**
     * 打开方式
     * @return
     */
    String launcher();

    /**
     * 获取资源位置
     * @return
     */
    String getPath();

    /**
     * 获取资源大小
     * @return
     */
    String size();

    /**
     * 占用空间
     * @return
     */
    String getSpace();

    /**
     * 创建时间
     * @return
     */
    String getCreateTime();

    /**
     * 修改时间
     * @return
     */
    String getModifyTime();

    /**
     * 修改时间集合
     * @return
     */
    String[] modifyTimes();

    /**
     * 访问时间
     * @return
     */
    String getVisitTime();

    /**
     * 属性（只读/隐藏）
     *
     * r - 只读模式 文件以只读模式打开。
     * rw - 读写模式 该文件以读写模式打开。 如果文件不存在，则创建该文件。
     * rws - 读写模式 该文件以读写模式打开。 对文件的内容及其元数据的任何修改立即被写入存储设备。
     * rwd - 读写模式 该文件以读写模式打开。 对文件内容的任何修改立即写入存储设备。
     * @return
     */
    String getProperty();
}
