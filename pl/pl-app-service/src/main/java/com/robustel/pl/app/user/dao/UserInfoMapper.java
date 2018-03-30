package com.robustel.pl.app.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.user.entity.UserInfo;
import com.robustel.pl.app.user.vo.ParamUserVo;
import com.robustel.pl.app.user.vo.PlUserVo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 用户基本信息表操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
public interface UserInfoMapper extends Mapper<UserInfo> {

    /**
     * 修改指定用户的密码<br/>
     * 注：旧密码必须正确才能修改
     * @param oldPassword
     * @param newPassword
     * @param userId
     * @return
     */
    int changePassword(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword,
                       @Param("userId") String userId);

    /**
     * 根据登录账号获取记录总数
     * @param loginAccount
     * @param userId 用户ID[更新时必填]
     * @return
     */
    Long verifyUnique(@Param("loginAccount") String loginAccount, @Param("userId") String userId);

    /**
     * 用户登录
     * @param loginAccount
     * @param password
     * @return
     */
    UserInfo login(@Param("loginAccount") String loginAccount, @Param("password") String password);

    /**
     * RLink3：获取用户列表<br/>
     * 需求:只能获取当前登录用户所在组的用户列表
     * @param vo groupIds不能为空,模糊查询时参数为keyword，精确查询时为具体的字段
     * @return
     */
    List<UserInfo> queryList2RLink(ParamUserVo vo);

    /**
     * 平台：获取指定应用下的所有用户列表（带用户信息查询）<br/>
     * 需求: 按应用获取所有用户列表（如果没选应用，则获取所有的用户）
     * @param vo
     * @return
     */
    List<PlUserVo> queryUserList2Pl(ParamUserVo vo);

    /**
     * 根据登录账号或用户名获取用户信息
     * @param loginAccount 登录账号
     * @param userName 用户名
     * @return
     */
    UserInfo queryUserInfoByLoginAccountOrUserName(@Param("loginAccount") String loginAccount,
                                                   @Param("userName") String userName);

    List<UserInfo> queryUserByCompanyId(String companyId);

    List<UserInfo> queryUserByIds(List<String> userIds);
}