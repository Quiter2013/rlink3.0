package com.robustel.common.web.vo;

import java.io.Serializable;

/**
* FileName：RtResponse.java
* version：1.0.0
* Author：HEKUI
* Date：2017年3月10日
* Updater：HEKUI
* UpdateTime：2017年3月10日
* Description：統一返回對象
* Copyright：Copyright 2016 Robustel, Inc. All Rights Reserved. http://www.robustel.com
*/
public class RtResponse<T> implements Serializable{
	 /**
     * 服务返回消息
     */
    private String msg;
    /**
     * 是否执行成功 0:成功 1:失败
     */
    private Integer code = new Integer(0);
    /**
     * 业务数据 没有使用attr的原因是，attr主要是用来放置查询条件的
     */
    private T data = null;
    public void setCode(Integer code, String msg) {
        this.setCode(code);
        this.msg = msg;
    }
    /**
     * 设置状态码。0-成功。非0-不成功.<br>
     * 当设置为0是，success会被设置为true。 当设置为false是，success会被设置为false。
     * 
     * @param code
     */
    public void setCode(Integer code) {
        if (code == null) {
            code = -1;
        }
        this.code = code;
    }

    public void setCode(int code, String msg) {
        setCode(code);
        setMsg(msg);
    }

    public Integer getCode() {
        return code;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
