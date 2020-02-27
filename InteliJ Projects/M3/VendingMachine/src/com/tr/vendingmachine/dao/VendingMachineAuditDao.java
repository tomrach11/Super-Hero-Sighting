package com.tr.vendingmachine.dao;

public interface VendingMachineAuditDao {
    void writeAuditEntry(String entry) throws VendingMachinePersistenceException;
}
