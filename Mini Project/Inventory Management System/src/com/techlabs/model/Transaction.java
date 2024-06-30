package com.techlabs.model;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private String productId;
    private String transactionType;
    private int productQuntity;
    private Date date;

    public Transaction(String transactionId, String productId, String transactionType, int productQuntity, Date date) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.transactionType = transactionType;
        this.productQuntity = productQuntity;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getProductQuntity() {
        return productQuntity;
    }

    public void setProductQuntity(int productQuntity) {
        this.productQuntity = productQuntity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", productId='" + productId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", productQuntity=" + productQuntity +
                ", date=" + date +
                '}';
    }
}
