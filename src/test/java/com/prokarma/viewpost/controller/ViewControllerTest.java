package com.prokarma.viewpost.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.prokarma.common.config.ConfigurationClass;
import com.prokarma.viewpost.model.PostReplyModelSet;
import com.prokarma.viewpost.model.ReplyOnPost;
import com.prokarma.viewpost.model.ResponseModelOnRply;
import com.prokarma.viewpost.model.SearchInfoModel;
import com.prokarma.viewpost.service.IViewService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class ViewControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	private IViewService service;

	@Test
	public void testGetAllFail() throws Exception {
		Set<PostReplyModelSet> postReplyModelSet = new HashSet<>();

		when(service.getAllPostsAndReplies((SearchInfoModel) any(SearchInfoModel.class))).thenReturn(postReplyModelSet);
		this.mockMvc
				.perform(post("/ask/getAll?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"empid\":8788,\"category\":\"\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andExpect(content().string("[]"))
				.andReturn();

	}

	@Test
	public void testGetAll() throws Exception {
		Set<PostReplyModelSet> postReplyModelSet = new HashSet<>();

		when(service.getAllPostsAndReplies((SearchInfoModel) any(SearchInfoModel.class))).thenReturn(postReplyModelSet);
		this.mockMvc
				.perform(post("/ask/getAll?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"empid\":4221,\"category\":\"\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void testGetAllCtrgy() throws Exception {
		Set<PostReplyModelSet> postReplyModelSet = new HashSet<>();

		when(service.getAllPostsAndReplies((SearchInfoModel) any(SearchInfoModel.class))).thenReturn(postReplyModelSet);
		this.mockMvc
				.perform(post("/ask/getAll?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"empid\":0,\"category\":\"UI\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

	}

	@Test
	public void testGetAllCtrgyFail() throws Exception {
		Set<PostReplyModelSet> postReplyModelSet = new HashSet<>();

		when(service.getAllPostsAndReplies((SearchInfoModel) any(SearchInfoModel.class))).thenReturn(postReplyModelSet);
		this.mockMvc
				.perform(post("/ask/getAll?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"empid\":0,\"category\":\"no\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andExpect(content().string("[]"))
				.andReturn();

	}

	@Test
	public void testGetAllCtrgyError() throws Exception {
		Set<PostReplyModelSet> postReplyModelSet = new HashSet<>();

		when(service.getAllPostsAndReplies((SearchInfoModel) any(SearchInfoModel.class))).thenReturn(postReplyModelSet);
		this.mockMvc
				.perform(post("/ask/getAll?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"empid\":,\"category\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();

	}

	@Test
	public void testGetAllWhole() throws Exception {
		Set<PostReplyModelSet> postReplyModelSet = new HashSet<>();

		when(service.getAllPostsAndReplies((SearchInfoModel) any(SearchInfoModel.class))).thenReturn(postReplyModelSet);
		this.mockMvc
				.perform(post("/ask/getAll?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"empid\":0,\"category\":\"\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

	}

/*	@Test
	public void testReplyOnPost() throws Exception {
		ResponseModelOnRply responseModelOnRply = new ResponseModelOnRply();

		when(service.replyToPost((ReplyOnPost) any(ReplyOnPost.class))).thenReturn(responseModelOnRply);
		this.mockMvc
				.perform(post("/ask/replyOnPost?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"postId\":41,\"replyCreatedBy\":4227,\"replyMsg\":\"from postMan\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"replyStatus\":\"reply posted successfully\"}")).andReturn();

	}*/

	@Test
	public void testReplyOnPostFail() throws Exception {
		ResponseModelOnRply responseModelOnRply = new ResponseModelOnRply();

		when(service.replyToPost((ReplyOnPost) any(ReplyOnPost.class))).thenReturn(responseModelOnRply);
		this.mockMvc
				.perform(post("/ask/replyOnPost?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"postId\":45,\"replyCreatedBy\":4227,\"replyMsg\":\"from postMan\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(content().string("{\"replyStatus\":\"unable to post a reply\"}")).andReturn();

	}

	@Test
	public void testReplyOnPostError() throws Exception {
		ResponseModelOnRply responseModelOnRply = new ResponseModelOnRply();

		when(service.replyToPost((ReplyOnPost) any(ReplyOnPost.class))).thenReturn(responseModelOnRply);
		this.mockMvc
				.perform(post("/ask/replyOnPost?").contentType(MediaType.APPLICATION_JSON)
						.content("{\"postId\":,\"replyCreatedBy\":,\"replyMsg\":}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest()).andExpect(content().string(""))
				.andReturn();

	}
}
