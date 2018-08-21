package com.prokarma.userprofile.service;

import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author Prokarma
 *
 */
public interface IRetrieveUserProfileService {

	/**
	 * @param empid
	 * @return
	 */
	UserProfileBean getUserProfile(int empid);
}
