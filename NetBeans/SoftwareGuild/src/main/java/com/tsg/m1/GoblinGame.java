package com.tsg.m1;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;

public class GoblinGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int health;
        int gold = 0;
        int potion = 0;
        int potionHealth = 4;
        int potionPrice = 2;
        int maxPotion = 5;
        int step = 0;
        int floor = 1;
        int chance = 20;
        int chanceIncrease = 1;
        int goblinDamage = 2;
        int goblinGold = 1;
        boolean keepGoing = true;
        do {
            health = random.nextInt(20 - 10) + 10;
            step = 0;
            while (health > 0) {
                System.out.println("Status: Health=" + health + " Gold=" + gold + " Potion=" + potion);
                System.out.println("---------------------------------------------------------");
                //taking step
                if (checkYes("Would you like to take a step? [Y][N]")) {
                    step++;
                }
                else {
                    checkYes("Whenever you ready [Y]");
                }
                System.out.println("---------------------------------------------------------");
                System.out.println("Floor: " + floor + ", At Step " + step);
                //find a store
                if (step % 5 == 0 && !(step % 10 == 0)) {
                    boolean buyPotion = true;
                    System.out.println(">>>>> You Found a potion store! <<<<<");
                    //buy potion
                    while (buyPotion == true && potion < maxPotion && gold >= potionPrice) {
                        if (checkYes("Would you like to buy potion? [Y][N]")) {
                            gold -= potionPrice;
                            potion++;
                            System.out.println("You got 1 more potion!");
                        }
                        else {
                            buyPotion = false;
                        }
                    }
                    if (potion >= maxPotion) {
                        System.out.println( "You already have " + maxPotion + "potion.");
                    }
                    else if (gold < potionPrice) {
                        System.out.println("You do not have enough gold to buy potion.");
                    }
                } else if (step % 10 == 0) {
                    boolean takePotion = true;
                    chance += chanceIncrease;
                    floor++;
                    System.out.println(">>>>> You clear a Floor!!! <<<<<");
                    while (potion > 0 && takePotion == true) {
                        if (checkYes("Would you like to take a Potion? [Y][N]")) {
                            health += potionHealth;
                            potion--;
                            System.out.println("You health go up by " + potionHealth + ".");
                        }
                        else {
                            takePotion = false;
                        }
                    }
                } else if (chance > random.nextInt(100)) {
                    System.out.println("You Found Goblin!!");
                    System.out.println("...");
                    System.out.println("Goblin HIT you! Lost " + goblinDamage + " Health.");
                    System.out.println("...");
                    health -= goblinDamage;
                    if (health > 0) {
                        System.out.println("You manage to kill Goblin!! and Get " + goblinGold + " Gold.");
                        gold += goblinGold;
                    }
                } else {
                    System.out.println("You safe!!");
                }
            }
            System.out.println("You die on Floor " + floor + ", step " + step);
            System.out.println("______________________________________________________");
            keepGoing = playAgain();
        } while (keepGoing == true);
    }
    public static boolean playAgain () {
        Scanner sc = new Scanner(System.in);
        if (!(checkYes("Do you want to try again? [Y][N]"))) {
            System.out.println("Thank you for playing !!");
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkYes (String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        String ans = sc.nextLine();
        if (("Y".equals(ans)) || ("y".equals(ans))) {
            return true;
        } else {
            return false;
        }
    }

}
