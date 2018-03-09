package com.robustel.common.core.vo;

import java.io.Serializable;
import java.util.Map;

public class CellLocationGoogle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocationAddr location;
	
	private float accuracy;

	

	public LocationAddr getLocation() {
		return location;
	}

	public void setLocation(LocationAddr location) {
		this.location = location;
	}

	public float getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}
	
	
	
	
	
}
