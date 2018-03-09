package com.robustel.common.core.vo;

import java.io.Serializable;
/**
 * 参数VO基类
 * @author jingfangnan
 *
 */
public class BaseEntityVO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**签名**/
	private String sign;
	
	/**时间戳**/
	private Long timeStamp;
	
	/**验证令牌token**/
	private String token;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
