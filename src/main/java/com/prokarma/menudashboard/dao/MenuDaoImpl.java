package com.prokarma.menudashboard.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Prokarma DAO implementation
 */
@Component
@Repository
public class MenuDaoImpl implements IMenuDao {
	/**
	 * to hit dataBase
	 */
	static final Logger LOGGER = Logger.getLogger(MenuDaoImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.menuPage.dao.IMenuDao#getUserRoleName(java.lang.String) it
	 * hit database and get role name
	 */
	public List<String> getUserRoleName(String userName) {
		final String query = "select role_name from ask.ask_role_tbl role JOIN ask.ask_map_roleCtgry map on role.role_id=map.role_id WHERE emp_id=(select  emp_id from ask.ask_user_tbl where u_name=?)";
		List<String> roleName = null;

		roleName = jdbcTemplate.queryForList(query, String.class, userName);

		return roleName;

	}
}
