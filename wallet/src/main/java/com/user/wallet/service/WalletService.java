package com.user.wallet.service;

import java.util.List;

import com.user.wallet.dto.TransactionDTO;
import com.user.wallet.exception.CustomException;

public interface WalletService {
	public Double fetchAvailableBalance(String username) throws CustomException;

	public String makeTransaction(TransactionDTO transactionDTO) throws CustomException;

	public List<TransactionDTO> getTransactionList(String username) throws CustomException;
}
