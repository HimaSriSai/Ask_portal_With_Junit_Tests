package com.prokarma.admin.services;

import org.springframework.stereotype.Component;

import com.prokarma.admin.model.FullNamesList;
import com.prokarma.admin.model.RequestDetails;
import com.prokarma.admin.model.ResponseMsg;

/**
 * @author Prokarma
 *
 */
@Component
public interface IAdminService {

	 /**
	 * @param requestDetails
	 * @return
	 */
	ResponseMsg addAsSme(RequestDetails requestDetails);
	
	/**
	 * @return FullNamesList
	 */
	FullNamesList getFullNames();

}
