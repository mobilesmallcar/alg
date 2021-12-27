package com.shaw.org.day05.dercription;

import java.util.Arrays;

/**
 * @author: xsy
 * @Date: 2021/12/27
 * @description: the step of RadixSort
 */
public class Radix {
    public static void main(String[] args){
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }
    // 基数排序法
    public static void radixSort(int[] arr){
        // 模拟对一轮(针对每个元素的个位数进行排序处理)

        // 定义一个二维数组,表示一个二维数组, 每个桶就是一个一维数组
        // 说明 二维数组包含10个一维数组
        //     为了防止放入数的时候 数据溢出 ,则每一个一维数组的大小为array.length()
        //     很明显 空间换时间
        int[][] bucket = new int[10][arr.length];
        // 为了记录每个桶中 实际存放了多少个数据 我们定义一个一维数组来记录每个桶的个数
        // bucketElementCounts[0] 就是bucket[0] 的放入数据的个数
        int[] bucketElementCounts = new int[10];
        for (int j = 0; j < arr.length; j++){
            // 取数每个元素的个位
            int digitOfElement = arr[j] % 10;
            // 放入到对应的桶
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 将桶里的数据放入
        int index = 0;
        // 遍历每一个桶 将桶里的数据放入 原来的数组中
        for (int k = 0;k < bucket.length; k++){
            if (bucketElementCounts[k] != 0){
                for (int j = 0; j < bucketElementCounts[k]; j++){
                    arr[index++] = bucket[k][j];
                }
            }
            // 第一轮需要对bucketElementCounts数组置零
            bucketElementCounts[k]= 0;
        }
        System.out.println("第一轮 对个位数进行处理后的数组:" + Arrays.toString(arr));

        // 模拟对二轮(针对每个元素的十位数进行排序处理)

        for (int j = 0; j < arr.length; j++){
            // 取数每个元素的十位
            int digitOfElement = arr[j] / 10 % 10;
            // 放入到对应的桶
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 将桶里的数据放入
        index = 0;
        // 遍历每一个桶 将桶里的数据放入 原来的数组中
        for (int k = 0;k < bucket.length; k++){
            if (bucketElementCounts[k] != 0){
                for (int j = 0; j < bucketElementCounts[k]; j++){
                    arr[index++] = bucket[k][j];
                }
            }
            bucketElementCounts[k]= 0;
        }
        System.out.println("第二轮 对十位数进行处理后的数组:" + Arrays.toString(arr));

        // 模拟对三轮(针对每个元素的百位数进行排序处理)

        for (int j = 0; j < arr.length; j++){
            // 取数每个元素的百位
            int digitOfElement = arr[j] /100 % 10;
            // 放入到对应的桶
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 将桶里的数据放入
        index = 0;
        // 遍历每一个桶 将桶里的数据放入 原来的数组中
        for (int k = 0;k < bucket.length; k++){
            if (bucketElementCounts[k] != 0){
                for (int j = 0; j < bucketElementCounts[k]; j++){
                    arr[index++] = bucket[k][j];
                }
            }
            bucketElementCounts[k]= 0;
        }
        System.out.println("第三轮 对百位数进行处理后的数组:" + Arrays.toString(arr));

    }
}
