package com.prokarma.menudashboard.service;

import java.util.Set;

/**
 * @author Prokarma service interface
 */
public interface IMenuService {

	/**
	 * @param userName
	 * @return service method
	 */
	Set<String> roleName(String userName);
}
