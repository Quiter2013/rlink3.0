/**
 * Project Name:km-cs
 * File Name:ErrorCode.java
 * Package Name:com.kingmed.cs.common.constant
 * Date:2015年4月17日下午3:15:39
 * Copyright (c) 2015, 625575981@qq.com All Rights Reserved.
 *
 */

package com.robustel.common.utils.constant;

/**
 * ClassName:ErrorCode <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO 系统错误代码定义常量类<br/>
 * Date: 2015年4月17日 下午3:15:39 <br/>
 * 
 * @author he.kui
 * @version
 * @since JDK 1.7
 * @see
 */
public class ErrCode {
	/**
	 * 成功返回码表值
	 * 
	 * 
	 */
	public final static String SUCCESS = "1";// 成功返回码表值
	/**
	 * 成功错误码表值
	 */
	public final static String FAIL = "0";// 成功错误码表值


	// 1开头为调用接口类异常
	/**
	 * 非法参数
	 */
	public final static String ERROR_CODE100 = "100";// 非法参数
	/**
	 * 非法操作
	 */
	public final static String ERROR_CODE101 = "101";// 非法操作
	/**
	 * 请求无效
	 */
	public final static String ERROR_CODE102 = "102";// 请求无效
	/**
	 * 禁止访问
	 */
	public final static String ERROR_CODE103 = "103";// 禁止访问
	/**
	 * 未实现
	 */
	public final static String ERROR_CODE104 = "104";// 未实现

	/**
	 * 无法找到资源
	 */
	public final static String ERROR_CODE105 = "105";// 无法找到资源
	/**
	 * 资源被禁止
	 */
	public final static String ERROR_CODE106 = "106";// 资源被禁止
	/**
	 * 网管错误
	 */
	public final static String ERROR_CODE107 = "107";// 网管错误
	/**
	 * 未登陆
	 */
	public final static String ERROR_CODE108 = "108";// 未登陆
	/**
	 * 无权限
	 */
	public final static String ERROR_CODE109 = "109";// 无权限

	/**
	 * 系统无法提供服务
	 */
	public final static String ERROR_CODE110 = "110";// 系统无法提供服务
	/**
	 * 参数太少
	 */
	public final static String ERROR_CODE111 = "111";// 参数太少
	/**
	 * 参数错误
	 */
	public final static String ERROR_CODE112 = "112";// 参数错误
	/**
	 * 参数为空
	 */
	public final static String ERROR_CODE113 = "113";// 参数为空
	/**
	 * JSON解析异常
	 */
	public final static String ERROR_CODE114 = "114";// JSON解析异常
	/**
	 * JSON匹配异常
	 */
	public final static String ERROR_CODE115 = "115";// JSON匹配异常
	/**
	 * 数据不存在
	 */
	public final static String ERROR_CODE116 = "116";// 数据不存在
	/**
	 * 表单验证异常
	 */
	public final static String ERROR_CODE117 = "117";// 表单验证异常
	/**
	 * 操作过频繁
	 */
	public final static String ERROR_CODE118 = "118";// 操作过频繁

	/**
	 * 服务器内部对象转换异常
	 */
	public final static String ERROR_CODE119 = "119";// 服务器内部对象转换异常

	/**
	 * 与数据库交换异常
	 */
	public final static String ERROR_CODE120 = "120";// 与数据库交换异常
	/****
	 * 邮箱不正确
	 */
	public final static String ERROR_CODE123 = "123";// 邮箱不正确

	/**
	 * 手机号码不正确
	 */
	public final static String ERROR_CODE121 = "121";// 手机号码不正确

	/**
	 * 该号码已被使用
	 */
	public final static String ERROR_CODE130 = "130";// 该号码已被使用

	/**
	 * 验证码已发出,请稍后再试
	 */
	public final static String ERROR_CODE131 = "131";

	/**
	 * 验证码获取异常,请稍后再试
	 */
	public final static String ERROR_CODE132 = "132";

	/**
	 * 暂不支持邮件注册
	 */
	public final static String ERROR_CODE133 = "133";

	/**
	 * 不支持该请求类型
	 */
	public final static String ERROR_CODE134 = "134";

	/****************/
	/**
	 * 用户不存在
	 */
	public final static String ERROR_CODE140 = "140";
	/***
	 * 用户名或密码错误!
	 */
	public final static String ERROR_CODE141 = "141";
	
