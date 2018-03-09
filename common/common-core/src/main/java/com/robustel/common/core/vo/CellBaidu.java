package com.robustel.common.core.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author jingfangnan
 *
 */
public class CellBaidu implements Serializable{
	
	private Integer status;
	
	private List<BaiduLoc> result;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<BaiduLoc> getResult() {
		return result;
	}

	public void setResult(List<BaiduLoc> result) {
		this.result = result;
	}
	
	
}
