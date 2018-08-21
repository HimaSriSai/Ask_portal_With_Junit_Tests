package com.prokarma.login.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.prokarma.login.model.InfoFromDB;
import com.prokarma.login.model.ResponseModel;
import com.prokarma.common.util.CommonUtil;
import com.prokarma.login.dao.ILoginDao;

import com.prokarma.login.model.UserModel;
import com.prokarma.menudashboard.service.IMenuService;

/**
 * @author Prokarma service interface implementation class
 */
@Component
public class LoginServiceImpl implements ILoginService {
	/**
	 * to use DAO layer
	 */
	@Autowired
	private ILoginDao iLoginDao;
	/**
	 * 
	 */
	@Autowired
	private IMenuService iMenuSer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.login.service.ILoginService this method get password from
	 * DAO it returns value
	 */

	public final ResponseModel validLogin(UserModel userModel) {
		String message;
		Set<String> roleName;
		final ResponseModel resModel = new ResponseModel();
		final String pwd = iLoginDao.getpaswordDetails(userModel.getUserName());
		if (StringUtils.isEmpty(pwd)) {
			message = "Invalid UserName";
			resModel.setResponseStr(message);
		} else if (!pwd.equalsIgnoreCase(userModel.getPassword())) {
			message = "Invalid Password";
			resModel.setResponseStr(message);
		} else {
			message = "Success";
			resModel.setResponseStr(message);
			InfoFromDB infoFromDB = iLoginDao.getEmpDetails(userModel.getUserName());
			resModel.setEmpId(infoFromDB.getEmpId());
			resModel.setUserFullName(
					CommonUtil.formatEmployeeName(infoFromDB.getFirstName(), infoFromDB.getLastName()));
			roleName = iMenuSer.roleName(userModel.getUserName());
			resModel.setRoleName(roleName);
		}
		return resModel;
	}
}
