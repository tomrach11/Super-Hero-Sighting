package com.tsg.interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String principal;
        String interest;
        double apr;
        double rpm;
        double totalSavings;
        double totalInterest;
        int month;
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your inital investment?");
        principal = sc.nextLine();
        System.out.println("What is your interest rate?");
        interest = sc.nextLine();
        BigDecimal investment = new BigDecimal(principal);
        BigDecimal percent = new BigDecimal(interest);
        percent = percent.setScale(2, RoundingMode.HALF_UP);
        investment = investment.setScale(2, RoundingMode.HALF_UP);
    }

}
