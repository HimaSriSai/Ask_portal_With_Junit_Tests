package com.prokarma.forgotpassword.service;

/**
 * @author prokarma
 *
 */
public interface IMailService {

	/**
	 * @param emailId
	 * @param pass
	 */
 void sendMail(String emailId, String pass);
}
