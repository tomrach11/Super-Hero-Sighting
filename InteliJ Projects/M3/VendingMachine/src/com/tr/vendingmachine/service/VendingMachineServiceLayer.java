package com.tr.vendingmachine.service;

import com.tr.vendingmachine.dao.VendingMachineInsufficientFundException;
import com.tr.vendingmachine.dao.VendingMachineItemNotFoundException;
import com.tr.vendingmachine.dao.VendingMachineItemOutOfStockException;
import com.tr.vendingmachine.dao.VendingMachinePersistenceException;
import com.tr.vendingmachine.dto.Change;
import com.tr.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineServiceLayer {
    List<Item> getItems() throws VendingMachinePersistenceException;

    BigDecimal insertMoney(BigDecimal money);

    void selectItem(String itemCode) throws VendingMachineItemNotFoundException, VendingMachinePersistenceException, VendingMachineItemOutOfStockException, VendingMachineInsufficientFundException;

    Change vendItem() throws VendingMachineItemOutOfStockException, VendingMachineInsufficientFundException, VendingMachinePersistenceException;

    Change returnChange();
}
/// inventory.txt
//ID::Name::Cost::Qty
//        A1::Snickers::1.25::10
//        A2::Twix::1.25::1