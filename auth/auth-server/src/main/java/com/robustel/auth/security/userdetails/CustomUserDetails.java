package com.robustel.auth.security.userdetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author: gaolinlou
 * Description: 自定义UserDetails
 * Date: Created in 16:23 2018/3/6
 * Modified By:
 */
public class CustomUserDetails implements UserDetails {
    static final long serialVersionUID = -7588980448693010399L;
    private String username;

    private String password;

    private boolean enabled = true;

    private String userId;

    private Collection<? extends GrantedAuthority> authorities;

    public String getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public static class CustomUserDetailsBuilder {
        private CustomUserDetails userDetails = new CustomUserDetails();

        public CustomUserDetailsBuilder withUsername(String username) {
            userDetails.setUsername(username);
            userDetails.setAuthorities(null);
            return this;
        }

        public CustomUserDetailsBuilder withPassword(String password) {
            userDetails.setPassword(password);
            return this;
        }

        public CustomUserDetailsBuilder withUserId(String userId) {
            userDetails.setUserId(userId);
            return this;
        }

        public CustomUserDetailsBuilder withAuthorities(Collection<? extends GrantedAuthority> authorities) {
            userDetails.setAuthorities(authorities);
            return this;
        }

        public CustomUserDetails build() {
            return userDetails;
        }
    }

}
