package com.tsg.m1.lessons;

import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args) {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("What number should I count down from?");
        number = Integer.parseInt(sc.nextLine());
        System.out.println();
        System.out.println("Here goes!");
        System.out.println();
        int i1 = number;
        while (i1 >= 0) {
            for (int i2 = 0; i2 < 9 && i1 > 0; i2++) {
                System.out.print(i1 + " ");
                i1--;
            }
            System.out.println(i1 + " ");
            i1--;
        }
        System.out.println();
        System.out.println("Lets stop here...!");
    }

}
