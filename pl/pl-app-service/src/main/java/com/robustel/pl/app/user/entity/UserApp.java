package com.robustel.pl.app.user.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 用户应用实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
@Data
@Table(name = "tbs_pl_user_app")
public class UserApp implements Serializable {
    /** 表主键，不参与业务 */
    @Id
    @GeneratedValue(generator = "UUID")
    private String pid;

    /** 应用ID */
    private String appId;

    /** 用户ID */
    private String userId;

    /** 是否默认应用：0否，1是。默认为0 */
    private String isDefault;

    /** 关联时间 */
    private Long createTime;

    /** 操作人 */
    private String creater;
}