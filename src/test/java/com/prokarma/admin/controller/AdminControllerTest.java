package com.prokarma.admin.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.any;

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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.prokarma.admin.model.RequestDetails;
import com.prokarma.admin.model.ResponseMsg;
import com.prokarma.admin.services.IAdminService;
import com.prokarma.common.config.ConfigurationClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class AdminControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	private IAdminService iAdminService;

	@Test
	public void testAddEmpAsSmeFail() throws Exception {
		when(iAdminService.addAsSme((RequestDetails) any(RequestDetails.class))).thenReturn(new ResponseMsg());
		this.mockMvc
				.perform(post("/ask/addEmpAsSme?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"fullName\":\"dsadsa puli\",\"ctrgyList\":[\"java\",\"angular\",\"jms\"]}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"'dsadsa puli' is not a vaild name\"}")).andReturn();

	}

/*	@Transactional
	@Test
	public void testAddEmpAsSme() throws Exception {

		when(iAdminService.addAsSme((RequestDetails) any(RequestDetails.class))).thenReturn(new ResponseMsg());
		this.mockMvc
				.perform(post("/ask/addEmpAsSme?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"fullName\":\"priya puli\",\"ctrgyList\":[\"java\"]}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"successfully added 'priya puli' as SME\"}")).andReturn();

	}*/

/*	@Test
	public void removeDupliAsSme() throws Exception {

		when(iAdminService.addAsSme((RequestDetails) any(RequestDetails.class))).thenReturn(new ResponseMsg());
		this.mockMvc
				.perform(post("/ask/addEmpAsSme?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"fullName\":\"mohansai krishnaKanchi\",\"ctrgyList\":[\"java\"]}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"'mohansai krishnaKanchi' is alredy SME for selected categories\"}"))
				.andReturn();

	}*/

	@Test
	public void testAddEmpAsSmeError() throws Exception {

		when(iAdminService.addAsSme((RequestDetails) any(RequestDetails.class))).thenReturn(new ResponseMsg());
		this.mockMvc
				.perform(post("/ask/addEmpAsSme?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"empId\":,\"ctrgyList\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();

	}
	
	@Test
	public void testGetNames() throws Exception {

		ResultActions actions = this.mockMvc.perform(get("/ask/getNames"));
		actions.andDo(MockMvcResultHandlers.print());
		actions.andExpect(content().contentType("application/json;charset=UTF-8"));
		actions.andExpect(status().isOk());

	}

}
