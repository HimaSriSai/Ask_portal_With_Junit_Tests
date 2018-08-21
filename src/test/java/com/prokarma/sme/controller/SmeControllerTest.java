package com.prokarma.sme.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.sme.model.ResponseOnUpdate;
import com.prokarma.sme.model.SmeCtrgyName;
import com.prokarma.sme.model.UpdatePostQuery;
import com.prokarma.sme.model.UpdateReplyQuery;
import com.prokarma.sme.services.ISmeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class SmeControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	private ISmeService iSmeService;

	@Test
	public void testGetCtrgyName() throws Exception {

		when(iSmeService.getCtrgyName(anyInt())).thenReturn(new SmeCtrgyName());
		this.mockMvc
				.perform(post("/ask/getCtrgyName?").contentType(MediaType.APPLICATION_JSON).content("{\"empId\":4221}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void testGetCtrgyNameFail() throws Exception {

		when(iSmeService.getCtrgyName(anyInt())).thenReturn(new SmeCtrgyName());
		this.mockMvc
				.perform(post("/ask/getCtrgyName?").contentType(MediaType.APPLICATION_JSON).content("{\"empId\":250}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"empId\":0,\"ctrgyName\":[]}")).andReturn();

	}

	@Test
	public void testGetCtrgyNameError() throws Exception {

		when(iSmeService.getCtrgyName(anyInt())).thenReturn(new SmeCtrgyName());
		this.mockMvc.perform(post("/ask/getCtrgyName?").contentType(MediaType.APPLICATION_JSON).content("{\"empId\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();

	}

/*	@Test
	public void testUpdatePostStatus() throws Exception {

		when(iSmeService.updatePost((UpdatePostQuery) any(UpdatePostQuery.class))).thenReturn(new ResponseOnUpdate());
		this.mockMvc
				.perform(post("/ask/updatePostStatus?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"lastUpdatedByEmpId\":250,\"postId\":121}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"successfully deleted posted query\"}")).andReturn();

	}*/

	@Test
	public void testUpdtPstStusFail() throws Exception {

		when(iSmeService.updatePost((UpdatePostQuery) any(UpdatePostQuery.class))).thenReturn(new ResponseOnUpdate());
		this.mockMvc
				.perform(post("/ask/updatePostStatus?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"lastUpdatedByEmpId\":250,\"postId\":0}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string(
						"{\"responseMsg\":\"might be 'lastUpdatedByEmpId' or 'postId' informations are not correct\"}"))
				.andReturn();

	}

	@Test
	public void testUpdtPstStusError() throws Exception {

		when(iSmeService.updatePost((UpdatePostQuery) any(UpdatePostQuery.class))).thenReturn(new ResponseOnUpdate());
		this.mockMvc
				.perform(post("/ask/updatePostStatus?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"lastUpdatedByEmpId\":,\"postId\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();

	}

/*	@Test
	public void testUpdateReplyStatus() throws Exception {

		when(iSmeService.updateReply((UpdateReplyQuery) any(UpdateReplyQuery.class)))
				.thenReturn(new ResponseOnUpdate());
		this.mockMvc
				.perform(post("/ask/updateReplyStatus?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"lastUpdatedByEmpId\":4227,\"replyId\":26}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"successfully deleted reply query\"}")).andReturn();

	}*/

	@Test
	public void testUpdtRplyStsFail() throws Exception {

		when(iSmeService.updateReply((UpdateReplyQuery) any(UpdateReplyQuery.class)))
				.thenReturn(new ResponseOnUpdate());
		this.mockMvc
				.perform(post("/ask/updateReplyStatus?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"lastUpdatedByEmpId\":250,\"replyId\":0}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string(
						"{\"responseMsg\":\"might be 'lastUpdatedByEmpId' or 'replyId' information are not correct\"}"))
				.andReturn();

	}

	@Test
	public void testUpdtRplyStsError() throws Exception {

		when(iSmeService.updateReply((UpdateReplyQuery) any(UpdateReplyQuery.class)))
				.thenReturn(new ResponseOnUpdate());
		this.mockMvc
				.perform(post("/ask/updateReplyStatus?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"lastUpdatedByEmpId\":,\"replyId\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();

	}

}
