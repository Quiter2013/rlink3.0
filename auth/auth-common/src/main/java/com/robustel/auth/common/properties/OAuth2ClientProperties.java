package com.robustel.auth.common.properties;

public class OAuth2ClientProperties {
	private String clientId;
	private String clientSecret;
	private int accessTokenValiditySeconds;
	private String authServiceId;
	private String checkTokenEndpointUrl;
	private boolean enableCache;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public int getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	public String getAuthServiceId() {
		return authServiceId;
	}

	public void setAuthServiceId(String authServiceId) {
		this.authServiceId = authServiceId;
	}

	public String getCheckTokenEndpointUrl() {
		return checkTokenEndpointUrl;
	}

	public void setCheckTokenEndpointUrl(String checkTokenEndpointUrl) {
		this.checkTokenEndpointUrl = checkTokenEndpointUrl;
	}

	public boolean isEnableCache() {
		return enableCache;
	}

	public void setEnableCache(boolean enableCache) {
		this.enableCache = enableCache;
	}
}