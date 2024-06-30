package com.techlabs.model;

import com.techlabs.exceptions.DataPersistenceException;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class DataManager implements DataPersistance{
    private static final String product_PATH = "C:\\Users\\ACER\\Documents\\MonoJava\\Mini Project\\Inventory Management System\\src\\com\\techlabs\\files\\products.ser";
    private static final String supplier_PATH = "C:\\Users\\ACER\\Documents\\MonoJava\\Mini Project\\Inventory Management System\\src\\com\\techlabs\\files\\suppliers.ser";
    private static final String transaction_PATH = "C:\\Users\\ACER\\Documents\\MonoJava\\Mini Project\\Inventory Management System\\src\\com\\techlabs\\files\\transactions.ser";

    @Override
    public void saveProducts(List<Product> products){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(product_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
        }
        catch (IOException e) {
            throw new DataPersistenceException("Error saving products", e);
        }

    }

    @Override
    public List<Product> loadProducts() {
        try{
            FileInputStream fileInputStream = new FileInputStream(product_PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Product>) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new DataPersistenceException("Error loading products", e);
        }

    }

    @Override
    public void saveSuppliers(List<Supplier> suppliers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(supplier_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(suppliers);
        }
        catch (IOException e) {
            throw new DataPersistenceException("Error saving products", e);
        }
    }

    @Override
    public List<Supplier> loadSuppliers() {
        try{
            FileInputStream fileInputStream = new FileInputStream(supplier_PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Supplier>) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new DataPersistenceException("Error loading products", e);
        }
    }

    @Override
    public void saveTransactions(List<Transaction> transactions) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(transaction_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(transactions);
        }
        catch (IOException e) {
            throw new DataPersistenceException("Error saving products", e);
        }
    }

    @Override
    public List<Transaction> loadTransactions() {
        try{
            FileInputStream fileInputStream = new FileInputStream(transaction_PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Transaction>) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new DataPersistenceException("Error loading products", e);
        }
    }
}
