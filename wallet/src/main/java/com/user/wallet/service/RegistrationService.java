package com.user.wallet.service;

import com.user.wallet.dto.UserDTO;
import com.user.wallet.exception.CustomException;

public interface RegistrationService {
	public String doRegistration(UserDTO user) throws CustomException; 
}
