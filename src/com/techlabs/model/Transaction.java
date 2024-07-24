package com.techlabs.model;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{

	private String transactionId;
    private String productId;
    private String type;
    private int quantity;
    private Date date;

    public Transaction(String transactionId, String productId, String type, int quantity, Date date) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.type = type;
        this.quantity = quantity;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getProductId() {
        return productId;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDate() {
        return date;
    }
	
}