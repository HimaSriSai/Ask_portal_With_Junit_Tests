package com.prokarma.forgotpasswordtest.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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
import org.junit.Test;

import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.forgotpassword.service.IForgotPasswordService;
import com.prokarma.forgotpassword.service.IMailService;

/**
 * @author prokarma
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
@Transactional
public class ForgotPasswordTestController {
	/**
	 * 
	 */
	private MockMvc mockMvc;

	@Mock
	private IForgotPasswordService ifrgtpswdsrvce;
	
	@Mock
	private transient IMailService mailService;
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
		Logger.getRootLogger().setLevel(Level.DEBUG);
	}

	@Test
	public void testEmpNotRes() throws Exception {
		String email = "msaikartheek@prokarma.com";

		when(ifrgtpswdsrvce.sendRestMail(email))
				.thenReturn("{\"responseMessage\":\"This Employee not Registered with us please Register!\"}");
		this.mockMvc
				.perform(post("/ask/resetPassword?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"emailid\":\"msaikartheek@prokarma.com\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content()
						.string("{\"responseMessage\":\"Please enter registered email\"}"))
				.andReturn();

	}

/*	@Test
	public void testSuccess() throws Exception {
		String email = "opriyanka@prokarma.com";
		String pass = "prokarma";

		when(ifrgtpswdsrvce.sendRestMail(email))
				.thenReturn("{\"responseMessage\":\"Password sent to registered email\"}");
		doNothing().when(mailService).sendMail(email, pass);
		this.mockMvc
				.perform(post("/ask/resetPassword?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"emailid\":\"opriyanka@prokarma.com\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(
						content().string("{\"responseMessage\":\"Password sent to registered email\"}"))
				.andReturn();

	}*/

}
