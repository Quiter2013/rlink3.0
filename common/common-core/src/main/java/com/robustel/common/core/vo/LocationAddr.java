package com.robustel.common.core.vo;

import java.io.Serializable;

public class LocationAddr implements Serializable {
	
	private Double lat;
	
	private Double lng;

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	
}
