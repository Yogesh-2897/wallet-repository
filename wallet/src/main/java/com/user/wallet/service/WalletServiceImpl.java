package com.user.wallet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.wallet.dto.TransactionDTO;
import com.user.wallet.entity.ErrorModel;
import com.user.wallet.entity.Transaction;
import com.user.wallet.entity.User;
import com.user.wallet.exception.CustomException;
import com.user.wallet.repository.TransactionRepository;
import com.user.wallet.repository.UserRepository;
import com.user.wallet.utility.ApplicationConstants;
import com.user.wallet.utility.TransactionMapper;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Double fetchAvailableBalance(String username) throws CustomException {
		User user = userRepository.findUserByUserName(username);
		if (user == null) {
			List<ErrorModel> error = new ArrayList<>();
			error.add(new ErrorModel(ApplicationConstants.USER_NOT_AVAILABLE_ERROR_CODE,
					ApplicationConstants.USER_NOT_AVAILABLE));
			throw new CustomException(ApplicationConstants.USER_NOT_AVAILABLE,
					ApplicationConstants.USER_NOT_AVAILABLE_ERROR_CODE,
					ApplicationConstants.USER_NOT_AVAILABLE_DETAILED_MESSAGE, error);
		}

		return user.getBalance();
	}

	@Override
	public String makeTransaction(TransactionDTO transactionDTO) throws CustomException {
		User u = userRepository.findById(transactionDTO.getUserId())
				.orElseThrow(() -> new CustomException(ApplicationConstants.USER_NOT_AVAILABLE,
						ApplicationConstants.USER_NOT_AVAILABLE_ERROR_CODE,
						ApplicationConstants.USER_NOT_AVAILABLE_DETAILED_MESSAGE, null));
		String trans = transactionDTO.getTransactionType();
		Transaction t = TransactionMapper.convertDtoToTransaction(transactionDTO);
		t.setDateOfTransaction(new Date());
		switch (trans) {
		case "Withdraw":
			if (u.getBalance() <= t.getTransactionAmount()) {
				return ApplicationConstants.INSUFFICIENT_BALANCE;
			}
			u.setBalance(u.getBalance() - t.getTransactionAmount());
			transactionRepository.save(t);
			break;
		case "Credit":
			u.setBalance(u.getBalance() + t.getTransactionAmount());
			break;
		default:
			List<ErrorModel> error = new ArrayList<>();
			error.add(new ErrorModel(ApplicationConstants.INVALID_TRANSACTION,
					ApplicationConstants.INVALID_TRANSACTION_DETAILED_MESSAGE));
			throw new CustomException(ApplicationConstants.INVALID_TRANSACTION,
					ApplicationConstants.INVALID_TRANSACTION_ERROR_CODE,
					ApplicationConstants.INVALID_TRANSACTION_DETAILED_MESSAGE, error);
		}

		return ApplicationConstants.TRANSACTION_SUCCESSFULL_MESSAGE;
	}

	@Override
	public List<TransactionDTO> getTransactionList(String username) throws CustomException {
		User user = userRepository.findUserByUserName(username);
		if (user == null) {
			List<ErrorModel> error = new ArrayList<>();
			error.add(new ErrorModel(ApplicationConstants.USER_NOT_AVAILABLE_ERROR_CODE,
					ApplicationConstants.USER_NOT_AVAILABLE));
			throw new CustomException(ApplicationConstants.USER_NOT_AVAILABLE,
					ApplicationConstants.USER_NOT_AVAILABLE_ERROR_CODE,
					ApplicationConstants.USER_NOT_AVAILABLE_DETAILED_MESSAGE, error);
		}
		List<Transaction> transactions = transactionRepository.findTransactionByUserId(user.getUserId());
		List<TransactionDTO> transactionsDTO = new ArrayList<>();
		if (transactions != null && !transactions.isEmpty()) {
			transactionsDTO = transactions.stream()
					.map(transaction -> TransactionMapper.convertTransactionToDTO(transaction))
					.collect(Collectors.toList());
		}
		return transactionsDTO;
	}

}
