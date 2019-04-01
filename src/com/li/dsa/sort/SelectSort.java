package com.li.dsa.sort;

public class SelectSort {


    public static void main(String[] args) {

        int[] arr = {50, 47, 48, 36, 2, 5, 6, 7, 1, 27, 26};

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
