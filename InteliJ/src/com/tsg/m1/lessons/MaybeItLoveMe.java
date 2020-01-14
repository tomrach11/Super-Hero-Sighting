package com.tsg.m1.lessons;

import java.util.Random;

public class MaybeItLoveMe {
    public static void main(String[] args) {
        Random random = new Random();
        int patel = random.nextInt(89 - 13) + 13;
        for (int i = 0; i < patel; i++) {
            if (i % 2 == 0) {
                System.out.println("It loves me!");
            }
            else {
                System.out.println("It loves me NOT!");
            }
        }
        System.out.println();
        if (patel % 2 != 0) {
            System.out.println("I knew it! I knew it!");
        }
        else {
            System.out.println("Awwww, bummer.");
        }
    }
}
