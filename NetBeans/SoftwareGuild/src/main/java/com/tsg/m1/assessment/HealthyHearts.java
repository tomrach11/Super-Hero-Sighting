package com.tsg.m1.assessment;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;
        int maxHeartRate;
        int minHeartRateZone;
        int maxHeartRateZone;

        System.out.println("What is you age?");
        age = Integer.parseInt(sc.nextLine());
        maxHeartRate = 220 - age;
        minHeartRateZone = (int) Math.ceil(maxHeartRate * 0.5);
        maxHeartRateZone = (int) Math.ceil(maxHeartRate * 0.85);

        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + minHeartRateZone + " - " + maxHeartRateZone + " beats per minute.");
    }
}
