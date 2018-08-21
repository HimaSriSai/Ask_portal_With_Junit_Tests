package com.prokarma.userprofile.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.prokarma.userprofile.model.ResponseBean;
import com.prokarma.userprofile.model.UserProfileBean;
import com.prokarma.userprofile.service.UpdateUserProfileService;

/**
 * @author Prokarma
 *
 */
@RestController
@EnableWebMvc
@RequestMapping("/ask")
public class UpdateUserProfileController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Autowired
	private transient UpdateUserProfileService updateService;

	/**
	 * @param userModel
	 * @return
	 */
	@RequestMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean updateUser(@RequestBody final UserProfileBean userModel) {
		return updateService.updateUser(userModel);

	}
}
