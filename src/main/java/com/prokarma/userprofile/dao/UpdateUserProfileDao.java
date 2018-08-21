package com.prokarma.userprofile.dao;

import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author Prokarma
 *
 */
public interface UpdateUserProfileDao {
	
	/**
	 * @param userModel
	 * @return
	 */
	 public String updateProfile(final UserProfileBean userModel);

}
