package com.shaw.org.day04;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author: xsy
 * @Date: 2021/12/23
 * @description: the algorithm of HellSort
 * the concrete steps see to:{@link com.shaw.org.day04.description.HellSortDesc}
 */
public class HellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 10, 5, 4, 6, 0};
        //分步骤
//        hellSort(arr);
        hellSortAll(arr);
//        upgradeHellSort2(arr);

    }

    // 希尔排序--> 思路分析: 以组为单位进行插入排序两种实现，第一种交换法，第二种简单插入法
    public static void hellSortAll(int[] arr) {
        int temp = 0;
        int group = arr.length / 2;
        while (group != 0) {
            for (int i = group; i < arr.length; i++) {
                for (int j = i - group; j >= 0; j -= group) {
                    if (arr[j] > arr[j + group]) {
                        //使用交换法
                        temp = arr[j];
                        arr[j] = arr[j + group];
                        arr[j + group] = temp;
                    }
                }
            }
            group = group / 2;
        }
        System.out.println("希尔排序结果");
        System.out.println(Arrays.toString(arr));
    }

    //希尔算法优化
    private static void upgradeHellSort(int arr[]) {
        int temp = 0;
        int group = arr.length / 2;
        while (group != 0) {
            for (int i = 0; i < arr.length; i++) {
                int cur = i;

                temp = arr[i];
                for (int j = i - group; j >= 0; j -= group) {
                    if (arr[j] > arr[j + group]) {
                        arr[j + group] = arr[j];
                        cur -= group;
                    }
                }
                if (cur != i) {
                    arr[cur] = temp;
                }
            }
            group = group / 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void upgradeHellSort2(int arr[]) {
        int temp = 0;
        int group = arr.length / 2;
        while (group != 0) {
            for (int i = 0; i < arr.length; i++) {
                int cur = i;
                temp = arr[i];
                while (i - group >= 0 && temp > arr[i - group]) {
                    arr[i] = arr[i - group];
                    cur -= group;
                }
                arr[cur + group] = temp;
            }
            group = group / 2;
        }
        System.out.println(Arrays.toString(arr));
    }

}

