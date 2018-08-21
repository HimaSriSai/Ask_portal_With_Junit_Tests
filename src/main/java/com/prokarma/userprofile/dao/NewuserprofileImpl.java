package com.prokarma.userprofile.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author prokarma
 *
 */
public class NewuserprofileImpl implements INewUserProfileDao, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(NewuserprofileImpl.class);
	/**
	 * 
	 */
	@Autowired
	private transient NamedParameterJdbcTemplate jdbctemplate;

	/**
	 * 
	 */
	@Autowired
	private JdbcTemplate jdbcTemplateObj;

	/**
	 * response Msg
	 */
	String responseMsg;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.user_profile.dao.INewUserProfileDao#addUser
	 * (com.prokarma.user_profile.model.UserProfileBean)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.user_profile.dao.INewUserProfileDao#addUser(com.prokarma.
	 * user_profile.model.UserProfileBean)
	 */
	@Override
	public String addUser(final UserProfileBean userProfile){

		final String checkUsersql = "select *  from  ask.ask_user_tbl where emp_id=:emplid";
		final MapSqlParameterSource mapEmpId = new MapSqlParameterSource();
		mapEmpId.addValue("emplid", userProfile.getEmpid());

		jdbctemplate.query(checkUsersql, mapEmpId, new ResultSetExtractor<UserProfileBean>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.
			 * ResultSet)
			 */
			public UserProfileBean extractData(ResultSet idResultset) throws DataAccessException, SQLException {

				if (!idResultset.next()) {

					final String checkUserNamesql = "select *  from  ask.ask_user_tbl where u_name =:userName";
					final MapSqlParameterSource mapUserName = new MapSqlParameterSource();
					mapUserName.addValue("userName", userProfile.getuName());
					jdbctemplate.query(checkUserNamesql, mapUserName, new ResultSetExtractor<UserProfileBean>() {
						/*
						 * (non-Javadoc)
						 * 
						 * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.
						 * ResultSet)
						 */
						public UserProfileBean extractData(ResultSet uNameResultset)
								throws DataAccessException, SQLException {

							if (!uNameResultset.next()) {

								final String sql = "INSERT INTO ask.ask_user_tbl (emp_id, fst_name, last_name,email_id,phn_no,u_name,user_key) VALUES "
										+ "(:empid,:firstname,:lastname,:email,:phn,:uname,:upwd)";
								final MapSqlParameterSource mapperParams = new MapSqlParameterSource();
								mapperParams.addValue("empid", userProfile.getEmpid());
								mapperParams.addValue("firstname", userProfile.getFstname());
								mapperParams.addValue("lastname", userProfile.getLastname());
								mapperParams.addValue("email", userProfile.getEmailid());
								mapperParams.addValue("uname", userProfile.getuName());
								mapperParams.addValue("upwd", userProfile.getuPwd());
								mapperParams.addValue("phn", userProfile.getPhnNo());
								int result = 0;
								try {
									result = jdbctemplate.update(sql, mapperParams);
								} catch (DuplicateKeyException e) {
									responseMsg = "This email already registered! Please try another email";
								}
								if (result == 1) {
									LOGGER.info("User Credentials Successfully Added");
									responseMsg = "Registered Successfully! Please Login";
								}

							} else {

								responseMsg = "UserName Already Exist! Please Try With Another";
								LOGGER.info(responseMsg);

							}

							return null;
						}
					});

				} else {
					responseMsg = "EmployeeID Already Registered! Please Login";
					LOGGER.info(responseMsg);
				}

				return null;
			}
		});

		return responseMsg;
	}

	public int giveEmpId(String firstName, String lastName) throws EmptyResultDataAccessException {
		String sql = "select emp_id from ask.ask_user_tbl where fst_name=? and last_name=?";
		return jdbcTemplateObj.queryForObject(sql, Integer.class, new Object[] { firstName, lastName });
	}

}
