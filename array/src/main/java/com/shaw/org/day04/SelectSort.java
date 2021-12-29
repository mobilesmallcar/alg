package com.shaw.org.day04;

import java.math.BigDecimal;
import java.util.Arrays;

import static com.shaw.org.day04.description.SelectSortDsc.selectSort;

/**
 * @author: xsy
 * @Date: 2021/12/22
 * @description: the algorithm of SelectSort
 * the concrete steps see to:{@link com.shaw.org.day04.description.SelectSortDsc}
 */
public class SelectSort {
    private static int[] arr = {101, 34, 119, 1};
    private static int len = arr.length;

    public static void main(String[] args) {

        //selectSort(arr);  //步骤分析
        selectSortAll();
    }

    // 选择排序 -- 步骤分析 设定一个n长度的数组,依次遍历,设定当前遍历到 k 位(k∈[0,n-1]),保证的是每次遍历最前面那个数为最小值
    // methods-->1.设定一个当前遍历的k位值为temp,和指针cur指向k
    //           2.向后遍历,如果有比temp小的数,temp重新赋值为arr[other],指针指向other
    public static void selectSortAll() {

        for (int i = 0; i < len - 1; i++) { //n-1次,无需遍历最后一位,
            int temp = arr[i];
            int cur = i;
            for (int j = i + 1; j < len; j++) {
                if(arr[j]<temp){
                    temp = arr[j];
                    cur = j;
                }
            }
            if(cur != i){
                int swap = arr[i];
                arr[i] = arr[cur];
                arr[cur] = swap;
            }
        }
        System.out.println("the algorithm of select result is:"+Arrays.toString(arr));

    }

}
