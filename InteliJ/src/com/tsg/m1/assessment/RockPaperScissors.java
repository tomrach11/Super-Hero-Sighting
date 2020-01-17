package com.tsg.m1.assessment;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = false;
        do {
            Random random = new Random();
            String[] hands = {"Rock", "Scissors", "Paper"};
            int playerHand;
            int botHand;
            int playerWin = 0;
            int botWin = 0;
            int totalTie = 0;
            int round = 0;
            String roundResult;
            System.out.println("How many round do you want to play? [1-10]");
            round = Integer.parseInt(sc.nextLine());
            //verify round
            if (round >= 1 && round <= 10) {
                //game start
                for (int i = 0; i < round; i++) {
                    //set up hands
                    playerHand = inputPlayerHand();
                    botHand = random.nextInt(4 - 1) + 1;
                    //print player and bot hands
                    System.out.println(">> Your Hand: " + hands[playerHand - 1] + ", Bot Hand: " + hands[botHand - 1]);

                    roundResult = checkHands(playerHand, botHand);
                    if ("playerWin".equals(roundResult)) {
                        playerWin++;
                        System.out.println("You WIN this round!!");
                    } else if ("tie".equals(roundResult)) {
                        totalTie++;
                        System.out.println("We TIE this round!!");
                    } else {
                        botWin++;
                        System.out.println("You LOST this round!!");
                    }
                }
                //show winner
                showFinalResult(playerWin, botWin);
                //play again
                System.out.println("Do you want to play again? [Y][N]");
                if (!("Y".equals(sc.nextLine()))) {
                    System.out.println("Thank you for playing !!");
                    keepGoing = false;
                } else {
                    keepGoing = true;
                }
            //invalid round
            } else {
                System.out.println("Error: program is shutting down.");
            }
        } while (keepGoing == true);
    }
    public static String checkHands (int playerHand, int botHand) {
        if (playerHand == 1 && botHand == 2 || playerHand == 2 && botHand == 3 || playerHand == 3 && botHand == 1) {
            return "playerWin";
        } else if (playerHand == botHand) {
            return "tie";
        } else {
            return "botWin";
        }
    }
    public static void showRoundResult (String result) {
        if ("playerWin".equals(result)) {
            System.out.println("You WIN this round!!");
        } else if ("tie".equals(result)) {
            System.out.println("We TIE this round!!");
        } else {
            System.out.println("You LOST this round!!");
        }
    }
    public static void showFinalResult (int playerWin, int botWin) {
        System.out.println("-----------------------------------------");
        System.out.println("The score: Player Win-" + playerWin + " , Bot Win-" + botWin);
        if (playerWin > botWin) {
            System.out.println("Congratulations you WIN the game!!");
        } else if (botWin > playerWin) {
            System.out.println("Sorry you LOST the game");
        } else if (playerWin == botWin) {
            System.out.println("We are TIE this game");
        }
        System.out.println("-----------------------------------------");
    }
    public static int inputPlayerHand () {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.println("Please Choose you hand:");
        System.out.println("Type: 1=>Rock, 2=>Scissors, 3=>Paper");
        return Integer.parseInt(sc.nextLine());
    }
}
