package com.user.wallet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.wallet.dto.BalanceResponse;
import com.user.wallet.dto.CommonResponse;
import com.user.wallet.dto.TransactionDTO;
import com.user.wallet.dto.TransactionListResponse;
import com.user.wallet.entity.ErrorModel;
import com.user.wallet.exception.CustomException;
import com.user.wallet.service.WalletService;
import com.user.wallet.utility.ApplicationConstants;
import com.user.wallet.utility.EndpointsConstants;

@RestController
@RequestMapping(EndpointsConstants.WALLET_MAPPING)
public class WalletController {

	@Autowired
	WalletService walletService;

	@GetMapping(EndpointsConstants.BALANCE_MAPPING)
	public ResponseEntity<BalanceResponse> getAvailableBalance(
			@RequestParam(name = EndpointsConstants.ATTRIBUTE_USERNAME, required = true) String username) throws CustomException {
		Double balance = walletService.fetchAvailableBalance(username);
		if (balance == null) {
			List<ErrorModel> error = new ArrayList<>();
			error.add(new ErrorModel(ApplicationConstants.BALANCE_NOT_AVAILABLE_ERROR_CODE,
					ApplicationConstants.BALANCE_NOT_AVAILABLE));
			throw new CustomException(ApplicationConstants.BALANCE_NOT_AVAILABLE,
					ApplicationConstants.BALANCE_NOT_AVAILABLE_ERROR_CODE,
					ApplicationConstants.BALANCE__NOT_AVAILABLE_DETAILED_MESSAGE, error);
		}
		BalanceResponse response = new BalanceResponse(balance);
		response.setCode(ApplicationConstants.SUCCESS_CODE);
		response.setMessage(ApplicationConstants.BALANCE_FETCHED_SUCCESS_MESSAGE);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(EndpointsConstants.TRANSACTION_MAPPING)
	public ResponseEntity<CommonResponse> makeTransaction(@RequestBody TransactionDTO transactionDTO)
			throws CustomException {
		String message = walletService.makeTransaction(transactionDTO);
		CommonResponse response = new CommonResponse(ApplicationConstants.SUCCESS_CODE, message);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping(EndpointsConstants.TRANSACTION_LIST_MAPPING)
	public ResponseEntity<TransactionListResponse> getTransactionList(
			@RequestParam(name = EndpointsConstants.ATTRIBUTE_USERNAME, required = true) String username) throws CustomException {
		List<TransactionDTO> transactions = walletService.getTransactionList(username);
		TransactionListResponse response = new TransactionListResponse();
		response.setCode(ApplicationConstants.SUCCESS_CODE);
		response.setMessage(ApplicationConstants.TRANSACTION_LIST_SUCCESS_MESSAGE);
		if(transactions.isEmpty()) {
			response.setMessage(ApplicationConstants.TRANSACTION_LIST_EMPTY_MESSAGE);
		}
		else {
			response.setTransactionList(transactions);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
