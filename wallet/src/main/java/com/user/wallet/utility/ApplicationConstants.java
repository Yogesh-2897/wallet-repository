package com.user.wallet.utility;

public class ApplicationConstants {
	public static final String REGISTRATION_ERROR_USER_EXISTS = "Username already Exists";
	public static final String REGISTRATION_ERROR_USER_EXISTS_ERROR_CODE = "1000";
	public static final String REGISTRATION_ERROR_USER_EXISTS_DETAILED_MESSAGE = "A user with this username is already registered";
	public static final String REGISTRATION_USER_CREATION_SUCCESS = "Registration Successfully";
	public static final String REGISTRATION_ERROR = "Error Occured during regirstration";
	
	public static final String SUCCESS_CODE = "200";
	public static final String FAILURE_CODE = "500";

	public static final String USER_NOT_AVAILABLE = "User not Available";
	public static final String USER_NOT_AVAILABLE_ERROR_CODE = "1001";
	public static final String USER_NOT_AVAILABLE_DETAILED_MESSAGE = "The username entered is invalid. No user found with this username";

	public static final String BALANCE_NOT_AVAILABLE = "Error occured while fetcing the balance";
	public static final String BALANCE_NOT_AVAILABLE_ERROR_CODE = "1002";
	public static final String BALANCE__NOT_AVAILABLE_DETAILED_MESSAGE = "Balance was not found in the database. Please check the username";
	public static final String BALANCE_FETCHED_SUCCESS_MESSAGE = "Balance fetched successfully";
	
	public static final String INSUFFICIENT_BALANCE = "Your account balance is insufficient for making this transaction";
	public static final String TRANSACTION_SUCCESSFULL_MESSAGE = "Transaction completed successfully";
	
	public static final String INVALID_TRANSACTION = "Invalid transaction type";
	public static final String INVALID_TRANSACTION_ERROR_CODE = "1003";
	public static final String INVALID_TRANSACTION_DETAILED_MESSAGE = "The transaction type received is invalid. Please enter a valid transaction type";

	public static final String TRANSACTION_LIST_SUCCESS_MESSAGE = "Transactions List fetched successfully";
	public static final String TRANSACTION_LIST_EMPTY_MESSAGE = "No transactions available for this user";

}
