package org.hotilsframework.orm;


import org.hotilsframework.core.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * 默认的分页类
 * @ClassName: SimplePage
 * @Author: hireny
 * @Date: Created in 2020-02-09 23:55
 * @Version: 1.0
 */
public class DefaultPage implements Paginable, Serializable {
    private static final long serialVersionUID = -2607043826294479899L;
    /**
     * 默认的分页数
     */
    public static final int DEFAULT_COUNT = 10;
    private List<Integer> localArrayList = Lists.newArrayList();

    protected int totalCount = 0;
    protected int pageSize = 20;
    protected int pageNo = 1;

    int minPage = pageNo - (int) Math.floor((pageSize - 1) / 2.0D);
    int maxPage = pageNo + (int) Math.ceil((pageSize - 1) / 2.0D);
    int totalPage = getTotalPage();

    public List<Integer> getSegment() {
        return localArrayList;
    }

    /**
     * 检查页码 checkPageNo
     * @param pageNo
     * @return  if pageNo == null or pageNo < 1 then return 1 else return pageNO
     */
    public static int cpn(Integer pageNo) {
        return (pageNo == null || pageNo < 1) ? 1 : pageNo;
    }

    public DefaultPage() {}

    /**
     * 构造器
     * @param pageNo        页码
     * @param pageSize      每页几条数据
     * @param totalCount    总共几条数据
     */
    public DefaultPage(int pageNo, int pageSize, int totalCount) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);
        adjustPageNo();
        int totalPages = getTotalPage();
        minPage = minPage < 1 ? 1 : minPage;
        maxPage = maxPage > totalPages ? totalPages : maxPage;
        for (int i = minPage; i <= maxPage; i++) {
            localArrayList.add(i);
        }
    }

    /**
     * 调整页码，使得不超过最大页数
     */
    public void adjustPageNo() {
        if (pageNo == 1) {
            return;
        }
        int tp = getTotalPage();
        if (pageNo > tp) {
            pageNo = tp;
        }
    }

    /**
     * 总共几条数据
     * @return
     */
    @Override
    public int getTotalCount() {
        return this.totalCount;
    }

    /**
     * if totalCount < 0 then totalCount = 0
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
    }

    /**
     * 总共几页
     * @return
     */
    @Override
    public int getTotalPage() {
        int totalPage = totalCount / pageSize;
        if (totalPage == 0 || totalCount % pageSize != 0) {
            totalPage++;
        }
        return totalPage;
    }

    /**
     * 每页几条数据
     * @return
     */
    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * if pageSize < 1 then pageSize = DEFAULT_COUNT
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = DEFAULT_COUNT;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * 获得页码
     * @return
     */
    @Override
    public int getPageNo() {
        return this.pageNo;
    }

    /**
     * if pageNo < 1 then pageNo = 1
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
    }

    /**
     * 是否第一页
     * @return
     */
    @Override
    public boolean isFirstPage() {
        return pageNo <= 1;
    }

    /**
     * 是否最后一页
     * @return
     */
    @Override
    public boolean isLastPage() {
        return pageNo >= getTotalPage();
    }

    /**
     * 下一页页码
     * @return
     */
    @Override
    public int getNextPage() {
        if (isLastPage()) {
            return pageNo;
        }
        return pageNo + 1;
    }

    /**
     * 上一页页码
     * @return
     */
    @Override
    public int getPreviousPage() {
        // 判断是否是第一页
        if (isFirstPage()) {
            return pageNo;
        }
        return pageNo - 1;
    }
}
