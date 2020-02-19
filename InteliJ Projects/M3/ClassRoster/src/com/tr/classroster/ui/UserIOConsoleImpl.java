package com.tr.classroster.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double input = readDouble(prompt);
        if (input >= min && input <= max) {
            return input;
        } else {
            return readDouble(prompt, min, max);
        }
    }

    @Override
    public float readFloat(String prompt) {
        print(prompt);
        return Float.parseFloat(sc.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float input = readFloat(prompt);
        if (input >= min && input <= max) {
            return input;
        } else {
            return readFloat(prompt, min, max);
        }
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int input = readInt(prompt);
        if (input >= min && input <= max) {
            return input;
        } else {
            return readInt(prompt, min, max);
        }
    }

    @Override
    public long readLong(String prompt) {
        print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long input = readLong(prompt);
        if (input >= min && input <= max) {
            return input;
        } else {
            return readLong(prompt, min, max);
        }
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return sc.nextLine();
    }

}
