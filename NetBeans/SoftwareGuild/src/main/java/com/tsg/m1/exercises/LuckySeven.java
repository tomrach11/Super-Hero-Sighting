package com.tsg.m1.exercises;

import java.util.Random;
import java.util.Scanner;

public class LuckySeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = false;
        do {
            int roll1 = 0;
            int roll2 = 0;
            int sum = 0;
            int startingBet = 0;
            int remainingBet = 0;
            int totalRolls = 0;
            int highestEarned = 0;
            Random rng = new Random();
            System.out.println("Enter Starting Bet:");
            startingBet = Integer.parseInt(sc.nextLine());
            highestEarned = startingBet;
            remainingBet = startingBet;
            while (remainingBet > 0) {
                roll1 = rng.nextInt(6 - 1) + 1;
                roll2 = rng.nextInt(6 - 1) + 1;
                totalRolls++;
                sum = roll1 + roll2;
                if (sum == 7) {
                    remainingBet += 10;
                    if (remainingBet > highestEarned) {
                        highestEarned = remainingBet;
                    }
                } else {
                    //remainingBet= remainingBet- 4;
                    remainingBet -= 4;
                }

            }
            System.out.println("Starting Bet:" + startingBet);
            System.out.println("Highest Earned:" + highestEarned);
            System.out.println("Total Rolled:" + totalRolls);
            System.out.println("Do you want to play Again?");
            keepGoing = "Y".equals(sc.nextLine());
        } while (keepGoing == true);
    }
}




