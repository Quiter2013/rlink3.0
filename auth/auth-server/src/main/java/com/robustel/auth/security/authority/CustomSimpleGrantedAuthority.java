package com.robustel.auth.security.authority;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: gaolinlou
 * Description: 自定义实现GrantedAuthority否则无法从缓存中反序列化
 * Date: Created in 17:13 2018/3/16
 * Modified By:
 */
public class CustomSimpleGrantedAuthority implements GrantedAuthority,Serializable {
    private static final long serialVersionUID = 420L;
    private  String authority;

    public CustomSimpleGrantedAuthority() {

    }
    public CustomSimpleGrantedAuthority(String authority) {
        Assert.hasText(authority, "A granted authority textual representation is required");
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSimpleGrantedAuthority that = (CustomSimpleGrantedAuthority) o;
        return Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority);
    }
}
