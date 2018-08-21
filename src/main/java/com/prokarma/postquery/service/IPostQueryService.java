package com.prokarma.postquery.service;

import java.text.ParseException;

import com.prokarma.postquery.model.PostQueryModel;

/**
 * @author Prokarma
 *
 */
public interface IPostQueryService {

	/**
	 * @param postquerymodel
	 * @return
	 * @throws ParseException 
	 */

	String postquestion(PostQueryModel postquerymodel) throws ParseException;
	
}
