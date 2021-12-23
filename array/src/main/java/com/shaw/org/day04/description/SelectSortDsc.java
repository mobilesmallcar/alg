package com.shaw.org.day04.description;

import java.util.Arrays;

public class SelectSortDsc {
    public static void selectSort(int[] arr){
        // 使用逐步推导的方式
        // 第一轮
        // 原始数组 101,34,119,1
        // 第一轮排序 1,34,119,101
        int minIndex = 0;
        int min = arr[0]; // 初始值
        for(int j = 1; j < arr.length;j++){
            if (min > arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        int temp = arr[0];
        arr[0] = arr[minIndex];
        arr[minIndex] = temp;
        System.out.println("第一轮排序");
        System.out.println(Arrays.toString(arr));

        // 第二轮
        // 第一轮排序 1, 34, 119, 101
        // 第二轮排序 1, 34, 119, 101
        min = arr[1]; // 初始值
        minIndex = 1;
        for(int j = 1; j < arr.length;j++){
            if (min > arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        temp = arr[1];
        arr[1] = arr[minIndex];
        arr[minIndex] = temp;
        System.out.println("第二轮排序");
        System.out.println(Arrays.toString(arr));

        // 第三轮
        // 第一轮排序 1, 34, 119, 101
        // 第二轮排序 1, 34, 119, 101
        // 第二轮排序 1, 34, 101, 119
        min = arr[2]; // 初始值
        minIndex = 2;
        for(int j = 2; j < arr.length;j++){
            if (min > arr[j]){
                minIndex = j;
                min = arr[j];
            }
        }
        temp = arr[2];
        arr[2] = arr[minIndex];
        arr[minIndex] = temp;
        System.out.println("第三轮排序");
        System.out.println(Arrays.toString(arr));

        /**
         * 第一轮排序
         * [1, 34, 119, 101]
         * 第二轮排序
         * [1, 34, 119, 101]
         * 第三轮排序
         * [1, 34, 101, 119]
         */
    }
}
