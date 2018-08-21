package com.prokarma.admin.dao;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Prokarma
 *
 */
@Component
public interface IAdminDAO {

	/**
	 * @param empId
	 * @param roleId
	 * @param ctrgyId
	 */
	void addEmpAsSme(int empId, int roleId, List<Integer> ctrgyId);

	/**
	 * @return
	 */
	int getSmeRoleId();

	/**
	 * @param ctgryName
	 * @return
	 */
	List<Integer> listOfCtrgyId(List<String> ctgryName);

	/**
	 * @param ctrgyIds
	 * @param empId
	 * @return
	 */
	List<Integer> removeDuplicateSME(List<Integer> ctrgyIds, int empId);

	/**
	 * @return fullNames
	 */
	List<String> getNamesFormUserTbl();

	/**
	 * @param firstName
	 * @return empId
	 */
	int getEmpIdUsingName(String firstName, String lastName) throws Exception;
}
