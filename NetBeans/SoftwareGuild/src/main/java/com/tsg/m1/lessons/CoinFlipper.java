package com.tsg.m1.lessons;

import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args) {
        Random random = new Random();
        double flip;
        String coin = "HEADS";
        flip = Math.random()*2;
        if (flip < 1) {
            coin = "TAILS";
        }
        System.out.println("Read, Set, Flip....!!");
        System.out.println("You got " + coin + "!");
    }
}
