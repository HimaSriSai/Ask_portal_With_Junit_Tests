package com.prokarma.login.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Prokarma
 *
 */
@JsonIgnoreProperties
public class UserModel {

	/**
	 * 
	 */
	private String userName;

	/**
	 * 
	 */
	private String password;

	

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public  final void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

}
