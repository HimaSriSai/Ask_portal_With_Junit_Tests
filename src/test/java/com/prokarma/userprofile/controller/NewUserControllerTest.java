package com.prokarma.userprofile.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.userprofile.model.UserProfileBean;
import com.prokarma.userprofile.service.INewUserService;

/**
 * @author prokarma
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class NewUserControllerTest {
	/**
	 * 
	 */
	private MockMvc mockMvc;
	@Mock
	private INewUserService iNewUserService;

	/**
	 * 
	 */
	@Autowired
	private WebApplicationContext wac;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * @throws Exception
	 * 
	 */
	@Test
	public void testNewUserFail() throws Exception {

		String responseBean = "EmployeeID Already Registered! Please Login";
		when(iNewUserService.createProfile((UserProfileBean) any(Object.class))).thenReturn(responseBean);
		this.mockMvc.perform(post("/ask/addUser").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":42341,\"fstname\":\"dsads\",\"lastname\":\"dsadsad\",\"emailid\":\"kalyani@gmail.comm\",\"phnNo\":9999888990,\"uName\":\"kalyanii\",\"uPwd\":\"1234567\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMessage\":\"EmployeeID Already Registered! Please Login\"}"))
				.andReturn();

	}

	/**
	 * @throws Exception
	 * 
	 */
	@Test
	public void testUserNameExist() throws Exception {
		String responseBean = "UserName Already Exist! Please Try With Another";
		when(iNewUserService.createProfile((UserProfileBean) any(Object.class))).thenReturn(responseBean);
		this.mockMvc.perform(post("/ask/addUser").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":4545,\"fstname\":\"dsa\",\"lastname\":\"das\",\"emailid\":\"dsa@gmail.comm\",\"phnNo\":9999888990,\"uName\":\"priya\",\"uPwd\":\"prokarma\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(
						content().string("{\"responseMessage\":\"UserName Already Exist! Please Try With Another\"}"))
				.andReturn();

	}

	@Test
	@Transactional
	public void testInvalidMail() throws Exception {

		String responseBean = "Failed To Register User";
		when(iNewUserService.createProfile((UserProfileBean) any(Object.class))).thenReturn(responseBean);
		this.mockMvc.perform(post("/ask/addUser").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":369,\"fstname\":\"puli\",\"lastname\":\"piya\",\"emailid\":\"opriyanka@prokarma.com\",\"phnNo\":9955888990,\"uName\":\"opriyanka\",\"uPwd\":\"opriya\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMessage\":\"This email already registered! Please try another email\"}"))
				.andReturn();
	}

	@Test
	@Transactional
	public void testNewUserSuccess() throws Exception {

		this.mockMvc.perform(post("/ask/addUser").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":510,\"fstname\":\"dumm\",\"lastname\":\"dum\",\"emailid\":\"dum@gmail.com\",\"phnNo\":2333,\"uName\":\"fromTest\",\"uPwd\":\"fromTest\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMessage\":\"Registered Successfully! Please Login\"}"))
				.andReturn();
	}
	
	@Test
	@Transactional
	public void testSameFisrtAndLastName() throws Exception {

		this.mockMvc.perform(post("/ask/addUser").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":510,\"fstname\":\"priya\",\"lastname\":\"puli\",\"emailid\":\"dum@gmail.com\",\"phnNo\":2333,\"uName\":\"fromTest\",\"uPwd\":\"fromTest\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMessage\":\"the combination of first name as 'priya' and last name as 'puli' already exist\"}"))
				.andReturn();
	}
	
	@Test
	@Transactional
	public void testBadReq() throws Exception {

		this.mockMvc.perform(post("/ask/addUser").contentType(MediaType.APPLICATION_JSON).content("{\"empId\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();
				
	}
}
