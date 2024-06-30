package com.techlabs.model;

import com.techlabs.exceptions.InvalidProductIdException;

import java.util.Date;
import java.util.List;

public class AddStock implements TransactionType{
    private ProductManager productManager;
    private List<Transaction> transactions;
    private UIDGenerator uidGenerator;

    public AddStock(ProductManager productManager, List<Transaction> transactions) {
        this.productManager = productManager;
        this.transactions = transactions;
        this.uidGenerator = new UIDGenerator();
    }

    @Override
    public void execute(String productId, int productQuantity) {
        Product product = productManager.getProduct(productId);
        if(product==null){
            throw new InvalidProductIdException("Product ID "+productId+" is invalid");
        }
        product.setProductQuantity(product.getProductQuantity()+productQuantity);
        transactions.add(new Transaction(uidGenerator.generateTransactionId(),productId,"add",productQuantity, new Date()));
    }
}
