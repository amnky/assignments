package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionManager implements TransactionManagement{
    private List<Transaction> transactions = new ArrayList<>();
    private ProductManager productManager;

    public TransactionManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    @Override
    public synchronized void executeTransaction(TransactionType transactionType, String productId, int productQuantity) {
        transactionType.execute(productId,productQuantity);
    }

    public synchronized void recordTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getTransactionHistory(String productId) {
        return transactions.stream().filter(transaction -> transaction.getProductId().equals(productId)).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
