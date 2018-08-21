package com.prokarma.login.service;


import com.prokarma.login.model.ResponseModel;
import com.prokarma.login.model.UserModel;


/**
 * @author Prokarma
 *service interface
 */
public interface ILoginService {
  
  /**
   * @param userProfile
   * @return
   * service interface method
   */
   ResponseModel validLogin(UserModel userProfile);

}
