package com.prokarma.userprofile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.prokarma.userprofile.dao.INewUserProfileDao;
import com.prokarma.userprofile.dao.UpdateUserProfileDao;
import com.prokarma.userprofile.model.ResponseBean;
import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author Prokarma
 *
 */
public class UpdateUserProfileServiceImpl implements UpdateUserProfileService {

	/**
	 * 
	 */
	@Autowired
	private transient UpdateUserProfileDao updateData;
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
	 * com.prokarma.user_profile.service.UpdateUserProfileService#updateUser(com.
	 * prokarma.user_profile.model.UserProfileBean)
	 */
	@Override
	public ResponseBean updateUser(final UserProfileBean userModel) {
		ResponseBean responseBean = new ResponseBean();
		int empId = 0;
		try {
			empId = newUserProfileDao.giveEmpId(userModel.getFstname(), userModel.getLastname());
		} catch (Exception e) {
			empId = 0;
		}
		if (empId == 0||(empId==userModel.getEmpid())) {
			responseBean.setResponseMessage(updateData.updateProfile(userModel));
		} else {
			responseBean.setResponseMessage("The combination of first name as '" + userModel.getFstname()
					+ "' and last name as '" + userModel.getLastname() + "' already exist");
		}

		return responseBean;
	}
}
