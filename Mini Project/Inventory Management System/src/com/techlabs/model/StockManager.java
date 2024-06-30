package com.techlabs.model;

public class StockManager implements Runnable {
    private TransactionManager transactionManager;
    private TransactionType transactionType;
    private String productId;
    private int productQuantity;

    public StockManager(TransactionManager transactionManager, TransactionType transactionType, String productId, int productQuantity) {
        this.transactionManager = transactionManager;
        this.transactionType = transactionType;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    @Override
    public void run() {
        try {
            transactionManager.executeTransaction(transactionType,productId,productQuantity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
