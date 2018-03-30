package com.robustel.pl.app.multilingual.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 系统多语言数据类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-08
 */
@Data
@Table(name = "tbs_pl_multilingual_data")
public class MultilingualData implements Serializable{
	/** 多语言数据ID */
	@Id
	@GeneratedValue(generator = "UUID")
	private String muDataId;

	/** 语种ID */
	private String muId;

	/** 语言KEY值ID */
	private String langKeyId;

	/** KEY代码 */
	private String keyCode;

	/** 显示值 */
	private String showValue;
}