	/***
	 * 验证码错误
	 */
	public final static String ERROR_CODE142 = "142";
	
	/***
	 * 账号已被注册
	 */
	public final static String ERROR_CODE143 = "143";
	

	/***
	 * 上传格式不正确
	 */
	public final static String ERROR_CODE144 = "144";
	


	/***
	 * 数据重复
	 */
	public final static String ERROR_CODE145 = "145";
	

	/***
	 * 数据关联操作异常
	 */
	public final static String ERROR_CODE146 = "146";
	/***
	 * 操作超时
	 */
	public final static String ERROR_CODE147 = "147";
	/***
	 * 设备型号错误
	 */
	public final static String ERROR_CODE148 = "148";
	/***
	 * 设备已入库
	 */
	public final static String ERROR_CODE149 = "149";
	/***
	 * 设备未测试通过
	 */
	public final static String ERROR_CODE150 = "150";
	/***
	 * 设备已测试
	 */
	public final static String ERROR_CODE151 = "151";
	
	/***
	 * 合同已经提交，提交后不可修改和删除
	 */
	public final static String ERROR_CODE152 = "152";
	

	/***
	 * 版本重复
	 */
	public final static String ERROR_CODE153 = "153";
	
	/***
	 * 未能删除服务器资源
	 */
	public final static String ERROR_CODE154 = "154";
	
	/***
	 * 服务器资源文件丢失
	 */
	public final static String ERROR_CODE155 = "155";

	/***
	 * 设备离线
	 */
	public final static String ERROR_CODE156 = "156";

	/**
	 * 时间精度异常
	 */
	public final static String ERROR_CODE157 = "157";
	
	/**
	 * 操作跳过
	 */
	public final static String ERROR_CODE158 = "158";
	
	/**
	 * 发货数量和合同数量不一致
	 */
	public final static String ERROR_CODE159 = "159";
	/**
	 * 设备型号和合同订单不一致\

	 */
	public final static String ERROR_CODE160 = "160";

	
	/**
	 * 设备型号发货数量超过合同型号数量
	 */
	public final static String ERROR_CODE164 = "164";
	/**
	 * 合同设备已全部发货
	 */
	public final static String ERROR_CODE162 = "162";
	/**
	 * 设备发货数量超出合同设备数量
	 */
	public final static String ERROR_CODE163 = "163";
	
	/**
	 * 该合同无设备
	 */
	public final static String ERROR_CODE165 = "165";

	/***
	 * 参数不符合Base64转码规范,解析失败
	 */
	public final static String ERROR_CODE161 = "161";
	
	/**
	 * 设备型号和合同设备型号不匹配
	 */
	public final static String ERROR_CODE166 = "166";
	/**
	 * 手机号已注册
	 */
	public final static String ERROR_CODE167 = "167";// 手机号码不正确
	/**
	 * 设备已收货
	 */
	public final static String ERROR_CODE168 = "168";//
	/**
	 * 设备已起租
	 */
	public final static String ERROR_CODE169 = "169";//
	
	/**
	 *服务公司/代理商未发货，不可起租
	 */
	public final static String ERROR_CODE170 = "170";//
	

	/**
	 * 合同未审核不可发货
	 */
	public final static String ERROR_CODE171 = "171";//
	

	/**
	 * 此合同已提交
	 */
	public final static String ERROR_CODE172 = "172";//
	
	/**
	 * 密码错误
	 */
	public final static String ERROR_CODE173 = "173";//
	
	/**
	 * 项目已关联设备，不可删除
	 */
	public final static String ERROR_CODE174 = "174";//
	
	/**
	 * 数据已存在
	 */
	public final static String ERROR_CODE175 = "175";// 数据已存在
	
	/**
	 * 设备最多只能关联3张卡
	 */
	public final static String ERROR_CODE176 = "176";// 设备最多只能关联3张卡
	
	/**
	 * 此卡已关联设备，不可再次关联
	 */
	public final static String ERROR_CODE177 = "177";// 此卡已关联设备，不可再次关联
	
	/**
	 * 此卡已被使用，不可删除和编辑
	 */
	public final static String ERROR_CODE178 = "178";// 此卡已被使用，不可删除和编辑
	
	/**
	 * 设备卡挂失、报废无效
	 */
	public final static String ERROR_CODE179 = "179";


