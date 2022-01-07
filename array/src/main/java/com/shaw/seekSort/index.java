package com.shaw.seekSort;

import java.util.Arrays;

public class index {
    private static int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
    private static int len = arr.length;

    public static void main(String[] args) {
        heapSort();
    }

    //堆排序思路解析：==>首先他是一个完全二叉树，从头开始遍历，
    // =======>当遍历到一个k节点,进行一些数据转换，使得2k+1,2k+2的节点小于k的节点
    // =======>4-7（三层） ,8-15（四层）  ===>推出来范围 2^(k-1)---2^k-1
    //                                  ===>??如何判断他有几层 |换种思路，挨个遍历，当遍历到2k+1或者2k+2超出范围则退回循环。
    private static void heapSort() {

        while (true) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                if ((2 * i) >= len) {
                    System.out.println(i);
                    break;
                }
                if ((2 * i + 1) >= len) {
                    break;
                } else {
                    int k = 2 * i + 1;
                    if (k + 1 < len && arr[k] < arr[k + 1]) {
                        k++;
                    }
                    if(arr[i]<arr[k]){
                        int temp = arr[k];
                        arr[k] = arr[i];
                        arr[i] = temp;
                        count++;
                    }
                }

                System.out.println("外层循环:" + i);
            }
            if (count == 0) {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
