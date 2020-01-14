package com.tsg.m1.exercises;

import java.util.Scanner;

public class Factorizor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int sum = 0;
        int count = 0;
        System.out.println("What number would you like to factor?");
        number = Integer.parseInt(scanner.nextLine());
        //all factor
        System.out.println("The factor of " + number + " are: ");
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                System.out.println(i);
                sum += i;
                count++;
            }
        }
        System.out.println("Total factors: " + count);
        //perfect number
        if (number == sum) {
            System.out.println(number + " is a perfect number.");
        }
        else {
            System.out.println(number + " is NOT a perfect number.");
        }
        //prime number
        if (sum == 1) {
            System.out.println(number + " is a prime number.");
        }
        else {
            System.out.println(number + " is NOT a prime");
        }
    }
}
