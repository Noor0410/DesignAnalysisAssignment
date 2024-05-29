package com.company;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
        sort.quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
    }
}
}