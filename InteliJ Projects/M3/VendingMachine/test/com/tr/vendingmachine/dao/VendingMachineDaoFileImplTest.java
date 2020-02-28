package com.tr.vendingmachine.dao;

import com.tr.vendingmachine.dto.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineDaoFileImplTest {

    private String TEST_FILE = "test.txt";
    VendingMachineDaoFileImpl dao = new VendingMachineDaoFileImpl(TEST_FILE);

    VendingMachineDaoFileImplTest() throws VendingMachinePersistenceException {
    }

    File file;

    @BeforeEach
    void setUp() throws VendingMachinePersistenceException {
        file = new File("test.txt");
        writeFile();

    }

    @AfterEach
    void tearDown() {
        file.delete();
    }

    @Test
    void readItem() throws VendingMachinePersistenceException {
        this.setUp();
        Item item = new Item();
        item.setItemCode("A1");
        item.setItemName("Item1");
        BigDecimal price = new BigDecimal("1.00");
        item.setPrice(price);
        item.setStock(1);

        Item fromDao = dao.readItem(item.getItemCode());

        assertEquals(item, fromDao);
        this.tearDown();
    }

    @Test
    void readAll() throws VendingMachinePersistenceException {
        this.setUp();
        List<Item> itemsDao = dao.readAll();
        assertEquals(3, itemsDao.size());
        this.tearDown();
    }

    @Test
    void updateItem() throws VendingMachinePersistenceException {
        this.setUp();
        Item item = new Item();
        item.setItemCode("A1");
        item.setItemName("UpdateItem1");
        BigDecimal price = new BigDecimal("1.00");
        item.setPrice(price);
        item.setStock(1);

        dao.updateItem(item.getItemCode(), item);
        Item updatedItem = dao.readItem(item.getItemCode());

        assertEquals(item, updatedItem);
        this.tearDown();
    }

    @Test
    void unmarshallItem() {
        String itemText = "A1::Item1::1.00::1";
        Item item = new Item();
        item.setItemCode("A1");
        item.setItemName("Item1");
        BigDecimal price = new BigDecimal("1.00");
        item.setPrice(price);
        item.setStock(1);

        Item StringToMap = dao.unmarshallItem(itemText);

        assertEquals(item, StringToMap);
    }

    @Test
    void marshallItem() {
        String itemText = "A1::Item1::1.00::1";
        Item item = new Item();
        item.setItemCode("A1");
        item.setItemName("Item1");
        BigDecimal price = new BigDecimal("1.00");
        item.setPrice(price);
        item.setStock(1);

        String MapToString = dao.marshallItem(item);

        assertEquals(itemText, MapToString);
    }

    private void writeFile() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(TEST_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("-_Could not save item data to file.");
        }

        String item1 = "A1::Item1::1.00::1";
        String item2 = "A2::Item2::1.25::10";
        String item3 = "A3::Item3::2.00::0";
        out.println(item1);
        out.flush();
        out.println(item2);
        out.flush();
        out.println(item3);
        out.flush();
        out.close();
    }
}