package com.shaw.seekSort.day03;


import static com.shaw.seekSort.day03.ArrayBinaryTreeDemo.arr;

/**
 * @author: xsy
 * @Date: 2022/1/1
 * @description: the concrete steps see to:{@link }
 */
public class ArrayBinaryTreeDemo {
    protected static int arr[] = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        ArrayBinaryTree tree = new ArrayBinaryTree();
        tree.preOrder(0);
    }
}

class ArrayBinaryTree {
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}

