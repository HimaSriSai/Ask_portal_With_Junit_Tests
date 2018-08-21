package com.prokarma.userprofile.dao;

import org.springframework.dao.EmptyResultDataAccessException;

import com.prokarma.userprofile.model.UserProfileBean;

/**
 * @author prokarma
 *
 */
public interface INewUserProfileDao {
	 /**
	 * @param userProfile
	 * @return
	 */
	String addUser(UserProfileBean userProfile) ;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @return
	 * @throws Exception
	 */
	int giveEmpId(String firstName,String lastName)throws EmptyResultDataAccessException;
}
