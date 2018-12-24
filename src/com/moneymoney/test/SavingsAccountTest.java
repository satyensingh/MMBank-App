package com.moneymoney.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.moneymoney.account.BankAccount;
import com.moneymoney.account.SavingsAccount;
import com.moneymoney.exception.InsufficientFundsException;
import com.moneymoney.exception.InvalidInputException;

public class SavingsAccountTest {

	private BankAccount bankAccount;

	@Before
	public void setup() {
		bankAccount = new SavingsAccount("Satyen", 10000, true);
	}

	@Test
	public void testGetCurrentBalanceJustAfterCreation() {
		double actual = bankAccount.getAccountBalance();
		Assert.assertEquals(10000, actual, 0.0);
	}

	@Test
	public void testDeposit() {
		bankAccount.deposit(1000);
		double actual = bankAccount.getAccountBalance();
		Assert.assertEquals(11000, actual, 0.0);
	}

	@Test
	public void testWithdraw() {
		bankAccount.withdraw(1000);
		double actual = bankAccount.getAccountBalance();
		Assert.assertEquals(9000, actual, 0.0);
	}

	@Test(expected = InvalidInputException.class)
	public void testWithdrawWithNegativeAmount() {
		bankAccount.withdraw(-1000);
	}

	@Test(expected = InvalidInputException.class)
	public void testWithdrawWithZeroAmount() {
		bankAccount.withdraw(0);
	}

	@Test(expected = InsufficientFundsException.class)
	public void testWithdrawForExceedingTheLimit() {
		bankAccount.withdraw(1000000);
	}

	@After
	public void tearDown() {
		bankAccount = null;
	}
}
