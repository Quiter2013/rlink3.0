package com.robustel.pl.app.user.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 用户角色实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-29
 */
@Data
@Table(name = "tbs_pl_user_role")
public class UserRole implements Serializable {
    /** 用户角色ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String userRoleId;

    /** 用户ID */
    private String userId;

    /** 角色ID */
    private String roleId;

    /** 关联时间 */
    private Long operateTime;

    /** 关联人ID */
    private String operaterId;

    /** 关联人名称 */
    private String operaterName;
}
