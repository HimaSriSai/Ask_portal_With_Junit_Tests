package com.prokarma.viewpost.model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.prokarma.common.config.ConfigurationClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = ConfigurationClass.class)
@WebAppConfiguration
public class TestViewModel {

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testPostQueryInfo() {
		PostQueryInfo postQueryInfo1 = new PostQueryInfo();
		postQueryInfo1.setCrtdByName("priya");
		postQueryInfo1.setPostId(45);

		PostQueryInfo postQueryInfo2 = new PostQueryInfo();
		postQueryInfo2.setCrtdByName("priya");
		postQueryInfo2.setPostId(45);

		PostQueryInfo postQueryInfo3 = new PostQueryInfo();
		postQueryInfo3.setCrtdByName("diff");
		postQueryInfo3.setPostId(467);

		assertTrue(postQueryInfo1.equals(postQueryInfo2));
		assertFalse(postQueryInfo1.equals(null));
		assertFalse(postQueryInfo1.equals(postQueryInfo3));
		Integer test = new Integer(5);
		assertFalse(postQueryInfo1.equals(test.getClass()));	
		assertTrue(postQueryInfo1.equals(postQueryInfo1));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testPostReplyModelSet() {
		PostReplyModelSet postReplyModelSet1 = new PostReplyModelSet();
		PostQueryInfo postQueryInfo1 = new PostQueryInfo();
		postQueryInfo1.setCrtdByName("priya");
		postQueryInfo1.setPostId(45);
		postReplyModelSet1.setPostQueryObj(postQueryInfo1);

		PostReplyModelSet postReplyModelSet2 = new PostReplyModelSet();
		PostQueryInfo postQueryInfo2 = new PostQueryInfo();
		postQueryInfo2.setCrtdByName("priya");
		postQueryInfo2.setPostId(45);
		postReplyModelSet2.setPostQueryObj(postQueryInfo2);

		PostReplyModelSet postReplyModelSet3 = new PostReplyModelSet();
		PostQueryInfo postQueryInfo3 = new PostQueryInfo();
		postQueryInfo3.setCrtdByName("diff");
		postQueryInfo3.setPostId(467);
		postReplyModelSet3.setPostQueryObj(postQueryInfo3);

		assertTrue(postReplyModelSet1.equals(postReplyModelSet2));
		assertFalse(postReplyModelSet1.equals(null));
		assertFalse(postReplyModelSet1.equals(postReplyModelSet3));

		PostReplyModelSet postReplyModelSet4 = null;
		assertFalse(postReplyModelSet1.equals(postReplyModelSet4));
		
		Integer test = new Integer(5);
		assertFalse(postReplyModelSet1.equals(test.getClass()));		
		assertTrue(postReplyModelSet1.equals(postReplyModelSet1));
		
		PostQueryInfo postQueryInfoNull =null;
		PostReplyModelSet testPostModelNull = new PostReplyModelSet();
		testPostModelNull.setPostQueryObj(postQueryInfoNull);
		assertFalse(testPostModelNull.equals(postReplyModelSet1));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testPostReplyInfo() {
		ReplyQueriesInfo replyInfo1 = new ReplyQueriesInfo();
		replyInfo1.setRepliesMsgs("priya");
		replyInfo1.setReplyId(45);

		ReplyQueriesInfo replyInfo2 = new ReplyQueriesInfo();
		replyInfo2.setRepliesMsgs("priya");
		replyInfo2.setReplyId(45);

		ReplyQueriesInfo replyInfo3 = new ReplyQueriesInfo();
		replyInfo3.setRepliesMsgs("diff");
		replyInfo3.setReplyId(467);

		assertTrue(replyInfo1.equals(replyInfo2));
		assertFalse(replyInfo1.equals(null));
		assertFalse(replyInfo1.equals(replyInfo3));
		Integer test = new Integer(5);
		assertFalse(replyInfo1.equals(test.getClass()));
		assertTrue(replyInfo1.equals(replyInfo1));

	}

}
