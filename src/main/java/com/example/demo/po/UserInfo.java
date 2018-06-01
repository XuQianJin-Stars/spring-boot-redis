package com.example.demo.po;

import java.io.Serializable;

public class UserInfo implements Serializable{


	private static final long serialVersionUID = -5706898173064572509L;

	
	private String userId;
	
	private String userName;
	
	private String address;
	
	private String mobile;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
