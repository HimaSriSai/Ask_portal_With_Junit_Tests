package com.prokarma.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.prokarma.login.model.InfoFromDB;

/**
 * @author Prokarma DAO implementation class
 */
@Component
@Repository
public class LoginDaoImple implements ILoginDao {
	/**
	 * to connect database
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.login.dao.ILoginDao#getpaswordDetails
	 * (com.prokarma.Entity.UserProfile) this method actually hits database and get
	 * password
	 */
	public String getpaswordDetails(String userName) {
		String query = "select user_key from ASK.ask_user_tbl where u_name=?";
		try {

			return jdbcTemplate.queryForObject(query, String.class, userName);

		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.login.dao.ILoginDao#getEmpId(java.lang.String) this method
	 * actually hits database and get employee id
	 */
	public InfoFromDB getEmpDetails(String userName) {
		String querySql = "select emp_id,fst_name,last_name from ask.ask_user_tbl where u_name='"+userName+"'";
		return jdbcTemplate.queryForObject(querySql, new RowMapper<InfoFromDB>() {
			public InfoFromDB mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
				InfoFromDB infoFromDB = new InfoFromDB();
				infoFromDB.setEmpId(resultSet.getInt("emp_id"));
				infoFromDB.setFirstName(resultSet.getString("fst_name"));
				infoFromDB.setLastName(resultSet.getString("last_name"));
				return infoFromDB;
			}
		});
	}
}
