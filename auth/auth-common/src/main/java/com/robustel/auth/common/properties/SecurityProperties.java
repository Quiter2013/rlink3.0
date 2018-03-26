package com.robustel.auth.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "custom.security")
@Component(value = "globalSecurityProperties")
public class SecurityProperties {
	private OAuth2Properties oauth2 = new OAuth2Properties();
	private UserDetailsProperties userDetails = new UserDetailsProperties();
	private String[] ignoredPatterns;
}
