package com.techlabs.model;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class UIDGenerator implements IDGenerator{
    private static final AtomicInteger productCounter = new AtomicInteger(1);
    private static final AtomicInteger supplierCounter = new AtomicInteger(1);
    private static final AtomicInteger transactionCounter = new AtomicInteger(1);

    @Override
    public String generateProductId() {
        return String.format("P%04d", productCounter.getAndIncrement());
    }

    @Override
    public String generateSupplierId() {
        return String.format("S%04d", supplierCounter.getAndIncrement());
    }

    @Override
    public String generateTransactionId() {
        return String.format("T%04d", transactionCounter.getAndIncrement());
    }
}
