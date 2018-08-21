package com.prokarma.sme.services;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prokarma.sme.dao.ISmeDao;
import com.prokarma.sme.model.ResponseOnUpdate;
import com.prokarma.sme.model.SmeCtrgyName;
import com.prokarma.sme.model.UpdatePostQuery;
import com.prokarma.sme.model.UpdateReplyQuery;

@Component
public class SmeServiceImpl implements ISmeService {
	
	@Autowired
	private ISmeDao iSmeDao;
	
	public SmeCtrgyName getCtrgyName(int empId) {
		SmeCtrgyName responseCtrgyName =new SmeCtrgyName();
		responseCtrgyName.setCtrgyName(iSmeDao.ctrgyNameOnSme(empId));
		return responseCtrgyName;
	}
	
	public ResponseOnUpdate updatePost(UpdatePostQuery updatePostQuery) throws ParseException {
		ResponseOnUpdate responseOnUpdate=new ResponseOnUpdate();
		responseOnUpdate.setResponseMsg(iSmeDao.updatePostStatus(updatePostQuery));
		return  responseOnUpdate;
	}
	public ResponseOnUpdate updateReply(UpdateReplyQuery updateReplyQuery) throws ParseException {
		ResponseOnUpdate responseOnUpdate=new ResponseOnUpdate();
		responseOnUpdate.setResponseMsg(iSmeDao.updateReplyStatus(updateReplyQuery));
		return  responseOnUpdate;
	}

}
