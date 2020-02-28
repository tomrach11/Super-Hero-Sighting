package com.tr.vendingmachine.dao;

public class VendingMachineInValidInputException extends Exception{
    public VendingMachineInValidInputException(String message) {
        super(message);
    }

    public VendingMachineInValidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
