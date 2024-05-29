package com.company;
import java.util.Scanner;

public class Main {

    private static int[][] B;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        System.out.print("Enter the capacity of the knapsack: ");
        int W = scanner.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];
        System.out.println("Enter the values and weights of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value for item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
            System.out.print("Weight for item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
        }

        int maxValue = knapsack(W, weights, values, n);

        System.out.println("Maximum value: " + maxValue);
        System.out.println("Dynamic programming table:");
        printTable();
        System.out.println("Items selected for maximum value:");
        printSelectedItems(B, weights, values, n);
    }

    private static int knapsack(int W, int[] weights, int[] values, int n) {
        B = new int[n + 1][W + 1];
        boolean[][] selected = new boolean[n + 1][W + 1];

        for (int w = 0; w <= W; w++) {
            B[0][w] = 0;
            selected[0][w] = false;
        }
        for (int i = 0; i <= n; i++) {
            B[i][0] = 0;
            selected[i][0] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    if (values[i - 1] + B[i - 1][w - weights[i - 1]] > B[i - 1][w]) {
                        B[i][w] = values[i - 1] + B[i - 1][w - weights[i - 1]];
                        selected[i][w] = true;
                    } else {
                        B[i][w] = B[i - 1][w];
                        selected[i][w] = selected[i - 1][w];
                    }
                } else {
                    B[i][w] = B[i - 1][w];
                    selected[i][w] = selected[i - 1][w];
                }
            }
        }

        return B[n][W];
    }

    private static void printSelectedItems(int[][] B, int[] weights, int[] values, int n) {
        int w = B[0].length - 1;
        for (int i = B.length - 1; i > 0; i--) {
            if (B[i][w] != B[i - 1][w]) {
                System.out.println("Item " + i + " is selected with weight " + weights[i - 1] + " and value " + values[i - 1]);
                w -= weights[i - 1];
            }
        }
    }

    private static void printTable() {
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                System.out.print(B[i][j]+" ");
            }
            System.out.println();
        }
    }
}