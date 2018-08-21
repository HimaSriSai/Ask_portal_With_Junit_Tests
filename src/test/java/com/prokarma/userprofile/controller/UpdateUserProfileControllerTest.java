package com.prokarma.userprofile.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.Before;
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
import com.prokarma.userprofile.model.ResponseBean;
import com.prokarma.userprofile.model.UserProfileBean;
import com.prokarma.userprofile.service.UpdateUserProfileService;

/**
 * @author prokarma
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
@Transactional
public class UpdateUserProfileControllerTest {
	/**
	 * 
	 */
	private MockMvc mockMvc;

	@Mock
	private UpdateUserProfileService userProfileService;

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
	public void testupdateProfileFail() throws Exception {

		when(userProfileService.updateUser((UserProfileBean) any(Object.class))).thenReturn(new ResponseBean());
		this.mockMvc.perform(post("/ask/updateUser").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":\"23411\",\"fstname\":\"Test\",\"lastname\":\"test\",\"emailid\":\"change@gmail.com\",\"uPwd\":\"yetgydhd\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMessage\":\"Failed To update User Credentials\"}"));

	}

	/**
	 * @throws Exception
	 * 
	 */
	@Test
	public void testupdateProfile() throws Exception {

		when(userProfileService.updateUser((UserProfileBean) any(Object.class))).thenReturn(new ResponseBean());
		this.mockMvc.perform(post("/ask/updateUser").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":\"234\",\"fstname\":\"Test\",\"lastname\":\"test\",\"emailid\":\"change@gmail.com\",\"uPwd\":\"yetgydhd\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMessage\":\"User Credentials Successfully updated\"}"));

	}

	@Test
	public void updateSameFisrtAndLastName() throws Exception {

		this.mockMvc.perform(post("/ask/updateUser?").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":510,\"fstname\":\"priya\",\"lastname\":\"puli\",\"emailid\":\"dum@gmail.com\",\"phnNo\":2333,\"uName\":\"fromTest\",\"uPwd\":\"fromTest\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string(
						"{\"responseMessage\":\"The combination of first name as 'priya' and last name as 'puli' already exist\"}"))
				.andReturn();
	}

	@Test
	public void testBadReq() throws Exception {

		this.mockMvc.perform(post("/ask/updateUser?").contentType(MediaType.APPLICATION_JSON).content("{\"empId\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();

	}

}
