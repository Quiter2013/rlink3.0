package com.robustel.common.web.vo;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;
import org.springframework.validation.annotation.Validated;

public class RtPageResponse<T extends List<?>> extends RtResponse<T> implements Serializable {
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

    private int size;

    public RtPageResponse() {
    }

    /**
     * 包装page对象
     * @param list
     * @param code
     * @param msg
     */
    public RtPageResponse(T list,int code,String msg) {
        this(list);
        setCode(code);
        setMsg(msg);

    }

    /**
     * 包装Page对象
     *
     * @param list          page结果
     */
    public RtPageResponse(T list) {
        if (list instanceof Page) {
            super.setCode(0);
            super.setMsg("success");
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.size = page.size();
            this.pageSize = page.getPageSize();
            this.setData(list);
        }else{
            super.setCode(0);
            this.pageNum =1;
            this.total =list.size();
            this.pages =1;
            this.size =list.size();
            this.pageSize =list.size();
            this.setData(list);
        }
    }

    @Validated
    public void setData(T data) {
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
