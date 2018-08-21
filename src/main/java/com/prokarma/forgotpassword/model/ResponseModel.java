package com.prokarma.forgotpassword.model;

import java.io.Serializable;

/**
 * @author prokarma
 *
 */
public class ResponseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String responseMessage;

	/**
	 * @param responseMessage
	 */
	public ResponseModel() {

	}

	/**
	 * @return
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
