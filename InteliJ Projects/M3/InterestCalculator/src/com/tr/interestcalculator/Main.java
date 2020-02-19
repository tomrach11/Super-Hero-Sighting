package com.tr.interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
Example:
        Savings : $10,000
        APR :  .02% / 12 =Monthly Interest
        Returned Per Month = .0000166
        $10,000 * .0000166 = $0.1666
        Balance ($10,000) + RPM($1.666) = $10,000.1666
        *Repeat until # of months are up.
        Create a program to determine how much interest is earned.
        Calculate total balance .
        Calculate total interest.
        Enter :
        Starting balance
        Interest rate
        Total months
        * Use bigDecimals  to round up/down
**/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ask for user input
        System.out.println("Please Enter money you would like to invest: ");
        String investment = sc.nextLine();
        System.out.println(("Please enter how many month you would like to invest: "));
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Plese enter the annaual interest rate: ");
        double api = Double.parseDouble(sc.nextLine());

        //convert and setup BigDecimal
        BigDecimal balance = new BigDecimal(investment);
        balance = balance.setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalInterest = new BigDecimal("0");
        totalInterest = totalInterest.setScale(2, RoundingMode.HALF_UP);

        String convertToRmp = Double.toString(api/12);
        BigDecimal rmp = new BigDecimal(convertToRmp);
        rmp = rmp.setScale(5, RoundingMode.HALF_UP);

        //Do calculation
        for (int i = 0; i < month; i++) {
            BigDecimal interest = balance.multiply(rmp);
            interest = interest.setScale(2, RoundingMode.HALF_UP);

            totalInterest = interest.add(totalInterest);
            balance = balance.add(interest);
        }

        //shows result
        System.out.println(rmp);
        System.out.println("Principle: " + investment);
        System.out.println("Balance after " + month + " month: " + balance);
        System.out.println("Total Interest: " + totalInterest);
    }
}
