package com.prokarma.userprofile.dao;

import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author Prokarma
 *
 */
public interface IRetrieveUserProfileDao {

	/**
	 * @param empid
	 * @return
	 */
	UserProfileBean getUserProfile(int empid) ;
		
	
	 
}
