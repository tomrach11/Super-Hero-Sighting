package com.tsg.m1.lessons;

public class ForByFor {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.print("|");

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            System.out.print("*");
                        }
                        else {
                            System.out.print("$");
                        }
                    }
                    else {
                        if (j % 2 == 0) {
                            System.out.print("@");
                        }
                        else {
                            System.out.print("#");
                        }
                    }
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
