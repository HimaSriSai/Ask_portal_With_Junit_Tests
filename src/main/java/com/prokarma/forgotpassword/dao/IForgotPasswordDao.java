package com.prokarma.forgotpassword.dao;

import java.sql.SQLException;

import com.prokarma.forgotpassword.model.ForgotPasswordModel;

/**
 * @author Prokarma
 *
 */
public interface IForgotPasswordDao {
	 /**
	 * @param email
	 * @return
	 * @throws SQLException 
	 */
	ForgotPasswordModel getdata(final String email) throws SQLException;

}
