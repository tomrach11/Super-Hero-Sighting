package com.tsg.m1.lessons;

import java.util.Random;
import java.util.Scanner;

public class GuessMeFinally {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        boolean firstGuess = true;
        int guess = 0;
        int number = random.nextInt(100 + 100) - 100;
        System.out.println("I have choose a number between -100 and 100. Betcha can't guess it");
        System.out.println(number);

        while (guess != number) {
            System.out.println("You Guess: ");
            guess = Integer.parseInt(sc.nextLine());
            if (guess == number && firstGuess == true) {
                System.out.println("Wow, nice guess! It was " + number + "!");
            }
            else if (guess == number) {
                System.out.println("Finally! It's about time. It was " + number + "!");
            }
            else if (guess < number) {
                System.out.println("Too LOW!, Try again!");
            } else if (guess > number) {
                System.out.println("Too high, Try again!");
            }
            firstGuess = false;
        }
    }
}