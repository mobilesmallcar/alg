package com.shaw.org.day04;

import java.util.Arrays;

import static com.shaw.org.day04.description.InsertDesc.insertSort;

/**
 * @author: xsy
 * @Date: 2021/12/23
 * @description: the algorithm of insertSort
 * the concrete steps see to:{@link com.shaw.org.day04.description.InsertDesc}
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        insertSort(arr); //分步骤演示
        insertSortAll(arr);
    }

    // 实现的是从小到大排序
    // 思路分析:  设定一个n长度的数组,从第一位依次遍历，设遍历途中遍历到 k 位(k属于[0,n-1])
    // methods:-->1.设定当前遍历的K位值为temp,和指针cur指向k
    //            2.如果后一个小于前一个数并且当前cur>=0,满足这两个条件,则让后一位等于前一位，直至cur<0,跳出循环
    //            3.把第cur指向的+1位判断是否等于当前的k位，如果需要赋值
    public static void insertSortAll(int[] arr) {
        int cur = 0;
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur = i;
            temp = arr[i];
            while (cur >= 1 && temp < arr[cur-1]) {
                arr[cur] = arr[cur-1];
                cur--;
            }
//            if (cur != i) {
                arr[cur] = temp;
//            }
        }
        System.out.println("the algorithm of insert result is:" + Arrays.toString(arr));
    }

}


