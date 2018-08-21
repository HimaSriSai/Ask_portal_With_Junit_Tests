package com.prokarma.sme.model;

public class UpdateReplyQuery {

	private int lastUpdatedByEmpId;
	private int replyId;

	/**
	 * 
	 */
	public UpdateReplyQuery() {
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
	 * @return the replyId
	 */
	public int getReplyId() {
		return replyId;
	}

	/**
	 * @param replyId
	 *            the replyId to set
	 */
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

}
