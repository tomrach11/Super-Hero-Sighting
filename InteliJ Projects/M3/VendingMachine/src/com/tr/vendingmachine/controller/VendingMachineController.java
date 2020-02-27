package com.tr.vendingmachine.controller;

import com.tr.vendingmachine.dao.*;
import com.tr.vendingmachine.dto.Change;
import com.tr.vendingmachine.dto.Item;
import com.tr.vendingmachine.service.VendingMachineServiceLayer;
import com.tr.vendingmachine.ui.VendingMachineView;

import java.math.BigDecimal;
import java.util.List;

public class VendingMachineController {

    VendingMachineView view;
    VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        try {
            displayItems();
            boolean keepGoing = true;
            while(keepGoing) {
                insertMoney();
                boolean toVend = selectItem();
                if(toVend) {
                    keepGoing = vendItem();
                }
                else {
                    keepGoing = false;
                }
            }
            shutDown();
        } catch (VendingMachinePersistenceException e) {
            new VendingMachinePersistenceException(e.getMessage());
        }
    }

    private void displayItems() throws VendingMachinePersistenceException {
        List<Item> inStockList = service.getItems();
        view.displayItems(inStockList);
    }

    private void insertMoney() {
        view.displayInsertMoneyBanner();
        BigDecimal money = new BigDecimal("0.00");
        view.displayBalance(service.insertMoney(money));
        money = view.insertMoney();
        service.insertMoney(money);
    }

    private boolean selectItem() throws VendingMachinePersistenceException {
        view.displaySelectItemBanner();
        boolean toVend = true;
        boolean hasError = true;
        while (hasError) {
            try {
                String selectedItem = view.getSelectItem();
                if(selectedItem.equalsIgnoreCase("Q")){
                    returnChange();
                    toVend = false;
                }
                else {
                    service.selectItem(selectedItem);
                }
                hasError = false;
            } catch (VendingMachineItemNotFoundException | VendingMachineItemOutOfStockException | VendingMachineInsufficientFundException e) {
                view.displayErrorMassage(e.getMessage());
                hasError = true;
            }
        }
        return toVend;
    }

    private boolean vendItem() throws VendingMachinePersistenceException{
        try {
            Change change = service.vendItem();
            view.displayDroppingItem();
            view.displayChange(change);
            view.displayVendSuccess();
            return false;
        } catch(VendingMachineItemOutOfStockException | VendingMachineInsufficientFundException e) {
            view.displayErrorMassage(e.getMessage());
            return true;
        }
    }

    private void returnChange() {
        Change change = service.returnChange();
        view.displayChange(change);
        view.displayCancelMessage();
    }

    private void shutDown() {
        view.displayProgramClosing();
    }

}
