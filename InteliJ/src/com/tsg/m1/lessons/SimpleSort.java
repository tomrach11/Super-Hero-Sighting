package com.tsg.m1.lessons;

import java.util.Arrays;

public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};
        int min = 0;

        int[] wholeNumbers = new int[24];
        for (int i = 0; i < wholeNumbers.length; i++) {
            for (int j = 0; j < firstHalf.length; j++) {
                wholeNumbers[i] = firstHalf[j];
                i++;
            }
            for (int j = 0; j < firstHalf.length; j++) {
                wholeNumbers[i] = secondHalf[j];
                i++;
            }
        }
        Arrays.sort(wholeNumbers);
        for (int number : wholeNumbers) {
            System.out.print(number + " ");
        }

    }
}
