package com.tr.vendingmachine.service;

import com.tr.vendingmachine.dao.*;
import com.tr.vendingmachine.dto.Change;
import com.tr.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;

    BigDecimal balance = new BigDecimal("0.00");
    String selectItem;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Item> getItems() throws VendingMachinePersistenceException {
        List<Item> fullList = dao.readAll();
        Predicate<Item> inStock = (Item item) -> item.getStock() > 0;
        fullList.sort((Item item1, Item item2) -> item1.getItemCode().compareTo(item2.getItemCode()));
        List<Item> filteredList = fullList.stream().filter(inStock).collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public BigDecimal insertMoney(BigDecimal money) {
        balance = balance.add(money);
        return balance;
    }

    @Override
    public void selectItem(String itemCode) throws VendingMachineItemNotFoundException, VendingMachinePersistenceException {
        Item item = dao.readItem(itemCode.toUpperCase());
        if (item == null) {
            throw new VendingMachineItemNotFoundException("Error: Item Code " + itemCode + " dose not exist.");
        } else {
            selectItem = itemCode;
        }
    }

    @Override
    public Change vendItem() throws VendingMachineItemOutOfStockException, VendingMachineInsufficientFundException, VendingMachinePersistenceException {
        Item item = dao.readItem(selectItem);
        Change change = new Change();
        if (item.getStock() <= 0) {
            throw new VendingMachineItemOutOfStockException("Error: Item Code " + item.getItemCode() + " is out of stock.");
        }
        else if (item.getPrice().compareTo(balance) > 0) {
            throw new VendingMachineInsufficientFundException("Insufficient fund. Please insert more money.");
        }
        else {
            balance.subtract(item.getPrice());
            //do change
        }
        return change;
    }

    @Override
    public Change returnChange() {
        return null;
    }
}
