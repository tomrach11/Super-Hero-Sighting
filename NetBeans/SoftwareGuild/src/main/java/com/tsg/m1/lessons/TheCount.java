package com.tsg.m1.lessons;

import java.util.Scanner;

public class TheCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start;
        int end;
        int step;
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        System.out.print("Start at: ");
        start = Integer.parseInt(sc.nextLine());
        System.out.print("Stop at: ");
        end = Integer.parseInt(sc.nextLine());
        System.out.print("Count by: ");
        step = Integer.parseInt(sc.nextLine());
        System.out.println();
//        for (int i1 = start; i1 < end; i1 += step) {
//            for (int i2 = 0; i2 < 2 && i1 < end; i2++) {
//                System.out.print(i1 + " ");
//                i1 += step;
//            }
//            System.out.println("- Ah ah ah!");
//        }
        for (int i = 1; i <= end - (start-1); i += step) {
            System.out.print( (i + (start-1)) + " ");
            if (i % 3 == 0) {
                System.out.println("-Ah ah ah!");
            }
        }
    }
}
