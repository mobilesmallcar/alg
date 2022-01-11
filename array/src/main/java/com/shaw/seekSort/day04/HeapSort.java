package com.shaw.seekSort.day04;

import java.util.Arrays;

/**
 * @author: xsy
 * @Date: 2022/1/10
 * @description: the sort of heaping use completed Binary Tree
 */
public class HeapSort {
    public static void main(String[] args) {
        // 数组升序排序
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        heapSort(arr);
    }

    // 编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        for (int i = arr.length / 2; i >= 0; i--) {//参见图片adjustHeap.png
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if ((k + 1) < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }
}

