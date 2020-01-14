package com.tsg.m1.lessons;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey, let's play a game! What is you name?");
        String name = sc.nextLine();
        System.out.println(("Ok, " + name + ", when were you born?"));
        int year = Integer.parseInt(sc.nextLine());
        String firstName = name.split(" ")[0];

        System.out.println("Well " + firstName + "...");
        System.out.print("Did you know ");
        if (year < 2005) {
            System.out.println("that Pixar's 'Up' came out half a decade ago.");
        }
        if ( year < 1995) {
            if (year < 1985) {
                System.out.print("And ");
            }
            else {
                System.out.print("Also, ");
            }
            System.out.println("that the first Harry Potter came out over 15 years ago.");
        }
        if (year < 1985) {
            if (year < 1975) {
                System.out.print("And ");
            }
            else {
                System.out.print("Also, ");
            }
            System.out.println( "Space Jam came out not last decade, but the one before THAT.");
        }
        if (year < 1975) {
            if (year < 1965) {
                System.out.print("And ");
            }
            else {
                System.out.print("Also, ");
            }
            System.out.println("that the original Jurassic Park release is closer to the date of the first lunar landing than it is to today.");
        }
        if (year < 1965) {
            System.out.print("Also, ");
            System.out.println("that the MASH TV series has been around for almost half a century!");
        }
    }

}
