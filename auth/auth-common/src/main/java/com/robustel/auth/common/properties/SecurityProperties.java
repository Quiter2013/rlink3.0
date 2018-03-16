package com.robustel.auth.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "auth.security")
@Component(value = "globalSecurityProperties")
public class SecurityProperties {

	private OAuth2Properties oauth2 = new OAuth2Properties();
	private String[] ignoredPatterns;

	public OAuth2Properties getOauth2() {
		return oauth2;
	}

	public void setOauth2(OAuth2Properties oauth2) {
		this.oauth2 = oauth2;
	}

	public String[] getIgnoredPatterns() {
		return ignoredPatterns;
	}

	public void setIgnoredPatterns(String[] ignoredPatterns) {
		this.ignoredPatterns = ignoredPatterns;
	}
}
