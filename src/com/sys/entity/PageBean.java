package com.sys.entity;

/**
 * @author ybl
 * @version 1.0.1
 * @conpany 东风标准
 * @date 2019/11/27 17:26
 * @desciption
 */
public class PageBean {
    //当前页
    private Integer page=1;
    //页数
    private Integer pageSize = 2;
    //总记录数
    private Integer count;
    //总页数
    private Integer pageTotal;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageTotal() {
        return this.count % this.pageSize == 0 ? this.count / this.pageSize : this.count / this.pageSize + 1;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
