package org.hotilsframework.jdbc;

import java.util.List;

/**
 * @ClassName: Pagination
 * @Author: hireny
 * @Date: Created in 2020-02-10 0:20
 * @Version: 1.0
 */
public class Pagination extends DefaultPage {
    private static final long serialVersionUID = 262012605302370696L;

    private List list;

    public Pagination() {}

    /**
     * 构造器
     * @param pageNo        页码
     * @param pageSize      每页几条数据
     * @param totalCount    总共几条数据
     */
    public Pagination(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    /**
     * 构造器
     * @param pageNo        页码
     * @param pageSize      每页几条数据
     * @param totalCount    总共几条数据
     * @param list          分页内容
     */
    public Pagination(int pageNo, int pageSize, int totalCount, List list) {
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    /**
     * 第一条数据位置
     * @return
     */
    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 获得分页内容
     * @param <T>
     * @return
     */
    public <T> List<T> getList() {
        return list;
    }

//    /**
//     *
//     * @param clazz 列表容器内的元素类型
//     * @param <T>   列表容器内的元素类型
//     * @return
//     */
//    public <T> List<T> getList(Class<T> clazz) {
//        return Lang
//    }

    public void setList(List list) {
        this.list = list;
    }
}
