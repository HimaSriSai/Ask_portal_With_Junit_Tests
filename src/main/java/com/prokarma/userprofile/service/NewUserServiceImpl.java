package com.prokarma.userprofile.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;

import com.prokarma.userprofile.dao.INewUserProfileDao;
import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author prokarma
 *
 */
public class NewUserServiceImpl implements INewUserService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2244221857020106372L;
	/**
	 * 
	 */
	@Autowired
	@Qualifier("newUserProfile")
	private transient INewUserProfileDao newUserProfileDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prokarma.user_profile.service.INewUserService#createProfile(com.prokarma.
	 * user_profile.model.UserProfileBean)
	 */
	@Override
	public String createProfile(final UserProfileBean userProfile) {
		int empId = 0;
		String returnValue=null;
		try {
			empId = newUserProfileDao.giveEmpId(userProfile.getFstname(), userProfile.getLastname());
		} catch (EmptyResultDataAccessException e) {
			empId = 0;
		}
		if (empId == 0) {
			
				returnValue=newUserProfileDao.addUser(userProfile);
			
		} else {
			returnValue= "the combination of first name as '" + userProfile.getFstname() + "' and last name as '"
					+ userProfile.getLastname() + "' already exist";
		}
		System.out.println("value is: "+returnValue);
		return returnValue;

	}

}
