package com.robustel.common.web.vo;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;

public class RtPageResponse extends RtResponse implements Serializable {
    /**
    * @字段说明 serialVersionUID
    */
    private static final long serialVersionUID = 1L;
    // 当前页
    private int pageNum;
    // 每页的数量
    private int pageSize;
    // 总记录数
    private long total;
    // 总页数
    private int pages;

    public RtPageResponse() {
    }

    @Validated
    public void setData(Object data) {
        super.setData(data);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", code=").append(getCode());
        sb.append(", msg=").append(getMsg());
        sb.append(", data=").append(getData());
        sb.append('}');
        return sb.toString();
    }
}
