package com.li.sort;

public class Insert {

    public static void main(String[] args) {

        int[] arr = {6, 4, 2, 1, 5, 9, 7, 8, 3};

        int length = arr.length;

        int insertNum;

        for (int i = 1; i < length; i++) {
            insertNum = arr[i];

            int j = i - 1;
            // 什么时候开始后移
            for (int k = j; k >= 0; k--) {
                if (arr[k] > insertNum) {

                    arr[k + 1] = arr[k];
                    arr[k] = insertNum;
                    insertNum = arr[k];
                }
            }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
