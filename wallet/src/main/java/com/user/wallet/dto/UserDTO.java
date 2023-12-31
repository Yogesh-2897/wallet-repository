package com.user.wallet.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private Double balance;
	private String userName;
	private String phoneNumber;
	private String password;
	private Date dateOfReg;
}
