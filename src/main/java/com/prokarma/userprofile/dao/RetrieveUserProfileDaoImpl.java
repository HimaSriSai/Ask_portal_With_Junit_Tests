package com.prokarma.userprofile.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prokarma.userprofile.model.UserProfileBean;


/**
 * @author Prokarma
 *
 */
@Repository
public class RetrieveUserProfileDaoImpl  implements IRetrieveUserProfileDao{

	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(RetrieveUserProfileDaoImpl.class);
	
	/**
	 * 
	 */
	@Autowired
	private NamedParameterJdbcTemplate jdbctemplate;

	/* (non-Javadoc)
	 * @see com.prokarma.user_profile.dao.EditUserDao#getUserProfile(int)
	 */
	@Override
	public UserProfileBean getUserProfile(final int empid) {
	
		

	final String sql="select * from ask.ask_user_tbl where emp_id=:empid";
		
	final MapSqlParameterSource mapSqlParam = new MapSqlParameterSource();
		mapSqlParam.addValue("empid", empid);
	return jdbctemplate.queryForObject(sql, mapSqlParam, new EditRowMapper());
		
	}	
	

	}
	
