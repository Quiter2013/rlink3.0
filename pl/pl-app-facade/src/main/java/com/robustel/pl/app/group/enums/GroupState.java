package com.robustel.pl.app.group.enums;

/**
 * 组状态枚举
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-07-11
 */
public enum GroupState {
    CAN_USE("0"), FORBIDDEN("1");

    private String value;

    private GroupState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
