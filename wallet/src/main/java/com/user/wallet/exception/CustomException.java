package com.user.wallet.exception;

import java.util.List;

import com.user.wallet.entity.ErrorModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1364206776905333017L;
	private String httpError;
	private String httpErrorCode;
	private String detailedMessage;
	private List<ErrorModel> errors;

	public CustomException() {
		super();
	}
	public CustomException(String httpError, String httpErrorCode, String detailedMessage, List<ErrorModel> errors) {
		super(detailedMessage);
		this.httpError = httpError;
		this.httpErrorCode = httpErrorCode;
		this.detailedMessage = detailedMessage;
		this.errors = errors;
	}
}
