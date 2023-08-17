package com.godknows.picpay.dtos;

public class ExceptionDTO {
	
	private String message;
	private String statusCode;
	
	public ExceptionDTO() {
	}

	public ExceptionDTO(String message, String statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}

	public String getMessageg() {
		return message;
	}

	public void setMessageg(String messageg) {
		this.message = messageg;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}
