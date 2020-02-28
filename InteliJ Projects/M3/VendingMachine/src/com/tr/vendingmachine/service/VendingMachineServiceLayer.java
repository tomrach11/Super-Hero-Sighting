package com.tr.vendingmachine.service;

import com.tr.vendingmachine.dao.*;
import com.tr.vendingmachine.dto.Change;
import com.tr.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineServiceLayer {
    List<Item> getItems() throws VendingMachinePersistenceException;

    BigDecimal insertMoney(BigDecimal money) throws VendingMachineInValidInputException;

    void selectItem(String itemCode) throws VendingMachineItemNotFoundException, VendingMachinePersistenceException, VendingMachineItemOutOfStockException, VendingMachineInsufficientFundException;

    Change vendItem() throws VendingMachineItemOutOfStockException, VendingMachineInsufficientFundException, VendingMachinePersistenceException;

    Change returnChange();
}
