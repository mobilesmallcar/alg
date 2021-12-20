package com.shaw.org.day01;

public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0 表示 没有棋子 1表示黑子 2表示白子
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        // 输出原始的二维数组
        System.out.println("输出原始的二维数组");
        for(int row[] : chessArray){
            for (int data : row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        // 将二维数组转为稀疏数组的思路
        // 1 先遍历 二维数组 得到 非0 数据的个数
        int sum = 0;
        for(int i = 0; i < chessArray.length; i++){
            for(int j = 0; j<chessArray.length; j++ ){
                if(chessArray[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("非0数据的个数 sum="+ sum);
        // 2 创建对应的稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 遍历二维数组 将非0的值存放到稀疏数组中
        int index = 1;
        for(int i = 0; i < chessArray.length; i++){
            for(int j = 0; j<chessArray.length; j++ ){
                if(chessArray[i][j] != 0){
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = chessArray[i][j];
                    index++;
                }
            }
        }
        // 输出稀疏数组
        System.out.println("得到的稀疏数组为:");
        for (int i = 0;i<sum+1;i++){
            System.out.print(sparseArray[i][0] + "\t");
            System.out.print(sparseArray[i][1] + "\t");
            System.out.print(sparseArray[i][2] + "\t");
            System.out.println();
        }

        // 稀疏数组恢复成二维数组
        // 1 读取稀疏数组的第一行 根据第一行的数据,  创建原始的二维数组
        // 2 在读取稀疏数组的后几行 并赋值
        int row = sparseArray[0][0];
        int cos = sparseArray[0][1];
        int newChessArray[][] = new int[row][cos];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cos; j++ ){
                newChessArray[i][j] = 0;
            }
        }
        for (int i = 1; i < sparseArray.length;i++){
            newChessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("输出恢复的二维数组");
        for(int rows[] : chessArray){
            for (int data : rows){
                System.out.print(data + "\t");
            }
            System.out.println();
        }

    }

}
