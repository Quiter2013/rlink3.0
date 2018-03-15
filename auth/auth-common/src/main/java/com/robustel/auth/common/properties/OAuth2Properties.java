package com.robustel.auth.common.properties;

public class OAuth2Properties {
	
	private String signingKey = "PB0J9^A0GZyvzMx^";
	
	private OAuth2ClientProperties client = new OAuth2ClientProperties();

	public OAuth2ClientProperties getClient() {
		return client;
	}

	public void setClient(OAuth2ClientProperties client) {
		this.client = client;
	}

	public String getSigningKey() {
		return signingKey;
	}

	public void setSigningKey(String signingKey) {
		this.signingKey = signingKey;
	}
}