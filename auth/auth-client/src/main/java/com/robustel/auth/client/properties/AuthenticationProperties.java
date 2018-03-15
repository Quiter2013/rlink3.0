package com.robustel.auth.client.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 16:27 2018/3/14
 * Modified By:
 */
@ConfigurationProperties(prefix = "auth")
public class AuthenticationProperties {
    private Set<String> ignoredPatterns = new LinkedHashSet();

    public Set<String> getIgnoredPatterns() {
        return ignoredPatterns;
    }

    public void setIgnoredPatterns(Set<String> ignoredPatterns) {
        this.ignoredPatterns = ignoredPatterns;
    }

    public String[] getPermitURL(){
        if(ignoredPatterns == null){
            return new String[]{};
        }
        return ignoredPatterns.toArray(new String[ignoredPatterns.size()]);
    }

    public boolean isIgnored(String url) {
        for (String pattern : ignoredPatterns) {
            String currentUrl = pattern.replaceAll("\\*\\*", "(.*?)");
            Pattern currentPattern = Pattern.compile(currentUrl, Pattern.CASE_INSENSITIVE);
            if (currentPattern.matcher(url).find()) {
                return true;
            }
        }
        return false;
    }
}
