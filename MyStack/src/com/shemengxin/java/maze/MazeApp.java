package com.shemengxin.java.maze;

/**
 * 迷宫问题
 */
public class MazeApp {
    public static void main(String[] args) {
        //绘制迷宫
        int [][] map =new int[8][7];

        /**
         * 设置第一行和最后一行为墙，设置为1
         */
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }

        /**
         * 设置第一例和第七列为墙
         */
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }

        /**
         * 设置障碍墙
         */
        map[3][1]=1;
        map[3][2]=1;

        System.out.println("新的迷宫");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        isRun(map ,1,1);

        System.out.println("走过的路线");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 1.小球从哪一个位置开始触发，起始位置 1、1
     * 2.map是地图对象
     * 3.最终小球达到了 6、5
     * 4.元素为0时，表示该点没有走过，元素为1表示是墙，元素为2时，表示通过可以走，当元素为3时，表示该点已经走过了，
     * 但是走不通。
     */
    public static boolean isRun(int[][] map,int i,int j){
        //终点
        if(map[6][5]==2){
            return  true;
        }else{
            if(map[i][j]==0){//没有走过该点
                map[i][j]=2;

                //上、下、左、右
                if(isRun(map,i+1,j)){
                    return true;
                } else if (isRun(map, i, j+1)) {
                    return true;
                } else if (isRun(map, i-1, j)) {
                    return true;
                } else if (isRun(map, i, j-1)) {
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
