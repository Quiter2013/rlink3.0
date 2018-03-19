package com.robustel.auth.common.properties;

import lombok.Data;

@Data
public class OAuth2Properties {
	private String signingKey = "PB0J9^A0GZyvzMx^";
	private OAuth2ClientProperties client = new OAuth2ClientProperties();
}