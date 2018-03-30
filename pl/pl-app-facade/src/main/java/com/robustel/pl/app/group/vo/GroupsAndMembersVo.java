package com.robustel.pl.app.group.vo;

import com.robustel.pl.app.user.vo.PlUserVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc 组树数据及其组员列表包装类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-23
 */
@Data
public class GroupsAndMembersVo implements Serializable{

    /**
     * 组信息
     */
    private GroupInfoDatagridVo groupInfo;

    /**
     * 组员列表
     */
    private List<PlUserVo> nodes;
}