	/***
	 * 设备机身号错误
	 */
	public final static String ERROR_CODE180 = "180";

	/**
	 * 字典未找到
	 */
	public final static String ERROR_CODE181 = "181";
	/**
	 * 重复的卡号
	 */
	public final static String ERROR_CODE182 = "182";
	/**
	 * 合同号重复
	 */
	public final static String ERROR_CODE183 = "183";


	/**
	 * 合同设备数据异常
	 */
	public final static String ERROR_CODE184 = "184";

	/**
	 * 无法审核此合同
	 */
	public final static String ERROR_CODE185 = "185";
	/**
	 * 跟订单关联，不可删除
	 */
	public final static String ERROR_CODE186 = "186";
	
	/**
	 * 流水号超过最大数99999
	 */
	public final static String ERROR_CODE187 = "187";
	
	
	/**
	 * 合同类型错误
	 */
	public final static String ERROR_CODE188 = "188";
	

	/**
	 * 工厂已发货，不能回退
	 */
	public final static String ERROR_CODE189 = "189";
	
	/**
	 * 合同未审核，不可回退
	 */
	public final static String ERROR_CODE190 = "190";
	
	/**
	 * 零件编号相同
	 */
	public final static String ERROR_CODE191 = "191";
	
	/**
	 * 零件编号已存在
	 */
	public final static String ERROR_CODE192 = "192";
	
	/**
	 * 无法执行该流程任务节点
	 */
	public final static String ERROR_CODE193 = "193";
	
	/**
	 * 找不到该机身号对应的设备
	 */
	public final static String ERROR_CODE194 = "194";
	
	/**
	 * 发货失败
	 */
	public final static String ERROR_CODE195 = "195";
	
	/**
	 * 收货失败
	 */
	public final static String ERROR_CODE196 = "196";
	
	/**
	 * 库存中没有该设备
	 */
	public final static String ERROR_CODE197 = "197";
	
	/**
	 * 该圈子Id的业务类型不是服务商和代理商
	 */
	public final static String ERROR_CODE198 = "198";
	
	/**
	 * 租赁方案编码不能一样
	 */
	
	public final static String ERROR_CODE199 = "199";
	/**
	 * 每期的月数不是整数
	 */
	public final static String ERROR_CODE200 = "200";

	/**
	 * 不存在该圈子
	 */
	public static final String ERROR_CODE201 = "201";
	/**
	 *该设备不是发货状态
	 */
	public static final String ERROR_CODE202 = "202";
	
	/**
	 * 不存在此合同变更类型
	 */
	public static final String ERROR_CODE203 = "203";

	/**
	 * 无法审批此变更
	 */
	public static final String ERROR_CODE204 = "204";
	
	/**
	 * 无效语言Code
	 */
	public static final String ERROR_CODE205 = "205";
	
	/**
	 * 该设备不是待收货状态
	 */
	public static final String ERROR_CODE206 = "206";
	
	/**
	 * 该设备不在收货范围内
	 */
	public static final String ERROR_CODE207 = "207";
	
	/**
	 * 不存在此编号的合同
	 */
	public static final String ERROR_CODE208 = "208";
	
	/**
	 * 不存在此合同Id的合同
	 */
	public static final String ERROR_CODE209 = "209";
	
	/**
	 * 事件代码重复
	 */
	public static final String ERROR_CODE210 = "210";
	
	/**
	 * 状态参数不正确
	 */
	public static final String ERROR_CODE211 = "211";
	
	/**
	 * 该用户不是根圈子管理员
	 */
	public static final String ERROR_CODE212 = "212";
	/**
	 * 分成方案期号跟租赁方案期数不一致
	 */
	public static final String ERROR_CODE213 ="213";
	
	/**
	 * 此设备不是待启租状态
	 */
	public static final String ERROR_CODE214 = "214";
	
	/**
	 * 审批不通过不能进行回退
	 */
	public static final String ERROR_CODE215 = "215";
	
	/**
	 * 库存合同不能进行服务商/代理商发货
	 */
	public static final String ERROR_CODE216 = "216";
	
	/**
	 * 此设备已发货
	 */
	public static final String ERROR_CODE217 = "217";
	
	/**
	 * 此设备不是待发货
	 */
	public static final String ERROR_CODE218 = "218";


	/**
	 * 用户重复
	 */
	public static final String ERROR_CODE219 = "219";
	
