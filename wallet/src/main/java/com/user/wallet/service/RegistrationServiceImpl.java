package com.user.wallet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.wallet.dto.UserDTO;
import com.user.wallet.entity.ErrorModel;
import com.user.wallet.entity.User;
import com.user.wallet.exception.CustomException;
import com.user.wallet.repository.UserRepository;
import com.user.wallet.utility.ApplicationConstants;
import com.user.wallet.utility.UserMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	UserRepository userRepository;

	@Override
	public String doRegistration(UserDTO user) throws CustomException {
		User temp = userRepository.findUserByUserName(user.getUserName());
		if (temp != null) {
			List<ErrorModel> error = new ArrayList<>();
			error.add(new ErrorModel(ApplicationConstants.REGISTRATION_ERROR_USER_EXISTS_ERROR_CODE,
					ApplicationConstants.REGISTRATION_ERROR_USER_EXISTS));
			throw new CustomException(ApplicationConstants.REGISTRATION_ERROR_USER_EXISTS,
					ApplicationConstants.REGISTRATION_ERROR_USER_EXISTS_ERROR_CODE,
					ApplicationConstants.REGISTRATION_ERROR_USER_EXISTS_DETAILED_MESSAGE, error);
		}
		temp = UserMapper.convertuserDtoToEntity(user);
		temp.setDateOfReg(new Date());
		if (temp != null) {
			User created = userRepository.save(temp);
			if (created != null) {
				return ApplicationConstants.REGISTRATION_USER_CREATION_SUCCESS;
			}
		}
		return null;
	}

}
