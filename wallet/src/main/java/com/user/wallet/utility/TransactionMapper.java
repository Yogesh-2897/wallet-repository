package com.user.wallet.utility;

import com.user.wallet.dto.TransactionDTO;
import com.user.wallet.entity.Transaction;

public class TransactionMapper {

	public static Transaction convertDtoToTransaction(TransactionDTO transactionDTO) {
		if(transactionDTO !=null) {
			Transaction t = new Transaction();
			t.setDateOfTransaction(transactionDTO.getDateOfTransaction());
			t.setTransactionType(transactionDTO.getTransactionType());
			t.setTransactionAmount(transactionDTO.getTransactionAmount());
			t.setTransactionName(transactionDTO.getTransactionName());
			t.setUserId(transactionDTO.getUserId());
			return t;
		}
		return null;
	}
	public static TransactionDTO convertTransactionToDTO(Transaction transaction) {
		if(transaction !=null) {
			TransactionDTO t = new TransactionDTO();
			t.setTrasactionId(transaction.getTransactionId());
			t.setDateOfTransaction(transaction.getDateOfTransaction());
			t.setTransactionType(transaction.getTransactionType());
			t.setTransactionAmount(transaction.getTransactionAmount());
			t.setTransactionName(transaction.getTransactionName());
			t.setUserId(transaction.getUserId());
			return t;
		}
		return null;
	}
}
