package com.robustel.pl.app.role.enums;

/**
 * 角色范围枚举
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-07-11
 */
public enum RoleScopeType {
    SYSTEM_LEVEL("0"), USER_LEVEL("1"), COMMON_USE("2");

    private String level;

    private RoleScopeType(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
