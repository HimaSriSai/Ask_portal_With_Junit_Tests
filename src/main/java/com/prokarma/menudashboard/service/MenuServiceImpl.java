package com.prokarma.menudashboard.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prokarma.menudashboard.dao.IMenuDao;

/**
 * @author Prokarma Service interface implementation
 */
@Component
public class MenuServiceImpl implements IMenuService {
	/**
	 * to hit DAO layer
	 */
	@Autowired
	private IMenuDao iMenuDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.menuPage.service.IMenuService#roleName(java.lang.String)
	 * based no role name given by DAO layer it decide's which has to be returned
	 */
	public Set<String> roleName(String userName) {
		Set<String> finalRoleNames = new HashSet<>();
		List<String> roleName = iMenuDao.getUserRoleName(userName);

		if (roleName.isEmpty()) {
			finalRoleNames.add("EMPLOYEE");
		} else {

			for (String selectedRole : roleName) {
				finalRoleNames.add(selectedRole);
			}
		}
		return finalRoleNames;
	}
}
