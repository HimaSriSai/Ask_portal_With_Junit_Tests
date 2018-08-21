package com.prokarma.userprofile.model;

import java.io.Serializable;

/**
 * @author prokarma
 *
 */
/**
 * @author prokarma
 *
 */
/**
 * @author prokarma
 *
 */
public class UserProfileBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int empid;
	/**
	 * 
	 */
	private String fstname;
	/**
	 * 
	 */
	private String lastname;
	/**
	 * 
	 */
	private String emailid;
	/**
	 * 
	 */
	private long phnNo;
	/**
	 * 
	 */
	private String uName;
	/**
	 * 
	 */
	private String uPwd;

	/**
	 * 
	 */
	public UserProfileBean() {
		// This constructor is intentionally empty. Nothing special is needed here.
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
	public String getFstname() {
		return fstname;
	}

	/**
	 * @param fstname
	 */
	public void setFstname(final String fstname) {
		this.fstname = fstname;
	}

	/**
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 */
	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return
	 */
	public String getEmailid() {
		return emailid;
	}

	/**
	 * @param emailid
	 */
	public void setEmailid(final String emailid) {
		this.emailid = emailid;
	}

	/**
	 * @return
	 */
	public long getPhnNo() {
		return phnNo;
	}

	/**
	 * @param phnNo
	 */
	public void setPhnNo(final long phnNo) {
		this.phnNo = phnNo;
	}

	/**
	 * @return
	 */
	public String getuName() {
		return uName;
	}

	/**
	 * @param uName
	 */
	public void setuName(final String uName) {
		this.uName = uName;
	}

	/**
	 * @return
	 */
	public String getuPwd() {
		return uPwd;
	}

	/**
	 * @param uPwd
	 */
	public void setuPwd(final String uPwd) {
		this.uPwd = uPwd;
	}

}