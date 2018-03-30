package com.robustel.common.utils.constant;

/**
 * Created by leicheng on 2015/10/5.
 */
public enum RadioType {
    gsm(2), cdma(2), wcdma(3), hsdpa(3), hspa(3), evdo(3), lte(4), wifi(null), lan(null), bluetooth(null);

    /**
     * 级别，如2G，3G
     */
    private Integer level;

    private RadioType(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }
}
