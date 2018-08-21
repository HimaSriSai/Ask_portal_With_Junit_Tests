 package com.prokarma.postquery.controller;


import java.io.Serializable;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.prokarma.postquery.model.PostQueryModel;
import com.prokarma.postquery.model.ResponseMsgModel;
import com.prokarma.postquery.service.IPostQueryService;




/**
 * @author Prokarma
 *
 */



@RestController
@EnableWebMvc
@RequestMapping("/ask")
public class PostQueryController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	@Autowired
	private transient IPostQueryService postQueryService;
	
	/**
	 * 
	 */
	final transient ResponseMsgModel responsemodel=new ResponseMsgModel();
	
	/**
	 * @param postquerymodel
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/postquery", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public 	 ResponseEntity<ResponseMsgModel> resetRequest(@RequestBody final PostQueryModel postquerymodel) throws ParseException {

		final String response = postQueryService.postquestion(postquerymodel);
	
		responsemodel.setResponseMsg(response);
		return new ResponseEntity<>(responsemodel, HttpStatus.OK);

	}

}