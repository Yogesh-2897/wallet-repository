package com.user.wallet.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TRANSACTION")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TRANSACTION_ID")
	private Integer transactionId;	
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="TRANSACTION_NAME")
	private String transactionName;
	@Column(name="TRANSACTION_TYPE")
	private String transactionType;
	@Column(name="TRANSACTION_AMOUNT")
	private Double transactionAmount;
	@Column(name="DATE_OF_TRANSACTION")
	private Date dateOfTransaction;
}