	/**
	 * 不存在此变更Id的变更
	 */
	public static final String ERROR_CODE220 = "220";
	
	/**
	 * 合同已启租不能进行启租前变更
	 */
	public static final String ERROR_CODE221 = "221";
	
	/**
	 * 合同已终止不能进行合同变更
	 */
	public static final String ERROR_CODE222 = "222";
	
	/**
	 * 合同未启租不能进行启租后变更
	 */
	public static final String ERROR_CODE223 = "223";
	/**
	 * 该圈子不是登录用户的子圈子
	 */
	public static final String ERROR_CODE224 = "224";
	/**
	 * 故障id不能为空
	 */
	public static final String ERROR_CODE225 = "225";
	/**
	 * 机身号不能为空
	 */
	public static final String ERROR_CODE226 = "226";
	/**
	 * 找不到对应的附件
	 */
	public static final String ERROR_CODE227 = "227";
	/**
	 * 找不到该条售后记录
	 */
	public static final String ERROR_CODE228 = "228";
	/**
	 * 找不到对应的部件
	 */
	public static final String ERROR_CODE229= "229";
	/**
	 * 找不到该故障
	 */
	public static final String ERROR_CODE230= "230";
	/**
	 * 根据故障id找不到设备
	 */
	public static final String ERROR_CODE231= "231";
	/**
	 *机身号不匹配
	 */
	public static final String ERROR_CODE232= "232";
	
	/**
	 * 左上角经度必须小于右下角经度并且右下角纬度需要小于左上角纬度
	 */
	public static final String ERROR_CODE233 = "233";
	/**
	 * 找不到对应的设备
	 */
	public static final String ERROR_CODE234 = "234";
	/**
	 * 根据售后id找不到对应的售后记录
	 */
	public static final String ERROR_CODE235 = "235";
	/**
	 * 根据设备id找不到对应的设备
	 */
	public static final String ERROR_CODE236 = "236";
	/**
	 * 报表类型不能为空
	 */
	public static final String ERROR_CODE237 = "237";
	/**
	 * 请先删除数据模块配置信息
	 */
	public static final String ERROR_CODE238 = "238";
	/**
	 * 该机身号不是这个圈子下的设备
	 */
	public static final String ERROR_CODE239 = "239";
	/**
	 * 根据模块id找不到对应的模块信息
	 */
	public static final String ERROR_CODE240 = "240";
	
	/**
	 * 请先删除参数定义表
	 */
	public static final String ERROR_CODE241 = "241";
	/**
	 * 根据id找不到对应的记录
	 */
	public static final String ERROR_CODE242 = "242";
	/**
	 * 目标已被使用无法删除
	 */
	public static final String ERROR_CODE243 = "243";
	
	/**
	 * 该PO单没有设备
	 */
	public static final String ERROR_CODE244 = "244";
	
	/**
	 * PO单业务类型错误
	 */
	public static final String ERROR_CODE245 = "245";

	/**
	 * PO单号重复
	 */
	public static final String ERROR_CODE246 = "246";
	
	/**
	 * PO单收货人信息不能为空
	 */
	public static final String ERROR_CODE247 = "247";

	/**
	 * PO单状态错误
	 */
	public static final String ERROR_CODE248 = "248";

	/**
	 * PO单订单不能为空
	 */
	public static final String ERROR_CODE249 = "249";
	
	/**
	 * PO单中订单设备数据错误
	 */
	public static final String ERROR_CODE250 = "250";

	/**
	 * PO单已经提交，提交后不可修改和删除
	 */
	public static final String ERROR_CODE251 = "251";
	/**
	 * 请先删除显示映射配置
	 */
	public static final String ERROR_CODE252 = "252";
	
	/**
	 * 该设备已经故障上报， 请不要重复提交
	 */
	public static final String ERROR_CODE253 = "253";
	
	/**
	 * 此Po单已提交
	 */
	public static final String ERROR_CODE254 = "254";
	
	/**
	 * 不存在此Po单
	 */
	public static final String ERROR_CODE255 = "255";
	
	/**
	 * 该设备出现故障，请先维修
	 */
	public static final String ERROR_CODE256 = "256";
	/**
	 * 您不是该设备的售后服务公司
	 */
	public static final String ERROR_CODE257 = "257";
	/**
	 * 当前设备未起租
	 */
	public static final String ERROR_CODE258 = "258";
	
