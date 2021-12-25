package com.shaw.org.day04;

import java.util.Arrays;

/**
 * @author: xsy
 * @Date: 2021/12/22
 * @description: the algorithm of bubbling
 */
public class BubbleSort {
    private static int arr[] = {3, 9, -1, 10, 20};
    private static int n = arr.length;

    //思路分析： 设定一个n项大小的数组，第一次从第0项遍历到n-1项,设过程中的为temp（temp∈[0,n-1]),让temp与temp+1项进行比较,
    // -->保证每次循环的最后一位都是最大数
    public static void main(String[] args) {

//        firstBubbling();
        upgradeBubbling();
        System.out.println("After bubbling,the result is:" + Arrays.toString(arr));
//        print();
    }

    private static void firstBubbling() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void upgradeBubbling() {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < n - 1; i++) {
            count++;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }else{
                flag = true;
            }
        }
        System.out.println("遍历了:" + count + "次");
    }

    private static void print() {
        System.out.print("After bubbling,the result is:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
