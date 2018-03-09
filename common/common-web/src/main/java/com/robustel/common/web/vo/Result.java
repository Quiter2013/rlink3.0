package com.robustel.common.web.vo;

import java.io.Serializable;


/**
 * 返回值对象
 * @author jingfangnan
 *
 */
public class Result implements Serializable {

	private static final long serialVersionUID = -1586118647101027089L;

	/**
	 * 返回代码
	 */
	private int code = ResultCode.FAILURE;
	
	/**
	 * 信息
	 */
	private String message;
	
	/**
	 * 对象
	 */
	private Object object;
	
	/**
	 * 是否成功
	 */
	private boolean success = false;
	
	public Result() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
		this.success = (code == ResultCode.SUCCESS);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
