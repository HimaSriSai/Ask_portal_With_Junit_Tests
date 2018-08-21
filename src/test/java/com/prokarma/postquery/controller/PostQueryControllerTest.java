package com.prokarma.postquery.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.postquery.model.PostQueryModel;
import com.prokarma.postquery.model.ResponseMsgModel;
import com.prokarma.postquery.service.IPostQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
@Transactional
public class PostQueryControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	private transient IPostQueryService postQueryService;

	@Test
	public void testAleardyOthers() throws Exception {
		when(postQueryService.postquestion((PostQueryModel) any(PostQueryModel.class)))
				.thenReturn(new ResponseMsgModel().getResponseMsg());
		this.mockMvc.perform(post("/ask/postquery?").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":4322,\"pstdqry\":\"we\",\"ctgryname\":\"\",\"other\":\"java\",\"ctgrycrtdby\":\"jhk\",\"lastuptdby\":576}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"The catergory 'java' already exist\"}")).andReturn();

	}

	@Test
	public void testPostQuery() throws Exception {
		when(postQueryService.postquestion((PostQueryModel) any(PostQueryModel.class)))
				.thenReturn(new ResponseMsgModel().getResponseMsg());
		this.mockMvc.perform(post("/ask/postquery?").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":4227,\"pstdqry\":\"fromTest\",\"ctgryname\":\"java\",\"other\":\"\",\"ctgrycrtdby\":\"\",\"lastuptdby\":4227}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"Query Successfully posted\"}")).andReturn();

	}

	@Test
	public void testSuccessOthers() throws Exception {
		when(postQueryService.postquestion((PostQueryModel) any(PostQueryModel.class)))
				.thenReturn(new ResponseMsgModel().getResponseMsg());
		this.mockMvc.perform(post("/ask/postquery?").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":4227,\"pstdqry\":\"fromTest\",\"ctgryname\":\"\",\"other\":\"fromTestCtrgy\",\"ctgrycrtdby\":\"emp\",\"lastuptdby\":4227}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"Query Successfully posted\"}")).andReturn();

	}

	@Test
	public void testPostError() throws Exception {
		when(postQueryService.postquestion((PostQueryModel) any(PostQueryModel.class)))
				.thenReturn(new ResponseMsgModel().getResponseMsg());
		this.mockMvc.perform(post("/ask/postquery?").contentType(MediaType.APPLICATION_JSON).content(
				"{\"empid\":,\"pstdqry\":\"\",\"ctgryname\":\"\",\"other\":\"\",\"ctgrycrtdby\":\"\",\"lastuptdby\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();
	}

	@Test
	public void testPostFail() throws Exception {
		when(postQueryService.postquestion((PostQueryModel) any(PostQueryModel.class)))
				.thenReturn(new ResponseMsgModel().getResponseMsg());
		this.mockMvc.perform(post("/ask/postquery?").contentType(MediaType.APPLICATION_JSON).content("{\"empid\":4322,\"pstdqry\":\"we\",\"ctgryname\":\"\",\"other\":\"\",\"lastuptdby\":\"576\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"responseMsg\":\"failure\"}")).andReturn();

	}

}
