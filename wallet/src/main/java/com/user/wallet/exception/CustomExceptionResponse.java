package com.user.wallet.exception;

import java.util.List;

import com.user.wallet.entity.ErrorModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionResponse {
	private String httpError;
	private String httpErrorCode;
	private String detailedMessage;
	private List<ErrorModel> errors;
}