	/**
	 * 根据零件编号找不到对应的零件
	 */
	public static final String ERROR_CODE259 = "259";
	
	/**
	 * 无法受理此PO单
	 */
	public final static String ERROR_CODE260 = "260";
	
	/**
	 * 查询不到本地平台信息
	 */
	public final static String ERROR_CODE261 = "261";
	
	/**
	 * 存在多个本地平台
	 */
	public final static String ERROR_CODE262 = "262";
	
	/**
	 * 查询不到主平台信息
	 */
	public final static String ERROR_CODE263 = "263";
	
	/**
	 * 存在多个主平台
	 */
	public final static String ERROR_CODE264 = "264";
	
	/**
	 * 物流信息不全
	 */
	public final static String ERROR_CODE265 = "265";
	
	/**
	 * 发货人信息不全
	 */
	public final static String ERROR_CODE266 = "266";
	
	/**
	 * 收货人信息不全
	 */
	public final static String ERROR_CODE267 = "267";

	/**
	 * PO单未受理不可发货
	 */
	public static final String ERROR_CODE268 = "268";

	/**
	 * 此PO单已全部发完货
	 */
	public static final String ERROR_CODE269 = "269";
	
	/**
	 * 设备数量超过PO单订单数量
	 */
	public static final String ERROR_CODE270 = "270";

	/**
	 * 发货单已同步不能修改
	 */
	public static final String ERROR_CODE271 = "271";

	/**
	 * 不存在此发货单
	 */
	public static final String ERROR_CODE272 = "272";

	/**
	 * 发货单已同步不可删除
	 */
	public static final String ERROR_CODE273 = "273";

	/**
	 * 合同未到发货状态
	 */
	public static final String ERROR_CODE274 = "274";

	/**
	 * 此平台信息查询不到
	 */
	public static final String ERROR_CODE275 = "275";
	
	/**
	 * 此平台存在多个
	 */
	public static final String ERROR_CODE276 = "276";
	
	/**
	 * 当前平台不是主平台
	 */
	public static final String ERROR_CODE277 = "277";
	
	/**
	 * 国外平台的不能是当前平台
	 */
	public static final String ERROR_CODE278 = "278";
	
	/**
	 * 该发货单没有设备
	 */
	public static final String ERROR_CODE279 = "279";
	
	/**
	 * 同步数据缺少订单明细Id
	 */
	public static final String ERROR_CODE280 = "280";
	
	/**
	 * 远程服务器存在相同的发货单Id
	 */
	public static final String ERROR_CODE281 = "281";
	
	/**
	 * 该Po单没有此设备
	 */
	public static final String ERROR_CODE282 = "282";
	
	/**
	 * 当前平台不是国外平台
	 */
	public static final String ERROR_CODE283 = "283";
	
	/**
	 * 发货单未同步不可发货
	 */
	public static final String ERROR_CODE284 = "284";
	
	/**
	 * Po单未发货不可以收货
	 */
	public static final String ERROR_CODE285 = "285";
	
	/**
	 * 存在相同的设备Id但通讯板Id不同
	 */
	public static final String ERROR_CODE286 = "286";

	/**
	 * Po单订单存在多个相同型号订单
	 */
	public static final String ERROR_CODE287 = "287";

	/**
	 * 发货单已发货
	 */
	public static final String ERROR_CODE288 = "288";
	
	/**
	 * 设备零件还未更换，不能添加
	 */
	public static final String ERROR_CODE289 = "289";
	/**
	 * 请填写年份
	 */
	public static final String ERROR_CODE290 = "290";
	/**
	 * 请填写年份和月份
	 */
	public static final String ERROR_CODE291 = "291";
	/**
	 * 找不到该圈子关联的设备
	 */
	public static final String ERROR_CODE292 = "292";
	/**
	 * 业务状态为空
	 */
	public static final String ERROR_CODE293 = "293";

	/**
	 * 此PO单已受理过
	 */
	public final static String ERROR_CODE294 = "294";
	
	/**
	 * 设备已购买
	 */
	public static final String ERROR_CODE295 = "295";
	/**
	 * 设备未发货
	 */
	public static final String ERROR_CODE296 = "296";
	/**
	 * 设备未收货
	 */
	public static final String ERROR_CODE297 = "297";
	/**
	 * 未找到客户信息
	 */
	public static final String ERROR_CODE298 = "298";
	/**
	 * 激活失败
	 */
	public static final String ERROR_CODE299 = "299";
	
