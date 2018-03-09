package com.robustel.common.core.vo;

import java.io.Serializable;
import java.util.Map;
/**
 * 定位地址
 * @author jingfangnan
 *
 */
public class CellLocationCoor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	
	private String info;
	
	private String infocode;
	
	private Map<String,Object> result;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	
	
}
