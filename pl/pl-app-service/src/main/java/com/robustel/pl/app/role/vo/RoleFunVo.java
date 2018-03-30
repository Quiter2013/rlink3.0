package com.robustel.pl.app.role.vo;

import com.robustel.pl.app.role.entity.RoleFun;
import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 角色功能VO
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-29
 */
@Data
public class RoleFunVo implements Serializable {
    /** 角色权限ID */
    private String rfId;

    /** 角色ID */
    private String roleId;

    /** 角色名称 */
    private String roleName;

    /** 应用功能ID */
    private String funId;

    /** 功能名称 */
    private String funName;

    /** 数据权限Id */
    private String dataPrivilegeId;

    /** 关联时间 */
    private Long createTime;

    /** 创建人ID */
    private String createrId;

    /** 创建人 */
    private String creater;

    /** 修改时间 */
    private Long updateTime;

    /** 修改人 */
    private String updater;

    public RoleFun vo2Entity() {
        RoleFun rf = new RoleFun();
        rf.setCreater(creater);
        rf.setCreaterId(createrId);
        rf.setCreateTime(createTime);
        rf.setDataPrivilegeId(dataPrivilegeId);
        rf.setFunId(funId);
        rf.setRfId(rfId);
        rf.setRoleId(roleId);
        rf.setUpdater(updater);
        rf.setUpdateTime(updateTime);
        return rf;
    }
}
