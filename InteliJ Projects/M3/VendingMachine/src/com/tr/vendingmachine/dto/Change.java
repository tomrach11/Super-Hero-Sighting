package com.tr.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Change {
    private BigDecimal QUARTER = new BigDecimal("0.25");
    private BigDecimal DIME = new BigDecimal("0.10");
    private BigDecimal NICKEL = new BigDecimal("0.05");
    private BigDecimal PENNY = new BigDecimal("0.01");

    private int quarterAmount = 0;
    private int dimeAmount = 0;
    private int nickelAmount = 0;
    private int pennyAmount = 0;

    public BigDecimal getQUARTER() {
        return QUARTER;
    }

    public BigDecimal getDIME() {
        return DIME;
    }

    public BigDecimal getNICKEL() {
        return NICKEL;
    }

    public BigDecimal getPENNY() {
        return PENNY;
    }

    public void setQUARTER(BigDecimal QUARTER) {
        this.QUARTER = QUARTER;
    }

    public void setDIME(BigDecimal DIME) {
        this.DIME = DIME;
    }

    public void setNICKEL(BigDecimal NICKEL) {
        this.NICKEL = NICKEL;
    }

    public void setPENNY(BigDecimal PENNY) {
        this.PENNY = PENNY;
    }

    public int getQuarterAmount() {
        return quarterAmount;
    }

    public void setQuarterAmount(int quarterAmount) {
        this.quarterAmount = quarterAmount;
    }

    public int getDimeAmount() {
        return dimeAmount;
    }

    public void setDimeAmount(int dimeAmount) {
        this.dimeAmount = dimeAmount;
    }

    public int getNickelAmount() {
        return nickelAmount;
    }

    public void setNickelAmount(int nickelAmount) {
        this.nickelAmount = nickelAmount;
    }

    public int getPennyAmount() {
        return pennyAmount;
    }

    public void setPennyAmount(int pennyAmount) {
        this.pennyAmount = pennyAmount;
    }
}
