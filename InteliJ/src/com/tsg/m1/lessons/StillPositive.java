package com.tsg.m1.lessons;

public class StillPositive {
    public static void main(String[] args) {
        int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};
        System.out.println("Gotta stay positive ...!");
        for (int number : numbers) {
            if (number > 0) {
                System.out.print(number + " ");
            }
        }
    }
}
