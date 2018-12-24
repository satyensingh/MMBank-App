package com.moneymoney.account;

import org.apache.log4j.Logger;

import com.moneymoney.exception.InsufficientFundsException;
import com.moneymoney.exception.InvalidInputException;

/**
 * @author Satyendra Singh
 * 
 * SavingsAccount is a type of BankAccount that allows salaried and non-salaried customers to own it.
 * 
 */
public class SavingsAccount extends BankAccount {
	private Logger logger = Logger.getLogger(SavingsAccount.class.getName()); 
	private boolean salary;
	
	/**
	 * 
	 * @param accountHolderName
	 * @param accountBalance
	 * @param salary
	 * 
	 * Allows user to create a new SavingsAccount with mentioned values.
	 */
	public SavingsAccount(String accountHolderName, double accountBalance, boolean salary) {
		super(accountHolderName, accountBalance);
		this.salary = salary;
	}

	public boolean isSalary() {
		return salary;
	}

	public void setSalary(boolean salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void withdraw(double amount) throws InvalidInputException, InsufficientFundsException {
		logger.debug("Inside Withdraw Method");
		if (amount > 0  &&  amount <= super.getAccountBalance()) {
			logger.info("Amount was correctly entered");
			super.deposit(-amount);
			logger.info("Account deucted with "+amount+" INR Successfully");
		} else if (amount<=0){
			logger.error("Amount was Invalid or Zero");
			throw new InvalidInputException("Invalid Amount!");
		}else {
			logger.error("Amount Exceeded - Insufficient Balance");
			throw new InsufficientFundsException("Insuffcient Balance in Account!");
		}
	}

	
}















