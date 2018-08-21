package com.prokarma.sme.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.prokarma.sme.model.UpdatePostQuery;
import com.prokarma.sme.model.UpdateReplyQuery;

@Component
public class SmeDaoImpl implements ISmeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<String> ctrgyNameOnSme(int empId) {
		String query = "select a.ctgry_name from ask.ask_ctgry_tbl a left join ask.ask_map_roleCtgry b on a.ctgry_id=b.ctgry_id where emp_id=?";
		List<String> ctrgyNameList = null;

		ctrgyNameList = jdbcTemplate.queryForList(query, String.class, empId);

		return ctrgyNameList;
	}

	public String updatePostStatus(UpdatePostQuery updatePostQuery) throws ParseException {
		String query = "update ask.ask_post_tbl set lst_updt_by=? ,lst_updt_dt=?,pst_status='n' where post_id=?";
		String response;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date today = new Date();

		java.util.Date str = formatter.parse(formatter.format(today));

		java.sql.Date sqlDate = new java.sql.Date(str.getTime());
		try {
			final int i = jdbcTemplate.update(query, updatePostQuery.getLastUpdatedByEmpId(), sqlDate,
					updatePostQuery.getPostId());
			if (i > 0) {
				response = "successfully deleted posted query";
			} else {
				response = "might be 'lastUpdatedByEmpId' or 'postId' informations are not correct";
			}
		} catch (Exception e) {
			response = "error while deleting posted query";
		}
		return response;
	}

	public String updateReplyStatus(UpdateReplyQuery updateReplyQuery) throws ParseException {
		String query = "update ask.ask_reply_tbl set lst_updt_by=? ,lst_updt_dt=?,rply_status='n' where rply_id=?";
		String response;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date today = new Date();

		java.util.Date str = formatter.parse(formatter.format(today));

		java.sql.Date sqlDate = new java.sql.Date(str.getTime());
		try {
			final int i = jdbcTemplate.update(query, updateReplyQuery.getLastUpdatedByEmpId(), sqlDate,
					updateReplyQuery.getReplyId());
			if (i > 0) {
				response = "successfully deleted reply query";
			} else {
				response = "might be 'lastUpdatedByEmpId' or 'replyId' information are not correct";
			}
		} catch (Exception e) {
			response = "error while deleting reply query";
		}
		return response;
	}

}
