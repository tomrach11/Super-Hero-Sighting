package com.tsg.m1.lessons;

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {
        Random random = new Random();
        boolean clean = false;
        int chance = 5;
        int i =0;
        while (clean == false && i <= 15) {
            System.out.println("Clean you room!! (x" + i + ")");
            int randomChance =  random.nextInt((100 - chance));
            if (chance >= randomChance) {
                clean = true;
                System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
            }
            else if (i >= 15) {
                System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
            }
            i++;
            chance += 5;
        }
    }
}
