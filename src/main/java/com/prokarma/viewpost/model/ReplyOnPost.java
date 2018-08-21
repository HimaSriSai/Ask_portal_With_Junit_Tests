package com.prokarma.viewpost.model;

/**
 * @author prokarma
 *
 */
public class ReplyOnPost {

	/**
	 * 
	 */
	private int postId;

	/**
	 * 
	 */
	private int replyCreatedBy;

	/**
	 * 
	 */
	private String replyMsg;

	public ReplyOnPost() {
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
	public int getReplyCreatedBy() {
		return replyCreatedBy;
	}

	/**
	 * @param replyCreatedBy
	 */
	public void setReplyCreatedBy(final int replyCreatedBy) {
		this.replyCreatedBy = replyCreatedBy;
	}

	/**
	 * @return
	 */
	public String getReplyMsg() {
		return replyMsg;
	}

	/**
	 * @param replyMsg
	 */
	public void setReplyMsg(final String replyMsg) {
		this.replyMsg = replyMsg;
	}

}
