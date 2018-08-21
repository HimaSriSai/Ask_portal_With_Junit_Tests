package com.prokarma.viewpost.model;

import java.sql.Date;

/**
 * @author prokarma
 *
 */
public class PostReplyTotal {
	/**
	 * 
	 */
	private int postId;
	/**
	 * 
	 */
	private String postedMsg;
	/**
	 * 
	 */
	private String ctgryName;
	/**
	 * 
	 */
	private Date postedDate;
	/**
	 * 
	 */
	private int postedBy;
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
	private int replyPostId;
	/**
	 * 
	 */
	private String firstName;
	/**
	 * 
	 */
	private String lastName;
	/**
	 * 
	 */
	private String rplyFirstName;
	/**
	 * 
	 */
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public int getReplyId() {
		return replyId;
	}

	/**
	 * @return
	 */
	public int getReplyPostId() {
		return replyPostId;
	}

	/**
	 * @param replyPostId
	 */
	public void setReplyPostId(final int replyPostId) {
		this.replyPostId = replyPostId;
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

	/**
	 * @return
	 */
	public int getRepliedBy() {
		return repliedBy;
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
	public int getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 */
	public void setPostId(final int postId) {
		this.postId = postId;
	}

	/**
	 * @return
	 */
	public String getPostedMsg() {
		return postedMsg;
	}

	/**
	 * @param postedMsg
	 */
	public void setPostedMsg(final String postedMsg) {
		this.postedMsg = postedMsg;
	}

	/**
	 * @return
	 */
	public int getPostedBy() {
		return postedBy;
	}

	/**
	 * @param postedBy
	 */
	public void setPostedBy(final int postedBy) {
		this.postedBy = postedBy;
	}

	/**
	 * @return
	 */
	public Date getPostedDate() {
		return postedDate;
	}

	/**
	 * @param postedDate
	 */
	public void setPostedDate(final Date postedDate) {
		this.postedDate = postedDate;
	}

	/**
	 * @return
	 */
	public String getCtgryName() {
		return ctgryName;
	}

	/**
	 * @param ctgryName
	 */
	public void setCtgryName(final String ctgryName) {
		this.ctgryName = ctgryName;
	}

}
