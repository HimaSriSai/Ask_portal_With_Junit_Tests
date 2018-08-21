package com.prokarma.viewpost.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReplyQueriesInfo {

	/**
	 * 
	 */
	private int replyId;

	/**
	 * 
	 */
	private String repliesMsgs;

	/**
	 * 
	 */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date replyedDate;

	/**
	 * 
	 */
	private int repliedBy;

	/**
	 * 
	 */
	private String replyStatus;

	/**
	 * 
	 */
	private int rplPostId;

	/**
	 * 
	 */
	private String rplyFirstName;

	/**
	 * 
	 */
	private String rpldByName;

	/**
	 * @return the rpldByName
	 */
	public String getRpldByName() {
		return rpldByName;
	}

	/**
	 * @param rpldByName
	 *            the rpldByName to set
	 */
	public void setRpldByName(final String rpldByName) {
		this.rpldByName = rpldByName;
	}

	private String rplyLastName;

	/**
	 * @return the rplyFirstName
	 */
	public String getRplyFirstName() {
		return rplyFirstName;
	}

	/**
	 * @param rplyFirstName
	 *            the rplyFirstName to set
	 */
	public void setRplyFirstName(final String rplyFirstName) {
		this.rplyFirstName = rplyFirstName;
	}

	/**
	 * @return the rplyLastName
	 */
	public String getRplyLastName() {
		return rplyLastName;
	}

	/**
	 * @param rplyLastName
	 *            the rplyLastName to set
	 */
	public void setRplyLastName(final String rplyLastName) {
		this.rplyLastName = rplyLastName;
	}

	/**
	 * 
	 */
	public ReplyQueriesInfo() {
	}

	/**
	 * @return
	 */
	public int getRplPostId() {
		return rplPostId;
	}

	/**
	 * @param rplPostId
	 */
	public void setRplPostId(final int rplPostId) {
		this.rplPostId = rplPostId;
	}

	/**
	 * @return
	 */
	public String getReplyStatus() {
		return replyStatus;
	}

	/**
	 * @param replyStatus
	 */
	public void setReplyStatus(final String replyStatus) {
		this.replyStatus = replyStatus;
	}

	/**
	 * @return
	 */
	public int getReplyId() {
		return replyId;
	}

	/**
	 * @param replyId
	 */
	public void setReplyId(final int replyId) {
		this.replyId = replyId;
	}

	/**
	 * @return
	 */
	public int getRepliedBy() {
		return repliedBy;
	}

	/**
	 * @return
	 */
	public String getRepliesMsgs() {
		return repliesMsgs;
	}

	/**
	 * @param repliesMsgs
	 */
	public void setRepliesMsgs(final String repliesMsgs) {
		this.repliesMsgs = repliesMsgs;
	}

	/**
	 * @param repliedBy
	 */
	public void setRepliedBy(final int repliedBy) {
		this.repliedBy = repliedBy;
	}

	/**
	 * @return
	 */
	public Date getReplyedDate() {
		return replyedDate;
	}

	/**
	 * @param replyedDate
	 */
	public void setReplyedDate(final Date replyedDate) {
		this.replyedDate = replyedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + replyId;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyQueriesInfo other = (ReplyQueriesInfo) obj;
		if (replyId != other.replyId)
			return false;
		return true;
	}

}
