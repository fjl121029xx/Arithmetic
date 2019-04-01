package com.li.dsa.search;

import java.util.Random;

public class BinarySearch {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 9;
        System.out.println(sort(arr, 0, arr.length, target));
    }

    public static int sort(int[] arr, int start, int end, int target) {

        if (start <= end) {

            int mid = (end + start) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                return sort(arr, start, mid, target);
            } else {
                return sort(arr, mid, end, target);
            }

        }
        return -1;
    }
}
