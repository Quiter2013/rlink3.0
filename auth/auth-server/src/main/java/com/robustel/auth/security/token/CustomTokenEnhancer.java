package com.robustel.auth.security.token;

import com.robustel.auth.security.userdetails.CustomUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import com.robustel.auth.common.constants.SecurityConstants;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: gaolinlou
 * Description: 自定义Token增强，增加clientId和UserId附加信息
 * Date: Created in 16:23 2018/3/6
 * Modified By:
 */
public class CustomTokenEnhancer extends JwtAccessTokenConverter implements Serializable {
    private static int authenticateCodeExpiresTime = 10 * 60;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
                                     OAuth2Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        authentication.getUserAuthentication().getPrincipal();
        Map<String, Object> info = new HashMap<>();
        info.put(SecurityConstants.USER_ID_IN_HEADER, userDetails.getUserId());

        DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(info);

        OAuth2AccessToken enhancedToken = super.enhance(customAccessToken, authentication);
       // enhancedToken.getAdditionalInformation().put(TOKEN_SEG_CLIENT, userDetails.getClientId());
        return enhancedToken;
    }

}
