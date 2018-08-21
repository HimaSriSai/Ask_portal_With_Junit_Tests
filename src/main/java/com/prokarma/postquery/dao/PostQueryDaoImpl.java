package com.prokarma.postquery.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prokarma.postquery.model.PostQueryModel;

/**
 * @author Prokarma
 *
 */
@Repository
public class PostQueryDaoImpl implements IPostQueryDao {

	/**
	 * 
	 */
	public static final Logger LOGGER = Logger.getLogger(PostQueryDaoImpl.class);

	/**
	 * 
	 */
	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prokarma.post_query.dao.PostQueryDao#postque(com.prokarma.post_query.
	 * model.PostQueryModel)
	 */
	@Override
	public String postque(PostQueryModel postquerymodel) throws ParseException {

		String postStatus = "y";
		String categoryStatus = "y";
		int onSelectedCtgry = 0;
		int ctgryresult = 0;
		int queryresult = 0;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		final Date today = new Date();

		final Date str = formatter.parse(formatter.format(today));
		java.sql.Date sqlDate = new java.sql.Date(str.getTime());

		String responseMsg = null;
		String sqlforquery = null;
		String sqlforctgry = null;
		try {
			MapSqlParameterSource mapsqlparamsrc = new MapSqlParameterSource();
			mapsqlparamsrc.addValue("post_id", postquerymodel.getPostid());
			mapsqlparamsrc.addValue("pstd_qry", postquerymodel.getPstdqry());
			mapsqlparamsrc.addValue("ctgry_name", postquerymodel.getCtgryname());
			mapsqlparamsrc.addValue("post_crtd_by", postquerymodel.getEmpid());
			mapsqlparamsrc.addValue("pstd_dt", sqlDate);
			mapsqlparamsrc.addValue("lst_uptd_by", postquerymodel.getLastuptdby());
			mapsqlparamsrc.addValue("lst_uptd_dt", sqlDate);
			mapsqlparamsrc.addValue("pst_status", postStatus);

			sqlforquery = "insert into ASK.ASK_POST_TBL values(ask.post_id_seq.nextval,:pstd_qry,:ctgry_name,:pstd_dt,:lst_uptd_by,:lst_uptd_dt,:pst_status,:post_crtd_by)";

			if (postquerymodel.getCtgryname() != "") {

				onSelectedCtgry = jdbctemplate.update(sqlforquery, mapsqlparamsrc);

			} else if (postquerymodel.getCtgryname() == "") {
				sqlforctgry = "insert into ASK.ASK_CTGRY_TBL values(ask.ctgry_id_seq.nextval,:ctgry_name,:ctgry_crtd_by,:ctgry_crtd_dt,:lst_uptd_by,:lst_uptd_dt,:ctgry_status)";

				mapsqlparamsrc.addValue("ctgry_id", postquerymodel.getCtgryid());
				mapsqlparamsrc.addValue("ctgry_crtd_by", postquerymodel.getCtgrycrtdby());
				mapsqlparamsrc.addValue("ctgry_crtd_dt", sqlDate);
				mapsqlparamsrc.addValue("lst_uptd_by", postquerymodel.getLastuptdby());
				mapsqlparamsrc.addValue("lst_uptd_dt", sqlDate);
				mapsqlparamsrc.addValue("ctgry_status", categoryStatus);
				mapsqlparamsrc.addValue("ctgry_name", postquerymodel.getOther());

				ctgryresult = jdbctemplate.update(sqlforctgry, mapsqlparamsrc);
				queryresult = jdbctemplate.update(sqlforquery, mapsqlparamsrc);
			}

			if (onSelectedCtgry == 1 || (ctgryresult == 1 && queryresult == 1)) {
				LOGGER.info("Query Successfully posted");
				responseMsg = "Query Successfully posted";

			} 

		} catch (Exception e) {

			responseMsg = "failure";

			LOGGER.info("Failed To post query "+e.getMessage());
		}
		return responseMsg;

	}
}
