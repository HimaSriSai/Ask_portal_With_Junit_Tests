package com.prokarma.userprofile.service;

import com.prokarma.userprofile.model.ResponseBean;
import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author Prokarma
 *
 */
public interface UpdateUserProfileService {

	/**
	 * @param userModel
	 * @return
	 */
	public ResponseBean updateUser(final UserProfileBean userModel);
}
