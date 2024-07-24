package com.techlabs.model;

import com.techlabs.interfaces.TransactionOperations;

public class StockTransactionTask implements Runnable{

	private TransactionOperations transactionOperations;
    private String productId;
    private int quantity;
    private boolean addStock;

    public StockTransactionTask(TransactionOperations transactionOperations, String productId, int quantity, boolean addStock) {
        this.transactionOperations = transactionOperations;
        this.productId = productId;
        this.quantity = quantity;
        this.addStock = addStock;
    }

    @Override
    public void run() {
        try {
            if (addStock) {
                transactionOperations.addStock(productId, quantity);
                return;
            }
            transactionOperations.removeStock(productId, quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}