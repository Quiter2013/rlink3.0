package com.robustel.common.web.vo;

/**
 * <p>定义 service 层的返回值</p>
 * @author jingfangnan
 * 
 */
public class ResultCode {

    /** 成功 */
    public static final int SUCCESS = 0;

    /** 失败 */
    public static final int FAILURE = -1;

    /** 参数错误 */
    public static final int PARAMETER_ERROR = 1;

    /** 数据库错误 */
    public static final int DB_ERROR = 2;

    /** 未登录 */
    public static final int NOT_LOGIN = 3;

    /** 用户不存在 **/
    public static final int USER_NOT_EXIST = 4;

    /** 无权限访问**/
    public static final int NOT_ACCESS = 5;

    /** 其他错误 */
    public static final int OTHER_ERROR = -999999;

    /** 内部服务器错误 */
    public static final int INTERNAL_SERVER_ERROR = 500;

    /**数据导入错误**/
    public static final int IMPORT_ERROR = 501;

    /**
     * 没有找到相关记录
     */
    public static final int DIC_NOT_RECORD = 5001;

    /**
     * 请求参数没有主键
     */
    public static final int NOT_PRIMARY = 5002;

    /**
     * 数字字典 更新/新增操作数据库失败
     */
    public static final int DIC_OPERATE_FAIL = 5002;

    /*************************link***********************/
    /**找不到记录**/
    public static final int RECORD_IS_NOT_EXISTS = 120001;
    /***无发送指令权限***/
    public static final int AUTH_ERROR_ON_COMD = 120002;

    // 没有设备信息
    public static final int NO_DEVICE_FOUND = 120003;

    // 没有模板信息
    public static final int NO_TEMPLATE_FOUND = 120004;

    // 指令下发失败
    public static final int SEND_COMMAND_FAILD = 120005;

    // 数据重复导入
    public static final int IMPORT_REP_DATA = 120006;

    // 指令发送成功
    public static final int SEND_COMMAND_SUCCESS = 120007;
    
    // 2.0设备不支持此操作
    public static final int UN_SUPPORT_OPERA = 120008;
    
    //以下设备记录不存在
    public static final int DEVICE_ERROR = 120009;
    //以下属性出现重复
    public static final int MUL_DEVICE_ERROR = 120010;
    //经度错误
    public static final int LONGITUDE_ERROR = 120011;
    //维度错误
    public static final int LATITUDE_ERROR = 120012;

    /*************************link***********************/

    /***************************iot*************************/
    // 查询不到产品定义规则
    public static final int NO_PRODUCT_RULE_FOUND = 160000;

    // 查询不到字段集合
    public static final int NO_PRODUCT_FIELD_FOUND = 160001;

    // 指令与字段不匹配
    public static final int NO_MATCHING_INSTRUCT = 160002;

    // 指令与字段长度不匹配
    public static final int INSTRUCT_LENGTH_NO_MATCHING = 160003;

    // 字段已经存在
    public static final int FIELD_EXISTENDS = 160004;

    // 查询不到相关动作
    public static final int NO_RECORD_ACTION = 160005;

    // 附件ID不能为空
    public static final int FIELD_ID_IS_NULL = 160006;

    // 附件为空
    public static final int ATTACH_MENT_IS_NULL = 160007;

    // 查询不到相关产品
    public static final int PRODUCT_IS_NULL = 160008;

    // 查询不到模块信息集合
    public static final int MODULE_IS_NULL = 160009;

    // 产品信息已经存在 不允许重复添加
    public static final int PRODUCT_EXIST = 160010;

    public static final int AGENT = 160011;
    
    /**
     *查找不到命令的相关记录
     */
    public static final int COMMAND_NOT_FOUND = 160012;

    /**
     * 固件升级失败
     */
    public static final int FIREWARE_UPGRADE_FAILURE = 160013;

    /**
     * 导出设备配置失败
     */
    public static final int EXPORT_CONFIG_FAILURE = 160014;

    // 非法产品数据包
    public static final int ERROR_PRODUCT_FILE = 160015;

    // 产品数据包已经被修改，请重新导入
    public static final int PRODUCT_FILE_CHANGED = 160016;
    
    //查询不到系统表参数
    public static final int SYSTEM_PARAM_IS_NULL = 160017;
    
    public static final int RULE_ACTION_MISMATCHING = 160018;
    
  //信号强度超出范围
    public static final int SINGAL_ERROR = 160019;
    
    //流量值非法
    public static final int FLOW_ERROR = 160020;

    /**************************iot**************************/

    /*----------------------- PL -----------------------*/
    /**
     * 记录已存在
     */
    public static final int RECORD_IS_EXISTS = 14001;

    /**
     * 添加记录失败
     */
    public static final int INSERT_FAULT = 14002;

    /**
     * 当前登录人没有归属组
     */
    public static final int NO_GROUP2LOGIN = 14003;

    /**
     * 没有找到记录，但还是成功的
     */
    public static final int NO_RECORD = 14004;

    /**
     * 请求参数缺少非空字段
     */
    public static final int LACK_SPECIFIC_PARAMETER = 14005;

    /**
     * 操作数据库失败
     */
    public static final int OPERATE_DB_ERROR = 14006;

    /**
     * 参数转换指定类型失败
     */
    public static final int CONVERT_FAIL = 14007;

    /**
     * 登录失效
     */
    public static final int LOGIN_LOSE_EFFICACY = 14008;

    /**
     * 当前登录人在当前应用有多个根组
     */
    public static final int MULTI_ROOT_GROUP = 14009;

    /**
     * 登录认证失败
     */
    public static final int LOGIN_VERIFY_FAIL = 14010;

    /**
     * 验证码错误
     */
    public static final int CAPTCHA_ERR = 14011;

    /**
     * 禁止存在两个默认应用
     */
    public static final int FORBID_TWO_DEFAULT_APP = 14012;

    /**
     * 已注册，请走license更新流程
     */
    public static final int ALREADY_REGISTER = 14013;

    /**
     * 用户所在组被禁用
     */
    public static final int GROUP_IS_FORBIDDEN = 14014;

    /**
     * 权限受限
     */
    public static final int FUNCTION_LIMIT = 14015;

    /**
     * 文件非法
     */
    public static final int FILE_ILLEGALITY = 14016;

    /**
     * 根组不能被禁用
     */
    public static final int ROOT_GROUP_CANNOT_FORBID = 14017;

    /**
     * 根据不能被删除
     */
    public static final int ROOT_GROUP_CANNOT_DELETE = 14018;

    /**
     * 被迫下线
     */
    public static final int FORCED_TO_LOGOFF = 14019;

    /**
     * 用户已被禁用
     */
    public static final int USER_FORBIDDEN = 14020;

    /**
     * 不能修改根组的管理员
     */
    public static final int ROOT_GROUP_MANAGER_IS_LOCKED = 14021;

    /**
     * 不能修改根组管理员的角色权限
     */
    public static final int ROOT_GROUP_MANAGER_ROLE_IS_LOCKED = 14022;

    /**
     * 根组成员不能取消，只能删除
     */
    public static final int ROOT_GROUP_MEMBER_CANNOT_RELIVE = 14023;

    /*----------------------- vpn -----------------------*/
    // 产品数据包已经被修改，请重新导入
    public static final int VPN_NODE_IS_NULL = 180001;
    public static final int VPN_MANAGER_IS_NULL = 180002;

    /*----------------------- vpn -----------------------*/
}
