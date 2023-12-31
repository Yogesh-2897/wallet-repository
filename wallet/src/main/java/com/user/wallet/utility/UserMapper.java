package com.user.wallet.utility;

import com.user.wallet.dto.UserDTO;
import com.user.wallet.entity.User;

public class UserMapper {
	public static User convertuserDtoToEntity(UserDTO user) {
		if (user != null) {
			User u = new User();
			u.setDateOfReg(user.getDateOfReg());
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			u.setPassword(user.getPassword());
			u.setPhoneNumber(user.getPhoneNumber());
			u.setBalance(user.getBalance());
			u.setUserName(user.getUserName());
			return u;
		}
		return null;
	}
}
