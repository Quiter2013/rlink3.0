package com.robustel.common.web.vo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
* FileName：RtRequest.java
* version：1.0.0
* Author：HEKUI
* Date：2017年3月10日
* Updater：HEKUI
* UpdateTime：2017年3月10日
* Description：通用请求参数
* Copyright：Copyright 2016 Robustel, Inc. All Rights Reserved. http://www.robustel.com
*/
public class RtRequest implements Serializable{
	 /**
     * 业务参数
     */
    private Map<String, Object> attr = new HashMap<String, Object>();
    private Map<String, Object> session = new HashMap<String, Object>();
    
   
	public void addAttr(String key, String value) {
        this.attr.put(key, value);
    }
    public void addAttr(Map<String, Object> attr) {
        if (attr == null) {
            return;
        }
        this.attr.putAll(attr);
    }
    public Object removeAttr(String key) {
        return this.attr.remove(key);
    }

    public void clearAttr() {
        this.attr.clear();
    }/**
     * 获取输入参数
     * 
     * @return
     */
    public Map<String, Object> getAttr() {
        return attr;
    }
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Object getSession(String key){
		return session.get(key);
	}
	
	public Object getAttr(String key){
		return attr.get(key);
	}
	
	public TokenVo getTokenVo(){
		return (TokenVo)session.get("token");
	}
}