package com.robustel.common.web.vo;

import com.alibaba.druid.util.StringUtils;

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

    public RtResponse(){

    }
    public RtResponse(Integer code, String msg,T data ){
        this.setCode(code,msg);
        this.data = data ;
    }

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

    public static RtResponse success() {
        return new RtResponse(0,"success",null);
    }

    /***
     * success:操作成功返回 <br/>
     *
     * @author he.kui
     * @param data
     *            返回到前端的数据对象
     * @return
     * @since JDK 1.7
     */
    public static <E> RtResponse<E> success(E data) {
        RtResponse result = new RtResponse(0,"success",data);
        return result;
    }


    /***
     * fail:操作失败时返回 <br/>
     *
     * @author he.kui
     * @param errCode
     *            错误代码
     * @return
     * @since JDK 1.7
     */
    public static RtResponse fail(int errCode) {
        RtResponse result = new RtResponse(errCode,"faliure",null);
        return result;
    }

    /**
     * 操作失败抛出错误代码和错误明细 fail:<br/>
     * @author gaolinlou
     * @param errCode
     * @param data
     * @return
     * @since JDK 1.7
     */
    public static <E> RtResponse<E> fail(int errCode,E data){
        RtResponse result = new RtResponse(errCode,"failure",null);
        return result;
    }


    /**
     * 操作失败抛出错误代码和错误信息 fail:<br/>
     *
     * @author he.kui
     * @param errCode
     * @param errMessage
     * @return
     * @since JDK 1.7
     */
    public static RtResponse fail(int errCode, String errMessage) {
        if (StringUtils.isEmpty(errMessage)) {
            return fail(errCode);
        } else {
            RtResponse result = new RtResponse(errCode, errMessage,null);
            return result;
        }
    }

}
