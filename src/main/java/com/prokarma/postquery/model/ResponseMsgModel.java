package com.prokarma.postquery.model;

import java.io.Serializable;

/**
 * @author Prokarma
 *
 */
public class ResponseMsgModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8242367075200026438L;
	/**
	 * 
	 */
	private String responseMsg;

	
	/**
	 * 
	 */
	public ResponseMsgModel() {
		
	}
	/**
	 * @return responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	

	/**
	 * @param response
	 */
	public void setResponseMsg(final String response) {
		this.responseMsg = response;
	}

}
