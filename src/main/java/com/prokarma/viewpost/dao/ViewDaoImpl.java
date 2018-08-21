package com.prokarma.viewpost.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.prokarma.viewpost.model.PostReplyTotal;
import com.prokarma.viewpost.model.ReplyOnPost;
import com.prokarma.viewpost.model.SearchInfoModel;

/**
 * @author prokarma
 *
 */
@Component
public class ViewDaoImpl implements IViewDao {
	/**
	 * 
	 */
	
	/**
	 * to connect database
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.viewAll.dao.IViewDao#getPostdata
	 */
	public List<PostReplyTotal> getPostdata(final SearchInfoModel searchModelInfo) {
		String queryObject = null;

		boolean isEmployeeWithoutCategory = searchModelInfo.getCategory().equalsIgnoreCase("") && searchModelInfo.getEmpid() == 0;
		if (isEmployeeWithoutCategory) {
			queryObject = "select u1.fst_name as postCreat,u1.last_name as postlast,u2.fst_name,u2.last_name,a.post_id,a.pstd_qry,a.ctgry_name,"
					+ "a.pstd_dt,a.post_crtd_by,b.rply_id,b.rply_rcvd,b.rply_dt,b.rply_crtd_by,b.rply_status FROM ask.ask_post_tbl a left join ask.ask_reply_tbl b on a.post_id=b.post_id left join ask.ask_user_tbl u1 on a.post_crtd_by  = u1.emp_id left join ask.ask_user_tbl u2 on b.rply_crtd_by  = u2.emp_id where a.pst_status='y' order by a.pstd_dt desc";
		} else if (searchModelInfo.getEmpid() > 0) {
			queryObject = "select u1.fst_name as postCreat,u1.last_name as postlast,u2.fst_name,u2.last_name,a.post_id,a.pstd_qry,a.ctgry_name,"
					+ "a.pstd_dt,a.post_crtd_by,b.rply_id,b.rply_rcvd,b.rply_dt,b.rply_crtd_by,b.rply_status FROM ask.ask_post_tbl a left join ask.ask_reply_tbl b on a.post_id=b.post_id left join ask.ask_user_tbl u1 on a.post_crtd_by  = u1.emp_id left join ask.ask_user_tbl u2 on b.rply_crtd_by  = u2.emp_id where a.pst_status='y' and a.post_crtd_by="
					+ searchModelInfo.getEmpid()+" order by a.pstd_dt desc";
		} else if ((!searchModelInfo.getCategory().equalsIgnoreCase("")) && (searchModelInfo.getEmpid() == 0)) {
			queryObject = "select u1.fst_name as postCreat,u1.last_name as postlast,u2.fst_name,u2.last_name,a.post_id,a.pstd_qry,a.ctgry_name,"
					+ "a.pstd_dt,a.post_crtd_by,b.rply_id,b.rply_rcvd,b.rply_dt,b.rply_crtd_by,b.rply_status FROM ask.ask_post_tbl a left join "
					+ "ask.ask_reply_tbl b on a.post_id=b.post_id left join ask.ask_user_tbl u1 on a.post_crtd_by  = u1.emp_id left join ask.ask_user_tbl u2 on b.rply_crtd_by  = u2.emp_id where a.pst_status='y' and "
					+ "a.ctgry_name='" + searchModelInfo.getCategory() + "' order by a.pstd_dt desc";
		}

		return jdbcTemplate.query(queryObject, new RowMapper<PostReplyTotal>() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
			 */
			public PostReplyTotal mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
				final PostReplyTotal postObj = new PostReplyTotal();
				postObj.setPostId(resultSet.getInt("post_id"));
				postObj.setFirstName(resultSet.getString("postCreat"));
				postObj.setLastName(resultSet.getString("postlast"));
				postObj.setPostedMsg(resultSet.getString("pstd_qry"));
				postObj.setCtgryName(resultSet.getString("ctgry_name"));
				postObj.setPostedDate(resultSet.getDate("pstd_dt"));
				postObj.setPostedBy(resultSet.getInt("post_crtd_by"));
				postObj.setReplyId(resultSet.getInt("rply_id"));
				postObj.setRepliesMsgs(resultSet.getString("rply_rcvd"));
				postObj.setReplyedDate(resultSet.getDate("rply_dt"));
				postObj.setRepliedBy(resultSet.getInt("rply_crtd_by"));
				postObj.setReplyStatus(resultSet.getString("rply_status"));
				postObj.setReplyPostId(resultSet.getInt("post_id"));
				postObj.setRplyFirstName(resultSet.getString("fst_name"));
				postObj.setRplyLastName(resultSet.getString("last_name"));

				return postObj;
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prokarma.viewAll.dao.IViewDao#insertReply(com.prokarma.viewAll.model.
	 * ReplyOnPost)
	 */
	public String insertReply(ReplyOnPost replyOnPost) throws ParseException {
		final String sql = "insert into ASK.ASK_REPLY_TBL values(ask.rply_id_seq.nextval,?,?,?,?,?,?,?)";
		String msg = "";
		final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		final Date today = new Date();

		final Date str = formatter.parse(formatter.format(today));

		final java.sql.Date sqlDate = new java.sql.Date(str.getTime());
		final String status = "y";
		try {
			jdbcTemplate.update(sql, new Object[] { replyOnPost.getReplyMsg(), sqlDate, replyOnPost.getReplyCreatedBy(),
					sqlDate, status, replyOnPost.getReplyCreatedBy(), replyOnPost.getPostId() });
			msg = "reply posted successfully";
		} catch (Exception e) {
			msg = "unable to post a reply";
		}
		return msg;
	}
}
