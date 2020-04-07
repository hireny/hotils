package org.hotilsframework.orm;

/**
 * 分页接口
 * @ClassName: Paginable
 * @Author: hireny
 * @Date: Created in 2020-02-09 23:51
 * @Version: 1.0
 */
public interface Paginable {
    /**
     * 总记录数
     * @return
     */
    int getTotalCount();

    /**
     * 总页数
     * @return
     */
    int getTotalPage();

    /**
     * 每页记录数
     * @return
     */
    int getPageSize();

    /**
     * 当前页号
     * @return
     */
    int getPageNo();

    /**
     * 是否第一页
     * @return
     */
    boolean isFirstPage();

    /**
     * 是否最后一页
     * @return
     */
    boolean isLastPage();

    /**
     * 返回下页的页号
     * @return
     */
    int getNextPage();

    /**
     * 返回上页的页号
     * @return
     */
    int getPreviousPage();
}
