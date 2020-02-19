package com.tr.enums;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
//        System.out.println("Please enter operator: ");
//        System.out.println("0. PLUS");
//        System.out.println("1. MINUS");
//        System.out.println("");
        int result = calculator.calculate(MathOperator.PLUS,1,1);
        System.out.println(result);
    }
}
