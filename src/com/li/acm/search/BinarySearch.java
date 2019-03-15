package com.li.acm.search;

import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {

        // 0 1 2 3 4 5 6 7 8 9 10 11
        int[] arr = new int[10000000];
        Random r = new Random();
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i + r.nextInt(10);
        }

        int waitFind = 99983;

        int i = binarySearch(waitFind, 0, arr.length, arr);

        System.out.println(i);

    }

    public static int binarySearch(int aim, int begin, int end, int[] arr) {

        if (begin <= end) {

            int midIndex = (end + begin) / 2;

            if (aim == arr[midIndex]) {

                return midIndex;
            } else if (aim > arr[midIndex]) {

                return binarySearch(aim, midIndex + 1, end, arr);
            } else {
                return binarySearch(aim, begin, midIndex - 1, arr);
            }
        }
        return -1;
    }
}
