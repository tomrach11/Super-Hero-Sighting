package com.tr.vendingmachine.dao;

public class VendingMachineItemNotFoundException extends Exception {

    public VendingMachineItemNotFoundException(String message) {
        super(message);
    }

    public VendingMachineItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
