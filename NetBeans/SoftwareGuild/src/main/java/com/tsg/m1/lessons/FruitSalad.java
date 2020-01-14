package com.tsg.m1.lessons;

public class FruitSalad {
    public static void main(String[] args) {
        String[] fruits = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};

        String[] fruitSalad = new String[12];
        int numApples = 0; int maxApple = 3;
        int numOranges = 0; int maxOranges = 2;
        int numFruit = 0; int maxFruit = fruitSalad.length;
        int numBerry = 0;
        int otherFruit = 0;
        int saladIndex = 0;

        for (String fruit : fruits) {
            if (fruit.contains("Apple") && numApples < maxApple && numFruit < maxFruit) {
                fruitSalad[saladIndex] = fruit;
                numApples++;
                numFruit++;
                saladIndex++;
            }
            else if (fruit.contains("Orange") && numOranges < maxOranges && numFruit < maxFruit) {
                fruitSalad[saladIndex] = fruit;
                numOranges++;
                numFruit++;
                saladIndex++;
            }
            else if (fruit.contains("berry") && numFruit < maxFruit) {
                fruitSalad[saladIndex] = fruit;
                numBerry++;
                numFruit++;
                saladIndex++;
            }
            else if (!fruit.contains("Apple") && !fruit.contains("Orange") && !fruit.contains("berry") && !fruit.contains("Tomato")){
                fruitSalad[saladIndex] = fruit;
                otherFruit++;
                numFruit++;
                saladIndex++;
            }
            if (saladIndex > fruitSalad.length - 1) {
                break;
            }
        }
        System.out.println("Fruit Salad Contain: ");
        System.out.println(numApples + " Apples");
        System.out.println(numOranges + " Oranges");
        System.out.println(numBerry + " Berries");
        System.out.println(otherFruit + " Other Fruits");
        System.out.println();
        System.out.println("List Below");
        System.out.println("---------------------------------");
        for (String fruit : fruitSalad) {
            System.out.println(fruit);
        }


    }
}
