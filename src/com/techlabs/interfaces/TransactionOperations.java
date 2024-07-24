package com.techlabs.interfaces;

import java.util.List;

import com.techlabs.exception.InsufficientStockException;
import com.techlabs.exception.ProductNotFoundException;
import com.techlabs.model.Transaction;

public interface TransactionOperations {

	void addStock(String productId, int quantity) throws ProductNotFoundException;
    void removeStock(String productId, int quantity) throws ProductNotFoundException, InsufficientStockException;
    List<Transaction> viewTransactionHistory(String productId);
	
}