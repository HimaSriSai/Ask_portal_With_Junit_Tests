package com.prokarma.forgotpassword.service;

import java.io.Serializable;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.prokarma.forgotpassword.dao.IForgotPasswordDao;
import com.prokarma.forgotpassword.model.ForgotPasswordModel;

/**
 * @author Prokarma
 *
 */
@Service
public class ForgotPasswordServiceImpl implements IForgotPasswordService, Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * Logger method
	 */
	static final Logger LOGGER = Logger.getLogger(ForgotPasswordServiceImpl.class);

	/**
	 * Interface IForgotPasswordDao class object created
	 */
	@Autowired
	@Qualifier("userProfileDao")
	private transient IForgotPasswordDao ifrgtPswdDao;

	/**
	 * Interface IMailService class object created
	 */
	@Autowired
	@Qualifier("mailService")
	private transient IMailService mailService;

	/*
	 * (non-Javadoc) implemented method of IForgotPasswordService
	 */
	@Override
	public String sendRestMail(String email) {
		ForgotPasswordModel frgtPswdmdl;
		String message = null;
		try {
			frgtPswdmdl = ifrgtPswdDao.getdata(email);
			if (!frgtPswdmdl.getEmailid().equalsIgnoreCase("")) {

				mailService.sendMail(frgtPswdmdl.getEmailid(), frgtPswdmdl.getuPwd());
				message = "Password sent to registered email";

			}

		} catch (SQLException | NullPointerException e) {

			message = "Please enter registered email";
			LOGGER.info(e.getMessage());
		}

		return message;

	}

}
