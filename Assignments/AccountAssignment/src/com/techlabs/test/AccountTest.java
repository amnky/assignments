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
		System.out.println("Enter account number for Current Account");
		accountNumber = scanner.nextLong();

		System.out.println("Enter account holder name for Current Account");
		accountHolderName = scanner.next();

		System.out.println("Enter account balance for Current Account");
		accountBalance = scanner.nextInt();

		CurrentAccount currentAccount1 = new CurrentAccount(accountNumber, accountHolderName, accountBalance);

		System.out.println("Enter amount to be withdrawn from Current Account");
		amount = scanner.nextInt();
		currentAccount1.debit(amount);

		System.out.println();
		System.out.println("Account number : " + currentAccount1.getAccountNumber());
		System.out.println("Account holder name : " + currentAccount1.getAccountHolderName());
		System.out.println("Account balance: " + currentAccount1.getAccountBalance());
		System.out.println("\n");

		// Test SavingsAccount
		System.out.println("Savings Account Details");
		System.out.println();

		System.out.println("Enter account number for Savings Account");
		accountNumber = scanner.nextLong();

		System.out.println("Enter account holder name for Savings Account");
		accountHolderName = scanner.next();

		System.out.println("Enter account balance for Savings Account");
		accountBalance = scanner.nextInt();

		SavingsAccount savingsAccount1 = new SavingsAccount(accountNumber, accountHolderName, accountBalance);

		System.out.println("Enter amount to be withdrawn from Savings Account");
		amount = scanner.nextInt();
		savingsAccount1.debit(amount);

		System.out.println();
		System.out.println("Account number : " + savingsAccount1.getAccountNumber());
		System.out.println("Account holder name : " + savingsAccount1.getAccountHolderName());
		System.out.println("Account balance: " + savingsAccount1.getAccountBalance());

		scanner.close();
	}
}
