package com.tsg.m1.lessons;

import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        int number = random.nextInt(200) - 100;
        System.out.println("I have choose a number between -100 and 100. Betcha can't guess it");

        do {
            System.out.println("You Guess: ");
            guess = Integer.parseInt(sc.nextLine());
            if (guess < number) {
                System.out.println("Too LOW!, Try again!");
            }
            else if (guess > number) {
                System.out.println("Too high, Try again!");
            }
        } while (guess != number);

        System.out.println("Wow, nice guess! It was " + number + "!");
        System.out.println(number);
    }
}
