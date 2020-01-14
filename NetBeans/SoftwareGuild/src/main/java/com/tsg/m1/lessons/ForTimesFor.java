package com.tsg.m1.lessons;

import java.util.Scanner;

public class ForTimesFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        int count = 0;
        int numberOfQuestion = 15;
        System.out.println("Which times table shall I recite?");
        number = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= numberOfQuestion; i++) {
            int answer;
            System.out.print(i + " * " + number + " is: ");
            answer = Integer.parseInt(sc.nextLine());
            if (i * number == answer) {
                count++;
                System.out.println("Correct!");
            }
            else {
                System.out.println("Sorry, the answer is: " + (i * number));
            }
        }
        System.out.println();
        System.out.println("You got " + count + " correct!");
        if (count > numberOfQuestion * 0.9) {
            System.out.println("That is impressive!");
        }
        else if (count < numberOfQuestion * 0.5) {
            System.out.println("Please study more!");
        }
    }
}
