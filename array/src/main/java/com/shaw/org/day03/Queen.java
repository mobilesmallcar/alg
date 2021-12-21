package com.shaw.org.day03;

/**
 * @author: xsy
 * @Date: 2021/12/21
 * @description: the famous issue Eight Queen..use the backTrack algorithm
 */
public class Queen {

    int max = 8;
    static int count = 0;
    int[] arr = new int[max];

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
    }

    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }

    }

    private boolean judge(int n) {

        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        System.out.print("第" + (++count) + "种:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("===");
    }
}

