package com.prokarma.menudashboard.dao;

import java.util.List;

/**
 * @author Prokarma
 *DAO interface
 */
public interface IMenuDao {
  
  /**
   * @param userName
   * @return
   * DAO method
   */
 List<String> getUserRoleName(String userName) ;
}
