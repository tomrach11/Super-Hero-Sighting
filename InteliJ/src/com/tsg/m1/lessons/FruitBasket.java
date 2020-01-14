package com.tsg.m1.lessons;

public class FruitBasket {
    public static void main(String[] args) {
        String[] fruits = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};
        String[] oranges = new String[fruits.length];
        String[] apples = new String[fruits.length];
        int appleIndex = 0;
        int orangeIndex = 0;
        for (int i = 0; i < fruits.length; i++) {
            if ("Apple".equals(fruits[i])) {
                apples[appleIndex] = "Apple";
                appleIndex++;
            }
            if ("Orange".equals(fruits[i])) {
                oranges[orangeIndex] = "Orange";
                orangeIndex++;
            }
        }
        System.out.println("Total Number of Fruit in Basket: " + fruits.length);
        System.out.println("Number of Apple: " + count(apples, "Apple"));
        System.out.println("Number of Orange: " + count(oranges, "Orange"));

    }
    public static int count (String[] basket, String fruit) {
        int count = 0;
        for (String ele : basket) {
            if (ele == fruit) {
                count++;
            }
        }
        return count;
    }
}
