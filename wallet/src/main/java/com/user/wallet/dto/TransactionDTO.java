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
public class TransactionDTO {
	private Integer trasactionId;	
	private Integer userId;
	private String transactionName;
	private String transactionType;
	private Double transactionAmount;
	private Date dateOfTransaction;
}