	/**PO单类型错误**/
	public final static String ERROR_CODE300 = "300";
	/**不存在此ID的PO单**/
	public final static String ERROR_CODE301 = "301";
	/**手工PO单号重复**/
	public final static String ERROR_CODE302 = "302";
	/**此PO单已提交**/
	public final static String ERROR_CODE303 = "303";
	/**无法受理此PO单**/
	public final static String ERROR_CODE304 = "304";
	/**受理不通过，不能进行回退**/
	public final static String ERROR_CODE305 = "305";
	/**PO单未受理，不能回退**/
	public final static String ERROR_CODE306 = "306";
	/**PO单未受理，不能发货**/
	public final static String ERROR_CODE307 = "307";
	/**不存在此编号的PO单**/
	public final static String ERROR_CODE308 = "308";
	/**该PO单无设备**/
	public final static String ERROR_CODE309 = "309";
	/**PO单设备已全部发货**/
	public final static String ERROR_CODE310 = "310";
	/**设备发货数量超出PO单设备数量**/
	public final static String ERROR_CODE311 = "311";
	
	/**
	 * 该设备有正在执行的指令
	 */
	public static final String ERROR_CODE312 = "312";
	
	
	/**期末处理必须为起租状态，才能操作！*/
	public final static String ERROR_CODE313 = "313";

	
	/**当前角色不能操作。*/
	public final static String ERROR_CODE314 = "314";
	
	/**平台代码重复*/
	public final static String ERROR_CODE315 = "315";
	
	/**
	 *该设备不是使用中状态
	 */
	public static final String ERROR_CODE316 = "316";

	
	/*****客户名称不能为空**********/
	public static final String ERROR_CODE317 = "317";
	
	/*****服务时长不能为空**********/
	public static final String ERROR_CODE318 = "318";
	/**
	 * 新售后服务公司跟旧售后服务公司相同
	 */
	public static final String ERROR_CODE319 = "319";
	
	/***
	 * 退机记录存在,该设备不能进行！
	 */
	public static final String ERROR_CODE320 = "320";
	/***
	 *  购机记录存在,该设备不能进行！
	 */
	public static final String ERROR_CODE321 = "321";
	
	/***
	 * 续组记录存在,该设备不能进行！
	 */
	public static final String ERROR_CODE322 = "322";
	/***
	 * 找不到对应的应收应付记录
	 */
	public static final String ERROR_CODE323 = "323";
	/***
	 * 设备转移失败
	 */
	public static final String ERROR_CODE324 = "324";
	/***
	 * 设备激活失败
	 */
	public static final String ERROR_CODE325 = "325";
	
	/**该设备已经处理,不能申请操作*/
	public static final String ERROR_CODE326 = "326";
	
	/**设备存在申请记录，请问需要继续申请？*/
	public static final String ERROR_CODE327 = "327";
	
	
	/**同一个设备不能同时进行退机审批，购机审批，续租审批*/
	public static final String ERROR_CODE328 = "328";
	
	/**请选择设备信息.*/
	public static final String ERROR_CODE329 = "329";
	/**请不要重复提交更换服务公司*/
	public static final String ERROR_CODE330 = "330";
	
	/**合同编号已经存在*/
	public static final String ERROR_CODE331 = "331";
	
	/**应收设备租赁合同到期*/
	public static final String ERROR_CODE332 = "332";
	/**应付设备租赁合同到期*/
	public static final String ERROR_CODE333 = "333";
	/**您不是该设备指定的售后人员*/
	public static final String ERROR_CODE334 = "334";
	/**请为该设备的售后人员分配权限*/
	public static final String ERROR_CODE335 = "335";
	/**设备回退失败*/
	public static final String ERROR_CODE336 = "336";

	/**租赁方案Id不能为空.*/
	public static final String ERROR_CODE337 = "337";

	/**数量不够.*/
	public static final String ERROR_CODE338 = "338";
	/**数量不能为空.*/
	public static final String ERROR_CODE339 = "339";
	
	/**等级不能为空.*/
	public static final String ERROR_CODE340 = "340";
	/**推送方式不能为空.*/
	public static final String ERROR_CODE341 = "341";
	/**推送对象不能为空.*/
	public static final String ERROR_CODE342 = "342";
	
