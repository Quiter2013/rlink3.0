package com.robustel.common.core.vo;

import java.io.Serializable;
/**
 * 定位地址
 * @author jingfangnan
 *
 */
public class CellLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer errcode;
	
    /**经度**/
    private Double lon;
    
    /**维度**/
    private Double lat;
    
    private Integer radius;
    
    
    private String address;


	public Integer getErrcode() {
		return errcode;
	}


	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}



	public Double getLon() {
		return lon;
	}


	public void setLon(Double lon) {
		this.lon = lon;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(Double lat) {
		this.lat = lat;
	}


	public Integer getRadius() {
		return radius;
	}


	public void setRadius(Integer radius) {
		this.radius = radius;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "CellLocation [errcode=" + errcode + ", lon=" + lon + ", lat="
				+ lat + ", radius=" + radius + ", address=" + address + "]";
	}

	
	
}
