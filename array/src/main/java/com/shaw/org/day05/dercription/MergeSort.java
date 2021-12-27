package com.shaw.org.day05.dercription;

import java.util.Arrays;

/**
 * @author: xsy
 * @Date: 2021/12/27
 * @description: this is the step of MergeSort
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length]; // 归并排序需要额外的空间
        mergeSort(arr, 0, arr.length-1, temp);

        System.out.println("归并排序后: "+ Arrays.toString(arr));
    }

    //分 + 合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right) {
            int mid = (left + right) / 2; // 中间的索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid+1, right, temp);

            // 以上是分解的方法
            // 每次分解之后 合并一次
            merge(arr, left, mid, right,temp);
        }
    }

    /**
     *  合并的方法
     * @param arr 原始的数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr,int left, int mid, int right, int[] temp){
        int i = left; //初始化 i, 左边的有序序列的初始索引
        int j = mid+1;// 初始化j 右边的初始索引
        int t = 0; //初始化temp数组的索引

        // 先把左右两边(有序)的数据 按照规则填充到temp
        // 直到左右两边的有序序列有一方处理完毕
        while (i <= mid && j <= right){
            // 如果左边的有序序列的当前元素 <= 右边有序序列的当前元素 将左边的当前元素放到temp的t的位置
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];// 放入后移
            }else {
                temp[t++] = arr[j++];
            }
        }
        // 将有剩余的数组的数据一次加入temp中的尾部
        while (i <= mid){ //左边的有序序列还有剩余的数据 将剩余的有序数据 依次加入temp数组
            temp[t++] = arr[i++];
        }
        while (j <=right){ //右边的有序序列还有剩余的数据 将剩余的有序数据 依次加入temp数组
            temp[t++] = arr[j++];
        }

        // 将temp数组重新放到arr
        // 注意 并不是每次拷贝所有
        t = 0;
        int tempLeft = left;// 第一次合并 tempLeft=0 right=1 //  第二次合并 tempLeft=2 right=3 //  第三次合并tempLeft=0 right=3
        //  最后一次合并  tempLeft=0 right=7
        while (tempLeft <= right){
            arr[tempLeft++] = temp[t++];
        }
    }

}

