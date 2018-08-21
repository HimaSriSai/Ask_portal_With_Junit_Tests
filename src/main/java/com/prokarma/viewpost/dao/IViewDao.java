package com.prokarma.viewpost.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prokarma.viewpost.model.PostReplyTotal;
import com.prokarma.viewpost.model.ReplyOnPost;
import com.prokarma.viewpost.model.SearchInfoModel;

/**
 * @author prokarma
 *
 */
@Component
public interface IViewDao {

	/**
	 * @param searchModelInfo
	 * @return
	 */
	List<PostReplyTotal> getPostdata(SearchInfoModel searchModelInfo);

	/**
	 * @param replyOnPost
	 * @return
	 * @throws ParseException
	 */
	String insertReply(ReplyOnPost replyOnPost) throws ParseException;

}
