package com.tsg.m1.lessons;

import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] questions = {
                {"What is the Lowest Level Programming Language?", "Source Code", "Assembly Language", "C#", "Machine Code", "4"},
                {"Website Security CAPTCHA Forms Are Descended From the Work of?", "Grace Hopper", "Alan Turing", "Charles Babbage", "Larry Page", "2"},
                {"Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?", "Serenity", "The Battlestar Galactica", "The USS Enterprise", "The Millennium Falcon", "3"}
        };
        int point = 0;

        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        for (int i = 0; i < questions.length; i++) {
            System.out.println();
            System.out.println("QUESTION: " + (i + 1));
            System.out.println(questions[i][0]);
            System.out.println("1) " + questions[i][1] + "\t\t2) " + questions[i][2]);
            System.out.println("3) " + questions[i][3] + "\t\t4) " + questions[i][4]);
            System.out.print("YOU ANSWER: ");
            int answer = Integer.parseInt(sc.nextLine());
            if (Integer.parseInt(questions[i][5]) == answer) {
                point += 1;
            }
        }
        System.out.println();
        if (point == 0) {
            System.out.println("You got all wrong !!");
        }
        else if (point == questions.length) {
            System.out.println("You got all correct !!");
        }
        else {
            System.out.println("You got " + point + " questions correct !!");
        }
    }
}
