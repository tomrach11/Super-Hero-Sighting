package com.tr.vendingmachine.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class UserIOFileImpl implements UserIO{
    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        print(prompt);
        return Integer.parseInt(sc.nextLine());
    }

//    @Override
//    public double readDouble(String prompt, double min, double max) throws AddressBookDaoException {
//        double input = readDouble(prompt);
//        if (input >= min && input <= max) {
//            return input;
//        } else {
//            return readDouble(prompt, min, max);
//        }
//    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        try {
            double input = readDouble(prompt);
            if (input >= min && input <= max) {
                return input;
            } else {
                return readDouble(prompt, min, max);
            }
        } catch (Exception e) {
            return 99999;
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

//    @Override
//    public int readInt(String prompt, int min, int max) throws AddressBookDaoException{
//        int input = readInt(prompt);
//        if (input >= min && input <= max) {
//            return input;
//        } else {
//            return readInt(prompt, min, max);
//        }
//    }

    @Override
    public int readInt(String prompt, int min, int max) {
        try {
            int input = readInt(prompt);
            if (input >= min && input <= max) {
                return input;
            } else {
                return readInt(prompt, min, max);
            }
        } catch (Exception e) {
            return 123456;
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

    @Override
    public LocalDate readLocalDate(String prompt) {
        print(prompt);
        return LocalDate.parse(sc.nextLine());
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        print(prompt);
        return new BigDecimal(sc.nextLine());
    }
}
