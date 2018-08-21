package com.prokarma.login.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.login.dao.ILoginDao;
import com.prokarma.login.model.ResponseModel;
import com.prokarma.login.model.UserModel;
import com.prokarma.login.service.ILoginService;
import com.prokarma.menudashboard.service.IMenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class LoginServiceTest {

	@Mock
	private ILoginDao iLoginDao;

	@Mock
	UserModel userModel;

	@Mock
	private IMenuService iMenuSer;

	@Autowired
	@InjectMocks
	private ILoginService iLoginService;

	@Test
	public void testLoginServiceNull() {
		userModel = new UserModel();
		userModel.setUserName(null);
		userModel.setPassword("prokarma");

		ResponseModel resModel = iLoginService.validLogin(userModel);
		String reString = resModel.getResponseStr();
		Set<String> roleName = resModel.getRoleName();
		int emplId = resModel.getEmpId();
		assertEquals("Invalid UserName", reString);
		assertEquals(null, roleName);
		assertEquals(0, emplId);
	}

	@Test
	public void testLoginServicePasswordNull() {
		userModel = new UserModel();
		userModel.setUserName("priya");
		userModel.setPassword(null);

		ResponseModel resModel = iLoginService.validLogin(userModel);
		String reString = resModel.getResponseStr();
		Set<String> roleName = resModel.getRoleName();
		int emplId = resModel.getEmpId();
		assertEquals("Invalid Password", reString);
		assertEquals(null, roleName);
		assertEquals(0, emplId);
	}

	@Test
	public void testLoginServicePasswordBlank() {
		userModel = new UserModel();
		userModel.setUserName("");
		userModel.setPassword("");

		ResponseModel resModel = iLoginService.validLogin(userModel);
		String reString = resModel.getResponseStr();
		Set<String> roleName = resModel.getRoleName();
		int emplId = resModel.getEmpId();
		assertEquals("Invalid UserName", reString);
		assertEquals(null, roleName);
		assertEquals(0, emplId);
	}

	@Test
	public void testLoginServiceUser2() {
		userModel = new UserModel();
		userModel.setUserName("mohan");
		userModel.setPassword("sai123");

		ResponseModel resModel = iLoginService.validLogin(userModel);
		String reString = resModel.getResponseStr();
		int emplId = resModel.getEmpId();
		assertEquals("Success", reString);
		assertEquals(4221, emplId);
	}
}
