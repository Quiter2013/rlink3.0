package com.robustel.common.utils.file;

/**
 * 系统属性配置文件 properties
 * @author jingfangnan
 *
 */
public interface FileConfig {

    /** The Constant ConfigFile. */
    public static final String CommonConfigFile = "config/common.properties";

    public static final String ActiveMQConfigFile = "config/mq.properties";
    public static final String SystemConfigFile = "config/system.properties";
    
    public static final String MQConfigFile = "mq.properties";
    
    /**
     * 邮箱的配置文件
     */
    public static final String EMAIL_CONFIG_FILE = "config/mail.properties";

    /**
     * pl配置文件
     */
    public static final String APPLICATION_CONFIG_FILE = "config/application.properties";

    /**
     * 客户激活配置文件
     */
    public static final String CLIENT_ACTIVE_CONFIG_FILE = "config/clientActive.properties";

    /**
     * 和NodeJs通信的socket信息
     */
    public static final String SOCKET_2_NODEJS_CONFIG = "config/socket.properties";

    /**
     * 激活邮件的内容模版
     */
    public static final String ACTIVE_EMAIL_CONTENT_VM = "config/clientActiveEmail.vm";

    /**
     * sigar执行文件目录
     */
    public static final String SIGAR_DIR = "sigar/";
    
    public static final String VpnCommonConfigFile = "common.properties";
    public static final String VpnConfidureFile = "vpn.properties";
}
