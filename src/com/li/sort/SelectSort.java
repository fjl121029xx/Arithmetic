package com.li.sort;

public class SelectSort {
    /**
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * @param args
     */
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
