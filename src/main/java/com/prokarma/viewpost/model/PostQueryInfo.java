package com.prokarma.viewpost.model;

import java.sql.Date;

/**
 * @author prokarma
 *
 */
public class PostQueryInfo {
	/**
	 * 
	 */
	private int postId;
	/**
	 * 
	 */
	private String crtdByName;
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
	 * @return the crtdByName
	 */
	public String getCrtdByName() {
		return crtdByName;
	}

	/**
	 * @param crtdByName
	 *            the crtdByName to set
	 */
	public void setCrtdByName(final String crtdByName) {
		this.crtdByName = crtdByName;
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
	public String getCtgryName() {
		return ctgryName;
	}

	/**
	 * @param ctgryName
	 */
	public void setCtgryName(final String ctgryName) {
		this.ctgryName = ctgryName;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postId;
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
		PostQueryInfo other = (PostQueryInfo) obj;
		if (postId != other.postId)
			return false;
		return true;
	}
}
