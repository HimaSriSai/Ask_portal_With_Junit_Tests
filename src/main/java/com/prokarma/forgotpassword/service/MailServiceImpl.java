package com.prokarma.forgotpassword.service;

import java.io.Serializable;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



/**
 * @author prokarma
 *
 */
@Service
public class MailServiceImpl implements IMailService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3699721769011706242L;
	
	/**
	 * java mail api method
	 */
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * Logger method
	 */
	static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class);
	

	/*
	 * (non-Javadoc) 
	 * implemented method of IMailService interface
	 */
	public void sendMail(final String emailId, final String pass) {

		final MimeMessage message = this.mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper;
		try {
			mimeHelper = new MimeMessageHelper(message, true);
			mimeHelper.setTo(emailId);

			mimeHelper.setFrom("mkanchi@prokarma.com");
			mimeHelper.setSubject("Password Reset Request @ASK_PORTAL");
			mimeHelper.setText("You recently requested for your password of Ask_Portal account Here is Your Password \n"
					+ "Password :" + pass, true);
			mailSender.send(message);
		} catch (MessagingException e) {
			if (LOGGER.isDebugEnabled()) {
			  LOGGER.info("Error Sending email " + e.getMessage());
			}
		}

	}
}