package com.prokarma.forgotpassword.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prokarma.forgotpassword.model.ForgotPasswordModel;

/**
 * @author prokarma
 *
 */
@Repository
public class ForgotPasswordDaoImpl implements IForgotPasswordDao {
	
	 /**
	 * Logger method
	 */
  private static final Logger LOGGER = Logger.getLogger(ForgotPasswordDaoImpl.class);
 
	
  /**
 * Named jdbc template   
 */
@Autowired
  NamedParameterJdbcTemplate jdbctemplate;
  

/* (non-Javadoc)
 * @see com.prokarma.forgotpassword.dao.IForgotPasswordDao#getdata(int)
 */
@Override

 public final ForgotPasswordModel getdata(String emailId) throws SQLException,NullPointerException{
	final String sql = "select email_id ,user_key,emp_id  from  ask.ask_user_tbl where email_id=:emailId";
    final MapSqlParameterSource mapsqlparameter = new MapSqlParameterSource();
    mapsqlparameter.addValue("emailId", emailId); 
   
    ForgotPasswordModel forgotPasswordModel = jdbctemplate.query(sql, mapsqlparameter,new ResultSetExtractor<ForgotPasswordModel>() 
    {   
      /* (non-Javadoc)
       * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
       */
      public final ForgotPasswordModel extractData(ResultSet resultset) throws SQLException,NullPointerException  {
    	 final ForgotPasswordModel frgtPswdMdlObj = new ForgotPasswordModel();
        while (resultset.next()) {
          
          frgtPswdMdlObj.setEmailid(resultset.getString("email_id"));
          frgtPswdMdlObj.setuPwd(resultset.getString("user_key"));
          frgtPswdMdlObj.setEmpid(resultset.getInt("emp_id"));
        }
        if(LOGGER.isDebugEnabled()) {
          LOGGER.info(frgtPswdMdlObj.getEmailid()+frgtPswdMdlObj.getEmpid()+frgtPswdMdlObj.getuPwd());
        
      }
        return frgtPswdMdlObj;
      }
    });
   
    return forgotPasswordModel;
}
}
