package com.prokarma.login.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.login.model.ResponseModel;
import com.prokarma.login.model.UserModel;
import com.prokarma.login.service.ILoginService;

/**
 * @author pabhisek
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class LoginControllerTest {
	private MockMvc mockMvc;

	@Mock
	private ILoginService iLoginService;

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

	@Test
	public void testsample() throws Exception {

		ResultActions actions = this.mockMvc.perform(get("/ask/sampleLogin"));
		actions.andDo(MockMvcResultHandlers.print());
		actions.andExpect(content().contentType("text/plain;charset=ISO-8859-1"));
		actions.andExpect(status().isOk());
		actions.andExpect(content().string("welcome to login controller"));
		MvcResult result = actions.andReturn();
		result.getResponse().getContentAsString();

	}

	@Test
	public void testCheckCredentials() throws Exception {

		when(iLoginService.validLogin((UserModel) any(Object.class))).thenReturn(new ResponseModel());

		this.mockMvc
				.perform(post("/ask/checkCredentials?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"mohan\",\"password\":\"sai123\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void testCheckCredentialsFail() throws Exception {

		when(iLoginService.validLogin((UserModel) any(Object.class))).thenReturn(new ResponseModel());

		this.mockMvc
				.perform(post("/ask/checkCredentials?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"abc\",\"password\":\"sai123\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string(
						"{\"responseStr\":\"Invalid UserName\",\"empId\":0,\"roleName\":null,\"userFullName\":null}"))
				.andReturn();

	}

	@Test
	public void testCheckCredentialsEmp() throws Exception {

		when(iLoginService.validLogin((UserModel) any(Object.class))).thenReturn(new ResponseModel());

		this.mockMvc
				.perform(post("/ask/checkCredentials?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"madhu\",\"password\":\"prokarma\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
	}

	@Test
	public void testCheckCredentialsError() throws Exception {

		when(iLoginService.validLogin((UserModel) any(Object.class))).thenReturn(new ResponseModel());

		this.mockMvc
				.perform(post("/ask/checkCredentials?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":,\"password\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();

	}

	@Test
	public void testCheckCredentialsInvalidPass() throws Exception {

		when(iLoginService.validLogin((UserModel) any(Object.class))).thenReturn(new ResponseModel());

		this.mockMvc
				.perform(post("/ask/checkCredentials?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"userName\":\"madhu\",\"password\":\"mywish\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseStr\":\"Invalid Password\",\"empId\":0,\"roleName\":null,\"userFullName\":null}"))
				.andReturn();

	}

}
