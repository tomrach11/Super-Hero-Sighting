package com.tr.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Change {
    private BigDecimal balance = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
