package org.hotilsframework.core.io;

/**
 * 资源信息
 * @ClassName: ResourceInfo
 * @Author: hireny
 * @Date: Created in 2020-01-28 14:37
 * @Version: 1.0
 */
public class ResourceInfo {
    /**
     * 文件名称
     */
    private String name;
    /**
     * 文件类型
     */
    private String type;
    /**
     * 打开方式
     */
    private String launcher;
    /**
     * 文件位置
     */
    private String path;
    /**
     * 文件大小
     */
    private String size;
    /**
     * 占用空间
     */
    private String space;

    private String createTime;

    private String modifyTime;
    /**
     * 访问时间
     */
    private String visitTime;
    /**
     * 属性(只读/隐藏)
     */
    private String property;
}
