package com.prokarma.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.prokarma.login.model.ResponseModel;
import com.prokarma.login.model.UserModel;

import com.prokarma.login.service.ILoginService;

/**
 * @author Prokarma login controller checks whether user is valid or not
 */
@RestController
@RequestMapping("/ask")
public class LoginController {
 /**
   * to use service layer
 */
  @Autowired
  private ILoginService iLoginService;
  
  /**
   * @return just for testing
   */
  @RequestMapping(value = "/sampleLogin", method = RequestMethod.GET)
  public String sample() {
    return "welcome to login controller";
  }
  
 
  /**
   * @param userModel
   * @return
   */
 
 
  @RequestMapping(value = "/checkCredentials", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)

  public ResponseModel checkCredentials(@RequestBody final UserModel userModel) {
 System.out.println("IN controller");
	  return iLoginService.validLogin(userModel);
   }
}
