package com.prokarma.viewpost.service;

import java.text.ParseException;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.prokarma.viewpost.model.PostReplyModelSet;
import com.prokarma.viewpost.model.ReplyOnPost;
import com.prokarma.viewpost.model.ResponseModelOnRply;
import com.prokarma.viewpost.model.SearchInfoModel;

/**
 * @author prokarma
 *
 */
@Component
public interface IViewService {
	 /**
	 * @param searchModelInfo
	 * @return
	 */
	Set<PostReplyModelSet> getAllPostsAndReplies(SearchInfoModel searchModelInfo) ;
	 /**
	 * @param replyOnPost
	 * @return
	 * @throws ParseException
	 */
	ResponseModelOnRply replyToPost(ReplyOnPost replyOnPost) throws ParseException;
	
}
