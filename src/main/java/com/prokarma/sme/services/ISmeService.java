package com.prokarma.sme.services;

import java.text.ParseException;

import com.prokarma.sme.model.ResponseOnUpdate;
import com.prokarma.sme.model.SmeCtrgyName;
import com.prokarma.sme.model.UpdatePostQuery;
import com.prokarma.sme.model.UpdateReplyQuery;

public interface ISmeService {
	public SmeCtrgyName getCtrgyName(int empId);

	public ResponseOnUpdate updatePost(UpdatePostQuery updatePostQuery) throws ParseException;

	public ResponseOnUpdate updateReply(UpdateReplyQuery updateReplyQuery) throws ParseException;

}
