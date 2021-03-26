package org.hotilsframework.io;

/**
 * ResourceWrapperImpl
 *
 * 资源包装器
 *
 * @author hireny
 * @create 2020-12-31 14:28
 */
public class ResourceWrapperImpl implements ResourceWrapper {
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源类型
     */
    private String type;
    /**
     * 打开方式
     */
    private String launcher;
    /**
     * 资源位置
     */
    private String path;
    /**
     * 资源大小
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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String launcher() {
        return null;
    }

    @Override
    public String getPath() {
        return null;
    }

    @Override
    public String size() {
        return null;
    }

    @Override
    public String getSpace() {
        return null;
    }

    @Override
    public String getCreateTime() {
        return null;
    }

    @Override
    public String getModifyTime() {
        return null;
    }

    @Override
    public String[] modifyTimes() {
        return new String[0];
    }

    @Override
    public String getVisitTime() {
        return null;
    }

    @Override
    public String getProperty() {
        return null;
    }
}
