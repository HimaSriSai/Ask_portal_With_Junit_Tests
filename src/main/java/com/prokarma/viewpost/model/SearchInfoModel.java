package com.prokarma.viewpost.model;

/**
 * @author prokarma
 *
 */
public class SearchInfoModel {
	/**
	 * 
	 */
	private int empid;
	/**
	 * 
	 */
	private String category;

	/**
	 * 
	 */
	public SearchInfoModel() {

	}

	/**
	 * @return
	 */
	public int getEmpid() {
		return empid;
	}

	/**
	 * @param empid
	 */
	public void setEmpid(final int empid) {
		this.empid = empid;
	}

	/**
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(final String category) {
		this.category = category;
	}
}
