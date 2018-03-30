package com.robustel.pl.app.group.facade;

import com.robustel.pl.app.group.entity.GroupInfo;

import java.util.List;

/**
 * @Desc 组业务实现接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-27
 */
public interface GroupInfoFacade {
	List<GroupInfo> findRootUsers();
}