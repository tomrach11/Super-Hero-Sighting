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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineDaoTest {

    VendingMachineDao dao = new VendingMachineDaoFileImpl();

    @BeforeEach
    void setUp() {
//        File file = new File("items.txt");
        //file.delete();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void readItem() throws VendingMachinePersistenceException {
//        this.setUp();
//        Item item = new Item();
//        item.setItemCode("A1");
//        item.setItemName("Item1");
//        item.setPrice(new BigDecimal("1.25"));
//        item.setStock(10);
//
//        dao.updateItem(item.getItemCode(), item);
//
//        assertEquals(item, dao.readItem(item.getItemCode()));
    }

    @Test
    void readAll() {
    }

    @Test
    void updateItem() {
    }
}