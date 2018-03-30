package com.robustel.common.utils.machine.vo;

/**
 * 磁盘信息展示类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-07-07
 */
public class DiskVo {

    /** 分区名 */
    private String zoneName;

    /** 分区总大小 */
    private String zoneTotal;

    /** 分区剩余大小 */
    private String free;

    /** 分区可用大小 */
    private String avail;

    /** 分区已使用大小 */
    private String used;

    /** 分区利用率 */
    private String usage;

    /**
     * 分区的文件系统类型
     */
    private String sysTypeName;

    /**
     * 读取次数
     */
    private int readTimes;

    /**
     * 写次数
     */
    private int writes;

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getZoneTotal() {
        return zoneTotal;
    }

    public void setZoneTotal(String zoneTotal) {
        this.zoneTotal = zoneTotal;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getSysTypeName() {
        return sysTypeName;
    }

    public void setSysTypeName(String sysTypeName) {
        this.sysTypeName = sysTypeName;
    }

    public int getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(int readTimes) {
        this.readTimes = readTimes;
    }

    public int getWrites() {
        return writes;
    }

    public void setWrites(int writes) {
        this.writes = writes;
    }

}
