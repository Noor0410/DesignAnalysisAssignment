package com.company;

public class Main {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int amount = 1988;

        int[] result = coinChange(denominations, amount);
        System.out.println("Denominations required:");
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                System.out.println(denominations[i] + " x " + result[i]);
                sum += denominations[i] * result[i];
            }
        }
        System.out.println("Total amount: " + amount);
        System.out.println("Sum of denominations: " + sum);
    }

    private static int[] coinChange(int[] denominations, int amount) {
        int[] result = new int[denominations.length];
        for (int i = denominations.length - 1; i >= 0 && amount > 0; i--) {
            if (denominations[i] <= amount) {
                result[i] = amount / denominations[i];
                amount %= denominations[i];
            }
        }
        return result;
    }
}
