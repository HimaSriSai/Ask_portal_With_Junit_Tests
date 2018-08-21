package com.prokarma.admin.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Prokarma
 *
 */
@Component
public class AdminDAOImpl implements IAdminDAO {

	/**
	 * 
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.admin.dao.IAdminDAO#addEmpAsSme(int, int, java.util.List)
	 */
	public void addEmpAsSme(int empId, int roleId, List<Integer> ctrgyId) {

		String query = "insert into ask.ask_map_roleCtgry values(ask.map_id_seq.nextval,?,?,?)";

		jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.springframework.jdbc.core.BatchPreparedStatementSetter
			 */
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setLong(1, empId);
				ps.setLong(2, roleId);
				ps.setLong(3, ctrgyId.get(i));
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.springframework.jdbc.core.BatchPreparedStatementSetter
			 */
			public int getBatchSize() {
				return ctrgyId.size();
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.admin.dao.IAdminDAO#getSmeRoleId()
	 */
	public int getSmeRoleId() {

		String sqlQuery = "select role_id from ask.ask_role_tbl where role_name='SME'";

		return jdbcTemplate.queryForObject(sqlQuery, Integer.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.admin.dao.IAdminDAO#listOfCtrgyId(java.util.List)
	 */
	public List<Integer> listOfCtrgyId(List<String> ctgryName) {
		final List<Integer> ctgryId = new ArrayList<>();
		String sql = "select ctgry_id from ask.ask_ctgry_tbl where ctgry_name=?";
		for (String selectedName : ctgryName) {
			int selectedId = 0;
			selectedId = (jdbcTemplate.queryForObject(sql, Integer.class, selectedName));
			ctgryId.add(selectedId);
		}

		return ctgryId;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.admin.dao.IAdminDAO#removeDuplicateSME(java.util.List, int)
	 */
	public List<Integer> removeDuplicateSME(List<Integer> ctrgyIds, int empId) {
		List<Integer> finalCtgryId = new ArrayList<>();
		int integer = 0;
		String sql = "select emp_id from ask.ask_map_roleCtgry where emp_id=? and ctgry_id=?";
		for (int selectedCtrgyId : ctrgyIds) {
			try {
				integer = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] { empId, selectedCtrgyId });
			} catch (Exception e) {
				integer = 0;
			}
			if (integer == 0) {
				finalCtgryId.add(selectedCtrgyId);
			}

		}
		return finalCtgryId;
	}

	/**
	 * @return list of full Names from user table
	 */
	public List<String> getNamesFormUserTbl() {
		List<String> fullNames = new ArrayList<>();
		String sqlQuery = "select fst_name||' '||last_name from ask.ask_user_tbl";
		fullNames = jdbcTemplate.queryForList(sqlQuery, String.class);
		return fullNames;
	}

	/**
	 * @return empId
	 */
	public int getEmpIdUsingName(String firstName, String lastName) throws Exception {
		String sql = "select emp_id from ask.ask_user_tbl where fst_name=? and last_name=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, new Object[] { firstName, lastName });
	}

}
