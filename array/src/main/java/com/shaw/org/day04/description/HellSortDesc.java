package com.shaw.org.day04.description;

import java.util.Arrays;

public class HellSortDesc {
    // 使用逐步推到的方式编写希尔排序(交换法)
    public static void hellSort(int[] arr){
        // 希尔数组的第一轮排序
        // 因为第一轮排序 将10个数据分成10/2=5组
        int temp = 0;
        for (int i = 5; i < arr.length; i++){
            // 遍历各组中 所有的元素(共五组,每组2个元素) 步场为5 如第一个数字和第5个数字比较
            for(int j = i - 5; j >= 0; j -= 5){
                // 如果当前的元素大于加上步长的元素,说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔数组的第一轮排序后");
        System.out.println(Arrays.toString(arr));

        // 希尔数组的第二轮排序
        // 因为第二轮排序 将10个数据分成5/2=2组
        for (int i = 2; i < arr.length; i++){
            // 遍历各组中 所有的元素(共五组,每组2个元素) 步场为5 如第一个数字和第5个数字比较
            for(int j = i - 2; j >= 0; j -= 2){
                // 如果当前的元素大于加上步长的元素,说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔数组的第2轮排序后");
        System.out.println(Arrays.toString(arr));

        // 希尔数组的第三轮排序
        // 因为第三轮排序 将10个数据分成2/2=1组
        for (int i = 1; i < arr.length; i++){
            // 遍历各组中 所有的元素(共五组,每组2个元素) 步场为5 如第一个数字和第5个数字比较
            for(int j = i - 1; j >= 0; j -= 1){
                // 如果当前的元素大于加上步长的元素,说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔数组的第3轮排序后");
        System.out.println(Arrays.toString(arr));
        /**
         * 希尔数组的第一轮排序后 --5
         * [3, 5, 1, 6, 0, 8, 9, 4, 7, 2]
         * 希尔数组的第2轮排序后 --2
         * [0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
         * 希尔数组的第3轮排序后 --1
         * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
         */
    }
}
