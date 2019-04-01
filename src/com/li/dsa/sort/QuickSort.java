package com.li.dsa.sort;

public class QuickSort {


    public static int partition(int[] arr, int lo, int hi) {

//        int[] arr = {6, 3, 7, 4, 1};
//
//        int lo = 0;
//        int hi = arr.length - 1;
        int mid = lo + (hi - lo) / 2;

        if (arr[lo] > arr[hi]) {
            swap(arr[lo], arr[hi]);
        }

        if (arr[lo] > arr[mid]) {
            swap(arr[lo], arr[hi]);
        }

        if (arr[lo] < arr[mid]) {
            swap(arr[lo], arr[hi]);
        }

        int key = arr[lo];

        while (lo < hi) {

            while (arr[hi] >= key && hi > lo) {
                hi--;
            }
            arr[lo] = arr[hi];

            while (arr[lo] <= key && hi > lo) {
                lo++;
            }
            arr[hi] = arr[lo];

        }
        arr[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    public static void main(String[] args) {

        int[] arr = {6, 3, 7, 4, 1};
        int lo = 0;
        int hi = arr.length - 1;
        sort(arr, lo, hi);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void swap(int a, int b) {

        int temp = a;
        a = b;
        b = temp;
    }
}
