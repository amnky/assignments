package com.techlabs.test;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

import com.techlabs.exception.DuplicateProductException;
import com.techlabs.exception.DuplicateSupplierException;
import com.techlabs.exception.InsufficientStockException;
import com.techlabs.exception.ProductNotFoundException;
import com.techlabs.exception.SupplierNotFoundException;
import com.techlabs.model.Inventory;
import com.techlabs.model.Product;
import com.techlabs.model.Supplier;
import com.techlabs.model.Transaction;

public class InventoryManagementSystemTest {

	private static Inventory inventory = new Inventory();
	
	public static void main(String[] args) {
		
		loadInitialData();
        displayMenu();

	}
	
	private static void loadInitialData() {
        try {
            inventory.loadData();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Inventory Management System");
            System.out.println("1. Product Management");
            System.out.println("2. Supplier Management");
            System.out.println("3. Transaction Management");
            System.out.println("4. Save Data");
            System.out.println("5. Load Data");
            System.out.println("6. Generate Reports");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    productManagementMenu(scanner);
                    break;
                case 2:
                    supplierManagementMenu(scanner);
                    break;
                case 3:
                    transactionManagementMenu(scanner);
                    break;
                case 4:
                    saveData();
                    break;
                case 5:
                    loadData();
                    break;
                case 6:
                    generateReport();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void productManagementMenu(Scanner scanner) {
        while (true) {
            System.out.println("Product Management Menu");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product Details");
            System.out.println("5. View All Products");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    viewProductDetails(scanner);
                    break;
                case 5:
                    viewAllProducts();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        Product product = new Product(productId, name, description, quantity, price);
        try {
            inventory.addProduct(product);
            System.out.println("Product added successfully.");
        } catch (DuplicateProductException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Enter Product ID to Update: ");
        String productId = scanner.nextLine();

        System.out.print("Enter New Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Product Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter New Product Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter New Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Product updatedProduct = new Product(productId, name, description, quantity, price);
        try {
            inventory.updateProduct(productId, updatedProduct);
            System.out.println("Product updated successfully.");
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Enter Product ID to Delete: ");
        String productId = scanner.nextLine();
        try {
            inventory.deleteProduct(productId);
            System.out.println("Product deleted successfully.");
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewProductDetails(Scanner scanner) {
        System.out.print("Enter Product ID to View: ");
        String productId = scanner.nextLine();
        try {
            Product product = inventory.viewProduct(productId);
            System.out.println("Product Details:");
            System.out.println("ID: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllProducts() {
        Collection<Product> products = inventory.viewAllProducts();
        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println("ID: " + product.getProductId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());
        }
    }

    private static void supplierManagementMenu(Scanner scanner) {
        while (true) {
            System.out.println("Supplier Management Menu");
            System.out.println("1. Add Supplier");
            System.out.println("2. Update Supplier");
            System.out.println("3. Delete Supplier");
            System.out.println("4. View Supplier Details");
            System.out.println("5. View All Suppliers");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addSupplier(scanner);
                    break;
                case 2:
                    updateSupplier(scanner);
                    break;
                case 3:
                    deleteSupplier(scanner);
                    break;
                case 4:
                    viewSupplierDetails(scanner);
                    break;
                case 5:
                    viewAllSuppliers();
                    break;
                case 6:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addSupplier(Scanner scanner) {
        System.out.print("Enter Supplier ID: ");
        String supplierId = scanner.nextLine();
        System.out.print("Enter Supplier Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Supplier Contact Info: ");
        String contactInfo = scanner.nextLine();

        Supplier supplier = new Supplier(supplierId, name, contactInfo);
        try {
            inventory.addSupplier(supplier);
            System.out.println("Supplier added successfully.");
        } catch (DuplicateSupplierException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateSupplier(Scanner scanner) {
        System.out.print("Enter Supplier ID to Update: ");
        String supplierId = scanner.nextLine();

        System.out.print("Enter New Supplier Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Supplier Contact Info: ");
        String contactInfo = scanner.nextLine();

        Supplier updatedSupplier = new Supplier(supplierId, name, contactInfo);
        try {
            inventory.updateSupplier(supplierId, updatedSupplier);
            System.out.println("Supplier updated successfully.");
        } catch (SupplierNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteSupplier(Scanner scanner) {
        System.out.print("Enter Supplier ID to Delete: ");
        String supplierId = scanner.nextLine();
        try {
            inventory.deleteSupplier(supplierId);
            System.out.println("Supplier deleted successfully.");
        } catch (SupplierNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewSupplierDetails(Scanner scanner) {
        System.out.print("Enter Supplier ID to View: ");
        String supplierId = scanner.nextLine();
        try {
            Supplier supplier = inventory.viewSupplier(supplierId);
            System.out.println("Supplier Details:");
            System.out.println("ID: " + supplier.getSupplierId());
            System.out.println("Name: " + supplier.getName());
            System.out.println("Contact Info: " + supplier.getContactInfo());
        } catch (SupplierNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllSuppliers() {
        Collection<Supplier> suppliers = inventory.viewAllSuppliers();
        System.out.println("All Suppliers:");
        for (Supplier supplier : suppliers) {
            System.out.println("ID: " + supplier.getSupplierId() + ", Name: " + supplier.getName() + ", Contact Info: " + supplier.getContactInfo());
        }
    }

    private static void transactionManagementMenu(Scanner scanner) {
        while (true) {
            System.out.println("Transaction Management Menu");
            System.out.println("1. Add Stock");
            System.out.println("2. Remove Stock");
            System.out.println("3. View Transaction History");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStock(scanner);
                    break;
                case 2:
                    removeStock(scanner);
                    break;
                case 3:
                    viewTransactionHistory(scanner);
                    break;
                case 4:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addStock(Scanner scanner) {
        System.out.print("Enter Product ID to Add Stock: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Quantity to Add: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        try {
            inventory.addStock(productId, quantity);
            System.out.println("Stock added successfully.");
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeStock(Scanner scanner) {
        System.out.print("Enter Product ID to Remove Stock: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Quantity to Remove: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        try {
            inventory.removeStock(productId, quantity);
            System.out.println("Stock removed successfully.");
        } catch (ProductNotFoundException | InsufficientStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewTransactionHistory(Scanner scanner) {
        System.out.print("Enter Product ID to View Transaction History: ");
        String productId = scanner.nextLine();
        try {
            Collection<Transaction> transactions = inventory.viewTransactionHistory(productId);
            System.out.println("Transaction History for Product ID: " + productId);
            for (Transaction transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getTransactionId() + ", Type: " + transaction.getType() + ", Quantity: " + transaction.getQuantity() + ", Date: " + transaction.getDate());
            }
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void saveData() {
        try {
            inventory.saveData();
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadData() {
        try {
            inventory.loadData();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private static void generateReport() {
        int totalProducts = inventory.viewAllProducts().size();
        double totalStockValue = inventory.viewAllProducts().stream()
            .mapToDouble(p -> p.getQuantity() * p.getPrice())
            .sum();
        System.out.println("Total Number of Products: " + totalProducts);
        System.out.println("Total Stock Value: " + totalStockValue);
    }

}