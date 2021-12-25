package com.shaw.org.day04.description;

import java.util.Arrays;

public class InsertDesc {
    public static void insertSort(int[] arr){
        // 使用逐步推导的方式来讲解 便于理解
        // 第一轮 101,34,119,1 => 34,101,119,1

        // 定义一个待插入的数
        int insertVal = arr[1]; // 初始化  因为101当做已经在一个有序数组里了  让待插入数
        int insertIndex = 1 -1 ; // 初始化  待插入的数的前一个数

        // 给insertVal 找到插入的位置
        // insertIndex >= 0  保证插入的位置不越界
        // insertVal < arr[insertIndex] 待插入数 还没有找到插入的位置 就需要 insertIndex 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex]; // 101 101 119 1
            insertIndex--; // insertIndex >= 0 小于零就终止了
        }
        // 退出while 循环时 插入位置找到 insertIndex + 1 (因为insertIndex初始化的时候是待插入数的前一个数)
        arr[insertIndex+1] = insertVal;
        System.out.println("第一轮后");
        System.out.println(Arrays.toString(arr));

        // 第二轮 34, 101, 119, 1 => 34, 101, 119, 1

        // 定义一个待插入的数
        insertVal = arr[2]; // 初始化  因为101当做已经在一个有序数组里了  让待插入数
        insertIndex = 2 -1 ; // 初始化  待插入的数的前一个数

        // 给insertVal 找到插入的位置
        // insertIndex >= 0  保证插入的位置不越界
        // insertVal < arr[insertIndex] 待插入数 还没有找到插入的位置 就需要 insertIndex 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--; // insertIndex >= 0 小于零就终止了
        }
        // 退出while 循环时 插入位置找到 insertIndex + 1 (因为insertIndex初始化的时候是待插入数的前一个数)
        arr[insertIndex+1] = insertVal;
        System.out.println("第二轮后");
        System.out.println(Arrays.toString(arr));

        // 第三轮 34, 101, 119, 1 => 1, 34, 101, 119

        // 定义一个待插入的数
        insertVal = arr[3]; // 初始化  因为101当做已经在一个有序数组里了  让待插入数
        insertIndex = 3 -1 ; // 初始化  待插入的数的前一个数

        // 给insertVal 找到插入的位置
        // insertIndex >= 0  保证插入的位置不越界
        // insertVal < arr[insertIndex] 待插入数 还没有找到插入的位置 就需要 insertIndex 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex]; //
            insertIndex--; // insertIndex >= 0 小于零就终止了
        }
        // 退出while 循环时 插入位置找到 insertIndex + 1 (因为insertIndex初始化的时候是待插入数的前一个数)
        arr[insertIndex+1] = insertVal;
        System.out.println("第三轮后");
        System.out.println(Arrays.toString(arr));
        /**
         * 第一轮后
         * [34, 101, 119, 1]
         * 第二轮后
         * [34, 101, 119, 1]
         * 第三轮后
         * [1, 34, 101, 119]
         */
    }
}
