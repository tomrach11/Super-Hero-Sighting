package com.tr.vendingmachine.ui;

import com.tr.vendingmachine.dao.VendingMachineInValidInputException;
import com.tr.vendingmachine.dto.Change;
import com.tr.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

public class VendingMachineView {

    UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayItems(List<Item> inStockList) {
        io.println("\nAvailable Items:");
        Consumer<Item> printItems = (Item item) -> {
            io.println("\t" + item.getItemCode() + " :: " + item.getItemName() + " :: $" + item.getPrice());
        };
        inStockList.stream().forEach(printItems);
        io.println("\t Q :: Quit the program.");
    }

    public void displayBalance(BigDecimal balance) {
        io.println("\tCurrent Balance: $" + balance);
    }

    public BigDecimal insertMoney() throws VendingMachineInValidInputException {
        return io.readBigDecimal("\tPlease Insert Money: ");
    }

    public String getSelectItem() {
        return io.readString("\tPlease Enter Item Code: ");
    }

    public void displayVendSuccess() {
        io.println("Please take your Item and change.");
    }

    public void displayErrorMassage(String message) {
        io.println("\n" + message.toUpperCase() + "\n");
    }

    public void displaySelectItemBanner() {
        io.println("\nItem Selection Menu: ");
    }

    public void displayInsertMoneyBanner() {
        io.println("\nInsert Money Menu: ");
    }

    public void displayCancelMessage() {
        io.println("Order Cancel. Please take your change.");
    }

    public void displayDroppingItem() {
        io.println("\n===== DROPPING YOUR ITEM ======");
    }

    public void displayChange(Change change) {
        io.println("Change:");
        io.println("\tQuarter: " + change.getQuarterAmount() + " coins.");
        io.println("\tDime: " + change.getDimeAmount() + " coins.");
        io.println("\tNickel: " + change.getNickelAmount() + " coins.");
        io.println("\tPenny: " + change.getPennyAmount() + " coins.");
    }

    public void displayProgramClosing() {
        io.println("\nProgram is shutting down ...");
    }
}
