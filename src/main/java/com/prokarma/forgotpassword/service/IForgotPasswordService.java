package com.prokarma.forgotpassword.service;

/**
 * @author prokarma
 *
 */
public interface IForgotPasswordService {
	
	/**
	 * @param email
	 * @param emplid
	 * @return
	 */
	 String sendRestMail(final String email);
}
