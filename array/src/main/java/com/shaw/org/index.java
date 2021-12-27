package com.shaw.org;

import com.shaw.org.day04.BubbleSort;
import com.shaw.org.day04.HellSort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class index {
    private static int[] arr = {8, 9, 1, 7, 2, 3, 10, 5, 4, 6, 0};
    public static int len = arr.length;
    public static int num = 100000;
    public static void main(String[] args) {
        Random r = new Random(num);
        arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = Math.abs(r.nextInt());
        }
        len = arr.length;
        System.out.println(Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        BubbleSort();
        long endTime = System.currentTimeMillis();
        System.out.println("bubbling time is:"+(endTime-startTime));
        selectSort();
        long endTime2 = System.currentTimeMillis();
        System.out.println("selecting time is:"+(endTime2-endTime));
        insertSort();
        long endTime3 = System.currentTimeMillis();
        System.out.println("inserting time is:"+(endTime3-endTime2));
        HellSort();
        long endTime4 = System.currentTimeMillis();
        System.out.println("helling time is:"+(endTime4-endTime3));
    }
    private static void BubbleSort() {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
//        System.out.println("After Bubbling,the arr is:" + Arrays.toString(arr));
    }

    private static void selectSort() {
        for (int i = 0; i < len - 1; i++) {
            int temp = arr[i];
            int cur = i;
            for (int j = i + 1; j < len - 1; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    cur = j;
                }
            }
            if (cur != i) {
                temp = arr[cur];
                arr[cur] = arr[i];
                arr[i] = temp;
            }
        }
//        System.out.println("After Selecting,the arr is:" + Arrays.toString(arr));
    }

    private static void insertSort() {
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            int cur = i;
            while (cur >= 1 && arr[cur - 1] > temp) {
                arr[cur] = arr[cur - 1];
                cur -= 1;
            }
            arr[cur] = arr[i];
        }
//        System.out.println("After Inserting,the arr is:" + Arrays.toString(arr));
    }

    private static void HellSort() {
        int group = len / 2;
        while(group!=0) {
            for (int i = group; i < len; i++) {

                int temp = arr[i];
                int cur = i;
                while (cur - group >= 0 && arr[cur - group] > temp) {
                    arr[cur] = arr[cur - group];
                    cur -= group;
                }
                arr[cur] = arr[i];
            }
            group /= 2;
        }
//        System.out.println("After Helling,the arr is:" + Arrays.toString(arr));
    }
}
