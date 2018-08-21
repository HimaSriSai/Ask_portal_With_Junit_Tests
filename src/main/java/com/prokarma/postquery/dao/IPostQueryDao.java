package com.prokarma.postquery.dao;

import java.text.ParseException;

import com.prokarma.postquery.model.PostQueryModel;

/**
 * @author Prokarma
 *
 */
public interface IPostQueryDao {
	/**
	 * @param postquerymodel
	 * @return
	 * @throws ParseException 
	 */
	
	String postque( PostQueryModel postquerymodel) throws ParseException;
	
	

}
