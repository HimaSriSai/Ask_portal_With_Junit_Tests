package com.prokarma.sme.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prokarma.sme.model.UpdatePostQuery;
import com.prokarma.sme.model.UpdateReplyQuery;

@Component
public interface ISmeDao {
	public List<String> ctrgyNameOnSme(int empId);

	public String updatePostStatus(UpdatePostQuery updatePostQuery) throws ParseException;

	public String updateReplyStatus(UpdateReplyQuery updateReplyQuery) throws ParseException;

}
