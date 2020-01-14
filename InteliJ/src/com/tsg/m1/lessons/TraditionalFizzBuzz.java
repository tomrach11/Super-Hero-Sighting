package com.tsg.m1.lessons;

import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many fizzing and buzzing units do you need in your life?");
        int number = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; count < number; i++) {
            if (i == 0) {
                System.out.println(i);
            }
            else if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizz buzz");
                count++;
            }
            else if (i % 3 == 0) {
                System.out.println("fizz");
                count++;
            }
            else if (i % 5 == 0) {
                System.out.println("buzz");
                count++;
            }
            else {
                System.out.println(i);
            }
        }
        System.out.println("TRADITION!!!!!");
    }
}
