package com.prokarma.login.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.login.dao.ILoginDao;
import com.prokarma.login.model.InfoFromDB;
import com.prokarma.login.model.ResponseModel;
import com.prokarma.login.model.UserModel;
import com.prokarma.menudashboard.service.IMenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class LoginServiceImplTest {

	@SuppressWarnings("unused")
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@InjectMocks
	private LoginServiceImpl iLoginService;

	@Mock
	private ILoginDao iLoginDao;

	@Mock
	private IMenuService iMenuSer;

	@Mock
	private UserModel usermodel;

	@Mock
	private InfoFromDB infoFromDB;

	@Mock
	ResponseModel resModel;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testValidLogin() {

		when(usermodel.getUserName()).thenReturn("mohan");
		when(usermodel.getPassword()).thenReturn("sai123");
		when(infoFromDB.getEmpId()).thenReturn(4221);
		when(infoFromDB.getFirstName()).thenReturn("krishnakanchi");
		when(infoFromDB.getLastName()).thenReturn("mohansai");

		when(iLoginDao.getpaswordDetails(Mockito.anyString())).thenReturn("sai123");
		when(iLoginDao.getEmpDetails(Mockito.anyString())).thenReturn(infoFromDB);

		Set<String> roleList = new HashSet<>();
		roleList.add("Employee");
		when(iMenuSer.roleName(Mockito.anyString())).thenReturn(roleList);

		assertEquals(4221, iLoginService.validLogin(usermodel).getEmpId());
		assertEquals("Success", iLoginService.validLogin(usermodel).getResponseStr());

	}

	@Test
	public void testValidLoginFailurePwd() {

		when(usermodel.getUserName()).thenReturn("mohan");
		when(usermodel.getPassword()).thenReturn("sai123");

		when(iLoginDao.getpaswordDetails(Mockito.anyString())).thenReturn("sai1213");
		when(iLoginDao.getEmpDetails(Mockito.anyString())).thenReturn(new InfoFromDB());

		Set<String> roleList = new HashSet<>();
		roleList.add("Employee");
		when(iMenuSer.roleName(Mockito.anyString())).thenReturn(roleList);

		List<String> roleExpectedList = new ArrayList<>();
		roleExpectedList.add("Employee");

		assertEquals(0, iLoginService.validLogin(usermodel).getEmpId());
		assertEquals(null, iLoginService.validLogin(usermodel).getRoleName());
		assertEquals("Invalid Password", iLoginService.validLogin(usermodel).getResponseStr());

	}

}
