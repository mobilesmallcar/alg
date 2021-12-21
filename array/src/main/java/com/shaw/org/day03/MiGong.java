package com.shaw.org.day03;

/**
 * @author: xsy
 * @Date:
 * @description: use two dimension of array && recursive to solve the solution of maze..
 */
public class MiGong {
    static int len = 8;
    public static void main(String[] args) {

        String[][] map = new String[len][len];
        for(int i =0;i<len;i++){
            for(int j = 0;j < len; j++){
                map[i][j] = "0";
            }
        }
        //初始化迷宫
        for (int i = 0; i < len; i++) {
            map[0][i] = "*";
            map[len-1][i] = "*";
            map[i][0] = "*";
            map[i][len-1] = "*";
        }

        //初始化障碍物
        map[1][2] = "*";
        map[2][2] = "*";
        map[4][1] = "*";
        map[4][2] = "*";
        map[4][3] = "*";
        map[4][4] = "*";
        map[3][4] = "*";
        map[2][4] = "*";
        map[2][5] = "*";
        map[4][6] = "*";
        //打印迷宫
        printMap(map);
        setWay(map,1,1);
        printMap(map);
    }
    public static boolean setWay(String[][] map,int i,int j){
        if(map[6][6].equals("2")){
            return true;
        }
        if(map[i][j].equals("0")){
            map[i][j] = "2";
            //顺序为上-下-左-右  改为--> 右-下-上-左
            if(setWay(map,i,j+1)){
                return true;
            }else if(setWay(map,i+1,j)){
                return true;
            }else if(setWay(map,i-1,j)){
                return true;
            }else if(setWay(map,i,j-1)){
                return true;
            }else{
                map[i][j] = "3";
                return false;
            }
        }else{
            return false;
        }
    }
    public static void printMap(String[][] map){
        System.out.println("===============");
        for(int i =0;i<len;i++){
            for(int j = 0;j < len; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===============");
    }
}

