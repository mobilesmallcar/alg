package com.shaw.org.day05;

import java.util.Arrays;

/**
 * @author: xsy
 * @Date: 2021/12/27
 * @description: the algorithm of quickSort
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr: " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l == r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            } else if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}


