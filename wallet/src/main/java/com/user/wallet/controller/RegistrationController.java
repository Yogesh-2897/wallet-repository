package com.user.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.wallet.dto.CommonResponse;
import com.user.wallet.dto.UserDTO;
import com.user.wallet.exception.CustomException;
import com.user.wallet.service.RegistrationService;
import com.user.wallet.utility.ApplicationConstants;
import com.user.wallet.utility.EndpointsConstants;

@RestController
@RequestMapping(EndpointsConstants.REGISTRATION_MAPPING)
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@PostMapping(EndpointsConstants.USER_MAPPING)
	public ResponseEntity<CommonResponse> doRegistration(@RequestBody UserDTO user) throws Exception {
		String message = registrationService.doRegistration(user);
		if (message == null) {
			throw new CustomException(ApplicationConstants.REGISTRATION_ERROR,
					ApplicationConstants.REGISTRATION_ERROR_USER_EXISTS_ERROR_CODE,
					ApplicationConstants.REGISTRATION_ERROR, null);
		}
		CommonResponse response = new CommonResponse(ApplicationConstants.SUCCESS_CODE,message);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
