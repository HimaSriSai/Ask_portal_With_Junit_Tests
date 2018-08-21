package com.prokarma.login.dao;

import com.prokarma.login.model.InfoFromDB;

/**
 * @author Prokarma DAO interface
 */
public interface ILoginDao {
	/**
	 * @param loginDetails
	 * @return password DAO interface method
	 */
	String getpaswordDetails(String userName);

	/**
	 * @param userName
	 * @return employee id
	 */
	public InfoFromDB getEmpDetails(String userName);
}
