package com.techlabs.interfaces;

import java.util.Collection;

import com.techlabs.exception.DuplicateProductException;
import com.techlabs.exception.ProductNotFoundException;
import com.techlabs.model.Product;

public interface ProductOperations {

	void addProduct(Product product) throws DuplicateProductException;
    void updateProduct(String productId, Product updatedProduct) throws ProductNotFoundException;
    void deleteProduct(String productId) throws ProductNotFoundException;
    Product viewProduct(String productId) throws ProductNotFoundException;
    Collection<Product> viewAllProducts();
	
}