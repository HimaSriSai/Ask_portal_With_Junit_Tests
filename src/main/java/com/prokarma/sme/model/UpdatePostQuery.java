package com.prokarma.sme.model;

public class UpdatePostQuery {

	private int lastUpdatedByEmpId;
	private int postId;

	/**
	 * 
	 */
	public UpdatePostQuery() {
		super();
	}

	/**
	 * @return the lastUpdatedByEmpId
	 */
	public int getLastUpdatedByEmpId() {
		return lastUpdatedByEmpId;
	}

	/**
	 * @param lastUpdatedByEmpId
	 *            the lastUpdatedByEmpId to set
	 */
	public void setLastUpdatedByEmpId(int lastUpdatedByEmpId) {
		this.lastUpdatedByEmpId = lastUpdatedByEmpId;
	}

	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 *            the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

}