	/**当前推送等级和对象已存在,请检查！*/
	public static final String ERROR_CODE343 = "343";
	
	/**
	 * 此合同有未执行完成的变更项
	 */
	public static final String ERROR_CODE344 = "344";
	
	/**
	 * 新的启租日期必须大于旧的启租日期
	 */
	public static final String ERROR_CODE345 = "345";
	
	/**
	 * 试用合同只能做终止试用变更
	 */
	public static final String ERROR_CODE346 = "346";
	
	/**
	 * 该合同已终止
	 */
	public static final String ERROR_CODE347 = "347";
	/**
	 * 当前时间是应收应付最后一期
	 */
	public static final String ERROR_CODE348 = "348";

	/**
	 * 合同状态不是售后公司发货前不能进行发货前变更数量
	 */
	public static final String ERROR_CODE349 = "349";
	
	/**
	 * 订单数量不能为负数
	 */
	public static final String ERROR_CODE350 = "350";
	
	/**
	 * 至少有一个订单的数量不为0
	 */
	public static final String ERROR_CODE351 = "351";
	
	/**
	 * 设备不是待返回状态
	 */
	public static final String ERROR_CODE352 = "352";
	
	/**
	 * 终止日期必须大于申请日期
	 */
	public static final String ERROR_CODE353 = "353";
	
	/**
	 * 终止日期不能为空
	 */
	public static final String ERROR_CODE354 = "354";
	
	/**
	 * 没有变更设备
	 */
	public static final String ERROR_CODE355 = "355";

	/**
	 * 暂停日期不能为空
	 */
	public static final String ERROR_CODE356 = "356";
	
	/**
	 * 暂停日期必须大于申请日期
	 */
	public static final String ERROR_CODE357 = "357";
	
	/**
	 * 设备Id不能为空
	 */
	public static final String ERROR_CODE358 = "358";
	
	/**
	 * 设备不是启租状态
	 */
	public static final String ERROR_CODE359 = "359";
	
	/**
	 * 此合同类型不能做变更业务
	 */
	public static final String ERROR_CODE360 = "360";
	
	/**
	 * 租赁合同不能做试用终止变更业务
	 */
	public static final String ERROR_CODE361 = "361";
	
	/**
	 * 合同状态不是售后公司发货后不能进行发货后减少设备
	 */
	public static final String ERROR_CODE362 = "362";
	
	/**
	 * 根据售后变更id找不到该条记录
	 */
	public static final String ERROR_CODE363 = "363";
	/**
	 * 审批通过但未执行的变更才能取消变更
	 */
	public static final String ERROR_CODE364 = "364";
	
	/**
	 * 找不到任务调度的任务
	 */
	public static final String ERROR_CODE365 = "365";
	/**
	 * 该变更任务不是未执行状态
	 */
	public static final String ERROR_CODE366 = "366";
	
	/**
	 * 你没有分配设备
	 */
	public static final String ERROR_CODE367 = "367";
	
	
	/**
	 * 售后公司才能进行发货操作
	 */
	public static final String ERROR_CODE368 = "368";
	
	/**
	 * 该变更已经取消了
	 */
	public static final String ERROR_CODE369 = "369";
	
	/**
	 * 您不是该条记录的收款对象
	 */
	public static final String ERROR_CODE370 = "370";

	/**
	 * 合同终止前需要先将未收货的设备进行收货
	 */
	public static final String ERROR_CODE371 = "371";
	
	/**
	 * 更换设备只能由售后公司发起申请
	 */
	public static final String ERROR_CODE372 = "372";
	
	/**
	 * 更换设备之外的合同变更只能由甲方发起申请
	 */
	public static final String ERROR_CODE373 = "373";
	
	/**
	 * 角色id不能为空
	 */
	public static final String ERROR_CODE374 = "374";
	
	
	/**
	 * 该设备已经暂停
	 */
	public static final String ERROR_CODE375 = "375";

	/**
	 * 售后公司才能启租
	 */
	public static final String ERROR_CODE376 = "376";
	
	/**
	 * 该设备未暂停
	 */
	public static final String ERROR_CODE377 = "377";
	
	/**
	 * 变更已执行，不能取消
	 */
	public static final String ERROR_CODE378 = "378";
	
