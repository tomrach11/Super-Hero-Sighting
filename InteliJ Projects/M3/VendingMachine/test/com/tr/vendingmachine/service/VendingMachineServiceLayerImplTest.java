package com.tr.vendingmachine.service;

import com.tr.vendingmachine.dao.*;
import com.tr.vendingmachine.dto.Change;
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

class VendingMachineServiceLayerImplTest {

    private String TEST_FILE = "test.txt";
    VendingMachineDaoFileImpl dao = new VendingMachineDaoFileImpl(TEST_FILE);
    VendingMachineAuditDao audit = new VendingMachineAuditDaoImpl();
    VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao, audit);

    VendingMachineServiceLayerImplTest() throws VendingMachinePersistenceException {
    }

    File file;

    @BeforeEach
    void setUp() throws VendingMachinePersistenceException {
        file = new File(TEST_FILE);
        writeFile();
    }

    @AfterEach
    void tearDown() {
        file.delete();
    }

    @Test
    void testGetItems() throws Exception {
        this.setUp();
        List<Item> itemList = service.getItems();
        assertEquals(2, itemList.size());
        this.tearDown();
    }

    @Test
    void insertMoney() {

    }

    @Test
    void testSelectItemWithCorrectItemCode() throws Exception {
        this.setUp();
        String itemCode = "A1";
        service.selectItem(itemCode);
        this.tearDown();
    }

    @Test
    void testSelectItemWithIncorrectItemCode() throws Exception {
        this.setUp();
        String itemCode = "ZZ";
        try {
            service.selectItem(itemCode);
            fail("Expected VendingMachineItemNotFoundException was not thrown");
        } catch (VendingMachineItemNotFoundException e) {
            return;
        }
        this.tearDown();
    }

    @Test
    void testVendItemSuccess() throws Exception {
        this.setUp();
        BigDecimal money = new BigDecimal("1.00");
        service.selectItem("A1");
        service.insertMoney(money);
        Change fromDao = service.vendItem();
        Change change = new Change();
        change.setQuarterAmount(0);
        change.setDimeAmount(0);
        change.setNickelAmount(0);
        change.setPennyAmount(0);
        assertEquals(change, fromDao);
        this.tearDown();
    }

    @Test
    void testVendItemInsufficientFund() throws Exception {
        this.setUp();
        BigDecimal money = new BigDecimal("0.00");
        service.selectItem("A1");
        service.insertMoney(money);
        try {
            service.vendItem();
            fail("Expected VendingMachineInsufficientFundException was not thrown");
        } catch (VendingMachineInsufficientFundException e) {
            return;
        }
        this.tearDown();
    }

    @Test
    void testVendItemOutOfStock() throws Exception {
        this.setUp();
        BigDecimal money = new BigDecimal("5.00");
        service.selectItem("A3");
        service.insertMoney(money);
        try {
            service.vendItem();
            fail("Expected VendingMachineItemOutOfStockException was not thrown");
        } catch (VendingMachineItemOutOfStockException e) {
            return;
        }
        this.tearDown();
    }
//test returnChange cases
    @Test
    void testReturnChangeOneEach() throws Exception{
        this.setUp();
        Change change = new Change();
        change.setQuarterAmount(1);
        change.setDimeAmount(1);
        change.setNickelAmount(1);
        change.setPennyAmount(1);

        BigDecimal money = new BigDecimal("0.41");
        service.selectItem("A1");
        service.insertMoney(money);
        Change fromDao = service.returnChange();

        assertEquals(change, fromDao);
        this.tearDown();
    }

    @Test
    void testReturnChangeOneQuater() throws Exception{
        this.setUp();
        Change change = new Change();
        change.setQuarterAmount(1);
        change.setDimeAmount(0);
        change.setNickelAmount(0);
        change.setPennyAmount(0);

        BigDecimal money = new BigDecimal("0.25");
        service.selectItem("A1");
        service.insertMoney(money);
        Change fromDao = service.returnChange();

        assertEquals(change, fromDao);
        this.tearDown();
    }

    @Test
    void testReturnChangeOneDime() throws Exception{
        this.setUp();
        Change change = new Change();
        change.setQuarterAmount(0);
        change.setDimeAmount(1);
        change.setNickelAmount(0);
        change.setPennyAmount(0);

        BigDecimal money = new BigDecimal("0.10");
        service.selectItem("A1");
        service.insertMoney(money);
        Change fromDao = service.returnChange();

        assertEquals(change, fromDao);
        this.tearDown();
    }

    @Test
    void testReturnChangeOneNickel() throws Exception{
        this.setUp();
        Change change = new Change();
        change.setQuarterAmount(0);
        change.setDimeAmount(0);
        change.setNickelAmount(1);
        change.setPennyAmount(0);

        BigDecimal money = new BigDecimal("0.05");
        service.selectItem("A1");
        service.insertMoney(money);
        Change fromDao = service.returnChange();

        assertEquals(change, fromDao);
        this.tearDown();
    }

    @Test
    void testReturnChangeOnePenny() throws Exception{
        this.setUp();
        Change change = new Change();
        change.setQuarterAmount(0);
        change.setDimeAmount(0);
        change.setNickelAmount(0);
        change.setPennyAmount(1);

        BigDecimal money = new BigDecimal("0.01");
        service.selectItem("A1");
        service.insertMoney(money);
        Change fromDao = service.returnChange();

        assertEquals(change, fromDao);
        this.tearDown();
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