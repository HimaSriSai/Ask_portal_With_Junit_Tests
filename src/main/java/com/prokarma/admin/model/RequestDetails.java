package com.prokarma.admin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prokarma
 *
 */
public class RequestDetails {

	/**
	 * 
	 */
	int empId;

	/**
	 * 
	 */
	List<String> ctrgyList = new ArrayList<>();

	/**
	* 
	*/
	String fullName;

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	/**
	 * @return the ctrgyList
	 */
	public List<String> getCtrgyList() {
		return ctrgyList;
	}

	/**
	 * @param ctrgyList
	 *            the ctrgyList to set
	 */
	public void setCtrgyList(List<String> ctrgyList) {
		this.ctrgyList = ctrgyList;
	}

}
