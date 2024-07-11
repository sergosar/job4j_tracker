package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int all) {
        return sum(all) + multiply(all) + minus(all) + divide(all);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        System.out.println(Calculator.minus(10));

        Calculator calculator = new Calculator();
        System.out.println("calculator.divide(10) = " + calculator.divide(10));
        System.out.println("calculator.multiply(10) = " + calculator.multiply(10));
        System.out.println("calculator.sumAllOperation(10) = " + calculator.sumAllOperation(10));
    }
}
