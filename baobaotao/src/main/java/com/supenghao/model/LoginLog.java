package com.supenghao.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class LoginLog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5121537854895505423L;
	
	private String loginLogId;
	private int userID;
	private String ip;
	private Date loginDate;
	
	
	public String getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(String loginLogId) {
		this.loginLogId = loginLogId;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	
	
	
	
	

}
