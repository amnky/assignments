package com.techlabs.model;

import java.io.Serializable;

public class Product implements Serializable{

	 private String productId;
	    private String name;
	    private String description;
	    private int quantity;
	    private double price;

	    public Product(String productId, String name, String description, int quantity, double price) {
	        this.productId = productId;
	        this.name = name;
	        this.description = description;
	        this.quantity = quantity;
	        this.price = price;
	    }

	    public String getProductId() {
	        return productId;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public double getPrice() {
	        return price;
	    }
	
}