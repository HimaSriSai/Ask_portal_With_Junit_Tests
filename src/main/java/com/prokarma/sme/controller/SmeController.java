package com.prokarma.sme.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prokarma.sme.model.ResponseOnUpdate;
import com.prokarma.sme.model.SmeCtrgyName;
import com.prokarma.sme.model.UpdatePostQuery;
import com.prokarma.sme.model.UpdateReplyQuery;
import com.prokarma.sme.services.ISmeService;

@RestController
@RequestMapping("/ask")
public class SmeController {

	@Autowired
	private ISmeService iSmeService;

	@RequestMapping(value = "/getCtrgyName", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SmeCtrgyName replyOnPost(@RequestBody final SmeCtrgyName smeCtrgyName) {
	return iSmeService.getCtrgyName(smeCtrgyName.getEmpId());
		
	}

	@RequestMapping(value = "/updatePostStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseOnUpdate updatePostStatus(@RequestBody final UpdatePostQuery updatePostQuery) throws ParseException {
	  return iSmeService.updatePost(updatePostQuery);
		 
	}
	
	@RequestMapping(value = "/updateReplyStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseOnUpdate updateReplyStatus(@RequestBody final UpdateReplyQuery updateReplyQuery) throws ParseException {
	  return iSmeService.updateReply(updateReplyQuery);
		
	}
}
