package com.robustel.pl.app.group.enums;

/**
 * 组织业务类型:0开发者，1运营商，2终端客户
 * 
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-06-10
 */
public enum OrgBizType {
    Developer("developer", 0), Operator("operator", 1), Client("client", 2);

    private String bizType;
    private int value;

    private OrgBizType(String bizType, int value) {
        this.bizType = bizType;
        this.value = value;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
