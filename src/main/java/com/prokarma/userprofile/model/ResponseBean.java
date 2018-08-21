package com.prokarma.userprofile.model;

import java.io.Serializable;

/**
 * @author prokarma
 *
 */
public class ResponseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String responseMessage;

	/**
	 * 
	 */
	public ResponseBean() {

	}

	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage
	 */
	public void setResponseMessage(final String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
