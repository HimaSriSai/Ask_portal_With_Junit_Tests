package com.prokarma.userprofile.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.prokarma.userprofile.model.ResponseBean;
import com.prokarma.userprofile.model.UserProfileBean;
import com.prokarma.userprofile.service.INewUserService;

/**
 * @author prokarma
 *
 */
@RestController
@EnableWebMvc
@RequestMapping("/ask")
public class NewUserController implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	@Autowired
	@Qualifier("newUserService")
	private transient INewUserService newUserService;
	
	/**
	 * 
	 */
	final transient ResponseBean responseBean = new ResponseBean();
	/**
	 * @param userProfile
	 * @return
	 */

	@RequestMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResponseBean> resetRequest(@RequestBody final UserProfileBean userProfile) {

		final String response = newUserService.createProfile(userProfile);
	
		responseBean.setResponseMessage(response);
		return new ResponseEntity<>(responseBean, HttpStatus.OK);

	}

}
