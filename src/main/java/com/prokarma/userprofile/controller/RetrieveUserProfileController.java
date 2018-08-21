package com.prokarma.userprofile.controller;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.prokarma.userprofile.model.UserProfileBean;
import com.prokarma.userprofile.service.IRetrieveUserProfileService;

/**
 * @author Prokarma
 *
 */
@RestController
@EnableWebMvc
@RequestMapping("/ask")
public class RetrieveUserProfileController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 
	 */
	@Autowired
	private transient IRetrieveUserProfileService editUserService;
	
	
	
	
	/**
	 * @param emp_id
	 * @return
	 */
	@RequestMapping(value = "/editUser/{emp_id}", method = RequestMethod.GET)
	
 public ResponseEntity<UserProfileBean> getUserProfile(@PathVariable(value="emp_id") final int emp_id) {
		final  UserProfileBean userProfileBean=editUserService.getUserProfile(emp_id);
		  return new ResponseEntity<>(userProfileBean,HttpStatus.OK);
     
    }
}
