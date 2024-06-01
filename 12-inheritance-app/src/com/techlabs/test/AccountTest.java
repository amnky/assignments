package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.CurrentAccount;
import com.techlabs.model.SavingsAccount;

public class AccountTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		long accountNumber;
		String accountHolderName;
		double accountBalance;
		double amount;

		// Test CurrentAccount
		System.out.println("Current Account Details");
		System.out.println();
		CurrentAccount currentAccount1 = new CurrentAccount();
		System.out.println("Enter account number for Current Account");
		accountNumber = scanner.nextLong();
		currentAccount1.setAccountNumber(accountNumber);

		System.out.println("Enter account holder name for Current Account");
		accountHolderName = scanner.next();
		currentAccount1.setAccountHolderName(accountHolderName);

		System.out.println("Enter account balance for Current Account");
		accountBalance = scanner.nextInt();
		currentAccount1.setAccountBalance(accountBalance);

		System.out.println("Enter amount to be withdrawn from Current Account");
		amount = scanner.nextInt();
		currentAccount1.debit(amount);

		System.out.println("Remaining balance: " + currentAccount1.getAccountBalance());
		System.out.println("\n");

		// Test SavingsAccount
		System.out.println("Savings Account Details");
		System.out.println();
		SavingsAccount savingsAccount1 = new SavingsAccount();
		System.out.println("Enter account number for Savings Account");
		accountNumber = scanner.nextLong();
		savingsAccount1.setAccountNumber(accountNumber);

		System.out.println("Enter account holder name for Savings Account");
		accountHolderName = scanner.next();
		savingsAccount1.setAccountHolderName(accountHolderName);

		System.out.println("Enter account balance for Savings Account");
		accountBalance = scanner.nextInt();
		savingsAccount1.setAccountBalance(accountBalance);

		System.out.println("Enter amount to be withdrawn from Savings Account");
		amount = scanner.nextInt();
		savingsAccount1.debit(amount);

		System.out.println("Remaining balance: " + savingsAccount1.getAccountBalance());

		scanner.close();
	}
}
