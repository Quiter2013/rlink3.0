package com.robustel.auth.common.properties;

import lombok.Data;

@Data
public class OAuth2ClientProperties {
	private String clientId;
	private String clientSecret;
	private int accessTokenValiditySeconds;
	private String authServiceId;
	private String checkTokenEndpointUrl;
	private boolean enableCache;
}