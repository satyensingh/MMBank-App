package com.moneymoney.account;

import org.apache.log4j.Logger;

import com.moneymoney.exception.InsufficientFundsException;
import com.moneymoney.exception.InvalidInputException;

/**
 * 
 * @author Satyendra Singh
 *
 *BankAccount class is an abstract super class of all types of BankAccount that can exist and customers can own
 *It has commonly user properties and behaviours like accountNumber, accountHolderName and accountBalance
 *and withdraw and deposit respectively.
 */
public abstract class BankAccount {
	private Logger logger = Logger.getLogger(SavingsAccount.class.getName()); 
	private final int accountNumber;
	private double accountBalance;
	private String accountHolderName;
	private static int accountId;
	
	static {
		accountId = 100;
	}
	
	{
		accountNumber = ++accountId;
	}
	
	/**
	 * 
	 * @param accountHolderName
	 * @param accountBalance
	 * 
	 * Used to initilaize the common instance members.
	 */
	public BankAccount(String accountHolderName, double accountBalance) {
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public BankAccount(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", accountHolderName=" + accountHolderName + "]";
	}

	/**
	 * 
	 * @param amount
	 * Deposit methods takes amount in double and changes the current balance by adding the amount in it.
	 */
	public void deposit(double amount) {
		accountBalance += amount;
		logger.info("Amount Deposited");
	}

	public abstract void withdraw(double amount) throws InsufficientFundsException, InvalidInputException;
	
}



















