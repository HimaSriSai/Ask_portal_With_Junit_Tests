package com.prokarma.login.model;

import java.util.Set;

/**
 * @author Prokarma
 *
 */
public class ResponseModel {
	/**
	 * 
	 */
	String responseStr;
	/**
	 * 
	 */
	int empId;

	/**
	 * 
	 */
	Set<String> roleName;

	/**
	 * 
	 */
	private String userFullName;

	/**
	 * @return the userFullName
	 */
	public String getUserFullName() {
		return userFullName;
	}

	/**
	 * @param userFullName
	 *            the userFullName to set
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	/**
	 * @return the responseStr
	 */
	public String getResponseStr() {
		return responseStr;
	}

	/**
	 * @param responseStr
	 *            the responseStr to set
	 */
	public void setResponseStr(String responseStr) {
		this.responseStr = responseStr;
	}

	/**
	 * @return the roleName
	 */
	public Set<String> getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(Set<String> roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
