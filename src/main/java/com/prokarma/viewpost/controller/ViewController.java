package com.prokarma.viewpost.controller;

import java.text.ParseException;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.viewpost.model.PostReplyModelSet;
import com.prokarma.viewpost.model.ReplyOnPost;
import com.prokarma.viewpost.model.ResponseModelOnRply;
import com.prokarma.viewpost.model.SearchInfoModel;
import com.prokarma.viewpost.service.IViewService;

/**
 * @author prokarma
 *
 */
@RestController
@RequestMapping("/ask")
public class ViewController {
	/**
	 * to use service layer
	 */

	@Autowired
	private IViewService service;

	/**
	 * @param searchModelInfo
	 * @return
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Set<PostReplyModelSet>> getAll(@RequestBody final SearchInfoModel searchModelInfo) {
		final Set<PostReplyModelSet> responseModel = service.getAllPostsAndReplies(searchModelInfo);
		return  new ResponseEntity<>(responseModel,HttpStatus.OK);
	}

	/**
	 * @param replyOnPost
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/replyOnPost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModelOnRply replyOnPost(@RequestBody final ReplyOnPost replyOnPost) throws ParseException {
		return service.replyToPost(replyOnPost);

	}

}
