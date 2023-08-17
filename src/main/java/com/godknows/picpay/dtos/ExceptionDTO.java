package com.godknows.picpay.dtos;

public class ExceptionDTO {
	
	private String messageg;
	private String statusCode;
	
	public ExceptionDTO() {
	}

	public ExceptionDTO(String messageg, String statusCode) {
		this.messageg = messageg;
		this.statusCode = statusCode;
	}

	public String getMessageg() {
		return messageg;
	}

	public void setMessageg(String messageg) {
		this.messageg = messageg;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}
