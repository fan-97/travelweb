package com.qingda.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * M : 数据封装 处理简单的业务逻辑
 * @param <T>
 */
public class PageBean<T>{
    private List<T> data = new ArrayList<T>(); // : 当前页面的数据信息
    private int pageNumber;//: 当前页页码
    private int pageSize ;//: 每页显示条数
    private int totalCount ;//: 总条数
    private int totalPage ;//: 总页数
    //-------
    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public PageBean(int pageNumber, int pageSize, int totalCount) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    // 计算起始索引
    public int getStartIndex(){
        return (pageNumber-1) * pageSize;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 计算总页数
     * @return
     */
    public int getTotalPage() {
        double totalPage = Math.ceil(totalCount * 1.0 / pageSize);
        return (int)totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + data +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
