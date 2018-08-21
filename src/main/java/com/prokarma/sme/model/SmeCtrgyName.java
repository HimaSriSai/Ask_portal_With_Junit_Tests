package com.prokarma.sme.model;

import java.util.List;

public class SmeCtrgyName {
	private int empId;
	private List<String> ctrgyName;

	/**
	 * 
	 */
	
	public SmeCtrgyName() {
	  /**
	     * @return SmeCtrgyName
	     */
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
	 * @return the ctrgyName
	 */
	public List<String> getCtrgyName() {
		return ctrgyName;
	}

	/**
	 * @param ctrgyName
	 *            the ctrgyName to set
	 */
	public void setCtrgyName(List<String> ctrgyName) {
		this.ctrgyName = ctrgyName;
	}

}
