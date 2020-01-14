package com.tsg.m1.assessment;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String dogName;
        int total = 100;
        int[] percents = new int[5];
        String[] dogBreeds = { "ST.Bernard", "Chihuahua", "Pug", "Pitbull", "Bulldog" };
        //input
        System.out.println("What is you dog's name?");
        dogName = sc.nextLine();
        //generate percentages
        for (int i = 0; i < percents.length - 1; i++) {
            int reserve = (percents.length - ( i + 1));
            percents[i] = random.nextInt(( (total - reserve) - 1) + 1 );
            total -= percents[i];
        }
        percents[percents.length - 1] = total;
        //show result
        System.out.println("Here is highly reliable report on " + dogName + " Esquire's prestigious background right here.");
        System.out.println(dogName + " Esquire is:");
        for (int i = 0; i < percents.length; i++) {
            System.out.println(percents[i] + "% " + dogBreeds[i]);
        }
        System.out.println("Wow, that's quite the dogs!");
    }
}
