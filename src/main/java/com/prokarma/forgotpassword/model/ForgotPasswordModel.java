package com.prokarma.forgotpassword.model;

import java.io.Serializable;

/**
 * @author Prokarma
 *
 */

public class ForgotPasswordModel implements Serializable {
	private static final long serialVersionUID = 7018837814811898035L;

	/**
	 * Emailid
	 */
	private String emailid;
	/**
	 * userpassword
	 */
	private String uPwd;
	/**
	 * employeeid
	 */
	private int empid;

	/**
	 * @return the empid
	 */
	public int getEmpid() {
		return empid;
	}

	/**
	 * @param empid
	 *            the empid to set
	 */
	public void setEmpid(final int empid) {
		this.empid = empid;
	}

	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}

	/**
	 * @param emailid
	 *            the emailid to set
	 */
	public void setEmailid(final String emailid) {
		this.emailid = emailid;
	}

	/**
	 * @return the uPwd
	 */
	public String getuPwd() {
		return uPwd;
	}

	/**
	 * @param uPwd
	 *            the uPwd to set
	 */
	public void setuPwd(final String uPwd) {
		this.uPwd = uPwd;
	}

	/**
	 * construcor with no parameters for some service classes
	 */
	public ForgotPasswordModel() {
		super();

	}

}