	/**
	 * 该合同没有设备
	 */
	public static final String ERROR_CODE379 = "379";
	/**
	 * 售后服务公司不存在
	 */
	public static final String ERROR_CODE380 = "380";
	/**
	 * 找不到该故障对应的事件等级
	 */
	public static final String ERROR_CODE381 = "381";
	
	/**
	 * 合同至少保留1个设备
	 */
	public static final String ERROR_CODE382 = "382";
	/**
	 * 找不到应收应付记录
	 */
	public static final String ERROR_CODE383 = "383";
	/**
	 * 找不到全选的设备
	 */
	public static final String ERROR_CODE384 = "384";
	/**该零件已经更换**/
	public static final String ERROR_CODE385 = "385";
	/**未找到新零件信息**/
	public static final String ERROR_CODE386 = "386";
	/**只能更换电池组**/
	public static final String ERROR_CODE387 = "387";
	
	/**
	 * 续租合同不能进行此变更
	 */
	public static final String ERROR_CODE388 = "388";
	
	/**
	 * 续租合同任务进行中，不能执行此变更
	 */
	public static final String ERROR_CODE389 = "389";
	/**
	 * 找不到该用户
	 */
	public static final String ERROR_CODE390 = "390";
	/**
	 * 激活失败，请先转移设备
	 */
	public static final String ERROR_CODE391 = "391";
	/**
	 * 找不到权限列表
	 */
	public static final String ERROR_CODE392 = "392";
	/**
	 * 服务器错误
	 */
	public static final String ERROR_CODE393 = "393";
	/**
	 * 该圈子不是大客户
	 */
	public static final String ERROR_CODE394 = "394";
	/**
	 * 请至少选择一个租赁方
	 */
	public static final String ERROR_CODE395 = "395";
	/**
	 * 设备已存在测试报告
	 */
	public static final String ERROR_CODE396 = "396";
	/**
	 * 找不到该条配置信息
	 */
	public static final String ERROR_CODE397 = "397";
	
	/**
	 * RFID长度只能为10位
	 */
	public static final String ERROR_CODE398 = "398";
	
	/**
	 * 电池容量不满足购机条件
	 */
	public static final String ERROR_CODE399 = "399";
	
	/**
	 * 命令发送失败，关联失败
	 */
	public static final String ERROR_CODE400 = "400";
	
	/**
	 * 合同审批不通过的不能发货
	 */
	public static final String ERROR_CODE401 = "401";
	
	/**
	 * 设备测试未通过的不能入库
	 */
	public static final String ERROR_CODE402 = "402";
	
	/**
	 * 设备不是正常状态的不可发货
	 */
	public static final String ERROR_CODE403 = "403";
	/**
	 * 请选择售后服务公司
	 */
	public static final String ERROR_CODE404 = "404";
	/**
	 * 型号跟马达代码不匹配
	 */
	public static final String ERROR_CODE405 = "405";
	
	/**
	 * 型号跟马达代码已存在
	 */
	public static final String ERROR_CODE406 = "406";
	/**
	 * 服务器数据加载不过来，你稍后重试
	 */
	public static final String ERROR_CODE407 = "407";
	/**
	 * 邮箱重复
	 */
	public static final String ERROR_CODE408 = "408";
	/**
	 * 请不要为该用户重复创建开关
	 */
	public static final String ERROR_CODE409 = "409";
	/**
	 * 平台异常 请稍后重试
	 */
	public static final String ERROR_CODE410 = "410";
	/**
	 * 找不到对应的保养计划
	 */
	public static final String ERROR_CODE411 = "411";
	/**
	 * 该圈子下还分有设备
	 */
	public static final String ERROR_CODE412 = "412";
	/**
	 * 当前圈子存在未结束的合同
	 */
	public static final String ERROR_CODE413 = "413";
	/**
	 * 当前圈子存在未付的应收应付
	 */
	public static final String ERROR_CODE414 = "414";
	/**
	 * 请不要重复提交
	 */
	public static final String ERROR_CODE415 = "415";
	/**
	 * 当前圈子为客户 
	 */
	public static final String ERROR_CODE416 = "416";
	/**
	 * 服务端有重大更新,请更新app版本
	 */
	public static final String ERROR_CODE417 = "417";
	/**
	 * 服务端无此版本
	 */
	public static final String ERROR_CODE418 = "418";
	
	
	
}
