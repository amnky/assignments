package com.techlabs.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.techlabs.exception.DuplicateProductException;
import com.techlabs.exception.DuplicateSupplierException;
import com.techlabs.exception.InsufficientStockException;
import com.techlabs.exception.ProductNotFoundException;
import com.techlabs.exception.SupplierNotFoundException;

public class Inventory {

	 private Map<String, Product> products = new HashMap<>();
	    private Map<String, Supplier> suppliers = new HashMap<>();
	    private List<Transaction> transactions = new ArrayList<>();

	    public void addProduct(Product product) throws DuplicateProductException {
	        if (products.containsKey(product.getProductId())) {
	            throw new DuplicateProductException("Product already exists with ID: " + product.getProductId());
	        }
	        products.put(product.getProductId(), product);
	    }

	    public void updateProduct(String productId, Product updatedProduct) throws ProductNotFoundException {
	        if (!products.containsKey(productId)) {
	            throw new ProductNotFoundException("No product found with ID: " + productId);
	        }
	        products.put(productId, updatedProduct);
	    }

	    public void deleteProduct(String productId) throws ProductNotFoundException {
	        if (!products.containsKey(productId)) {
	            throw new ProductNotFoundException("No product found with ID: " + productId);
	        }
	        products.remove(productId);
	    }

	    public Product viewProduct(String productId) throws ProductNotFoundException {
	        Product product = products.get(productId);
	        if (product == null) {
	            throw new ProductNotFoundException("No product found with ID: " + productId);
	        }
	        return product;
	    }

	    public Collection<Product> viewAllProducts() {
	        return products.values();
	    }

	    public void addSupplier(Supplier supplier) throws DuplicateSupplierException {
	        if (suppliers.containsKey(supplier.getSupplierId())) {
	            throw new DuplicateSupplierException("Supplier already exists with ID: " + supplier.getSupplierId());
	        }
	        suppliers.put(supplier.getSupplierId(), supplier);
	    }

	    public void updateSupplier(String supplierId, Supplier updatedSupplier) throws SupplierNotFoundException {
	        if (!suppliers.containsKey(supplierId)) {
	            throw new SupplierNotFoundException("No supplier found with ID: " + supplierId);
	        }
	        suppliers.put(supplierId, updatedSupplier);
	    }

	    public void deleteSupplier(String supplierId) throws SupplierNotFoundException {
	        if (!suppliers.containsKey(supplierId)) {
	            throw new SupplierNotFoundException("No supplier found with ID: " + supplierId);
	        }
	        suppliers.remove(supplierId);
	    }

	    public Supplier viewSupplier(String supplierId) throws SupplierNotFoundException {
	        Supplier supplier = suppliers.get(supplierId);
	        if (supplier == null) {
	            throw new SupplierNotFoundException("No supplier found with ID: " + supplierId);
	        }
	        return supplier;
	    }

	    public Collection<Supplier> viewAllSuppliers() {
	        return suppliers.values();
	    }

	    public void addStock(String productId, int quantity) throws ProductNotFoundException {
	        Product product = products.get(productId);
	        if (product == null) {
	            throw new ProductNotFoundException("No product found with ID: " + productId);
	        }
	        product.setQuantity(product.getQuantity() + quantity);
	        transactions.add(new Transaction(UUID.randomUUID().toString(), productId, "add", quantity, new Date()));
	    }

	    public void removeStock(String productId, int quantity) throws ProductNotFoundException, InsufficientStockException {
	        Product product = products.get(productId);
	        if (product == null) {
	            throw new ProductNotFoundException("No product found with ID: " + productId);
	        }
	        if (product.getQuantity() < quantity) {
	            throw new InsufficientStockException("Insufficient stock for product ID: " + productId);
	        }
	        product.setQuantity(product.getQuantity() - quantity);
	        transactions.add(new Transaction(UUID.randomUUID().toString(), productId, "remove", quantity, new Date()));
	    }

	    public Collection<Transaction> viewTransactionHistory(String productId) throws ProductNotFoundException {
	        if (!products.containsKey(productId)) {
	            throw new ProductNotFoundException("No product found with ID: " + productId);
	        }
	        List<Transaction> productTransactions = new ArrayList<>();
	        for (Transaction transaction : transactions) {
	            if (transaction.getProductId().equals(productId)) {
	                productTransactions.add(transaction);
	            }
	        }
	        return productTransactions;
	    }

	    public void saveData() throws IOException {
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("inventory.txt"))) {
	            out.writeObject(products);
	            out.writeObject(suppliers);
	            out.writeObject(transactions);
	        }
	    }

	    @SuppressWarnings("unchecked")
	    public void loadData() throws IOException, ClassNotFoundException {
	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("inventory.txt"))) {
	            products = (Map<String, Product>) in.readObject();
	            suppliers = (Map<String, Supplier>) in.readObject();
	            transactions = (List<Transaction>) in.readObject();
	        }
	    }
	
}