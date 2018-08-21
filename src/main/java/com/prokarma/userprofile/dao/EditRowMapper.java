package com.prokarma.userprofile.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author Prokarma
 *
 */
public class EditRowMapper implements RowMapper<UserProfileBean> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public UserProfileBean mapRow(final ResultSet resultSet,final int number) throws SQLException {
		final UserProfileBean editusermodel = new UserProfileBean();
		editusermodel.setFstname(resultSet.getString("fst_name"));
		editusermodel.setLastname(resultSet.getString("last_name"));
		editusermodel.setEmailid(resultSet.getString("email_id"));
		editusermodel.setPhnNo(resultSet.getLong("phn_no"));
		editusermodel.setuName(resultSet.getString("u_Name"));
		editusermodel.setuPwd(resultSet.getString("user_key"));
		editusermodel.setEmpid(resultSet.getInt("emp_id"));
	   
	    return editusermodel;	
		
	} 

}
