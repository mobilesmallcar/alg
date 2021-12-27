package com.shaw.org.day05;

import java.util.Arrays;
import java.util.TimerTask;

/**
 * @author: xsy
 * @Date: 2021/12/27
 * @description: the algorithm of MergeSort
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("归并排序后: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int cur = 0;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[cur++] = arr[l++];
            } else {
                temp[cur++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[cur++] = arr[l++];
        }

        while (r <= right) {
            temp[cur++] = arr[r++];
        }

        cur = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[cur++];
        }


    }
}

