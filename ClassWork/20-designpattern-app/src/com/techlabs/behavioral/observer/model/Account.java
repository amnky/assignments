package com.techlabs.behavioral.observer.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private String accountName;
    private double accountBalance;
    private List<INotifier> notifiers;

    public Account(int accountNumber, String accountName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        notifiers = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void registerNotifier(INotifier notifier){
        //changes made
        if(!notifiers.contains(notifier)){
            notifiers.add(notifier);
        }
    }

    public void withdrawAmount(int amount){
        if(this.accountBalance>amount){
            this.accountBalance-=amount;

            for (INotifier notifier : notifiers){
                notifier.notifyUser(this,amount,"Withdrawal");
            }
        }
    }

    public void depositAmount(int amount){
            this.accountBalance+=amount;

            for (INotifier notifier : notifiers) {
                notifier.notifyUser(this,amount,"Deposition");
            }
    }

    @Override
    public String toString() {
        return "\n" +
                "Account Number=" + accountNumber +"\n"+
                "Account Name='" + accountName + '\n' +
                "Account Balance=" + accountBalance;
    }
}
