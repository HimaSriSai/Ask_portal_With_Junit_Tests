package com.prokarma.userprofile.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author Prokarma
 *
 */
public class UpdateUserProfileDaoImpl implements UpdateUserProfileDao {

	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(UpdateUserProfileDaoImpl.class);

	/**
	 * 
	 */
	@Autowired
	private NamedParameterJdbcTemplate namedparameterjdbctemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prokarma.user_profile.dao.UpdateUserProfileDao#updateProfile(com.prokarma
	 * .user_profile.model.UserProfileBean)
	 */
	@Override
	public String updateProfile(final UserProfileBean userbean) {
		String message;

		final String sql = "update ASK.ASK_USER_TBL set fst_name=:fst_name,last_name=:lastname,email_id=:email,phn_no=:phone,user_key=:password where emp_id=:empid";
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("fst_name", userbean.getFstname());
		mapSqlParameterSource.addValue("lastname", userbean.getLastname());
		mapSqlParameterSource.addValue("email", userbean.getEmailid());
		mapSqlParameterSource.addValue("phone", userbean.getPhnNo());
		mapSqlParameterSource.addValue("password", userbean.getuPwd());
		mapSqlParameterSource.addValue("empid", userbean.getEmpid());

		final int result = namedparameterjdbctemplate.update(sql, mapSqlParameterSource);

		if (result == 1) {
			LOGGER.info("User Credentials Successfully updated");
			message = "User Credentials Successfully updated";

		} else {
			LOGGER.info("Failed To update User Credentials");
			message = "Failed To update User Credentials";

		}
		return message;

	}

}
