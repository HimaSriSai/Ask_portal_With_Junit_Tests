package com.prokarma.userprofile.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.prokarma.userprofile.dao.IRetrieveUserProfileDao;
import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author Prokarma
 *
 */
public class RetrieveUserProfileServiceImpl implements IRetrieveUserProfileService{

	
	/**
	 * 
	 */
	@Autowired
	private transient IRetrieveUserProfileDao edituser;
	
	/* (non-Javadoc)
	 * @see com.prokarma.user_profile.service.EditUserService#getUserProfile(int)
	 */
	@Override
	public final UserProfileBean getUserProfile(final int empid) {
		return edituser.getUserProfile(empid);
		 
	}

}
