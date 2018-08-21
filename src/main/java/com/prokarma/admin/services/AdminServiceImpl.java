package com.prokarma.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prokarma.admin.dao.IAdminDAO;
import com.prokarma.admin.model.FullNamesList;
import com.prokarma.admin.model.RequestDetails;
import com.prokarma.admin.model.ResponseMsg;

/**
 * @author Prokarma
 *
 */
@Component
public class AdminServiceImpl implements IAdminService {

	/**
	 * 
	 */
	@Autowired
	private IAdminDAO iAdminDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prokarma.admin.services.IAdminService#addAsSme(com.prokarma.admin.model.
	 * RequestDetails)
	 */
	@Override
	final public ResponseMsg addAsSme(RequestDetails requestDetails) {
		ResponseMsg responseMsg = new ResponseMsg();
		String fullName = requestDetails.getFullName();
		String firstName = fullName.substring(0, fullName.indexOf(" ")).trim();
		String lastName = fullName.substring(fullName.indexOf(" ")).trim();
		try {
			requestDetails.setEmpId(iAdminDAO.getEmpIdUsingName(firstName, lastName));
			int roleId = iAdminDAO.getSmeRoleId();
			List<Integer> ctrgyId = iAdminDAO.listOfCtrgyId(requestDetails.getCtrgyList());
			List<Integer> finalCtrgyId = iAdminDAO.removeDuplicateSME(ctrgyId, requestDetails.getEmpId());
			if (finalCtrgyId.isEmpty()) {
				responseMsg
						.setResponseMsg("'" + requestDetails.getFullName() + "' is alredy SME for selected categories");
			} else {
				iAdminDAO.addEmpAsSme(requestDetails.getEmpId(), roleId, finalCtrgyId);
				responseMsg.setResponseMsg("successfully added '" + requestDetails.getFullName() + "' as SME");
			}
		} catch (Exception e) {
			responseMsg.setResponseMsg("'" + requestDetails.getFullName() + "' is not a vaild name");
		}
		return responseMsg;
	}

	public FullNamesList getFullNames() {
		FullNamesList fullNamesList = new FullNamesList();
		fullNamesList.setFullNames(iAdminDAO.getNamesFormUserTbl());
		return fullNamesList;
	}
}
