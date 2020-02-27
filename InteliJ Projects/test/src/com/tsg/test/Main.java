package com.tsg.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        BigDecimal QUARTER = new BigDecimal("0.25");
        BigDecimal DIME = new BigDecimal("0.10");
        BigDecimal NICKEL = new BigDecimal("0.05");
        BigDecimal PENNY = new BigDecimal("0.01");

        int quarterAmount = 0;
        int dimeAmount = 0;
        int nickelAmount = 0;
        int pennyAmount = 0;

        BigDecimal money = new BigDecimal("1.07");
        quarterAmount = money.divide(QUARTER, 0, RoundingMode.DOWN).intValue();
        money = money.remainder(QUARTER);
        System.out.println("Quarter: " + quarterAmount);
        System.out.println(money);

        dimeAmount = (money.divide(DIME, 0, RoundingMode.DOWN).intValue());
        money = money.remainder(DIME);
        System.out.println("Dime: " + dimeAmount);
        System.out.println(money);

        nickelAmount = (money.divide(NICKEL, 0, RoundingMode.DOWN).intValue());
        money = money.remainder(NICKEL);
        System.out.println("Nickel: " + nickelAmount);
        System.out.println(money);

        pennyAmount = (money.divide(PENNY, 0, RoundingMode.DOWN).intValue());
        money = money.remainder(PENNY);
        System.out.println("Penny: " + pennyAmount);
        System.out.println(money);

        System.out.println("Quarter: " + quarterAmount);
        System.out.println("Dime: " + dimeAmount);
        System.out.println("Nickel: " + nickelAmount);
        System.out.println("Penny: " + pennyAmount);

        System.out.println("Money: " + money);
    }
}
