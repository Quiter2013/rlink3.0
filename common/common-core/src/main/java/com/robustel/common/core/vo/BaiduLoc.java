package com.robustel.common.core.vo;

import java.io.Serializable;

/**
 * 
 * @author jingfangnan
 *
 */
public class BaiduLoc implements Serializable {
	
	private Double x;
	
	private Double y;

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "BaiduLoc [x=" + x + ", y=" + y + "]";
	}
	
	
}
