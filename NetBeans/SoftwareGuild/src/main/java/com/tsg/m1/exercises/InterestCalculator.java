package com.tsg.m1.exercises;

import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        double initialMoney;
        double yearlyRate;
        int totalYear;
        int compoundPeriod;

        double currentMoney;
        int currentYear;
        double periodRate;
        double beginMoney;
        double yearlyMoney;

        //input
        System.out.println("How much money would you like to invest?");
        initialMoney = Double.parseDouble(sc.nextLine());
        currentMoney = initialMoney;
        System.out.println("What is Yearly Interest rate?");
        yearlyRate = Double.parseDouble(sc.nextLine());
        System.out.println("How many year would you like to stay in the fund?");
        totalYear = Integer.parseInt(sc.nextLine());
        System.out.println("Please choose compound period");
        System.out.println("[4]Monthly, [12]Monthly, [365]Yearly");
        compoundPeriod = Integer.parseInt(sc.nextLine());
        periodRate = yearlyRate / compoundPeriod;

        for (int i1 = 1; i1 <= totalYear; i1++) {
            currentYear = i1;
            beginMoney = currentMoney;
            for (int i2 = 0; i2 < compoundPeriod; i2++) {
                currentMoney = currentMoney * (1 + periodRate / 100);
            }
            yearlyMoney = currentMoney - beginMoney;

            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Year: " + currentYear);
            System.out.println("The Principle at the beginning of Year: " + currency.format(beginMoney));
            System.out.println("The total amount that interest earned for the year: " + currency.format(yearlyMoney));
            System.out.println("The Principle at the end of year: " + currency.format(currentMoney));
        }
    }
}

