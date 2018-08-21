package com.prokarma.forgotpassword.controller;

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

import com.prokarma.forgotpassword.model.ForgotPasswordModel;
import com.prokarma.forgotpassword.model.ResponseModel;
import com.prokarma.forgotpassword.service.IForgotPasswordService;

/**
 * @author prokarma
 *
 */
@RestController
@EnableWebMvc
@RequestMapping("/ask")
public class ForgotPasswordController {
	/**
	 * interface class 
	 */
	@Autowired
	@Qualifier("forgotpasswordservice")
	private IForgotPasswordService ifrgtpswdsrvce;
     /**
	 * @param userProfile
	 * @return
	 */
	@RequestMapping(value = "/resetPassword", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResponseModel>
	resetRequest(@RequestBody final ForgotPasswordModel frgtPswdmdl) {
		
		final String response=ifrgtpswdsrvce.sendRestMail(frgtPswdmdl.getEmailid());
		final ResponseModel responseModel=new ResponseModel();
		responseModel.setResponseMessage(response);
		return  new ResponseEntity<>(responseModel,HttpStatus.OK); 
				

	}

}
