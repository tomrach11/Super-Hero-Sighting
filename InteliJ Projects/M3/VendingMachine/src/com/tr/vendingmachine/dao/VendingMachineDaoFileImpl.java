package com.tr.vendingmachine.dao;

import com.tr.vendingmachine.dto.Change;
import com.tr.vendingmachine.dto.Item;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    private static final String ITEMS_FILE = "items.txt";
    private static final String DELIMITER = "::";

    Map<String, Item> items = new HashMap<>();
    Change change = new Change();

    @Override
    public Item readItem(String itemCode) throws VendingMachinePersistenceException {
        readFile();
        return items.get(itemCode.toUpperCase());
    }

    @Override
    public List<Item> readAll() throws VendingMachinePersistenceException {
        readFile();
        return new ArrayList<Item>(items.values()) ;
    }

    @Override
    public Item updateItem(String itemCode, Item item) throws VendingMachinePersistenceException {
        readFile();
        Item updatedItem = items.put(itemCode, item);
        writeFile();
        return updatedItem;
    }

    //read file
    public void readFile() throws VendingMachinePersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("-_Could not load Items data into memory.");
        }
        while (scanner.hasNextLine()) {
            String itemText = scanner.nextLine();
            Item item = unmarshallItem(itemText);
            items.put(item.getItemCode(), item);
        }
    }

    public Item unmarshallItem(String itemText) {
        String[] itemArray = itemText.split(DELIMITER);
        Item item = new Item();
        item.setItemCode(itemArray[0]);
        item.setItemName(itemArray[1]);
        BigDecimal price = new BigDecimal(itemArray[2]);
        item.setPrice(price);
        int stock = Integer.parseInt(itemArray[3]);
        item.setStock(stock);
        return item;
    }

    //write file
    public void writeFile() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("-_Could not save item data to file.");
        }

        String itemText;
        List<Item> itemList = this.readAll();
        for(Item item : itemList) {
            itemText = marshallItem(item);
            out.println(itemText);
            out.flush();
        }
        out.close();
    }

    public String marshallItem(Item item) {
        String itemText = item.getItemCode() + DELIMITER;
        itemText += item.getItemName() + DELIMITER;
        itemText += item.getPrice() + DELIMITER;
        itemText += item.getStock();
        return itemText;
    }
}







































