package com.shaw.org.day05;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int bucket[][] = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        int max = arr[0];
        int index;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLen = (max + "").length();
        int n = 1;
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];
            }
            index = 0;
            for (int k = 0; k < bucket.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        arr[index++] = bucket[k][j];
                    }
                }
                bucketElementCounts[k] = 0;
            }
            n *= 10;
        }
    }

}

