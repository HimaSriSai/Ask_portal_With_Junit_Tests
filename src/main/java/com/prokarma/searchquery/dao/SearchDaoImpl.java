package com.prokarma.searchquery.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.prokarma.common.util.Ask_AOP;

/**
 * @author prokarma
 *
 */
public class SearchDaoImpl implements ISearchDao {

	
	
	/**
	 * 
	 */
	@Autowired
	private NamedParameterJdbcTemplate jdbctemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.search_query.dao.ISearchDao#getCategory()
	 */
	@Ask_AOP
	@Override
	public List<String> getCategory() {

		final String query = "select ctgry_name from ask.ASK_CTGRY_TBL";

		List<String> employeelist = jdbctemplate.query(query, new RowMapper<String>() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
			 */
			public String mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

				return resultSet.getString(1);

			}
		});

		return employeelist;

	}

}
