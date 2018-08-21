package com.prokarma.userprofile.service;

import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author prokarma
 *
 */
public interface INewUserService {
	
	/**
	 * @param userProfile
	 * @return
	 */
	public String  createProfile(UserProfileBean userProfile);
}
