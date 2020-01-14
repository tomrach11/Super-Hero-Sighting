package com.tsg.m1.lessons;

import java.util.Random;

public class BarelyControlledChaos {
    public static void main(String[] args) {

        String color = randomColor(); // call color method here
        String animal = randomAnimal(); // call animal method again here
        String colorAgain = randomColor(); // call color method again here
        int weight = randomRange(5, 200); // call number method,
        // with a range between 5 - 200
        int distance = randomRange(10 , 20); // call number method,
        // with a range between 10 - 20
        int number = randomRange(10_000, 20_000); // call number method,
        // with a range between 10000 - 20000
        int time = randomRange(2, 6); // call number method,
        // with a range between 2 - 6

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    public static String randomColor () {
        String[] colors = {"black", "white", "red", "blue", "green", "gray"};
        Random random = new Random();
        int randomIndex;
        randomIndex = random.nextInt(6);
        return colors[randomIndex];
    }
    public static String randomAnimal () {
        String[] animals = {"Cat", "Dog", "T-Rex", "Tiger", "Wolf", "Penguin"};
        Random random = new Random();
        int randomIndex;
        randomIndex = random.nextInt(6);
        return animals[randomIndex];
    }
    public static  int randomRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
