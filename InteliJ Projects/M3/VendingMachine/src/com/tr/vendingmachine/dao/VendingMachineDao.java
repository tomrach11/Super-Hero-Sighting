package com.tr.vendingmachine.dao;

import com.tr.vendingmachine.dto.Item;

import java.util.List;

public interface VendingMachineDao {
    Item readItem (String itemCode) throws VendingMachinePersistenceException;

    List<Item> readAll () throws VendingMachinePersistenceException;

    Item updateItem (String itemCode, Item item) throws VendingMachinePersistenceException;

}
