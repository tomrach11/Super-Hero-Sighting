package com.tsg.m1.lessons;

import java.util.Scanner;

public class FieldDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's your last name?");
        String name = sc.nextLine();
        String team = "";
        if (name.compareTo("baggins") <= 0) {
            team = "Red Dragon";
        }
        else if (name.compareTo("dresden") <= 0) {
            team = "Dark Wizards";
        }
        else if (name.compareTo("howl") <= 0) {
            team = "Moving Castles";
        }
        else if (name.compareTo("potter") <= 0) {
            team = "Golden Snitches";
        }
        else if (name.compareTo("vimes") <= 0) {
            team = "Night Guards";
        }
        else {
            team = "Black Holes";
        }
        System.out.println(name.compareTo("Baggins"));
        System.out.println("Aha! You're on the team \"" + team + "\"!");
        System.out.println("Good luck in the games!");
    }
}
