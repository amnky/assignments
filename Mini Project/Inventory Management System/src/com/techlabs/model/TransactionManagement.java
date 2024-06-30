package com.techlabs.model;

import java.util.List;

public interface TransactionManagement {
    void executeTransaction(TransactionType transactionType, String productId, int productQuantity);
    List<Transaction> getTransactionHistory(String productId);
    List<Transaction> getAllTransactions();
}
