package com.techlabs.interfaces;

import java.util.Collection;

import com.techlabs.exception.DuplicateSupplierException;
import com.techlabs.exception.SupplierNotFoundException;
import com.techlabs.model.Supplier;

public interface SupplierOperations {

	void addSupplier(Supplier supplier) throws DuplicateSupplierException;
    void updateSupplier(String supplierId, Supplier updatedSupplier) throws SupplierNotFoundException;
    void deleteSupplier(String supplierId) throws SupplierNotFoundException;
    Supplier viewSupplier(String supplierId) throws SupplierNotFoundException;
    Collection<Supplier> viewAllSuppliers();
	
}