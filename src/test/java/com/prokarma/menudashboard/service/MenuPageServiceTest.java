package com.prokarma.menudashboard.service;

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
import com.prokarma.menudashboard.dao.IMenuDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class MenuPageServiceTest {

	@SuppressWarnings("unused")
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	private IMenuDao iMenuDao;

	@InjectMocks
	private MenuServiceImpl iMenuService;

	@Test
	public void testroleName() {
		List<String> roleList = new ArrayList<>();
		roleList.add("SME");
		when(iMenuDao.getUserRoleName(Mockito.anyString())).thenReturn(roleList);

		Set<String> roleExpectedList = new HashSet<>();
		roleExpectedList.add("SME");
		assertEquals(roleExpectedList,iMenuService.roleName("priya"));
	}
	
	@Test
	public void testroleNameFailure() {
		List<String> roleList = new ArrayList<>();
		roleList.add("");
		when(iMenuDao.getUserRoleName(Mockito.anyString())).thenReturn(roleList);

		Set<String> roleExpectedList = new HashSet<>();
		roleExpectedList.add("");
		assertEquals(roleExpectedList,iMenuService.roleName("nothing"));
	}
	
	@Test
	public void testroleNameError() {
		List<String> roleList = new ArrayList<>();
		roleList.add("");
		when(iMenuDao.getUserRoleName(Mockito.anyString())).thenReturn(roleList);

		Set<String> roleExpectedList = new HashSet<>();
		roleExpectedList.add("");
		assertEquals(roleExpectedList,iMenuService.roleName(""));
	}
	
	@Test
	public void testroleNameCatch() {
		List<String> roleList = null;
		when(iMenuDao.getUserRoleName(Mockito.anyString())).thenReturn(roleList);

		Set<String> roleExpectedList = new HashSet<>();
		roleExpectedList.add("EMPLOYEE");
		assertEquals(roleExpectedList,iMenuService.roleName(null));
	}

}
