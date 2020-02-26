package com.tr.vendingmachine.dao;

public class VendingMachineItemOutOfStockException extends Exception {

    public VendingMachineItemOutOfStockException(String message) {
        super(message);
    }

    public VendingMachineItemOutOfStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
