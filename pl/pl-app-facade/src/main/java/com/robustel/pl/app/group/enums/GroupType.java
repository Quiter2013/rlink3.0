package com.robustel.pl.app.group.enums;

/**
 * 组织类型
 * 
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-06-10
 */
public enum GroupType {
    SocialCircle("SocialCircle", 0),
    Team("Team", 1),
    Organization("Organization", 2),
    Company("company", 3),
    Bloc("bloc", 4),
    InnerGroup("innerGroup", 5);

    private String groupType;
    private int value;

    private GroupType(String groupType, int value) {
        this.groupType = groupType;
        this.value = value;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
